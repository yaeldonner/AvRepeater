import io.testproject.java.sdk.v2.Runner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class Testing {
    Runner runner;

    @Before
    public void run() throws InstantiationException{
        runner = Runner.create("yxOHRv2aKUyHldH_WwYfy_vq2iRLlTptXR9WcyHm1vo1");
    }

    @After
    public void closer () throws IOException{
        runner.close();
    }

    @Test
    public void starter () throws Exception{

        AvailabilitiesRepeater a = new AvailabilitiesRepeater();
        a.setLocationID("[\"40cedb32-9641-417f-8968-6efaf4f1f5b2\",\"bc37087b-45ca-406b-b898-72b6aa49f32e\",\"b5d8344e-db9c-4b4a-a619-2a56a5e302ae\",\"0a498510-885c-45f1-a5c3-745cf1a7f431\",\"a713394e-27f5-408e-a013-c29cb5b2b245\",\"2f31c6d0-e2c9-497d-834c-93cc11233714\",\"cb3e4cd9-0cfb-4734-874f-f3bb11d968bd\",\"578350ec-03b0-41b7-9c0d-9f743aa7a7a6\",\"59a0cb3e-d4fa-4d7a-b3cc-8fe6199fc0b2\",\"f9517904-ca99-47b4-8d50-a513ad758f90\",\"a9a36504-51c8-4b58-beab-c80fd47fa0dd\",\"e8686ce4-4bf7-44c5-bac1-2ab1a4c37932\",\"69bfa07b-b7fd-4424-b2e4-223223700fcc\",\"6864e889-f51d-4d98-b635-f5b2e69f7aa3\",\"d6ae333a-ab49-46a5-b50a-d8131e86a74e\",\"81bc0228-4a45-427c-8150-bfc5b8b77af4\",\"706adabe-2749-4dc1-a1bc-5eec39e61045\",\"cc7f680e-efe8-4257-ae88-dfe97881f2f8\",\"31c94c49-1475-4dfe-a106-3138bf987328\",\"dbf96899-845b-4f39-8201-a1d932551bb6\",\"81a068b3-618c-4d55-8cfc-8f8525ef1845\",\"5f754503-b1a9-40f6-8c85-d34477cc6879\",\"3dcb9049-6507-420f-a399-2bda6c5d1ada\",\"e94531a5-6a74-4c99-bd8d-38e6aee6ee06\",\"31629a47-ef8b-45e9-baa1-85a935819ef8\",\"50b4909a-dd77-430f-9f42-a026ffb4c732\",\"2bf5e770-0504-4d96-b893-f8f489fdad37\",\"3b48932d-f546-4de0-b699-9d3e90523448\",\"1afa3319-48da-46a4-b5be-4db4d0d7066e\",\"75f3b24f-f45c-4f5f-abe6-8ab294d28944\",\"7efc2fe9-78a2-4313-99ca-3cb1fd2ef18d\",\"738ab46e-83c0-4130-b33c-db03769c4c03\",\"d4d76847-0f88-4a71-94b0-65a076b772e6\",\"9ab808db-b6ea-4ef9-8197-be334cfd9144\",\"6a701484-af7b-4ded-9cc3-434b73760529\",\"43323c62-506e-4080-9d16-059718373642\",\"006be3f8-7313-483e-9c77-6d4841e66ca6\",\"97b78dec-2b17-4f9e-830e-e003dae170ed\",\"cedead9a-cd95-493d-a98d-4016373d2e13\",\"2cc214fb-ab51-486a-8f62-eade70a2e712\",\"5d8f641e-9af6-4b1e-ad09-51d8b6363867\",\"574bc7c3-bb5f-4bec-9817-05d5c5ad6b3b\",\"36b98307-8715-40cb-beff-e04ab98c0d6b\",\"57db4be1-7e28-4919-842d-075541f6d968\",\"545aa4e6-1d42-488e-81cb-27d31b722bcb\",\"990f214f-d92e-4ee5-aac3-6382fd2906b0\",\"87548134-c3d4-4fa2-b936-3fb6db97010c\",\"31235e8c-41ba-4311-a19a-fab015e31491\",\"b6f3e96c-cf46-444a-a45c-c80190604955\",\"97e4f06d-9ddb-469c-82d4-bf2e5840ff9d\",\"2b59ea75-781f-4659-bcba-d304e39d9c37\",\"fac340d4-7574-4db8-9d5a-796f76809d02\",\"b86b627e-88d2-46c2-b002-7e63818b889b\",\"0eb108f9-3526-4fad-a104-7a7291863756\",\"5f3543ae-3958-4966-b465-64715a8d0faf\",\"6662cd7a-f859-4b43-8a11-5bcc600ec29a\",\"f892b64d-0b32-493d-aa3c-d69152138347\",\"953401cf-d05d-486a-88b6-ed2f9a017d7f\",\"239cdbd2-b05d-45c4-9fe9-87d0b66a0cb6\",\"ff6e7446-5de7-48d0-ba40-235feafaca2e\",\"2e9de9d3-92ff-44e3-9624-74dcdfa393c6\",\"f015897f-98c1-4947-bd44-db6d149fae63\",\"e9d3cdc0-31ac-4441-8c10-6510a5be425e\",\"2e90bd04-6b69-419a-8373-cc224dd8cebf\",\"7dae071e-def0-406b-ac73-f1576962fdc5\",\"83142658-7661-4304-bc7d-3b95c519f43e\"]");
        a.setCheckinDate("2020-08-21");
        a.setCheckoutDate("2020-08-24");
        runner.run(a);
    }
}
