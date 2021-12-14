package api.body;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.ContentType.URLENC;

public class ResponseBody
{

    /**
     * Function:GetResponse
     * Description:Customer Verification Human Step's step request.
     * Input Parameters:
     *
     * @param reqBody        Body of the sent request.
     * @param desiredPostURL URL to be posted
     * @param token          Token information
     *                       Author: Hilal Yilmaz
     *                       Date: 04-06-21
     */
    public static Response getResponse(String reqBody, String token, String desiredPostURL) {
        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(JSON)
                .and()
                .body(reqBody)
                .when()
                .get(desiredPostURL)
                .then()
                .extract().response();
    }


    /**
     * Function:GetToken
     * Description:Response method with token information.
     * Input Parameters: None.
     * Author: Hilal Yilmaz
     * Date: 04-06-21
     */
    public static String getResponseTokenWithParam(String getTokenURL) {
        //It can be added to as many parameters as desired and updated accordingly.
        return given()
                .contentType(URLENC)
                .param("", "")
                .and()
                .when()
                .post(getTokenURL)
                .then()
                .extract().response().body().asPrettyString();
    }

    /**
     * Function:GetResponseWithBasicAuthentication
     * Description:Response method with token information.
     * Input Parameters: None.
     * Author: Hilal Yilmaz
     * Date: 04-06-21
     */
    public static Response getResponseWithBasicAuthentication(String reqBody, String desiredPostURL
            , String username, String password) {
        return given()
                .auth()
                .preemptive()
                .basic(username, password)
                .contentType(JSON)
                .and()
                .body(reqBody)
                .when()
                .post(desiredPostURL)
                .then()
                .extract().response();
        kjflkgjfjg
    }
}
