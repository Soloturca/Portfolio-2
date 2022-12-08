package base;

import java.util.ArrayList;
import java.util.List;

public class AutomationConstants {

    // DB constants
    public static String postgreUsername = "";
    public static String postgrePassword = "";
    public static String connectionString = "";
    public static String oracleUsername = "";
    public static String oraclePassword = "";

    // Proxy constants
    public static String proxyUsername = "srvc.pntest";
    public static String proxyPassword = "sX7/idykeqkqorxsopwjfjlfc";
    public static String proxyHost = "172.31.53.99";
    public static Integer proxyPort = 8080;

    //Common Values
    public static String responseData = "";
    public static String sessionId = "";

    public static List<String> title = new ArrayList<String>();
    public static List<String> idList = new ArrayList<String>();
    public static int sizeList;


    public static int id;
    public static String result;
    public static String status;
    public static String listPrice;
    public static String salePrice;
    public static String quantity;

    public static String msisdn = "";
    public static String code = "";
    public static String field = "";
    public static String txtTelNumber = "";
    public static String lastSevenDigits = "";


    //url api
    public static String urlCreatePaytionTokenURL = "http://vftr-auth-server.apps.mbt.vodafone.local/oauth/token";
    public static String urlKolaypackPreauth = "http://kolaypacks-api-server.apps.mbt.vodafone.local/preauth/";
    public static String CLIENT_ID = "test-client-01";
    public static String CLENT_SECRET = "secret";
    public static String token = "";


    public static String sIEDriverPath = "/Exes/IEDriverServer.exe";
    public static String sChromeDriverPath = "/Exes/chromedriver.exe";
    public static String sGeckoDriverPath = "/Exes/geckodriver.exe";
    public static String sMsEdgeDriverPath = "/Exes/msedgedriver.exe";
    public static long lngPageLoadTimeout = 90L;
    public static long lngImplicitWaitTimeout = 60L;
}
