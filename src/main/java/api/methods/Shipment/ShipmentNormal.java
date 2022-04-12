package api.methods.Shipment;

import api.body.RequestBody;
import api.body.ResponseBody;
import base.AutomationConstants;
import base.CommonLib;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Objects;

public class ShipmentNormal {
    public boolean createShipment(String desiredMethod, String desiredShipmentRefNo, String desiredShipmentCompany, String desiredPath) {
        boolean status = false;

        try {
            Response response = ResponseBody.getResponse(desiredPath, RequestBody.createShipment(desiredShipmentRefNo, desiredShipmentCompany), AutomationConstants.urlCreateShipment + desiredMethod);

            JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

            String result = js.getString("result.successful");

            AutomationConstants.shipmentRefNo = js.getString("shipmentRefNo");

            AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

            System.out.println(AutomationConstants.responseData);

            if (result.contains("true")) {
                status = true;
                CommonLib.allureReport("PASS", "The shipment was created correctly.");
            } else {
                CommonLib.allureReport("FAIL", "Error. The shipment was not created.");
            }

            CommonLib.allureReport("INFO", "DATA: " + response.asPrettyString());
            status = true;
        } catch (Exception e) {
            CommonLib.allureReport("FAIL", "An error occurred while creating a shipment. Check it. Error: " + e.getMessage());
        }

        return status;

    }

    public boolean createShipmentEmptyFromAddressText(String desiredMethod, String desiredShipmentRefNo, String desiredShipmentCompany, String desiredPath) {
        boolean status = false;

        try {
            Response response = ResponseBody.getResponse(desiredPath, RequestBody.createShipmentEmptyFromAddressText(desiredShipmentRefNo, desiredShipmentCompany), AutomationConstants.urlCreateShipment + desiredMethod);

            JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

            String result = js.getString("result.successful");

            AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

            System.out.println(AutomationConstants.responseData);

            if (result.contains("true")) {
                status = true;
                CommonLib.allureReport("PASS", "The shipment was created correctly.");
            } else {
                CommonLib.allureReport("FAIL", "Error. The shipment was not created.");
            }
            CommonLib.allureReport("INFO", "DATA: " + response.asPrettyString());

            status = true;
        } catch (Exception e) {
            CommonLib.allureReport("FAIL", "An error occurred while creating a shipment. Check it. Error: " + e.getMessage());
        }

        return status;
    }

    public boolean createShipmentEmptyToAddressText(String desiredMethod, String desiredShipmentRefNo, String desiredShipmentCompany, String desiredPath) {
        boolean status = false;

        try {
            Response response = ResponseBody.getResponse(desiredPath, RequestBody.createShipmentEmptyToAddressText(desiredShipmentRefNo, desiredShipmentCompany), AutomationConstants.urlCreateShipment + desiredMethod);

            JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

            String result = js.getString("result.desc");

            AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

            System.out.println(AutomationConstants.responseData);

            if (result.contains("true")) {
                status = true;
                CommonLib.allureReport("PASS", "The shipment was created correctly.");
            } else {
                CommonLib.allureReport("FAIL", "Error. The shipment was not created.");
            }
            CommonLib.allureReport("INFO", "DATA: " + response.asPrettyString());

            status = true;

        } catch (Exception e) {
            CommonLib.allureReport("FAIL", "An error occurred while creating a shipment. Check it. Error: " + e.getMessage());
        }

        return status;
    }

    public boolean createShipmentEmptyShipmentRefNo(String desiredMethod, String desiredShipmentRefNo, String desiredShipmentCompany, String desiredPath) {
        boolean status = false;

        try {
            Response response = ResponseBody.getResponse(desiredPath, RequestBody.createShipmentEmptyShipmentRefNo(desiredShipmentRefNo, desiredShipmentCompany), AutomationConstants.urlCreateShipment + desiredMethod);

            JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

            String result = js.getString("result.successful");

            AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

            System.out.println(AutomationConstants.responseData);

            if (result.contains("true")) {
                status = true;
                CommonLib.allureReport("PASS", "The ref no was created automatically because the ref no was empty. The shipment was created correctly.");
            } else {
                CommonLib.allureReport("FAIL", "Error. The shipment was not created.");
            }
            CommonLib.allureReport("INFO", "DATA: " + response.asPrettyString());

            status = true;
        } catch (Exception e) {
            CommonLib.allureReport("FAIL", "An error occurred while creating a shipment. Check it. Error: " + e.getMessage());
        }

        return status;
    }

    public boolean checkFields(String expectedResultSuccessful, String expectedResultDesc) {
        boolean status = false;

        JsonPath js = new JsonPath(Objects.requireNonNull(AutomationConstants.responseData));

        String result = js.getString("result.successful");
        String resultDesc = js.getString("result.desc");

        if (result.contains(expectedResultSuccessful) && resultDesc.contains(expectedResultDesc)) {
            CommonLib.allureReport("PASS", "It was seen that the desired result and desc were received.");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "It was seen that the requested result and desc did not come. Check.");
        }

        CommonLib.allureReport("INFO", "Data: " + AutomationConstants.responseData);

        return status;
    }

    public boolean checkFieldRefNo(String expectedResultSuccessful) {
        boolean status = false;

        JsonPath js = new JsonPath(Objects.requireNonNull(AutomationConstants.responseData));

        String result = js.getString("result.successful");

        if (result.contains(expectedResultSuccessful)) {
            CommonLib.allureReport("PASS", "It was seen that the desired result and desc were received.");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "It was seen that the requested result and desc did not come. Check.");
        }

        CommonLib.allureReport("INFO", "Data: " + AutomationConstants.responseData);

        return status;
    }

    public boolean shipmentStatus(String desiredMethod, String desiredShipmentCompany, String desiredPath) {
        boolean status = false;

        try {
            Response response = ResponseBody.getResponse(desiredPath, RequestBody.shipmentStatus(desiredShipmentCompany, AutomationConstants.shipmentRefNo), AutomationConstants.urlCreateShipment + desiredMethod);

            JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

            String result = js.getString("shipmentRefNo");

            AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

            System.out.println(AutomationConstants.responseData);

            if (result.equals(AutomationConstants.shipmentRefNo)) {
                status = true;
                CommonLib.allureReport("PASS", "The shipment status was checked correctly.");
            } else {
                CommonLib.allureReport("FAIL", "Error. The shipment status was not checked.");
            }
            CommonLib.allureReport("INFO", "DATA: " + response.asPrettyString());

            status = true;
        } catch (Exception e) {
            CommonLib.allureReport("FAIL", "An error occurred while checking a status. Error: " + e.getMessage());
        }

        return status;
    }

    public boolean checkStatus(String expectedStatus) {
        boolean status = false;

        JsonPath js = new JsonPath(Objects.requireNonNull(AutomationConstants.responseData));

        String result = js.getString("status");

        if (result.contains(expectedStatus)) {
            CommonLib.allureReport("PASS", "It was seen that the desired status were received.");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "It was seen that the requested status did not come. Check.");
        }

        CommonLib.allureReport("INFO", "Data: " + AutomationConstants.responseData);

        return status;
    }
}
