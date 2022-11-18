package api.examplemethods.vfMall;

import api.examplebody.ExampleRequestBody;
import api.examplebody.ExampleResponseBody;
import api.examplemethods.BaseMethods;
import base.AutomationConstants;
import base.CommonLib;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

public class Offering extends BaseMethods {

    public boolean createVFMallOffering(String desiredPath, String barcode, String brand, String cargoCompID, String catID, String deliveryDuration, String desc, String displayName, String images, String listPrice, String salePrice, String quantity) {

        boolean status = false;

        if (!listPrice.isEmpty()) {
            if (listPrice.contains(".")) {
                double listPriceFloat = Double.parseDouble(listPrice);
                double roundOff = Math.round(listPriceFloat * 100.0) / 100.0;
                AutomationConstants.listPrice = String.format(Locale.US, "%.2f", roundOff);
            } else {
                float listPriceFloat = (float) (Integer.parseInt(listPrice));
                AutomationConstants.listPrice = String.format(Locale.US, "%.2f", listPriceFloat);
            }
        }

        if (!salePrice.isEmpty()) {
            if (salePrice.contains(".")) {
                double salePriceFloat = Double.parseDouble(salePrice);
                double roundOff = Math.round(salePriceFloat * 100.0) / 100.0;
                AutomationConstants.salePrice = String.format(Locale.US, "%.2f", roundOff);
            } else {
                float salePriceFloat = (float) (Integer.parseInt(salePrice));
                AutomationConstants.salePrice = String.format(Locale.US, "%.2f", salePriceFloat);
            }
        }

        AutomationConstants.quantity = quantity;

        if (barcode.isEmpty()) {
            barcode = UUID.randomUUID().toString();
            AutomationConstants.barcode = barcode;
            System.out.println("Barcode: " + AutomationConstants.barcode);
        } else {
            AutomationConstants.barcode = barcode;
            System.out.println("Barcode: " + AutomationConstants.barcode);
        }

        Response response = ExampleResponseBody.getResponse(desiredPath, ExampleRequestBody.createVFMallOffering(AutomationConstants.barcode, brand, cargoCompID, catID, deliveryDuration, desc, displayName, images, listPrice, salePrice, quantity),
                AutomationConstants.token, AutomationConstants.urlCreateVfMallOffering);

        AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

        System.out.println("Response is: " + Objects.requireNonNull(response).asPrettyString());

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        AutomationConstants.result = js.getString("result.result");
        AutomationConstants.code = js.getString("code");

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


    public boolean createVFMallOfferingWithOutImages(String desiredPath, String barcode, String brand, String catID, String deliveryDuration, String desc, String displayName, String listPrice, String salePrice, String quantity) {

        boolean status = false;

        if (barcode.isEmpty()) {

            barcode = UUID.randomUUID().toString();
            AutomationConstants.barcode = barcode;
            System.out.println("Barcode: " + AutomationConstants.barcode);
        } else {
            AutomationConstants.barcode = barcode;
            System.out.println("Barcode: " + AutomationConstants.barcode);
        }

        Response response = ExampleResponseBody.getResponse(desiredPath, ExampleRequestBody.createVFMallOfferingWithOutImages(AutomationConstants.barcode, brand, catID, deliveryDuration, desc, displayName, listPrice, salePrice, quantity),
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
}
