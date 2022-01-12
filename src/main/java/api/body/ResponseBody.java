package api.body;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.ContentType.XML;

public class ResponseBody
{

    /**
     * Function:GetResponse
     * Description:
     * Input Parameters:
     *
     * @param reqBody        Body of the sent request.
     * @param desiredPostURL URL to be posted
     * @param token          Token information
     *                       Author: Hilal Yilmaz
     *                       Date: 04-06-21
     */
    public static Response getResponse(String reqBody, String token, String desiredPostURL, Map<String,String> map) {
        return given()
                .header("Authorization", "Bearer " + token)
                .contentType(JSON)
                .queryParams(map)
                .and()
                .body(reqBody)
                .when()
                .get(desiredPostURL)
                .then()
                .extract().response();
    }

    /**
     * Function:GetResponse
     * Description:
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
    }

    public static Response getResponseWithSOAPAPI(String reqBody, String desiredPostURL) {
        return  given()
                .request().body(reqBody)
                .contentType(XML)
                .headers("SOAPAction", "findSoapAction").
                        when()
                .post(desiredPostURL).
                        then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK).extract().response();
    }
}
