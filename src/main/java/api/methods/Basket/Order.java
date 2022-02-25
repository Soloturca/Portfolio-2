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

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.payShoppingCart(), AutomationConstants.urlPayShoppingCart, map);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");
        String resultCode = js.getString("result.resultCode");

        if (result.contains("SUCCESS") && resultCode.contains("0")) {
            CommonLib.allureReport("PASS", "");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
            System.out.println(response.asPrettyString());
            CommonLib.waitSeconds(5);
        }

        return status;
    }

    public boolean VfMallOrderStatusPending(String desiredPath) {
        boolean status = false;

        Response response = ResponseBody.getResponse(desiredPath, "", AutomationConstants.token, AutomationConstants.urlVfMallOrders);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");

        AutomationConstants.orderId = js.getString("listSalesOrders.id[0]");
        System.out.println("orderId is: " + AutomationConstants.orderId);

        AutomationConstants.status = js.getString("listSalesOrders.status[0]");
        System.out.println("status:" + AutomationConstants.status);

        CommonLib.allureReport("INFO", "orderId is: " + AutomationConstants.orderId);

        if (result.contains("SUCCESS")) {
            CommonLib.allureReport("PASS", "");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
        }

        return status;
    }

    public boolean updateSalesOrderStatusChange(String desiredPath, String desiredStatus) {
        boolean status = false;

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.updateStatus(desiredStatus, AutomationConstants.orderId), AutomationConstants.urlUpdateSalesOrderStatus);

        System.out.println("orderId is: " + AutomationConstants.orderId);

        if (Objects.requireNonNull(response).getStatusCode() == HttpStatus.SC_OK) {
            AutomationConstants.status = desiredStatus;
            CommonLib.allureReport("PASS", "");
            System.out.println("Status is updated. Status is: " + AutomationConstants.status);
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
        }

        return status;
    }

    public boolean enterSessionIdAtInsertVfMallRateAndComment(String desiredPath, String desiredHideMyName) {
        boolean status = false;
        try {
            Map<String, String> map = new HashMap<>();

            map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

            Response response = ResponseBody.getResponse(desiredPath, RequestBody.insertRateAndComment(AutomationConstants.uuidID, AutomationConstants.variantCode, desiredHideMyName), AutomationConstants.urlInsertVfMallRateAndComment, map);

            AutomationConstants.hideMyName = desiredHideMyName;

            AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

            System.out.println(AutomationConstants.responseData);

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean getVFMallRateAndComment(String desiredPath) {
        boolean status = false;

        try {
            Map<String, String> map = new HashMap<>();

            map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

            Response response = ResponseBody.getResponse(desiredPath, RequestBody.getRateAndComment(AutomationConstants.uuidID, AutomationConstants.variantCode), AutomationConstants.urlGetRateAndComment, map);

            JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

            AutomationConstants.commentId = js.getString("vfMallRateAndComment.id");

            System.out.println("commentId is: " + AutomationConstants.commentId);

            AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

            System.out.println(AutomationConstants.responseData);

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

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

        AutomationConstants.commentId = AutomationConstants.randomCommentId;

        System.out.println("commentId is: " + AutomationConstants.commentId);

        CommonLib.allureReport("INFO", "commentId is: " + AutomationConstants.commentId);

        if (result.contains("SUCCESS") && resultCode.contains("0")) {
            CommonLib.allureReport("PASS", "");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
        }

        return status;
    }

    public boolean enterSessionIdAtInsertVfMallRateAndCommentUpdate(String desiredPath, String desiredHideMyName) {
        boolean status = false;
        try {
            Map<String, String> map = new HashMap<>();

            map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

            Response response = ResponseBody.getResponse(desiredPath, RequestBody.updateRateAndComment(AutomationConstants.commentId, desiredHideMyName), AutomationConstants.urlUpdateVfMallRateAndComment, map);

            AutomationConstants.hideMyName = desiredHideMyName;

            System.out.println(Objects.requireNonNull(response).asPrettyString());

            AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

            System.out.println(AutomationConstants.responseData);

            status = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean checkInsertVFMallRateAndComment(String expectedResult, String expectedResultMessage) {
        boolean status = false;

        JsonPath js = new JsonPath(Objects.requireNonNull(AutomationConstants.responseData));

        String result = js.getString("result.result");
        String resultDesc = js.getString("result.resultDesc");

        if (result.contains(expectedResult) && resultDesc.contains(expectedResultMessage)) {
            CommonLib.allureReport("PASS", "");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
            System.out.println(AutomationConstants.responseData);
        }

        return status;
    }
}
