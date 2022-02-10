package api.methods.Basket;

import api.body.RequestBody;
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


public class ShoppingCart extends BaseMethods {

    public boolean cleanShoppingCart(String desiredPath) {
        boolean status = false;

        Map<String, String> map = new HashMap<>();

        map.put(String.valueOf(ParameterDTO.method), "cleanShoppingCart");

        map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

        Response response = ResponseBody.getResponse(desiredPath, "", "", AutomationConstants.urlShoppingJourney, map);

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


    public boolean addVfMallCustomerProfile(String desiredPath) {
        boolean status = false;

        Map<String, String> map = new HashMap<>();

        map.put("sid", AutomationConstants.sessionId);

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.addVFMallCustomerProfile(AutomationConstants.msisdn), "", AutomationConstants.urlAddCustomerProfile, map);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");

        AutomationConstants.customerProfileId = js.getString("customerProfile.customerProfileId");

        System.out.println("customerProfileId is: " + AutomationConstants.customerProfileId);

        CommonLib.allureReport("INFO", "customerProfileId is: " + AutomationConstants.customerProfileId);

        if (result.contains("SUCCESS")) {
            CommonLib.allureReport("PASS", "");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
        }

        return status;
    }

    public boolean saveShoppingCartAddress(String desiredPath) {
        boolean status = false;

        Map<String, String> map = new HashMap<>();

        map.put(String.valueOf(ParameterDTO.method), "saveShoppingCartAddress");

        map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

        AutomationConstants.deliveryAddressId = AutomationConstants.customerProfileId;
        AutomationConstants.invoiceAddressId = AutomationConstants.customerProfileId;

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.saveShoppingCartAddress(AutomationConstants.deliveryAddressId, AutomationConstants.invoiceAddressId), "", AutomationConstants.urlShoppingJourney, map);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        System.out.println("customerProfileId: " + AutomationConstants.customerProfileId);
        System.out.println("deliveryAddressId: " + AutomationConstants.deliveryAddressId);
        System.out.println("invoiceAddressId: " + AutomationConstants.invoiceAddressId);

        String result = js.getString("result.result");

        if (result.contains("SUCCESS")) {
            CommonLib.allureReport("PASS", "");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
        }

        return status;
    }

    public boolean addCartItems(String desiredPath) {
        boolean status = false;

        Map<String, String> map = new HashMap<>();

        map.put(String.valueOf(ParameterDTO.method), "addCartItems");

        map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.addCartItems(AutomationConstants.offeringId), "", AutomationConstants.urlAddCartItem, map);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");

        AutomationConstants.shoppingCartId = js.getString("shoppingCart.id");

        System.out.println("shoppingCartId is: " + AutomationConstants.shoppingCartId);

        CommonLib.allureReport("INFO", "shoppingCartId is: " + AutomationConstants.shoppingCartId);

        if (result.contains("SUCCESS")) {
            CommonLib.allureReport("PASS", "");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
        }

        return status;
    }
}
