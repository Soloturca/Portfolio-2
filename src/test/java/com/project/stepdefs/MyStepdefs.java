package com.project.stepdefs;

import api.methods.BaseMethods;
import api.methods.Basket.Order;
import api.methods.Basket.ShoppingCart;
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

    @Given("createSessionID URL'i {string} edilerek sessionID elde edilir.")
    public void createsessionidURLIEdilerekSessionIDEldeEdilir(String desiredPath) {
        Assert.assertTrue(new BaseMethods().createSessionID(desiredPath));
    }

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

    @And("createSessionId {string} request'i ile sessionId olusturulur")
    public void createsessionidRequestIIleSessionIdOlusturulur(String desiredPath) {
        Assert.assertTrue(new BaseMethods().createSessionID(desiredPath));
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

    @Given("createSessionId {string} request'i ile sessionId alınır.")
    public void createSessionIdRequestIIleSessionIdAlinir(String desiredPath) {
        Assert.assertTrue(new BaseMethods().createSessionID(desiredPath));
    }

    @And("cleanShoppingCart {string} requesti ile sepetin temiz olduğuna bakılır.")
    public void cleanShoppingCartRequestiIleSepetinTemizOldugunaBakilir(String desiredPath) {
        Assert.assertTrue(new ShoppingCart().cleanShoppingCart(desiredPath));
    }

    @And("addVFMallCustomerProfile {string} requestine sessionId atılır.")
    public void addVfMallCustomerProfileRequestineSessionIdAtilir(String desiredPath) {
        Assert.assertTrue(new ShoppingCart().addVfMallCustomerProfile(desiredPath));
    }

    @And("customerProfileID parametresi saveShoppingCartAddress {string} requestine eklenir.")
    public void customerprofileidParametresiSaveShoppingCartAddressRequestineEklenir(String desiredPath) {
        Assert.assertTrue(new ShoppingCart().saveShoppingCartAddress(desiredPath));
    }

    @And("addCartItems {string} requseti atılır.")
    public void addCartItemsRequsetiAtilir(String desiredPath) {
        Assert.assertTrue(new ShoppingCart().addCartItems(desiredPath));
    }

    @And("payShoppingCart {string} requesti ile sepetteki ürünler satılır.")
    public void payShoppingCartRequestiIleSepettekiUrunlerSatilir(String desiredPath) {
        Assert.assertTrue(new Order().sellProductsWithPayShoppingCart(desiredPath));
    }

    @And("insertVfMallRateAndComment {string} requestine sessionId girilir.")
    public void insertvfmallrateandcommentRequestineSessionIdGirilir(String desiredPath) {
        Assert.assertTrue(new BaseMethods().enterSessionIdAtInsertVfMallRateAndComment(desiredPath));
    }

    @And("getVfMallOrders {string} requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.")
    public void getVfMallOrdersRequestineAuthkeyGirilirVeStatusPendingOlacakSekildeIstekGonderilir(String desiredPath) {
        Assert.assertTrue(new Order().VfMallOrderStatusPending(desiredPath));
    }

    @And("updateSalesOrderStatus {string} requesti ile status değeri değiştirilir.")
    public void updateSalesOrderStatusRequestiIleStatusDegeriDegistirilir(String desiredPath) {
        Assert.assertTrue(new Order().updateSalesOrderStatusChange(desiredPath));
    }

    @And("createVfMallOffering {string} requesti {string}, {string} ve {string} ile tetiklenir")
    public void createvfmallofferingRequestiVeIleTetiklenir(String desiredPath, String barcode, String maxSaleCount, String cargoCompanyID) {
            Assert.assertTrue(new Offering().createVfMallOfferingRequest(desiredPath, barcode, maxSaleCount,cargoCompanyID));
    }
}

