package api.baseMethods;


import api.tokenMethods.OAUTH2GrantTypeTestCase;
import api.base.AutomationConstants;
import api.base.CommonLib;

public class BaseMethods {

    public boolean createPaytionTokenRequest() {
        boolean status = false;

        OAUTH2GrantTypeTestCase oauth2GrantTypeTestCase = new OAUTH2GrantTypeTestCase();
        String token = oauth2GrantTypeTestCase.testOAuthWithClientCredential();
        System.out.println("The token was created correctly:" + token);
        AutomationConstants.token = token;
        System.out.println("The AutomationConstants.token:" + AutomationConstants.token);

        if (token != null) {
            status = true;
            CommonLib.allureReport("PASS", "The token was created correctly.");
        } else {
            CommonLib.allureReport("FAIL", "Error getting token. Check it.");
        }
        return status;
    }
}
