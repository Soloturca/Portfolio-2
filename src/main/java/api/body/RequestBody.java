package api.body;

import api.model.JSON.CreateVFMallOffering.Main;
import api.model.JSON.CreateVFMallOffering.Parameter;
import api.model.JSON.CreateVfMallToken;
import base.CommonLib;

import java.util.ArrayList;
import java.util.List;

public class RequestBody {

    //API SIDE
    public static String createVfMallToken() {

        CreateVfMallToken createVfMallToken = new CreateVfMallToken();

        createVfMallToken.setUsername("otomasyon@test.com");
        createVfMallToken.setPassword("Test123456789.");
        createVfMallToken.setIntegratorCode("");

        return CommonLib.prepJson(createVfMallToken);
    }

    public static String createVFMallOffering(int barcode){

        Main main = new Main();
        Parameter parameter = new Parameter();

        main.setBarcode(barcode);
        main.setBrand("5fc8de0c72fb11234c3c5e26");
        main.setCargoCompanyId("60d44700026e19ca7dfc0155");
        main.setAlternativeCargoCompanyId("601be721a23ffc44f4864240");
        main.setCategoryId("83f2e6e7-7959-441f-8779-1838a51f4c2a");
        main.setDeliveryDuration(4);
        main.setDescription("<html>Urun aciklama </html>");
        main.setDisplayName("testDisplayName");

        List<String> values = new ArrayList<>();
        values.add("https://ligarbatravel.com/wp-content/uploads/2020/06/kahve-one-cikan-gorsel.jpg");
        main.setImages(values);

        main.setListPrice(100);
        main.setName("productTest");
        main.setQuantity(40);
        main.setCargoPaymentFlag("MERCHANT");
        main.setSalePrice(80);
        main.setStockCode("MJ6667S");
        main.setTitle("productTitle");
        main.setVariantCode("MJ6667");
        main.setDimensionalWeight("10");
        main.setVatRate(18);
        main.setMaxSaleCount(10);
        main.setMaturityAmount(100);
        main.setMaturityCount(9);

        //1
        Parameter gender = new Parameter();
        gender.setId("f7aba4ab-ce1f-4260-a5e9-e15ad5c15b5c");
        gender.setName("Cinsiyet");
        gender.setCode("49158665-647");

        List<String> value = new ArrayList<>();
        value.add("Erkek");
        gender.setValue(value);

        gender.setIsVariant(false);
        gender.setParameterTypeCode("CATEGORY");


        //2
        Parameter model = new Parameter();
        model.setId("3c338328-d8fe-4558-bbb3-571527c31593");
        model.setName("Model");
        model.setCode("61062192-707");

        List<String> value2 = new ArrayList<>();
        value2.add("Fonksiyonel");
        model.setValue(value2);

        model.setIsVariant(false);
        model.setParameterTypeCode("CATEGORY");


        //3
        Parameter property = new Parameter();
        property.setId("8c19bcc0-d498-4fb1-8c18-b8356c2bcefb");
        property.setName("Özellik");
        property.setCode("60941201-267");

        List<String> value3 = new ArrayList<>();
        value3.add("Gore-Tex");
        property.setValue(value3);

        property.setIsVariant(false);
        property.setParameterTypeCode("CATEGORY");


        //4
        Parameter still = new Parameter();
        still.setId("5353d989-eade-470f-9225-09a63bf8173a");
        still.setName("Stil");
        still.setCode("27921366-281");

        List<String> value4 = new ArrayList<>();
        value4.add("Casual Gece Klasik Sokak Stili Trend");
        still.setValue(value4);

        still.setIsVariant(false);
        still.setParameterTypeCode("CATEGORY");


        //5
        Parameter age = new Parameter();
        age.setId("087fd7c8-107e-4708-b567-c1c4414f07f5");
        age.setName("Yaş Grubu");
        age.setCode("03406645-697");

        List<String> value5 = new ArrayList<>();
        value5.add("Yetişkin");
        age.setValue(value5);

        age.setIsVariant(false);
        age.setParameterTypeCode("CATEGORY");


        //6
        Parameter size = new Parameter();
        size.setId("456168b7-da5a-41ed-b741-7de680a7cf35");
        size.setName("Beden");
        size.setCode("17930552-047");

        List<String> value6 = new ArrayList<>();
        value6.add("S");
        size.setValue(value6);

        size.setIsVariant(true);
        size.setParameterTypeCode("CATEGORY");


        //7
        Parameter param = new Parameter();
        param.setId("404c6f40-5961-4dfd-aedb-69bdc48d4c31");
        param.setName("");
        param.setCode("");

        List<String> value7 = new ArrayList<>();
        value7.add("Mavi");
        param.setValue(value7);

        param.setIsVariant(true);
        param.setParameterTypeCode("");


        List<Parameter> parameterValues = new ArrayList<>();
        parameterValues.add(gender);
        parameterValues.add(model);
        parameterValues.add(property);
        parameterValues.add(still);
        parameterValues.add(age);
        parameterValues.add(size);
        parameterValues.add(param);
        main.setParameters(parameterValues);

        return CommonLib.prepJson(main);
    }


   // public static String createVfMallOffer(String barcode, String displayName, String maxSaleCount, String cargoCompanyID, String variantCode) {
   //     return "{\n" +
   //             "  \"barcode\": \"" + barcode + "\",\n" +
   //             "  \"brand\": \"5fd0833e183b320001c8b816\",\n" +
   //             "  \"cargoCompanyId\": \"" + cargoCompanyID + "\",\n" +
   //             "  \"categoryId\": \"83f2e6e7-7959-441f-8779-1838a51f4c2a\",\n" +
   //             "  \"deliveryDuration\": 4,\n" +
   //             "  \"description\": \"<html>Urun aciklama </html>\",\n" +
   //             "  \"displayName\": \"" + displayName + "\",\n" +
   //             "  \"images\": [\n" +
   //             "    \"http://personal.psu.edu/xqz5228/jpg.jpg\",\n" +
   //             "    \"http://personal.psu.edu/xqz5228/jpg.jpg\"\n" +
   //             "  ],\n" +
   //             "  \"listPrice\": 1600,\n" +
   //             "  \"name\": \"" + displayName + "\",\n" +
   //             "  \"quantity\": 10,\n" +
   //             "  \"cargoPaymentFlag\": \"MERCHANT\",\n" +
   //             "  \"salePrice\": 950,\n" +
   //             "  \"stockCode\": \"MJ6667S\",\n" +
   //             "  \"title\": \"Title Test\",\n" +
   //             "  \"variantCode\": \"" + variantCode + "\",\n" +
   //             "  \"dimensionalWeight\": \"10\",\n" +
   //             "  \"vatRate\": 18,\n" +
   //             "  \"maxSaleCount\": " + maxSaleCount + ",\n" +
   //             "  \"parameters\": [\n" +
   //             "    {\n" +
   //             "      \"id\": \"f7aba4ab-ce1f-4260-a5e9-e15ad5c15b5c\",\n" +
   //             "      \"name\": \"Cinsiyet\",\n" +
   //             "      \"code\": \"49158665-647\",\n" +
   //             "      \"value\": [\n" +
   //             "        \"Kadın\"\n" +
   //             "      ],\n" +
   //             "      \"isVariant\": false,\n" +
   //             "      \"parameterTypeCode\": \"CATEGORY\"\n" +
   //             "    },\n" +
   //             "    {\n" +
   //             "      \"id\": \"3c338328-d8fe-4558-bbb3-571527c31593\",\n" +
   //             "      \"name\": \"Model\",\n" +
   //             "      \"code\": \"61062192-707\",\n" +
   //             "      \"value\": [\n" +
   //             "        \"Fonksiyonel\"\n" +
   //             "      ],\n" +
   //             "      \"isVariant\": false,\n" +
   //             "      \"parameterTypeCode\": \"CATEGORY\"\n" +
   //             "    },\n" +
   //             "    {\n" +
   //             "      \"id\": \"8c19bcc0-d498-4fb1-8c18-b8356c2bcefb\",\n" +
   //             "      \"name\": \"Özellik\",\n" +
   //             "      \"code\": \"60941201-267\",\n" +
   //             "      \"value\": [\n" +
   //             "        \"Gore-Tex\"\n" +
   //             "      ],\n" +
   //             "      \"isVariant\": false,\n" +
   //             "      \"parameterTypeCode\": \"CATEGORY\"\n" +
   //             "    },\n" +
   //             "    {\n" +
   //             "      \"id\": \"5353d989-eade-470f-9225-09a63bf8173a\",\n" +
   //             "      \"name\": \"Stil\",\n" +
   //             "      \"code\": \"27921366-281\",\n" +
   //             "      \"value\": [\n" +
   //             "        \"Casual Gece Klasik Sokak Stili Trend\"\n" +
   //             "      ],\n" +
   //             "      \"isVariant\": false,\n" +
   //             "      \"parameterTypeCode\": \"CATEGORY\"\n" +
   //             "    },\n" +
   //             "    {\n" +
   //             "      \"id\": \"087fd7c8-107e-4708-b567-c1c4414f07f5\",\n" +
   //             "      \"name\": \"Yaş Grubu\",\n" +
   //             "      \"code\": \"03406645-697\",\n" +
   //             "      \"value\": [\n" +
   //             "        \"Yetişkin\"\n" +
   //             "      ],\n" +
   //             "      \"isVariant\": false,\n" +
   //             "      \"parameterTypeCode\": \"CATEGORY\"\n" +
   //             "    },\n" +
   //             "    {\n" +
   //             "      \"id\": \"456168b7-da5a-41ed-b741-7de680a7cf35\",\n" +
   //             "      \"name\": \"Beden\",\n" +
   //             "      \"code\": \"17930552-047\",\n" +
   //             "      \"value\": [\n" +
   //             "        \"S\"\n" +
   //             "      ],\n" +
   //             "      \"isVariant\": true,\n" +
   //             "      \"parameterTypeCode\": \"CATEGORY\"\n" +
   //             "    },\n" +
   //             "    {\n" +
   //             "      \"id\": \"404c6f40-5961-4dfd-aedb-69bdc48d4c31\",\n" +
   //             "      \"value\": [\n" +
   //             "        \"Mavi\"\n" +
   //             "      ],\n" +
   //             "      \"isVariant\": true\n" +
   //             "    }\n" +
   //             "  ]\n" +
   //             "}";
   // }
   //
   // public static String updateVfMallStockAndPrice(String listPriceU, String quantityU, String salePriceU) {
   //     return "{\n" +
   //             "  \"offerings\": [\n" +
   //             "    {\n" +
   //             "      \"id\": \"3f72dcaf-cc9a-469f-8f59-08bbd689ed2f\",\n" +
   //             "      \"listPrice\": \"" + listPriceU + "\",\n" +
   //             "      \"quantity\": \"" + quantityU + "\",\n" +
   //             "      \"salePrice\": \"" + salePriceU + "\"\n" +
   //             "    }\n" +
   //             "  ]\n" +
   //             "}";
   // }
   //
   // public static String addVFMallCustomerProfile(String msisdn) {
   //
   //     AddVfMallCustomerProfile addVfMallCustomerProfile = new AddVfMallCustomerProfile();
   //
   //     addVfMallCustomerProfile.setName("otomasyon");
   //     addVfMallCustomerProfile.setSurname("otomasyon");
   //     addVfMallCustomerProfile.setContactNumber("");
   //     addVfMallCustomerProfile.setMsisdn(msisdn);
   //     addVfMallCustomerProfile.setCity("Bolu");
   //     addVfMallCustomerProfile.setDistrict("Abant");
   //     addVfMallCustomerProfile.setAddressTitle("otomasyon");
   //     addVfMallCustomerProfile.setDetailedAddress("BJKasd22  Mah. 1905098 Sok.Karakartalasdf2222 Cad. Vofomall2 Apt. NO:19 D:05");
   //
   //     return CommonLib.prepJson(addVfMallCustomerProfile);
   // }
   //
   // public static String saveShoppingCartAddress(String deliveryAddressId, String invoiceAddressId) {
   //
   //     SaveShoppingCartAddress saveShoppingCartAddress = new SaveShoppingCartAddress();
   //
   //     saveShoppingCartAddress.setDeliveryAddressId(deliveryAddressId);
   //     saveShoppingCartAddress.setInvoiceAddressId(invoiceAddressId);
   //     saveShoppingCartAddress.setShoppingCartId("");
   //
   //     return CommonLib.prepJson(saveShoppingCartAddress);
   // }
   //
   // public static String addCartItems(String uuidID) {
   //     return "[\n" +
   //             "\n" +
   //             "{\n" +
   //             "    \"offeringId\": \"" + uuidID + "\",\n" +
   //             "    \"quantity\": \"1\"\n" +
   //             "}\n" +
   //             "]";
   // }
   //
   // public static String getOfferingDetails() {
   //
   //     GetOfferingDetails getOfferingDetails = new GetOfferingDetails();
   //
   //     getOfferingDetails.setUuid("00b34d43-bcd2-4f11-9668-3346e7202192");
   //
   //     return CommonLib.prepJson(getOfferingDetails);
   // }
   //
   //
   //
   // public static String insertRateAndComment(String uuidID, String variantCode, String desiredHideMyName) {
   //
   //     InsertRateComment insertRateComment = new InsertRateComment();
   //
   //     insertRateComment.setUuid(uuidID);
   //     insertRateComment.setVariantCode(variantCode);
   //     insertRateComment.setRate(4);
   //     insertRateComment.setTitle("eh fena değil");
   //     insertRateComment.setComment("çok kaliteli değil ama iş görür.");
   //     insertRateComment.setHideMyName(Boolean.parseBoolean(desiredHideMyName));
   //     insertRateComment.setHeight("192");
   //     insertRateComment.setWeight("92");
   //
   //     return CommonLib.prepJson(insertRateComment);
   // }
   //
   // public static String getRateAndComment(String uuidID, String variantCode) {
   //
   //     GetRateAndComment getRateAndComment = new GetRateAndComment();
   //
   //     getRateAndComment.setUuid(uuidID);
   //     getRateAndComment.setVariantCode(variantCode);
   //
   //     return CommonLib.prepJson(getRateAndComment);
   // }
   //
   // public static String updateRateAndComment(String commentId, String desiredHideMyName) {
   //
   //     UpdateRateAndComment updateRateAndComment = new UpdateRateAndComment();
   //
   //     updateRateAndComment.setId(commentId);
   //     updateRateAndComment.setRate(3);
   //     updateRateAndComment.setTitle("Harika");
   //     updateRateAndComment.setStatus("1");
   //     updateRateAndComment.setComment("Alır almaz bitirdim");
   //     updateRateAndComment.setHideMyName(Boolean.parseBoolean(desiredHideMyName));
   //
   //     return CommonLib.prepJson(updateRateAndComment);
   // }
   //
   // public static String payShoppingCart() {
   //
   //     PayShoppingCart payShoppingCart = new PayShoppingCart();
   //
   //     payShoppingCart.setCardUniqueId("string");
   //     payShoppingCart.setMasterpassTokenId("alos");
   //     payShoppingCart.setPaymentTokenId("string");
   //
   //     return CommonLib.prepJson(payShoppingCart);
   //
   // }
   //
   // public static String updateStatus(String desiredStatus, String orderId) {
   //
   //     UpdateStatus updateStatus = new UpdateStatus();
   //     OrderStatusRequest orderStatusRequest = new OrderStatusRequest();
   //
   //     orderStatusRequest.setOrderId(orderId);
   //     orderStatusRequest.setReasonCode("");
   //     orderStatusRequest.setReasonText("");
   //
   //     updateStatus.setChangedBy("ORDER_TRACKING");
   //     updateStatus.setNewStatus(desiredStatus);
   //     List<OrderStatusRequest> orderStatusRequestsValues = new ArrayList<>();
   //     orderStatusRequestsValues.add(orderStatusRequest);
   //     updateStatus.setOrderStatusRequests(orderStatusRequestsValues);
   //     updateStatus.setReturnOrders(false);
   //
   //     return CommonLib.prepJson(updateStatus);
   // }
}