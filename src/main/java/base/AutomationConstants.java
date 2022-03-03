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

    //Common Values
    public static String responseData = "";
    public static String sessionId = "";
    public static String customerProfileId = "";
    public static String deliveryAddressId = "";
    public static String invoiceAddressId = "";
    public static String shoppingCartId = "";
    public static String orderId = "";
    public static String commentId = "";
    public static String randomCommentId = "11";

    public static List<String> title = new ArrayList<String>();
    public static List<String> idList = new ArrayList<String>();
    public static int sizeList;

    public static String token = "";
    public static int id;
    public static String uuidID;
    public static String result;
    public static String offerStatus;
    public static String resultCode;
    public static String resultDesc;
    public static String offerCode;
    public static String status;
    public static String hideMyName;

    public static String salesAmount;
    public static String listAmount;
    public static String productQuantity;
    public static String updatedSalesAmount = "";
    public static String updatedListAmount = "";
    public static String updatedProductQuantity;
    public static String variantCode = "";

    //url
    public static String urlCreateToken = "http://10.177.244.60:7003/ws/rest/v10/token/subscription/create";
    public static String urlCreateSubscription = "http://10.177.244.60:7003/ws/rest/v11/subscription/create";
    public static String urlCreateSessionId = "http://10.86.244.136:8080/api?method=createSession&password=11111111&msisdn=";
    public static String urlGetVFMallOfferingDetails = "http://10.86.244.136:8080/vfmall/getVFMallOfferingDetails";
    public static String urlCreateVfMallToken = "http://ms-vfmall-api-marketplace.apps.mbt.vodafone.local/vfmallapi/createVfMallToken";
    public static String urlGetVfMallHomePage = "http://10.86.244.136:8080/vfmall/getVFMallHomePage";
    public static String urlCreateVfMallOffering = "http://ms-vfmall-api-marketplace.apps.mbt.vodafone.local/vfmallapi/createVfMallOffering";
    public static String urlUpdateVfMallStockAndPrice = "http://ms-vfmall-api-marketplace.apps.mbt.vodafone.local/vfmallapi/updateVfMallStockAndPrice";
    public static String urlShoppingJourney = "http://10.86.244.136:8080";
    public static String urlAddCustomerProfile = "http://10.86.244.136:8080/vfmall/addVFMallCustomerProfile";
    public static String urlAddCartItem = "http://10.86.244.136:8080/api";
    public static String urlPayShoppingCart = "http://10.86.244.136:8080/";
    public static String urlVfMallOrders = "http://ms-vfmall-api-marketplace.apps.mbt.vodafone.local/vfmallapi/getVfMallOrders?status=PENDING&size=10";
    public static String urlUpdateSalesOrderStatus = "http://ms-shop-operation-marketplace.apps.mbt.vodafone.local/shopoperation/updateSalesOrderStatusV2";
    public static String urlInsertVfMallRateAndComment = "https://efes.vodafone.com.tr/vfmall/insertVFMallRateAndComment";
    public static String urlGetRateAndComment = "https://efes.vodafone.com.tr/vfmall/getVFMallRateAndComment";
    public static String urlUpdateVfMallRateAndComment = "https://efes.vodafone.com.tr/vfmall/updateVFMallRateAndComment";
}
