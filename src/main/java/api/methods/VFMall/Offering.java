package api.methods.VFMall;

import api.body.RequestBody;
import api.body.ResponseBody;
import api.methods.BaseMethods;
import base.AutomationConstants;
import base.CommonLib;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.Objects;
import java.util.Random;

public class Offering extends BaseMethods {

    public boolean createVFMallOffering(String desiredPath, String brand, String catID, String deliveryDuration, String desc, String displayName, String images, String listPrice, String salePrice, String quantity) {

        boolean status = false;

        Random rand = new Random();
        AutomationConstants.barcode += +rand.nextInt(1000000000);
        System.out.println("Barcode: " + AutomationConstants.barcode);

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.createVFMallOffering(AutomationConstants.barcode, brand, catID, deliveryDuration, desc, displayName, images, listPrice, salePrice, quantity),
                AutomationConstants.token, AutomationConstants.urlCreateVfMallOffering);

        AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

        System.out.println("Response is: " + Objects.requireNonNull(response).asPrettyString());

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        AutomationConstants.result = js.getString("result.result");

        if (response.getStatusCode() == HttpStatus.SC_OK && AutomationConstants.result.contains("SUCCESS")) {
            status = true;
            CommonLib.allureReport("PASS", "CreateVFMallOffering service sent successfully.");
            System.out.println("CreateVFMallOffering service sent successfully.");
        }
        if (response.getStatusCode() == HttpStatus.SC_OK && AutomationConstants.result.contains("FAIL")) {
            status = true;
            CommonLib.allureReport("PASS", "CreateVFMallOffering service empty fields check successfully.");
            System.out.println("CreateVFMallOffering service empty fields check successfully.");
        } else {
            CommonLib.allureReport("FAIL", "Check it. CreateVFMallOffering service unsuccessfully");
        }
        return status;
    }

    public boolean checkFields(String expectedResult, String exceptedResultDesc) {
        boolean status = false;

        JsonPath js = new JsonPath(Objects.requireNonNull(AutomationConstants.responseData));

        String result = js.getString("result.result");
        String resultDesc = js.getString("result.resultDesc");

        if (result.contains(expectedResult) && resultDesc.contains(exceptedResultDesc)) {
            CommonLib.allureReport("PASS", "It was seen that the desired message and status were received.");
            CommonLib.allureReport("INFO", "Result is: " + result);
            CommonLib.allureReport("INFO", "Result Description is: " + resultDesc);
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "It was seen that the requested message and status did not come. Check.");
        }

        CommonLib.allureReport("INFO", "Data: " + AutomationConstants.responseData);

        return status;
    }


    public boolean createVFMallOfferingWithOutImages(String desiredPath, String brand, String catID, String deliveryDuration, String desc, String displayName, String listPrice, String salePrice, String quantity) {

        boolean status = false;

        Random rand = new Random();
        AutomationConstants.barcode += +rand.nextInt(1000000000);
        System.out.println("Barcode: " + AutomationConstants.barcode);

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.createVFMallOfferingWithOutImages(AutomationConstants.barcode, brand, catID, deliveryDuration, desc, displayName, listPrice, salePrice, quantity),
                AutomationConstants.token, AutomationConstants.urlCreateVfMallOffering);

        AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

        System.out.println("Response is: " + Objects.requireNonNull(response).asPrettyString());

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        AutomationConstants.result = js.getString("result.result");

        if (response.getStatusCode() == HttpStatus.SC_OK && AutomationConstants.result.contains("SUCCESS")) {
            status = true;
            CommonLib.allureReport("PASS", "CreateVFMallOffering service sent successfully.");
            System.out.println("CreateVFMallOffering service sent successfully.");
        }
        if (response.getStatusCode() == HttpStatus.SC_OK && AutomationConstants.result.contains("FAIL")) {
            status = true;
            CommonLib.allureReport("PASS", "CreateVFMallOffering service empty fields check successfully.");
            System.out.println("CreateVFMallOffering service empty fields check successfully.");
        } else {
            CommonLib.allureReport("FAIL", "Check it. CreateVFMallOffering service unsuccessfully");
        }
        return status;
    }








    //public boolean createVfMallOfferingRequest(String desiredPath, String barcode, String maxSaleCount, String cargoCompanyID) {
    //    boolean status = false;
    //
    //    CommonLib.waitSeconds(3);
    //    Response response = null;
    //    try {
    //        if (barcode.isEmpty()) {
    //            AutomationConstants.variantCode = "";
    //            AutomationConstants.uuidID = "";
    //            Random rand = new Random();
    //            AutomationConstants.id = rand.nextInt(1000);
    //            barcode = UUID.randomUUID().toString();
    //            AutomationConstants.uuidID = barcode;
    //            Random r = new Random();
    //            for (int i = 0; i < 4; i++) {
    //                AutomationConstants.variantCode += (char) (r.nextInt(26) + 'a');
    //            }
    //        }
    //        AutomationConstants.variantCode += barcode;
    //
    //        System.out.println("variantCode: " + AutomationConstants.variantCode);
    //        String displayName = "automation" + AutomationConstants.id;
    //
    //        CommonLib.allureReport("INFO", "Request: " + RequestBody.createVfMallOffer(barcode, displayName, maxSaleCount, cargoCompanyID, AutomationConstants.variantCode));
    //
    //        CommonLib.waitSeconds(10);
    //
    //        response = ResponseBody.getResponse(desiredPath, RequestBody.createVfMallOffer(barcode, displayName, maxSaleCount, cargoCompanyID, AutomationConstants.variantCode), AutomationConstants.token, AutomationConstants.urlCreateVfMallOffering);
    //
    //        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());
    //
    //        AutomationConstants.result = js.getString("result.result");
    //        AutomationConstants.offerStatus = js.getString("status");
    //        AutomationConstants.resultCode = js.getString("result.resultCode");
    //        AutomationConstants.resultDesc = js.getString("result.resultDesc");
    //        AutomationConstants.uuidID = js.getString("offeringId");
    //        AutomationConstants.offerCode = js.getString("code");
    //
    //        System.out.println("offeringId: " + AutomationConstants.uuidID);
    //
    //        CommonLib.allureReport("INFO", "offerID:" + AutomationConstants.uuidID);
    //
    //        if (maxSaleCount.equals("0") || barcode.equals("c8249cb5-0848-4cdc-9c91-1e7a576860d7") || cargoCompanyID.equals("601be73da23ffc44f4864242")) {
    //            if (AutomationConstants.result.contains("FAIL") && AutomationConstants.offerStatus == null) {
    //                status = true;
    //                CommonLib.allureReport("PASS", "It was seen that the error was received as desired.");
    //            }
    //        } else if (AutomationConstants.result.contains("SUCCESS") && AutomationConstants.offerStatus.contains("Active")) {
    //            status = true;
    //            CommonLib.allureReport("FAIL", "Offer Status appears to be 'Active' and progressing properly.");
    //        } else {
    //            CommonLib.allureReport("FAIL", "An error occurred while generating data. Check.");
    //        }
    //
    //        CommonLib.allureReport("INFO", "DATA: " + response.asPrettyString());
    //    } catch (Exception e) {
    //        CommonLib.allureReport("FAIL", "An error occurred while generating data. Check.Error : " + e.getMessage());
    //        CommonLib.allureReport("INFO", "Response: " + response.asPrettyString());
    //    }
    //
    //    return status;
    //}

}
