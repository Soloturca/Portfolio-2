package api.methods.VFMall;

import api.body.ResponseBody;
import api.methods.BaseMethods;
import api.model.JSON.ParameterDTO;
import base.AutomationConstants;
import base.CommonLib;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HomePage extends BaseMethods {
    public boolean getVfMallHomepageRequestWithSessionID(String desiredPath) {
        boolean status = false;

        Map<String, String> map = new HashMap<>();

        map.put(String.valueOf(ParameterDTO.sid), AutomationConstants.sessionId);

        Response response = ResponseBody.getResponse(desiredPath, "", "", AutomationConstants.urlGetVfMallHomePage, map);

        JsonPath js = new JsonPath(Objects.requireNonNull(response).asPrettyString());

        String result = js.getString("result.result");

        AutomationConstants.idList = js.get("vfmallHome.id");
        AutomationConstants.sizeList = AutomationConstants.idList.size();
        System.out.println("idList:" + AutomationConstants.idList);
        CommonLib.allureReport("INFO", "idList:" + AutomationConstants.idList);

        AutomationConstants.title = js.get("vfmallHome.title");
        System.out.println("title:" + AutomationConstants.title);
        CommonLib.allureReport("INFO", "title:" + AutomationConstants.title);

        if (result.contains("SUCCESS")) {
            CommonLib.allureReport("PASS", "Title field appears.");
            status = true;
        } else {
            CommonLib.allureReport("FAIL", "It appears that an error has been received. Check it.");
        }
        CommonLib.allureReport("INFO", "DATA: " + response.asPrettyString());
        return status;
    }
}
