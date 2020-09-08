import com.jayway.jsonpath.JsonPath;
import io.testproject.java.annotations.v2.Parameter;
import io.testproject.java.annotations.v2.Test;
import io.testproject.java.enums.ParameterDirection;
import io.testproject.java.sdk.v2.addons.GenericAction;
import io.testproject.java.sdk.v2.addons.helpers.AddonHelper;
import io.testproject.java.sdk.v2.enums.ExecutionResult;
import io.testproject.java.sdk.v2.exceptions.FailureException;
import io.testproject.java.sdk.v2.reporters.Reporter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;

@Test(name = "Availabilities Repeater")
public class AvailabilitiesRepeater implements GenericAction {

    @Parameter(description = "LocationID")
    private String locationID;

    @Parameter(description = "checkinDate")
    private String checkinDate;

    @Parameter(description = "checkoutDate")
    private String checkoutDate;

    @Parameter(description = "Response", direction = ParameterDirection.OUTPUT)
    private String response;

    @Override
    public ExecutionResult execute(AddonHelper helper) throws FailureException {
        response = repeater(helper.getReporter());

        return ExecutionResult.PASSED;
    }

    final OkHttpClient httpClient = new OkHttpClient();


    private String request2(String location, String in, String out) throws IOException, InterruptedException {
        String link = "https://bookqa.selinatech.xyz/availability/" + location + "/bff-stay?checkInDate=" + in + "&checkOutDate=" + out + "&includeContent=true";
        Request request = new Request.Builder().get()
                .url(link)
                .build();
        System.out.println(link);
        Response resp = httpClient.newCall(request).execute();
        return resp.body().string();
    }

    String repeater(Reporter reporter) {
        locationID = locationID.replaceAll("\\[|\\]", "");
        String[] locations = locationID.split(",");
        String resolved = "";

        for (int i = 0; i < locations.length; i++) {
            String attempt = "";
            String location = locations[i].replace("\"", "");


            try {
                attempt = workingLink(request2(location, checkinDate, checkoutDate), location);
                if (attempt.contains("bookingId")) {
                    resolved = attempt;
//                    System.out.println(attempt);
                    return resolved;
                }
            } catch (Exception e) {
                reporter.result("catch" + e.toString());
                resolved = "No values found";
            }
        }

        return resolved;
    }

    public String workingLink(String response, String locationID) throws FailureException {
        String json = "";

        String mainPart = json(response, "$");

        System.out.println(mainPart);

        mainPart = mainPart == null ? "Invalid" : mainPart;

        if (!mainPart.equals("Invalid")) {
            String BookingIDstring = json(response, "$.availabilities[?(@.isAvailable==true)].bookingId");
            BookingIDstring = BookingIDstring.replace("[","");
            BookingIDstring = BookingIDstring.replace("]","");
            String[]BookingIDs = BookingIDstring.split(",");
            String SelectedBookingID =BookingIDs[0];
            String RatesIDstring = json(response, "$.availabilities[?(@.isAvailable==true)].allRates[0].id");
            RatesIDstring= RatesIDstring.replace("[","");
            RatesIDstring = RatesIDstring.replace("]","");
            String[] RatesID= RatesIDstring.split(",");
            String SelectedRateID = RatesID[0];
            json = String.format("{ \"LocationID\":\"%s\",\"bookingId\":%s,\"rateId\":\"%s\" }",
                    locationID,
                    SelectedBookingID,
                    SelectedRateID);
            System.out.println(json);
        }


        return json;
    }

    String json(String jsonval, String jpath) throws FailureException {

        return JsonPath.read(jsonval, jpath).toString();
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}
