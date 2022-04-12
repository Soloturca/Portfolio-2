package com.project.stepdefs;

import api.methods.BaseMethods;
import api.methods.Basket.Order;
import api.methods.Basket.ShoppingCart;
import api.methods.Shipment.ShipmentIade;
import api.methods.Shipment.ShipmentNormal;
import api.methods.VFMall.HomePage;
import api.methods.VFMall.Offering;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class MyStepdefs {

    @Before
    public void setReportName(Scenario scenario) {
        System.out.println(scenario.getName());
    }

    //API SIDE
    @And("getVFMallHomePage requestine sessionId parametresi eklenir ve servis {string} olarak tetiklenir")
    public void getvfmallhomepageRequestineSessionIdParametresiEklenirVeServisOlarakTetiklenir(String desiredPath) {
        Assert.assertTrue(new HomePage().getVfMallHomepageRequestWithSessionID(desiredPath));
    }

    @Given("createVfMallToken {string} request'i ile token olusturulur")
    public void createvfmalltokenRequestIIleTokenOlusturulur(String desiredPath) {
        Assert.assertTrue(new BaseMethods().createVfMallTokenRequest(desiredPath));
    }

    @Then("Response Bodyde {string}, {string},{string} alanlari kontrol edilir")
    public void responseBodydeAlanlariKontrolEdilir(String expectedResultCode, String expectedErrorMessage, String expectedResult) {
        Assert.assertTrue((new BaseMethods().checkFieldsInResponseBody(expectedResultCode, expectedErrorMessage, expectedResult)));
    }

    @And("getVFMallOfferingDetails {string} requestine sessionId parametresi eklenir ve servis tetiklenir")
    public void getvfmallofferingdetailsRequestineSessionIdParametresiEklenirVeServisTetiklenir(String desiredPath) {
        Assert.assertTrue(new BaseMethods().addSessionIdOfferingDetailsRequest(desiredPath));
    }

    @And("updateVfMallStockAndPrice {string} requesti tetiklenir")
    public void updatevfmallstockandpriceRequestiTetiklenir(String desiredPath) {
        Assert.assertTrue(new BaseMethods().updateVfMallStockAndPriceRequest(desiredPath));
    }

    @Then("{string} Response Body icin kontrol edilir")
    public void responseBodyIcinKontrolEdilir(String requestType) {
        Assert.assertTrue(new BaseMethods().checkResponseBody(requestType));
    }

    @And("getVfMallOrders {string} requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.")
    public void getVfMallOrdersRequestineAuthkeyGirilirVeStatusPendingOlacakSekildeIstekGonderilir(String desiredPath) {
        Assert.assertTrue(new Order().VfMallOrderStatusPending(desiredPath));
    }

    @And("createVfMallOffering {string} requesti {string}, {string} ve {string} ile tetiklenir")
    public void createVfMallOfferingRequestiVeIleTetiklenir(String desiredPath, String barcode, String maxSaleCount, String cargoCompanyID) {
        Assert.assertTrue(new Offering().createVfMallOfferingRequest(desiredPath, barcode, maxSaleCount, cargoCompanyID));
    }

    @And("updateSalesOrderStatus {string} requesti ile status değeri {string} ile değiştirilir.")
    public void updateSalesOrderStatusRequestiIleStatusDegeriIleDegistirilir(String desiredPath, String desiredStatus) {
        Assert.assertTrue(new Order().updateSalesOrderStatusChange(desiredPath, desiredStatus));
    }

    @And("payShoppingCart {string} requesti ve {string} metodu aracılıgıyla sepetteki ürünler satılır.")
    public void payShoppingCartRequestiVeMetoduAraciligiylaSepettekiUrunlerSatilir(String desiredPath, String desiredMethod) {
        Assert.assertTrue(new Order().sellProductsWithPayShoppingCart(desiredPath, desiredMethod));
    }

    @And("cleanShoppingCart {string} requesti ve {string} metodu aracılıgıyla sepetin temiz olduğuna bakılır.")
    public void cleanShoppingCartRequestiVeMetoduAraciligiylaSepetinTemizOldugunaBakilir(String desiredPath, String desiredMethod) {
        Assert.assertTrue(new ShoppingCart().cleanShoppingCart(desiredPath, desiredMethod));
    }

    @And("customerProfileID parametresi {string} metoduyla {string} requestine eklenir.")
    public void customerprofileidParametresiMetoduylaRequestineEklenir(String desiredPath, String desiredMethod) {
        Assert.assertTrue(new ShoppingCart().saveShoppingCartAddress(desiredPath, desiredMethod));
    }

    @And("addVFMallCustomerProfile {string} requestine {string} msisdn degeri kullanılarak sessionId atılır.")
    public void addVfMallCustomerProfileRequestineMsisdnDegeriKullanilarakSessionIdAtilir(String desiredPath, String desiredMsisdn) {
        Assert.assertTrue(new ShoppingCart().addVfMallCustomerProfile(desiredPath, desiredMsisdn));
    }

    @And("{string} metodu ve ürünün uuidsi ile {string} requseti atılır.")
    public void metoduVeUrununUuidsiIleRequsetiAtilir(String desiredPath, String desiredMethod) {
        Assert.assertTrue(new ShoppingCart().addCartItems(desiredPath, desiredMethod));
    }

    @Then("{string} ve {string} geldiği görülür.")
    public void veGeldigiGorulur(String expectedResult, String expectedResultMessage) {
        Assert.assertTrue(new Order().checkInsertVFMallRateAndComment(expectedResult, expectedResultMessage));
    }

    @Given("createSessionId {string} request'i ve {string} ile sessionId alınır.")
    public void createSessionIdRequestIVeIleSessionIdAlinir(String desiredPath, String msisdn) {
        Assert.assertTrue(new BaseMethods().createSessionID(desiredPath, msisdn));
    }

    @And("getVFMallRateAndComment {string} requesti ile yorumun idsi alınır.")
    public void getVfMallRateAndCommentRequestiIleYorumunIdsiAlinir(String desiredPath) {
        Assert.assertTrue(new Order().getVFMallRateAndComment(desiredPath));
    }

    @And("getVFMallRateAndComment {string} requesti ile rastgele bir yorumun id alınır.")
    public void getVfMallRateAndCommentRequestiIleRastgeleBirYorumunIdAlinir(String desiredPath) {
        Assert.assertTrue(new Order().getVFMallRateAndCommentRandomID(desiredPath));
    }

    @And("insertVfMallRateAndComment {string} requestine hideMyName {string} girilir ve sessionId girilir.")
    public void insertvfmallrateandcommentRequestineHideMyNameGirilirVeSessionIdGirilir(String desiredPath, String desiredHideMyName) {
        Assert.assertTrue(new Order().enterSessionIdAtInsertVfMallRateAndComment(desiredPath, desiredHideMyName));
    }

    @And("updateRateAndComment {string} requestine hideMyName {string} girilir ve yeni rate, comment bilgileri girilerek güncellenir.")
    public void updateRateAndCommentRequestineHideMyNameGirilirVeYeniRateCommentBilgileriGirilerekGuncellenir(String desiredPath, String desiredHideMyName) {
        Assert.assertTrue(new Order().enterSessionIdAtInsertVfMallRateAndCommentUpdate(desiredPath, desiredHideMyName));
    }

    @And("{string} requesti ile HideMyName {string} olduğundan isim ve soyisim buna göre gözükür.")
    public void requestiIleHideMyNameOldugundanIsimVeSoyisimBunaGoreGozukur(String desiredPath, String desiredWay) {
        Assert.assertTrue(new Order().checkResponseForMask(desiredPath, desiredWay));
    }

    @And("getVfMallCustomerProfileList {string} requesti atılır ve customerProfileId değeri çekilir.")
    public void getVfMallCustomerProfileListRequestiAtilirVeCustomerProfileIdDegeriCekilir(String desiredPath) {
        Assert.assertTrue(new ShoppingCart().getVfMallCustomerProfileList(desiredPath));
    }

    @And("customerProfileID parametresi {string} metoduyla {string} isteği atılarak silinir.")
    public void customerProfileIdParametresiMetoduylaIstegiAtilarakSilinir(String desiredPath, String desiredMethod) {
        Assert.assertTrue(new ShoppingCart().removeCustomerProfile(desiredPath, desiredMethod));
    }

    //CORE SIDE
    @Given("{string} metodu tüm alanlar doğru, ShipmentRefNo {string} ve ShipmentCompany {string} olacak şekilde gönderilerek {string} edilir.")
    public void metoduTumAlanlarDogruVeShipmentCompanyOlacakSekildeGonderilerekEdilir(String desiredMethod, String desiredShipmentRefNo, String desiredShipmentCompany, String desiredPath) {
        Assert.assertTrue(new ShipmentNormal().createShipment(desiredMethod, desiredShipmentRefNo, desiredShipmentCompany, desiredPath));
    }

    @Given("{string} metodu fromAddress alanındaki text alanı boş, ShipmentRefNo {string} ve ShipmentCompany {string} olarak {string} edilir.")
    public void metoduFromAddressAlanindakiTextAlaniBosVeShipmentCompanyOlarakEdilir(String desiredMethod, String desiredShipmentRefNo, String desiredShipmentCompany, String desiredPath) {
        Assert.assertTrue(new ShipmentNormal().createShipmentEmptyFromAddressText(desiredMethod, desiredShipmentRefNo, desiredShipmentCompany, desiredPath));
    }

    @Given("{string} metodu toAddress alanındaki text alanı boş, ShipmentRefNo {string} ve ShipmentCompany {string} olarak {string} edilir.")
    public void metoduToAddressAlanindakiTextAlaniBosVeShipmentCompanyOlarakEdilir(String desiredMethod, String desiredShipmentRefNo, String desiredShipmentCompany, String desiredPath) {
        Assert.assertTrue(new ShipmentNormal().createShipmentEmptyToAddressText(desiredMethod, desiredShipmentRefNo, desiredShipmentCompany, desiredPath));
    }

    @Then("{string} ve {string} alanları kontrol edilir.")
    public void veAlanlariKontrolEdilir(String expectedResultSuccessful, String expectedResultDesc) {
        Assert.assertTrue(new ShipmentNormal().checkFields(expectedResultSuccessful, expectedResultDesc));
    }

    @Given("{string} metodu tüm alanlar doğru, ShipmentRefNo {string} \\(bos) ve ShipmentCompany {string} olacak şekilde gönderilerek {string} edilir.")
    public void metoduShipmentRefNoAlaniBosVeShipmentCompanyOlarakEdilirVeRequestKendiligindenRefNoUretir(String desiredMethod, String desiredShipmentRefNo, String desiredShipmentCompany, String desiredPath) {
        Assert.assertTrue(new ShipmentNormal().createShipmentEmptyShipmentRefNo(desiredMethod, desiredShipmentRefNo, desiredShipmentCompany, desiredPath));
    }

    @Then("{string} alanı kontrol edilir.")
    public void alaniKontrolEdilir(String expectedResultSuccessful) {
        Assert.assertTrue(new ShipmentNormal().checkFieldRefNo(expectedResultSuccessful));
    }

    @Given("{string} metodu shipmentCompany {string} olarak {string} edilir.")
    public void metoduShipmentCompanyOlarakEdilir(String desiredMethod, String desiredShipmentCompany, String desiredPath) {
        Assert.assertTrue(new ShipmentNormal().shipmentStatus(desiredMethod, desiredShipmentCompany, desiredPath));
    }

    @Then("{string} alanının ne olduğu kontrol edilir.")
    public void alanininNeOlduguKontrolEdilir(String expectedStatus) {
        Assert.assertTrue(new ShipmentNormal().checkStatus(expectedStatus));
    }

    @Given("{string} iade metodu tüm alanlar doğru, ShipmentRefNo {string} ve ShipmentCompany {string} olacak şekilde gönderilerek {string} edilir.")
    public void iadeMetoduTumAlanlarDogruShipmentRefNoVeShipmentCompanyOlacakSekildeGonderilerekEdilir(String desiredMethod, String desiredShipmentRefNo, String desiredShipmentCompany, String desiredPath) {
        Assert.assertTrue(new ShipmentIade().createShipmentIade(desiredMethod, desiredShipmentRefNo, desiredShipmentCompany, desiredPath));
    }
}