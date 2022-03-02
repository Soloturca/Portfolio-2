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

    public boolean cleanShoppingCart(String desiredPath, String desiredMethod) {
        boolean status = false;

        Map<String, String> map = new HashMap<>();

        map.put(String.valueOf(ParameterDTO.method), desiredMethod);

        map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

        Response response = ResponseBody.getResponse(desiredPath, "", "", AutomationConstants.urlShoppingJourney, map);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");

        if (result.contains("SUCCESS")) {
            CommonLib.allureReport("PASS", "Basket cleared successfully.");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "An error was encountered while cleaning the basket. Check.");
        }

        CommonLib.allureReport("INFO", "DATA: " + response.asPrettyString());

        return status;
    }


    public boolean addVfMallCustomerProfile(String desiredPath, String desiredMsisdn) {

        boolean status = false;

        Map<String, String> map = new HashMap<>();

        map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

        CommonLib.allureReport("INFO", "Request : " + RequestBody.addVFMallCustomerProfile(desiredMsisdn));

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.addVFMallCustomerProfile(desiredMsisdn), AutomationConstants.urlAddCustomerProfile, map);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");

        AutomationConstants.customerProfileId = js.getString("customerProfile.customerProfileId");

        CommonLib.allureReport("INFO", "customerProfileId is: " + AutomationConstants.customerProfileId);

        if (result.contains("SUCCESS")) {
            CommonLib.allureReport("PASS", "The registration to the Save Shopping Cart Address has been done properly.");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "Registration to the Save Shopping Cart Address did not occur properly. Please check.");
        }

        CommonLib.allureReport("INFO", "DATA : " + response.asPrettyString());

        return status;
    }

    public boolean saveShoppingCartAddress(String desiredMethod, String desiredPath) {
        boolean status = false;

        Map<String, String> map = new HashMap<>();

        map.put(String.valueOf(ParameterDTO.method), desiredMethod);

        map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

        AutomationConstants.deliveryAddressId = AutomationConstants.customerProfileId;
        AutomationConstants.invoiceAddressId = AutomationConstants.customerProfileId;

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.saveShoppingCartAddress(AutomationConstants.deliveryAddressId, AutomationConstants.invoiceAddressId), AutomationConstants.urlShoppingJourney, map);

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

    public boolean addCartItems(String desiredMethod, String desiredPath) {
        boolean status = false;

        Map<String, String> map = new HashMap<>();

        map.put(String.valueOf(ParameterDTO.method), desiredMethod);

        map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.addCartItems(AutomationConstants.uuidID), AutomationConstants.urlAddCartItem, map);

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
