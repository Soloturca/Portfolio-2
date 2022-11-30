package api.body;

import api.baseMethods.BaseMethods;
import api.paytionPojo.OriginatorInfo;
import base.AutomationConstants;
import base.CommonLib;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

public class Responses extends BaseMethods {

    /**
     * Function:RESPONSE Body for KolayPackPreAuth API
     * Description:
     * Author: Baturay Caglasin
     * Date: Nov'22
     */
    public boolean KolaypackPreauthPostResponse(String desiredRequestMethod, String transactionId, String transactionGroupId, String reconDate, String ipAddress, String companyId, String institutionId, String productId, String bankId, String transactionDate, String description, String paymentMethod, String customerReferenceType, String sun, String customerCode, String installment) {
        boolean status = false;

        Response response = ResponseBody.getResponse(desiredRequestMethod, Requests.KolaypackPreauthPostRequest(transactionId, transactionGroupId, reconDate, ipAddress,
                        companyId, institutionId, productId, bankId, transactionDate, description,
                        paymentMethod, customerReferenceType, sun, customerCode, installment),
                AutomationConstants.token, AutomationConstants.urlKolaypackPreauth);

        AutomationConstants.responseData = Objects.requireNonNull(response).asPrettyString();

        System.out.println("Response is: " + Objects.requireNonNull(response).asPrettyString());

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        AutomationConstants.result = js.getString("result.result");
        AutomationConstants.code = js.getString("code");

        if (response.getStatusCode() == HttpStatus.SC_OK) {
            status = true;
            CommonLib.allureReport("PASS", "KolaypackPreauth service sent successfully!");
            System.out.println("KolaypackPreauth service sent successfully.");
        } else {
            CommonLib.allureReport("FAIL", "Check it. KolaypackPreauth service unsuccessfully");
        }
        return status;
    }

}
