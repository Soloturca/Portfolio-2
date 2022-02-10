package api.body;

public class RequestBody {

    public static String createVfMallOffer(String barcode, String displayName, String maxSaleCount) {
        return "{\n" +
                "  \"barcode\": \"" + barcode + "\",\n" +
                "  \"brand\": \"5fd0833e183b320001c8b816\",\n" +
                "  \"cargoCompanyId\": \"60e80fd0026e19ca7d1fe005\",\n" +
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
                "  \"variantCode\": \"MJ6667\",\n" +
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
        return "{\n" +
                "    \"name\":\"otomasyon\",\n" +
                "    \"surname\": \"otomasyon\",\n" +
                "    \"contactNumber\":\"\",\n" +
                "    \"msisdn\": \"" + msisdn + "\",\n" +
                "    \"city\": \"Bolu\",\n" +
                "    \"district\": \"Abant\",\n" +
                "    \"addressTitle\": \"otomasyon\",\n" +
                "    \"detailedAddress\":\"BJKasd22  Mah. 1905098 Sok.Karakartalasdf2222 Cad. Vofomall2 Apt. NO:19 D:05\"\n" +
                "}";
    }
    public static String saveShoppingCartAddress(String deliveryAddressId, String invoiceAddressId) {
        return "{\n" +
                "  \"deliveryAddressId\": \"" + deliveryAddressId + "\",\n" +
                "  \"invoiceAddressId\": \"" + invoiceAddressId + "\",\n" +
                "  \"shoppingCartId\": \"\"\n" +
                "}";
    }

    public static String addCartItems(String offeringId) {
        return "{\n" +
                "    \"offeringId\": \"" + offeringId + "\",\n" +
                "    \"quantity\": \"2\"\n" +
                "}";
}
