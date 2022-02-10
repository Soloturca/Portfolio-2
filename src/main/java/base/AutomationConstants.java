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

    public static String apiURL = "https://rickandmortyapi.com/api/";

    //Common Values
    public static String responseData = "";
    public static String sessionId = "";
    public static String customerProfileId = "";
    public static String msisdn = "5499940334";
    public static String deliveryAddressId = "";
    public static String invoiceAddressId = "";
    public static String offeringId = "00b34d43-bcd2-4f11-9668-3346e7202192";
    public static String shoppingCartId = "";

    public static List<String> title = new ArrayList<String>();
    public static List<String> idList = new ArrayList<String>();
    public static int sizeList;

    public static String token = "";
    public static int id;
    public static String offerID;
    public static String result;
    public static String offerStatus;
    public static String resultCode;
    public static String resultDesc;
    public static String offerCode;
    public static String status;

    public static String salesAmount;
    public static String listAmount;
    public static String productQuantity;
    public static String updatedSalesAmount;
    public static String updatedListAmount;
    public static String updatedProductQuantity;
    public static String variantCode;


    public static String urlCreateToken = "http://10.177.244.60:7003/ws/rest/v10/token/subscription/create";
    public static String urlCreateSubscription = "http://10.177.244.60:7003/ws/rest/v11/subscription/create";
    public static String urlCreateSessionId = "http://10.86.244.136:8080/api?method=createSession&password=11111111&msisdn=5485009042";
    public static String urlGetVFMallOfferingDetails = "http://10.86.244.136:8080/vfmall/getVFMallOfferingDetails";
    public static String urlCreateVfMallToken = "http://ms-vfmall-api-marketplace.apps.mbt.vodafone.local/vfmallapi/createVfMallToken";
    public static String urlGetVfMallHomePage = "http://10.86.244.136:8080/vfmall/getVFMallHomePage";
    public static String urlCreateVfMallOffering = "http://ms-vfmall-api-marketplace.apps.mbt.vodafone.local/vfmallapi/createVfMallOffering";
    public static String urlUpdateVfMallStockAndPrice = "http://ms-vfmall-api-marketplace.apps.mbt.vodafone.local/vfmallapi/updateVfMallStockAndPrice";
    public static String urlShoppingJourney = "http://10.86.244.136:8080";
    public static String urlAddCustomerProfile = "http://10.86.244.136:8080/vfmall/addVFMallCustomerProfile";
    public static String urlAddCartItem = "http://10.86.244.136:8080/api";
    public static String urlPayShoppingCart = "http://10.86.244.136:8080/";
    public static String urlInsertVfMallRateAndComment = "https://efes.vodafone.com.tr/vfmall/insertVFMallRateAndComment";


    //Mongo
    public static String MongoDBHost = "172.31.40.25";
    public static Integer MongoDBPortPRP = 27017;
    public static String MongoDBUsername = "tces";
    public static String MongoDBPassword = "$uper@dmin";
    public static String MongoGeneralDatabase = "admin";
    public static String MongoDBVfmall = "vfmall";
    public static String MongoDBProductCatalog = "productcatalog";
    public static String MongoDBSequence = "Sequence";
    public static String MongoDBHomePage = "homepage";
    public static String MongoDBSimpleOffering = "SimpleOffering";
    public static String MongoLocalDb = "mongodb://test:marketplace2218@localhost:27017/?authSource=productcatalog";
}
