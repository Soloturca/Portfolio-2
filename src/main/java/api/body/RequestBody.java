package api.body;

import api.model.JSON.AddVfMallCustomerProfile;
import api.model.JSON.CreateShipment.*;
import api.model.JSON.CreateVfMallToken;
import api.model.JSON.GetOfferingDetails;
import api.model.JSON.ShoppingCart.PayShoppingCart;
import api.model.JSON.RateAndComment.GetRateAndComment;
import api.model.JSON.RateAndComment.InsertRateComment;
import api.model.JSON.RateAndComment.UpdateRateAndComment;
import api.model.JSON.ShoppingCart.SaveShoppingCartAddress;
import api.model.JSON.ShipmentStatus;
import api.model.JSON.UpdateStatus.OrderStatusRequest;
import api.model.JSON.UpdateStatus.UpdateStatus;
import base.CommonLib;

import java.util.ArrayList;
import java.util.List;

public class RequestBody {

    //API SIDE
    public static String createVfMallOffer(String barcode, String displayName, String maxSaleCount, String cargoCompanyID, String variantCode) {
        return "{\n" +
                "  \"barcode\": \"" + barcode + "\",\n" +
                "  \"brand\": \"5fd0833e183b320001c8b816\",\n" +
                "  \"cargoCompanyId\": \"" + cargoCompanyID + "\",\n" +
                "  \"categoryId\": \"83f2e6e7-7959-441f-8779-1838a51f4c2a\",\n" +
                "  \"deliveryDuration\": 4,\n" +
                "  \"description\": \"<html>Urun aciklama </html>\",\n" +
                "  \"displayName\": \"" + displayName + "\",\n" +
                "  \"images\": [\n" +
                "    \"http://personal.psu.edu/xqz5228/jpg.jpg\",\n" +
                "    \"http://personal.psu.edu/xqz5228/jpg.jpg\"\n" +
                "  ],\n" +
                "  \"listPrice\": 1600,\n" +
                "  \"name\": \"" + displayName + "\",\n" +
                "  \"quantity\": 10,\n" +
                "  \"cargoPaymentFlag\": \"MERCHANT\",\n" +
                "  \"salePrice\": 950,\n" +
                "  \"stockCode\": \"MJ6667S\",\n" +
                "  \"title\": \"Title Test\",\n" +
                "  \"variantCode\": \"" + variantCode + "\",\n" +
                "  \"dimensionalWeight\": \"10\",\n" +
                "  \"vatRate\": 18,\n" +
                "  \"maxSaleCount\": " + maxSaleCount + ",\n" +
                "  \"parameters\": [\n" +
                "    {\n" +
                "      \"id\": \"f7aba4ab-ce1f-4260-a5e9-e15ad5c15b5c\",\n" +
                "      \"name\": \"Cinsiyet\",\n" +
                "      \"code\": \"49158665-647\",\n" +
                "      \"value\": [\n" +
                "        \"Kadın\"\n" +
                "      ],\n" +
                "      \"isVariant\": false,\n" +
                "      \"parameterTypeCode\": \"CATEGORY\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"3c338328-d8fe-4558-bbb3-571527c31593\",\n" +
                "      \"name\": \"Model\",\n" +
                "      \"code\": \"61062192-707\",\n" +
                "      \"value\": [\n" +
                "        \"Fonksiyonel\"\n" +
                "      ],\n" +
                "      \"isVariant\": false,\n" +
                "      \"parameterTypeCode\": \"CATEGORY\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"8c19bcc0-d498-4fb1-8c18-b8356c2bcefb\",\n" +
                "      \"name\": \"Özellik\",\n" +
                "      \"code\": \"60941201-267\",\n" +
                "      \"value\": [\n" +
                "        \"Gore-Tex\"\n" +
                "      ],\n" +
                "      \"isVariant\": false,\n" +
                "      \"parameterTypeCode\": \"CATEGORY\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"5353d989-eade-470f-9225-09a63bf8173a\",\n" +
                "      \"name\": \"Stil\",\n" +
                "      \"code\": \"27921366-281\",\n" +
                "      \"value\": [\n" +
                "        \"Casual Gece Klasik Sokak Stili Trend\"\n" +
                "      ],\n" +
                "      \"isVariant\": false,\n" +
                "      \"parameterTypeCode\": \"CATEGORY\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"087fd7c8-107e-4708-b567-c1c4414f07f5\",\n" +
                "      \"name\": \"Yaş Grubu\",\n" +
                "      \"code\": \"03406645-697\",\n" +
                "      \"value\": [\n" +
                "        \"Yetişkin\"\n" +
                "      ],\n" +
                "      \"isVariant\": false,\n" +
                "      \"parameterTypeCode\": \"CATEGORY\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"456168b7-da5a-41ed-b741-7de680a7cf35\",\n" +
                "      \"name\": \"Beden\",\n" +
                "      \"code\": \"17930552-047\",\n" +
                "      \"value\": [\n" +
                "        \"S\"\n" +
                "      ],\n" +
                "      \"isVariant\": true,\n" +
                "      \"parameterTypeCode\": \"CATEGORY\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"404c6f40-5961-4dfd-aedb-69bdc48d4c31\",\n" +
                "      \"value\": [\n" +
                "        \"Mavi\"\n" +
                "      ],\n" +
                "      \"isVariant\": true\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    public static String updateVfMallStockAndPrice(String listPriceU, String quantityU, String salePriceU) {
        return "{\n" +
                "  \"offerings\": [\n" +
                "    {\n" +
                "      \"id\": \"3f72dcaf-cc9a-469f-8f59-08bbd689ed2f\",\n" +
                "      \"listPrice\": \"" + listPriceU + "\",\n" +
                "      \"quantity\": \"" + quantityU + "\",\n" +
                "      \"salePrice\": \"" + salePriceU + "\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    public static String addVFMallCustomerProfile(String msisdn) {

        AddVfMallCustomerProfile addVfMallCustomerProfile = new AddVfMallCustomerProfile();

        addVfMallCustomerProfile.setName("otomasyon");
        addVfMallCustomerProfile.setSurname("otomasyon");
        addVfMallCustomerProfile.setContactNumber("");
        addVfMallCustomerProfile.setMsisdn(msisdn);
        addVfMallCustomerProfile.setCity("Bolu");
        addVfMallCustomerProfile.setDistrict("Abant");
        addVfMallCustomerProfile.setAddressTitle("otomasyon");
        addVfMallCustomerProfile.setDetailedAddress("BJKasd22  Mah. 1905098 Sok.Karakartalasdf2222 Cad. Vofomall2 Apt. NO:19 D:05");

        return CommonLib.prepJson(addVfMallCustomerProfile);
    }

    public static String saveShoppingCartAddress(String deliveryAddressId, String invoiceAddressId) {

        SaveShoppingCartAddress saveShoppingCartAddress = new SaveShoppingCartAddress();

        saveShoppingCartAddress.setDeliveryAddressId(deliveryAddressId);
        saveShoppingCartAddress.setInvoiceAddressId(invoiceAddressId);
        saveShoppingCartAddress.setShoppingCartId("");

        return CommonLib.prepJson(saveShoppingCartAddress);
    }

    public static String addCartItems(String uuidID) {
        return "[\n" +
                "\n" +
                "{\n" +
                "    \"offeringId\": \"" + uuidID + "\",\n" +
                "    \"quantity\": \"1\"\n" +
                "}\n" +
                "]";
    }

    public static String getOfferingDetails() {

        GetOfferingDetails getOfferingDetails = new GetOfferingDetails();

        getOfferingDetails.setUuid("00b34d43-bcd2-4f11-9668-3346e7202192");

        return CommonLib.prepJson(getOfferingDetails);
    }

    public static String createVfMallToken() {

        CreateVfMallToken createVfMallToken=new CreateVfMallToken();

        createVfMallToken.setIntegratorCode("");
        createVfMallToken.setPassword("Test123456*");
        createVfMallToken.setUsername("muafpartner.autovfmall@hotmail.com");

        return CommonLib.prepJson(createVfMallToken);
    }

    public static String insertRateAndComment(String uuidID, String variantCode, String desiredHideMyName) {

        InsertRateComment insertRateComment = new InsertRateComment();

        insertRateComment.setUuid(uuidID);
        insertRateComment.setVariantCode(variantCode);
        insertRateComment.setRate(4);
        insertRateComment.setTitle("eh fena değil");
        insertRateComment.setComment("çok kaliteli değil ama iş görür.");
        insertRateComment.setHideMyName(Boolean.parseBoolean(desiredHideMyName));
        insertRateComment.setHeight("192");
        insertRateComment.setWeight("92");

        return CommonLib.prepJson(insertRateComment);
    }

    public static String getRateAndComment(String uuidID, String variantCode) {

        GetRateAndComment getRateAndComment = new GetRateAndComment();

        getRateAndComment.setUuid(uuidID);
        getRateAndComment.setVariantCode(variantCode);

        return CommonLib.prepJson(getRateAndComment);
    }

    public static String updateRateAndComment(String commentId, String desiredHideMyName) {

        UpdateRateAndComment updateRateAndComment = new UpdateRateAndComment();

        updateRateAndComment.setId(commentId);
        updateRateAndComment.setRate(3);
        updateRateAndComment.setTitle("Harika");
        updateRateAndComment.setStatus("1");
        updateRateAndComment.setComment("Alır almaz bitirdim");
        updateRateAndComment.setHideMyName(Boolean.parseBoolean(desiredHideMyName));

        return CommonLib.prepJson(updateRateAndComment);
    }

    public static String payShoppingCart() {

        PayShoppingCart payShoppingCart = new PayShoppingCart();

        payShoppingCart.setCardUniqueId("string");
        payShoppingCart.setMasterpassTokenId("alos");
        payShoppingCart.setPaymentTokenId("string");

        return CommonLib.prepJson(payShoppingCart);

    }

    public static String updateStatus(String desiredStatus, String orderId) {

        UpdateStatus updateStatus=new UpdateStatus();
        OrderStatusRequest orderStatusRequest = new OrderStatusRequest();

        orderStatusRequest.setOrderId(orderId);
        orderStatusRequest.setReasonCode("");
        orderStatusRequest.setReasonText("");

        updateStatus.setChangedBy("ORDER_TRACKING");
        updateStatus.setNewStatus(desiredStatus);
        List<OrderStatusRequest> orderStatusRequestsValues = new ArrayList<>();
        orderStatusRequestsValues.add(orderStatusRequest);
        updateStatus.setOrderStatusRequests(orderStatusRequestsValues);
        updateStatus.setReturnOrders(false);

        return CommonLib.prepJson(updateStatus);
    }

    //CORE SIDE
    public static String createShipment(String shipmentRefNo, String shipmentCompany) {

        CreateShipment createShipment = new CreateShipment();
        FromAddress fromAddress = new FromAddress();
        ToAddress toAddress = new ToAddress();
        Item item = new Item();
        Size size = new Size();

        fromAddress.setCity("İSTANBUL");
        fromAddress.setTown("Sarıyer");
        fromAddress.setName("Fatma");
        fromAddress.setSurname("Delen");
        fromAddress.setText("Maslak Mah. Eski Büyükdere Cad. Orjin Maslak Plaza No:27 Kat:2-3-4 Daire:54-57-59 Sarıyer 34485 İstanbul");
        fromAddress.setMsisdn("5363636363");

        toAddress.setCity("istanbul");
        toAddress.setTown("kağıthane");
        toAddress.setName("Deneme");
        toAddress.setSurname("Delen");
        toAddress.setText("Merkez Mahallesi, Ayazma Cad. Papirus Plaza, B Blok, No: 37/44 Kağıthane/İstanbul ");
        toAddress.setMsisdn("5363636363");

        item.setCode("01");
        item.setName("test1");
        item.setWeight(1);
        item.setQuantity(1);
        item.setSize(size);
        size.setDeci(1);

        createShipment.setShipmentRefNo(shipmentRefNo);
        createShipment.setShipmentCompany(shipmentCompany);
        createShipment.setShipmentPayer("PLATFORM");
        createShipment.setCustomerShip(false);
        createShipment.setFromAddress(fromAddress);
        createShipment.setToAddress(toAddress);
        List<Item> itemValues = new ArrayList<>();
        itemValues.add(item);
        createShipment.setItems(itemValues);

        return CommonLib.prepJson(createShipment);
    }

    public static String createShipmentEmptyFromAddressText(String shipmentRefNo, String shipmentCompany) {

        CreateShipment createShipment = new CreateShipment();
        FromAddress fromAddress = new FromAddress();
        ToAddress toAddress = new ToAddress();
        Item item = new Item();
        Size size = new Size();

        fromAddress.setCity("İSTANBUL");
        fromAddress.setTown("Sarıyer");
        fromAddress.setName("Fatma");
        fromAddress.setSurname("Delen");
        fromAddress.setText("");
        fromAddress.setMsisdn("5363636363");

        toAddress.setCity("istanbul");
        toAddress.setTown("kağıthane");
        toAddress.setName("Deneme");
        toAddress.setSurname("Delen");
        toAddress.setText("Merkez Mahallesi, Ayazma Cad. Papirus Plaza, B Blok, No: 37/44 Kağıthane/İstanbul ");
        toAddress.setMsisdn("5363636363");

        item.setCode("01");
        item.setName("test1");
        item.setWeight(1);
        item.setQuantity(1);
        item.setSize(size);
        size.setDeci(1);

        createShipment.setShipmentRefNo(shipmentRefNo);
        createShipment.setShipmentCompany(shipmentCompany);
        createShipment.setShipmentPayer("PLATFORM");
        createShipment.setCustomerShip(false);
        createShipment.setFromAddress(fromAddress);
        createShipment.setToAddress(toAddress);
        List<Item> itemValues = new ArrayList<>();
        itemValues.add(item);
        createShipment.setItems(itemValues);

        return CommonLib.prepJson(createShipment);
    }

    public static String createShipmentEmptyToAddressText(String shipmentRefNo, String shipmentCompany) {

        CreateShipment createShipment = new CreateShipment();
        FromAddress fromAddress = new FromAddress();
        ToAddress toAddress = new ToAddress();
        Item item = new Item();
        Size size = new Size();

        fromAddress.setCity("İSTANBUL");
        fromAddress.setTown("Sarıyer");
        fromAddress.setName("Fatma");
        fromAddress.setSurname("Delen");
        fromAddress.setText("Maslak Mah. Eski Büyükdere Cad. Orjin Maslak Plaza No:27 Kat:2-3-4 Daire:54-57-59 Sarıyer 34485 İstanbul");
        fromAddress.setMsisdn("5363636363");

        toAddress.setCity("istanbul");
        toAddress.setTown("kağıthane");
        toAddress.setName("Deneme");
        toAddress.setSurname("Delen");
        toAddress.setText("");
        toAddress.setMsisdn("5363636363");

        item.setCode("01");
        item.setName("test1");
        item.setWeight(1);
        item.setQuantity(1);
        item.setSize(size);
        size.setDeci(1);

        createShipment.setShipmentRefNo(shipmentRefNo);
        createShipment.setShipmentCompany(shipmentCompany);
        createShipment.setShipmentPayer("PLATFORM");
        createShipment.setCustomerShip(false);
        createShipment.setFromAddress(fromAddress);
        createShipment.setToAddress(toAddress);
        List<Item> itemValues = new ArrayList<>();
        itemValues.add(item);
        createShipment.setItems(itemValues);

        return CommonLib.prepJson(createShipment);
    }

    public static String createShipmentEmptyShipmentRefNo(String shipmentRefNo, String shipmentCompany) {

        CreateShipment createShipment = new CreateShipment();
        FromAddress fromAddress = new FromAddress();
        ToAddress toAddress = new ToAddress();
        Item item = new Item();
        Size size = new Size();

        fromAddress.setCity("İSTANBUL");
        fromAddress.setTown("Sarıyer");
        fromAddress.setName("Fatma");
        fromAddress.setSurname("Delen");
        fromAddress.setText("Maslak Mah. Eski Büyükdere Cad. Orjin Maslak Plaza No:27 Kat:2-3-4 Daire:54-57-59 Sarıyer 34485 İstanbul");
        fromAddress.setMsisdn("5363636363");

        toAddress.setCity("istanbul");
        toAddress.setTown("kağıthane");
        toAddress.setName("Deneme");
        toAddress.setSurname("Delen");
        toAddress.setText("Merkez Mahallesi, Ayazma Cad. Papirus Plaza, B Blok, No: 37/44 Kağıthane/İstanbul ");
        toAddress.setMsisdn("5363636363");

        item.setCode("01");
        item.setName("test1");
        item.setWeight(1);
        item.setQuantity(1);
        item.setSize(size);
        size.setDeci(1);

        createShipment.setShipmentRefNo(shipmentRefNo);
        createShipment.setShipmentCompany(shipmentCompany);
        createShipment.setShipmentPayer("PLATFORM");
        createShipment.setCustomerShip(false);
        createShipment.setFromAddress(fromAddress);
        createShipment.setToAddress(toAddress);
        List<Item> itemValues = new ArrayList<>();
        itemValues.add(item);
        createShipment.setItems(itemValues);

        return CommonLib.prepJson(createShipment);

    }

    public static String shipmentStatus(String shipmentCompany, String shipmentRefNo) {
        ShipmentStatus shipmentStatus = new ShipmentStatus();

        shipmentStatus.setShipmentCompany(shipmentCompany);
        shipmentStatus.setShipmentRefNo(shipmentRefNo);

        return CommonLib.prepJson(shipmentStatus);
    }

    public static String createShipmentIade(String shipmentRefNo, String shipmentCompany) {

        return "{\n" +
                "\"shipmentRefNo\":\"" + shipmentRefNo + "\",\n" +
                "  \"shipmentCompany\": \"" + shipmentCompany + "\",\n" +
                "    \"shipmentPayer\": \"PLATFORM\",\n" +
                "    \"customerShip\": true,\n" +
                "    \"fromAddress\": {\n" +
                "        \"city\": \"istanbul\",\n" +
                "        \"town\": \"kağıthane\",\n" +
                "        \"name\": \"Fatma\",\n" +
                "\t\t\"surname\":\"Delen\",\n" +
                "\t\t\"msisdn\": \"5363636363\",\n" +
                "        \"text\": \"Merkez Mahallesi, Ayazma Cad. Papirus Plaza, B Blok, No: 37/44 Kağıthane/İstanbul \"\n" +
                "    },\n" +
                "    \"toAddress\": {\n" +
                "\t\t \"city\": \"İSTANBUL\",\n" +
                "        \"town\": \"Sarıyer\",\n" +
                "        \"name\": \"Leyla\",\n" +
                "\t\t\"surname\":\"Delen\",\n" +
                "        \"text\": \"Maslak Mah. Eski Büyükdere Cad. Orjin Maslak Plaza No: 27 Kat: 2-3-4 Daire: 54-57-59 Sarıyer 34485 İstanbul\",\n" +
                "        \"msisdn\": \"5363636363\",\n" +
                "        \"shipmentMembershipDealerNo\" : \"PAR-52060852-8382\"\n" +
                "    },\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"code\": \"01\",\n" +
                "            \"name\": \"test1\",\n" +
                "            \"weight\": 1,\n" +
                "            \"quantity\": 1,\n" +
                "            \"size\": {\n" +
                "                \"deci\": 1\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }
}