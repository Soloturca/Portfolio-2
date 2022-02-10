package api.methods.Basket;

import api.body.ResponseBody;
import api.methods.BaseMethods;
import api.model.JSON.ParameterDTO;
import base.AutomationConstants;
import base.CommonLib;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order extends BaseMethods {
    public boolean sellProductsWithPayShoppingCart(String desiredPath) {
        boolean status = false;

        Map<String, String> map = new HashMap<>();

        map.put(String.valueOf(ParameterDTO.method), "payShoppingCart");

        map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

        Response response = ResponseBody.getResponse(desiredPath, "", "", AutomationConstants.urlPayShoppingCart, map);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");

        if (result.contains("SUCCESS")) {
            CommonLib.allureReport("PASS", "");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
        }

        return status;
    }

    public boolean VfMallOrderStatusPending(String desiredPath) {
        boolean status = false;

        Response response = ResponseBody.getResponse(desiredPath, "", AutomationConstants.token, AutomationConstants.urlShoppingJourney);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");

        //path kısmından emin değilim?
        AutomationConstants.status = js.getString("attachment.status.value[0]");
        System.out.println("status:" + AutomationConstants.status);

        if (result.contains("SUCCESS")) {
            CommonLib.allureReport("PASS", "");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
        }

        return status;
    }

    public boolean updateSalesOrderStatusChange(String desiredPath) {
        boolean status = false;

        Response response = ResponseBody.getResponse(desiredPath, "", "", AutomationConstants.urlShoppingJourney);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");

        AutomationConstants.status = js.getString("attachment.status.value[3]");

        System.out.println("salesAmount:" + AutomationConstants.status);

        if (result.contains("SUCCESS")) {
            CommonLib.allureReport("PASS", "");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
        }

        return status;
    }
}
