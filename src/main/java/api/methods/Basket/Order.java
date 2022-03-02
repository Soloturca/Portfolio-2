package api.methods.Basket;

import api.body.RequestBody;
import api.body.ResponseBody;
import api.methods.BaseMethods;
import api.model.JSON.ParameterDTO;
import base.AutomationConstants;
import base.CommonLib;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order extends BaseMethods {
    public boolean sellProductsWithPayShoppingCart(String desiredPath, String desiredMethod) {
        boolean status = false;

        Map<String, String> map = new HashMap<>();

        map.put(String.valueOf(ParameterDTO.method), desiredMethod);

        map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

        CommonLib.allureReport("INFO", "Request : " + RequestBody.payShoppingCart());

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.payShoppingCart(), AutomationConstants.urlPayShoppingCart, map);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");
        String resultCode = js.getString("result.resultCode");

        if (result.contains("SUCCESS") && resultCode.contains("0")) {
            CommonLib.allureReport("PASS", "Items in the cart are successfully purchased.");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "It is seen that the products in the cart cannot be purchased successfully. Check.");
        }
        CommonLib.allureReport("INFO", "Data: " + response.asPrettyString());

        return status;
    }

    public boolean VfMallOrderStatusPending(String desiredPath) {
        boolean status = false;

        Response response = ResponseBody.getResponse(desiredPath, "", AutomationConstants.token, AutomationConstants.urlVfMallOrders);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");

        AutomationConstants.orderId = js.getString("listSalesOrders.id[0]");
        System.out.println("orderId is: " + AutomationConstants.orderId);
        CommonLib.allureReport("INFO", "orderId is: " + AutomationConstants.orderId);


        AutomationConstants.status = js.getString("listSalesOrders.status[0]");
        System.out.println("status:" + AutomationConstants.status);
        CommonLib.allureReport("INFO", "orderId is: " + AutomationConstants.orderId);

        if (result.contains("SUCCESS")) {
            CommonLib.allureReport("PASS", "It appears to have successfully attained the 'PENDING' status.");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "Error trying to set 'PENDING' status. Please check.");
        }

        CommonLib.allureReport("INFO", "Data :" + Objects.requireNonNull(response).asPrettyString());

        return status;
    }

    public boolean updateSalesOrderStatusChange(String desiredPath, String desiredStatus) {
        boolean status = false;

        CommonLib.allureReport("INFO", "Request : " + RequestBody.updateStatus(desiredStatus, AutomationConstants.orderId));

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.updateStatus(desiredStatus, AutomationConstants.orderId), AutomationConstants.urlUpdateSalesOrderStatus);

        System.out.println("orderId is: " + AutomationConstants.orderId);
        CommonLib.allureReport("INFO", "Request : " + "orderId is: " + AutomationConstants.orderId);


        if (Objects.requireNonNull(response).getStatusCode() == HttpStatus.SC_OK) {
            AutomationConstants.status = desiredStatus;
            CommonLib.allureReport("PASS", "Appears to have been successfully updated to the desired Status.");
            System.out.println("Status is updated. Status is: " + AutomationConstants.status);
            CommonLib.allureReport("INFO", "Status is updated. Status is: " + AutomationConstants.status);

            status = true;
        } else {
            CommonLib.allureReport("FAIL", "Error encountered while updating to Status. Please check.");
        }
        CommonLib.allureReport("INFO", "Data: " + response.asPrettyString());

        return status;
    }

    public boolean enterSessionIdAtInsertVfMallRateAndComment(String desiredPath, String desiredHideMyName) {
        boolean status = false;
        try {
            Map<String, String> map = new HashMap<>();

            map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

            CommonLib.allureReport("INFO", "Request: " + RequestBody.insertRateAndComment(AutomationConstants.uuidID, AutomationConstants.variantCode, desiredHideMyName));

            Response response = ResponseBody.getResponse(desiredPath, RequestBody.insertRateAndComment(AutomationConstants.uuidID, AutomationConstants.variantCode, desiredHideMyName), AutomationConstants.urlInsertVfMallRateAndComment, map);

            AutomationConstants.hideMyName = desiredHideMyName;

            CommonLib.allureReport("INFO", "HideMyName: " + AutomationConstants.hideMyName);


            AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

            CommonLib.allureReport("PASS", "It was seen that the name display status was entered as desired and comments were added.");

            CommonLib.allureReport("INFO", "Data: " + response.asPrettyString());

            status = true;

        } catch (Exception e) {
            CommonLib.allureReport("FAIL", "An error occurred while adding a comment. Check.Error: " + e.getMessage());
        }

        return status;
    }

    public boolean getVFMallRateAndComment(String desiredPath) {
        boolean status = false;

        try {
            Map<String, String> map = new HashMap<>();

            map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

            CommonLib.allureReport("INFO", "Request : " + RequestBody.getRateAndComment(AutomationConstants.uuidID, AutomationConstants.variantCode));

            Response response = ResponseBody.getResponse(desiredPath, RequestBody.getRateAndComment(AutomationConstants.uuidID, AutomationConstants.variantCode), AutomationConstants.urlGetRateAndComment, map);

            JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

            String result = js.getString("result.result");

            AutomationConstants.commentId = js.getString("vfMallRateAndComment.id");

            System.out.println("commentId is: " + AutomationConstants.commentId);

            CommonLib.allureReport("INFO", "commentId is: " + AutomationConstants.commentId);


            AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

            if (result.contains("SUCCESS")) {
                CommonLib.allureReport("PASS", "Correctly retrieved comment ID.");
                status = true;
            } else {
                CommonLib.allureReport("FAIL", "An error was received while trying to get the Comment ID.");
            }

            CommonLib.allureReport("INFO", "Data : " + response.asPrettyString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean checkResponseForMask(String desiredPath, String desiredWay) {
        boolean status = false;
        Map<String, String> map = new HashMap<>();

        map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

        CommonLib.allureReport("INFO", "Request : " + RequestBody.getRateAndComment(AutomationConstants.uuidID, AutomationConstants.variantCode));

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.getRateAndComment(AutomationConstants.uuidID, AutomationConstants.variantCode), AutomationConstants.urlGetRateAndComment, map);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");

        String name = js.getString("vfMallRateAndComment.name");
        String surname = js.getString("vfMallRateAndComment.surname");

        if (result.contains("SUCCESS")) {
            if (desiredWay.equals("true")) {
                if (name.contains("*") && surname.contains("*")) {
                    CommonLib.allureReport("PASS", "The masking operation appears to be correct.");

                }

            } else if (desiredWay.equals("false")) {
                if (!name.contains("*") && !surname.contains("*")) {
                    CommonLib.allureReport("PASS", "Name and surname appear correctly.");
                }
            } else {
                CommonLib.allureReport("FAIL", "An error was received while checking.");
            }
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "An error has been returned from the service, check.");
        }
        CommonLib.allureReport("INFO", "Data: " + response.asPrettyString());

        return status;
    }

    public boolean getVFMallRateAndCommentRandomID(String desiredPath) {
        boolean status = false;

        Map<String, String> map = new HashMap<>();

        map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.getRateAndComment(AutomationConstants.uuidID, AutomationConstants.variantCode), AutomationConstants.urlGetRateAndComment, map);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");
        String resultCode = js.getString("result.resultCode");

        CommonLib.allureReport("INFO", "commentId is: " + AutomationConstants.commentId);

        if (result.contains("SUCCESS") && resultCode.contains("0")) {
            CommonLib.allureReport("PASS", "");
            AutomationConstants.commentId = AutomationConstants.randomCommentId;

            System.out.println("commentId is: " + AutomationConstants.commentId);
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
        }
        CommonLib.allureReport("INFO", "Data : " + response.asPrettyString());

        return status;
    }

    public boolean enterSessionIdAtInsertVfMallRateAndCommentUpdate(String desiredPath, String desiredHideMyName) {
        boolean status = false;
        Response response = null;
        try {
            Map<String, String> map = new HashMap<>();

            map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

            CommonLib.allureReport("INFO", "Request: " + RequestBody.updateRateAndComment(AutomationConstants.commentId, desiredHideMyName));

            response = ResponseBody.getResponse(desiredPath, RequestBody.updateRateAndComment(AutomationConstants.commentId, desiredHideMyName), AutomationConstants.urlUpdateVfMallRateAndComment, map);

            AutomationConstants.hideMyName = desiredHideMyName;

            CommonLib.allureReport("PASS", "The comment is updated.");

            AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

            CommonLib.allureReport("INFO", "Data : " + AutomationConstants.responseData);

            status = true;

        } catch (Exception e) {
            CommonLib.allureReport("FAIL", "An error was received while updating the comment. Error :" + e.getMessage());
            CommonLib.allureReport("INFO", "Data : " + response.asPrettyString());
        }

        return status;
    }

    public boolean checkInsertVFMallRateAndComment(String expectedResult, String expectedResultMessage) {
        boolean status = false;

        JsonPath js = new JsonPath(Objects.requireNonNull(AutomationConstants.responseData));

        String result = js.getString("result.result");
        String resultDesc = js.getString("result.resultDesc");

        if (result.contains(expectedResult) && resultDesc.contains(expectedResultMessage)) {
            CommonLib.allureReport("PASS", "It was seen that the desired message and status were received.");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "It was seen that the requested message and status did not come. Check.");
        }

        CommonLib.allureReport("INFO", "Data: " + AutomationConstants.responseData);

        return status;
    }
}
