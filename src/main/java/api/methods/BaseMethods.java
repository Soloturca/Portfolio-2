package api.methods;

import api.body.RequestBody;
import api.body.ResponseBody;
import api.model.JSON.ParameterDTO;
import base.AutomationConstants;
import base.CommonLib;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static base.AutomationConstants.updatedListAmount;
import static base.AutomationConstants.updatedSalesAmount;

public class BaseMethods {

    public boolean createSessionID(String desiredPath, String msisdn) {
        boolean status = false;

        Response response = ResponseBody.getResponse(desiredPath, "", AutomationConstants.urlCreateSessionId + msisdn);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");

        AutomationConstants.sessionId = js.getString("session.sessionId");

        System.out.println("sessionID is: " + AutomationConstants.sessionId);

        CommonLib.allureReport("INFO", "sessionID is: " + AutomationConstants.sessionId);

        if (result.contains("SUCCESS")) {
            CommonLib.allureReport("PASS", "");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
        }

        return status;
    }

    public boolean createVfMallTokenRequest(String desiredPath) {
        boolean status = false;

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.createVfMallToken(), AutomationConstants.urlCreateVfMallToken);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");
        AutomationConstants.token = js.getString("token").substring(7);
        System.out.println("token is: " + AutomationConstants.token);

        if (result.contains("SUCCESS")) {
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
        }
        return status;
    }

    public boolean checkFieldsInResponseBody(String expectedResultCode, String expectedErrorMessage, String expectedResult) {
        boolean status = false;
        try {
            Assert.assertEquals("result code hatalidir", expectedResultCode, AutomationConstants.resultCode);
            Assert.assertEquals("result description hatalidir", expectedErrorMessage, AutomationConstants.resultDesc);
            Assert.assertEquals("result hatalidir", expectedResult, AutomationConstants.result);
            status = true;
        } catch (Exception e) {
            CommonLib.allureReport("FAIL", "");
        }
        return status;
    }

    public boolean addSessionIdOfferingDetailsRequest(String desiredPath) {

        boolean status = false;

        Map<String, String> map = new HashMap<>();

        map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.getOfferingDetails(AutomationConstants.uuidID), "", AutomationConstants.urlGetVFMallOfferingDetails, map);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");
        AutomationConstants.salesAmount = js.getString("offeringDetails.saleAmount.value[0]");
        System.out.println("salesAmount:" + AutomationConstants.salesAmount);
        AutomationConstants.listAmount = js.getString("offeringDetails.listAmount.value[0]");
        System.out.println("listAmount:" + AutomationConstants.listAmount);
        AutomationConstants.productQuantity = js.getString("offeringDetails.quantity[0]");
        System.out.println("quantity:" + AutomationConstants.productQuantity);
        AutomationConstants.variantCode = js.getString("offeringDetails.variantCode[0]");

        if (result.contains("SUCCESS")) {
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
            CommonLib.allureReport("INFO", "DATA: " + response.asPrettyString());
        }
        return status;
    }

    public boolean updateVfMallStockAndPriceRequest(String desiredPath) {
        boolean status = false;

        updatedListAmount = CommonLib.integerToString(AutomationConstants.listAmount);
        updatedSalesAmount = CommonLib.integerToString(AutomationConstants.salesAmount);

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.updateVfMallStockAndPrice(updatedListAmount, AutomationConstants.updatedProductQuantity, updatedSalesAmount), AutomationConstants.token, AutomationConstants.urlUpdateVfMallStockAndPrice);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());
        String result = js.getString("result.result");
        String resultCode = js.getString("result.resultCode");
        String resultDesc = js.getString("result.resultDesc");

        if (result.contains("SUCCESS") && resultCode.equals("0")) {
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
            CommonLib.allureReport("INFO", "DATA: " + response.asPrettyString());
        }
        return status;
    }

    public boolean checkResponseBody(String requestType) {
        boolean status = false;

        try {
            switch (requestType) {
                case "VFMallOffering":
                    Assert.assertNotNull(AutomationConstants.salesAmount);
                    Assert.assertNotNull(AutomationConstants.listAmount);
                    Assert.assertNotNull(AutomationConstants.productQuantity);
                    status = true;
                    break;
                case "VFMallHomePage":
                    Assert.assertNotNull(AutomationConstants.title);
                    status = true;
                    break;
            }
        } catch (Exception e) {
            CommonLib.allureReport("FAIL", "");
        }
        return status;
    }
}