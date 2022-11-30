package api.tokenMethods;

import io.restassured.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;

import static base.AutomationConstants.*;
import static io.restassured.RestAssured.given;

/**
 * Class:OAUTH2 - Grant Type Authentication Steps
 * Description:
 * Author: Baturay Caglasin
 * Date: Nov'22
 */
public class OAUTH2GrantTypeTestCase {
    private static final Log log = LogFactory.getLog(OAUTH2GrantTypeTestCase.class);

    public String testOAuthWithClientCredential() throws JSONException {
        Response response =
                given()
                        .auth().preemptive().basic(CLIENT_ID, CLENT_SECRET)
                        .contentType("application/x-www-form-urlencoded")
                        .formParam("grant_type", "client_credentials")
                        .when()
                        .post(urlCreatePaytionTokenURL);

        JSONObject jsonObject = new JSONObject(response.getBody().asString());
        System.out.println(jsonObject);
        String accessToken = jsonObject.get("access_token").toString();
        String tokenType = jsonObject.get("token_type").toString();
        log.info("Oauth Token with type " + tokenType + "   " + accessToken);
        return accessToken;
    }
}