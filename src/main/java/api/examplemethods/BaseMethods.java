package api.examplemethods;

import api.examplebody.ExampleRequestBody;
import api.examplebody.ExampleResponseBody;
import base.AutomationConstants;
import base.CommonLib;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Objects;

public class BaseMethods {

    public boolean createVfMallTokenRequest(String desiredPath) {
        boolean status = false;

        Response response = ExampleResponseBody.getResponse(desiredPath, ExampleRequestBody.createVfMallToken(), AutomationConstants.urlCreateVfMallToken);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        AutomationConstants.token = js.getString("token");

        System.out.println("Token is: " + AutomationConstants.token);

        String result = js.getString("result.result");

        System.out.println("Response is: " + Objects.requireNonNull(response).asPrettyString());

        if (result.contains("SUCCESS")) {
            status = true;
            CommonLib.allureReport("PASS", "The token was created correctly.");
        } else {
            CommonLib.allureReport("FAIL", "Error getting token. Check it.");
        }
        return status;
    }
}
