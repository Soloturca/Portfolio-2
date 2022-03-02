package api.methods.VFMall;

import api.body.RequestBody;
import api.body.ResponseBody;
import api.methods.BaseMethods;
import base.AutomationConstants;
import base.CommonLib;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class Offering extends BaseMethods {
    public boolean createVfMallOfferingRequest(String desiredPath, String barcode, String maxSaleCount, String cargoCompanyID) {
        boolean status = false;

        CommonLib.waitSeconds(3);
        Response response = null;
        try {
            if (barcode.isEmpty()) {
                Random rand = new Random();
                AutomationConstants.id = rand.nextInt(1000);
                barcode = UUID.randomUUID().toString();
                AutomationConstants.uuidID = barcode;
                Random r = new Random();
                for (int i = 0; i < 4; i++) {
                    AutomationConstants.variantCode += (char) (r.nextInt(26) + 'a');
                }
            }

            AutomationConstants.variantCode += barcode;

            System.out.println("variantCode: " + AutomationConstants.variantCode);
            String displayName = "automation" + AutomationConstants.id;

            CommonLib.allureReport("INFO", "Request: " + RequestBody.createVfMallOffer(barcode, displayName, maxSaleCount, cargoCompanyID, AutomationConstants.variantCode));

            response = ResponseBody.getResponse(desiredPath, RequestBody.createVfMallOffer(barcode, displayName, maxSaleCount, cargoCompanyID, AutomationConstants.variantCode), AutomationConstants.token, AutomationConstants.urlCreateVfMallOffering);

            JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

            AutomationConstants.result = js.getString("result.result");
            AutomationConstants.offerStatus = js.getString("status");
            AutomationConstants.resultCode = js.getString("result.resultCode");
            AutomationConstants.resultDesc = js.getString("result.resultDesc");
            AutomationConstants.uuidID = js.getString("offeringId");
            AutomationConstants.offerCode = js.getString("code");

            System.out.println("offeringId: " + AutomationConstants.uuidID);

            CommonLib.allureReport("INFO", "offerID:" + AutomationConstants.uuidID);

            if (maxSaleCount.equals("0") || barcode.equals("c8249cb5-0848-4cdc-9c91-1e7a576860d7") || cargoCompanyID.equals("601be73da23ffc44f4864242")) {
                if (AutomationConstants.result.contains("FAIL") && AutomationConstants.offerStatus == null) {
                    status = true;
                    CommonLib.allureReport("PASS", "It was seen that the error was received as desired.");
                }
            } else if (AutomationConstants.result.contains("SUCCESS") && AutomationConstants.offerStatus.contains("Active")) {
                status = true;
                CommonLib.allureReport("FAIL", "Offer Status appears to be 'Active' and progressing properly.");
            } else {
                CommonLib.allureReport("FAIL", "An error occurred while generating data. Check.");
            }

            CommonLib.allureReport("INFO", "DATA: " + response.asPrettyString());
        } catch (Exception e) {
            CommonLib.allureReport("FAIL", "An error occurred while generating data. Check.Error : " + e.getMessage());
            CommonLib.allureReport("INFO", "DATA: " + response.asPrettyString());
        }

        return status;
    }
}
