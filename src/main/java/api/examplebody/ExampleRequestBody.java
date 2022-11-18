package api.examplebody;

import api.Examplemodel.JSON.createVFMallOffering.Main;
import api.Examplemodel.JSON.createVFMallOffering.Parameter;
import api.Examplemodel.JSON.CreateVfMallToken;
import base.CommonLib;

import java.util.ArrayList;
import java.util.List;

public class ExampleRequestBody {

    public static String createVfMallToken() {

        CreateVfMallToken createVfMallToken = new CreateVfMallToken();

        createVfMallToken.setUsername("otomasyon@test.com");
        createVfMallToken.setPassword("Test123456789.");
        createVfMallToken.setIntegratorCode("");

        return CommonLib.prepJson(createVfMallToken);
    }

    public static String createVFMallOffering(String barcode, String brand, String cargoCompID, String catID, String deliveryDuration, String desc, String displayName, String images, String listPrice, String salePrice, String quantity){

        Main main = new Main();

        main.setBarcode(barcode);
        main.setBrand(brand);
        main.setCargoCompanyId(cargoCompID);
        main.setAlternativeCargoCompanyId("601be721a23ffc44f4864240");
        main.setCategoryId(catID);
        main.setDeliveryDuration(deliveryDuration);
        main.setDescription(desc);
        main.setDisplayName(displayName);

        List<String> values = new ArrayList<>();
        values.add(images);
        main.setImages(values);

        main.setListPrice(listPrice);
        main.setName("productTest");
        main.setQuantity(quantity);
        main.setCargoPaymentFlag("MERCHANT");
        main.setSalePrice(salePrice);
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

    public static String createVFMallOfferingWithOutImages(String barcode, String brand, String catID, String deliveryDuration, String desc, String displayName, String listPrice, String salePrice, String quantity){

        Main main = new Main();

        main.setBarcode(barcode);
        main.setBrand(brand);
        main.setCargoCompanyId("60d44700026e19ca7dfc0155");
        main.setAlternativeCargoCompanyId("601be721a23ffc44f4864240");
        main.setCategoryId(catID);
        main.setDeliveryDuration(deliveryDuration);
        main.setDescription(desc);
        main.setDisplayName(displayName);

        main.setListPrice(listPrice);
        main.setName("productTest");
        main.setQuantity(quantity);
        main.setCargoPaymentFlag("MERCHANT");
        main.setSalePrice(salePrice);
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
}