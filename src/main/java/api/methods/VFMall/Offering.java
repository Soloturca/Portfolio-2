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

        if (barcode.isEmpty()) {
            Random rand = new Random();
            AutomationConstants.id = rand.nextInt(1000);
            barcode = UUID.randomUUID().toString();
        }
        String displayName = "automation" + AutomationConstants.id;

        Response response = ResponseBody.getResponse(desiredPath, RequestBody.createVfMallOffer(barcode, displayName, maxSaleCount, cargoCompanyID), AutomationConstants.token, AutomationConstants.urlCreateVfMallOffering);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        AutomationConstants.result = js.getString("result.result");
        AutomationConstants.offerStatus = js.getString("status");
        AutomationConstants.resultCode = js.getString("result.resultCode");
        AutomationConstants.resultDesc = js.getString("result.resultDesc");
        AutomationConstants.offerID = js.getString("offeringId");
        AutomationConstants.offerCode = js.getString("code");
        System.out.println("offeringId: " + AutomationConstants.offerID);
        CommonLib.allureReport("INFO", "offerID:" + AutomationConstants.offerID);

        if (maxSaleCount.equals("0") || barcode.equals("c8249cb5-0848-4cdc-9c91-1e7a576860d7") || cargoCompanyID.equals("601be73da23ffc44f4864242")) {
            if (AutomationConstants.result.contains("FAIL") && AutomationConstants.offerStatus == null) {
                status = true;
            }
        } else if (AutomationConstants.result.contains("SUCCESS") && AutomationConstants.offerStatus.contains("Active")) {
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "");
            CommonLib.allureReport("INFO", "DATA: " + response.asPrettyString());
        }

        return status;
    }

}
