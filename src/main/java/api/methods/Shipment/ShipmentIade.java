package api.methods.Shipment;

import api.body.RequestBody;
import api.body.ResponseBody;
import base.AutomationConstants;
import base.CommonLib;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Objects;

public class ShipmentIade {
    public boolean createShipmentIade(String desiredMethod, String desiredShipmentRefNo, String desiredShipmentCompany, String desiredPath) {
        boolean status = false;

        try {
            Response response = ResponseBody.getResponse(desiredPath, RequestBody.createShipmentIade(desiredShipmentRefNo, desiredShipmentCompany), AutomationConstants.urlCreateShipment + desiredMethod);

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
}
