package com.project.stepdefs;

import api.methods.BaseMethods;
import api.methods.Basket.Order;
import api.methods.Basket.ShoppingCart;
import api.methods.VFMall.HomePage;
import api.methods.VFMall.Offering;
import base.AutomationConstants;
import base.CommonLib;
import base.MyTestNGBaseClass;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.Set;

public class MyStepdefs extends MyTestNGBaseClass {

    CommonLib commonLib = new CommonLib();

    int timeout = 30;

    @Before
    public void setReportName(Scenario scenario) {
        System.out.println(scenario.getName());
    }

    //API SIDE

    @Given("createVfMallToken {string} service is sent and take the token")
    public void createVfMallTokenServiceIsSentAndTakeTheToken(String desiredPath) {
        Assert.assertTrue(new BaseMethods().createVfMallTokenRequest(desiredPath));
    }

    @Given("createVfMallOffering {string} is sent with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and token")
    public void createvfmallofferingIsSentWithAndToken(String desiredPath, String barcode, String brand, String cargoCompID, String catID, String deliveryDuration, String desc, String displayName, String images, String listPrice, String salePrice, String quantity) {
        Assert.assertTrue(new Offering().createVFMallOffering(desiredPath, barcode, brand, cargoCompID, catID, deliveryDuration, desc, displayName, images, listPrice, salePrice, quantity));
    }

    //@Given("createVFMallOfferingWithoutDeliveryDuration {string} is sent with token")
    // public void createVFMallOfferingWithoutDeliveryDuration(String desiredPath, String brand, String catID, String deliveryDuration, String desc, String displayName, String images, String listPrice, String salePrice, String quantity) {
    //   Assert.assertTrue(new Offering().createVFMallOffering(desiredPath, brand, catID, deliveryDuration, desc, displayName, images, listPrice, salePrice, quantity));
    // }

    //@Given("createVFMallOfferingWithoutDescription {string} is sent with token")
    // public void createvfmallofferingwithoutdescriptionIsSentWithToken(String desiredPath, String brand, String catID, String deliveryDuration, String desc, String displayName, String images, String listPrice, String salePrice, String quantity) {
    //    Assert.assertTrue(new Offering().createVFMallOffering(desiredPath, brand, catID, deliveryDuration, desc, displayName, images, listPrice, salePrice, quantity));
    //}

    @Given("^Open the (.*) URL$")
    public void openUrl(String URL) {
        CommonLib.navigateToURL(oDriver, URL);
    }

    @Then("^I see (.*) page$")
    public void seePage(String page) {
        commonLib.seePage(page);
    }

    @Then("^I enter \"([^\"]*)\" text to (.*) at index (\\d+)")
    public boolean enterText(String text, String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;
        try {
            if (object != null) {
                object.click();
                object.clear();
                object.sendKeys(text);
                System.out.println("The text has been entered:" + text);
                Allure.addAttachment("The text has been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));

                return true;
            }
        } catch (Exception e) {
            Allure.addAttachment("The text has not been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            Assert.fail("Could not entered the text:" + text);
            flag = false;
        }
        return flag;
    }

    @And("^I wait (.*) element (\\d+) seconds at index (\\d+)")
    public void waitElement(String element, int timeout, int index) throws InterruptedException {
        commonLib.waitElement(element, timeout, index);
        Allure.addAttachment("Element found", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));

    }

    @When("^(?:I )?click element: (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean clickElement(String element, int index) {
        WebElement object = commonLib.findElement(element, index);
        boolean flag = false;
        try {
            if (object != null) {
                object.click();
                System.out.println("Clicked on object --> " + element);
                //System.out.println(AutomationConstants.fileName);
                Allure.addAttachment("Element is clicked.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                return true;
            }
        } catch (Exception e) {
            Allure.addAttachment("Element is not clicked.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            Assert.fail("Could not clicked the element: " + element);
            flag = false;
        }

        return flag;
    }
    @Given("I go to \"([^\"]*)\" with this username: \"([^\"]*)\" and this password:\"([^\"]*)\"")
    public void loginSystem(String URL, String username, String password) throws InterruptedException {
        openUrl(URL);
        seePage("login");
        enterText(username, "username text area", 1);
        enterText(password, "password text area", 1);
        waitElement("login button", timeout, 1);
        clickElement("login button", 1);
        seePage("home");
    }


    @Then("^I enter OFRCode text to (.*) at index (\\d+)")
    public boolean enterOFRCode(String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;
        try {
            if (object != null) {
                object.click();
                object.clear();
                object.sendKeys(AutomationConstants.code);
                System.out.println("The text has been entered:" + AutomationConstants.code);
                Allure.addAttachment("The text has been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));

                return true;
            }
        } catch (Exception e) {
            Allure.addAttachment("The text has not been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            Assert.fail("Could not entered the text:" + AutomationConstants.code);
            flag = false;
        }
        return flag;
    }

    @And("^I need to just wait")
    public void justWait() throws InterruptedException {
        Thread.sleep(10000);
    }

    @Then("^I need to check if record is (more|less|equal) to (\\d+) for (.*)")
    public boolean getCountWebTable2(String rule, int expectedCount, String element) {

        boolean flag = false;
        int rowCount = Integer.valueOf(commonLib.findElement(element, 1).getText().substring(13));
        System.out.println("Record count: " + rowCount);

        switch (rule) {
            case "more":
                if (rowCount > expectedCount) flag = true;
                break;
            case "less":
                if (rowCount < expectedCount) flag = true;
                break;
            case "equal":
                if (rowCount == expectedCount) flag = true;
                break;
            default:
                flag = false;
                break;
        }

        if (flag) {
            System.out.println("Condition of " + rule + " than " + expectedCount + " is PASSED");
        } else {
            Allure.addAttachment("FAIL", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            Assert.fail("Condition of " + rule + " than " + expectedCount + " is FAILED! Record count: " + rowCount);
        }
        return true;
    }
    // @Given("createVFMallOfferingWithoutDisplayName {string} is sent with token")
    //public void createvfmallofferingwithoutdisplaynameIsSentWithToken(String desiredPath, String brand, String catID, String deliveryDuration, String desc, String displayName, String images, String listPrice, String salePrice, String quantity) {
    //    Assert.assertTrue(new Offering().createVFMallOffering(desiredPath, brand, catID, deliveryDuration, desc, displayName, images, listPrice, salePrice, quantity));
    // }

    @Then("check the {string} and {string} fields")
    public void checkTheAndFields(String exceptedResult, String exceptedResultDesc) {
        Assert.assertTrue(new Offering().checkFields(exceptedResult, exceptedResultDesc));
    }

    @When("^(?:I )?double click element: (\\w+(?: \\w+)*) at index (\\d+)")
    public void doubleClickElement(String element, int index) {
        WebElement object = commonLib.findElement(element, index);
        commonLib.doubleClickElement(object);
    }

    @When("^(?:I )?switch to child window")
    public void switchToChildWindow() throws InterruptedException {
        String MainWindow = oDriver.getWindowHandle();
        int timeCount = 1;
        do {
            oDriver.getWindowHandles();
            Thread.sleep(200);
            timeCount++;
            if (timeCount > 50) {
                break;
            }
        }
        while (oDriver.getWindowHandles().size() == 1);
        Set<String> s1 = oDriver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            //System.out.println(ChildWindow + "******" + driver.getTitle());
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                // Switching to Child window
                oDriver.switchTo().window(ChildWindow);
                Thread.sleep(3000);
                System.out.println("Switched to child window ID : " + ChildWindow);
                break;
            }
        }
    }

    @Then("^(?:I )?get the value of (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean getValueFromArea(String element, int index) {
        String object = commonLib.getTheItemValue(element, index);
        boolean flag = false;
        try {
            if (object != null) {
                System.out.println(object);
                AutomationConstants.field = object;
                Allure.addAttachment("Information gathered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Could not got the information.");
            Allure.addAttachment("Information could not be gathered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            Assert.fail("Could not got the information.");
            flag = false;

        }
        return flag;
    }

    @Then("^I confirm if element: (.*) equals to value from API Response")
    public boolean checkStrings(String element) {
        boolean flag = false;
        switch (element) {
            case "list price text area":
                String object1 = commonLib.getTheItemValueFromAttribute(element, 1);
                System.out.println(object1);

                try {
                    if (object1.equals(AutomationConstants.listPrice)) {
                        System.out.println(element + " is " + AutomationConstants.listPrice + " .");
                        Allure.addAttachment(element + " is " + AutomationConstants.listPrice + " .", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                        flag = true;

                    }
                } catch (Exception e) {
                    Allure.addAttachment(element + " and " + AutomationConstants.listPrice + " are not equal.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    Assert.fail(element + " and " + AutomationConstants.listPrice + " are not equal.");

                }
                break;

            case "sale price text area":
                String object2 = commonLib.getTheItemValueFromAttribute(element, 1);
                System.out.println(object2);
                try {
                    if (object2.equals(AutomationConstants.salePrice)) {
                        System.out.println(element + " is " + AutomationConstants.salePrice + " .");
                        Allure.addAttachment(element + " is " + AutomationConstants.salePrice + " .", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    }
                } catch (Exception e) {
                    Allure.addAttachment(element + " and " + AutomationConstants.salePrice + " are not equal.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    Assert.fail(element + " and " + AutomationConstants.salePrice + " are not equal.");

                }
                break;

            case "stock quantity":
                String object3 = commonLib.getTheItemValueFromAttribute(element, 1);
                System.out.println(object3);


                try {
                    if (object3.equals(AutomationConstants.quantity)) {
                        System.out.println(element + " is " + AutomationConstants.quantity + " .");
                        Allure.addAttachment(element + " is " + AutomationConstants.quantity + " .", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));


                    }
                } catch (Exception e) {
                    Allure.addAttachment(element + " and " + AutomationConstants.quantity + " are not equal.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    Assert.fail(element + " and " + AutomationConstants.quantity + " are not equal.");

                }
                break;

        }


        return flag;
    }

    @Then("^(?:I )?get the text area information: (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean getTextFromAttribute(String element, int index) {
        String object = commonLib.getTheItemValueFromAttribute(element, index);
        boolean flag = false;
        try {
            if (object != null) {
                System.out.println(object);
                Allure.addAttachment("Information gathered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Could not got the information.");
            Allure.addAttachment("Information could not be gathered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            Assert.fail("Could not got the information.");
            flag = false;

        }
        return flag;
    }


    //@And("getVFMallHomePage requestine sessionId parametresi eklenir ve servis {string} olarak tetiklenir")
    //public void getvfmallhomepageRequestineSessionIdParametresiEklenirVeServisOlarakTetiklenir(String desiredPath) {
    //    Assert.assertTrue(new HomePage().getVfMallHomepageRequestWithSessionID(desiredPath));
    //}
    //
    //@Then("Response Bodyde {string}, {string},{string} alanlari kontrol edilir")
    //public void responseBodydeAlanlariKontrolEdilir(String expectedResultCode, String expectedErrorMessage, String expectedResult) {
    //    Assert.assertTrue((new BaseMethods().checkFieldsInResponseBody(expectedResultCode, expectedErrorMessage, expectedResult)));
    //}
    //
    //@And("getVFMallOfferingDetails {string} requestine sessionId parametresi eklenir ve servis tetiklenir")
    //public void getvfmallofferingdetailsRequestineSessionIdParametresiEklenirVeServisTetiklenir(String desiredPath) {
    //    Assert.assertTrue(new BaseMethods().addSessionIdOfferingDetailsRequest(desiredPath));
    //}
    //
    //@And("updateVfMallStockAndPrice {string} requesti tetiklenir")
    //public void updatevfmallstockandpriceRequestiTetiklenir(String desiredPath) {
    //    Assert.assertTrue(new BaseMethods().updateVfMallStockAndPriceRequest(desiredPath));
    //}
    //
    //@Then("{string} Response Body icin kontrol edilir")
    //public void responseBodyIcinKontrolEdilir(String requestType) {
    //    Assert.assertTrue(new BaseMethods().checkResponseBody(requestType));
    //}
    //
    //@And("getVfMallOrders {string} requestine Authkey girilir ve status PENDING olacak şekilde istek gönderilir.")
    //public void getVfMallOrdersRequestineAuthkeyGirilirVeStatusPendingOlacakSekildeIstekGonderilir(String desiredPath) {
    //    Assert.assertTrue(new Order().VfMallOrderStatusPending(desiredPath));
    //}
    //
    //@And("createVfMallOffering {string} requesti {string}, {string} ve {string} ile tetiklenir")
    //public void createVfMallOfferingRequestiVeIleTetiklenir(String desiredPath, String barcode, String maxSaleCount, String cargoCompanyID) {
    //    Assert.assertTrue(new Offering().createVfMallOfferingRequest(desiredPath, barcode, maxSaleCount, cargoCompanyID));
    //}
    //
    //@And("updateSalesOrderStatus {string} requesti ile status değeri {string} ile değiştirilir.")
    //public void updateSalesOrderStatusRequestiIleStatusDegeriIleDegistirilir(String desiredPath, String desiredStatus) {
    //    Assert.assertTrue(new Order().updateSalesOrderStatusChange(desiredPath, desiredStatus));
    //}
    //
    //@And("payShoppingCart {string} requesti ve {string} metodu aracılıgıyla sepetteki ürünler satılır.")
    //public void payShoppingCartRequestiVeMetoduAraciligiylaSepettekiUrunlerSatilir(String desiredPath, String desiredMethod) {
    //    Assert.assertTrue(new Order().sellProductsWithPayShoppingCart(desiredPath, desiredMethod));
    //}
    //
    //@And("cleanShoppingCart {string} requesti ve {string} metodu aracılıgıyla sepetin temiz olduğuna bakılır.")
    //public void cleanShoppingCartRequestiVeMetoduAraciligiylaSepetinTemizOldugunaBakilir(String desiredPath, String desiredMethod) {
    //    Assert.assertTrue(new ShoppingCart().cleanShoppingCart(desiredPath, desiredMethod));
    //}
    //
    //@And("customerProfileID parametresi {string} metoduyla {string} requestine eklenir.")
    //public void customerprofileidParametresiMetoduylaRequestineEklenir(String desiredPath, String desiredMethod) {
    //    Assert.assertTrue(new ShoppingCart().saveShoppingCartAddress(desiredPath, desiredMethod));
    //}
    //
    //@And("addVFMallCustomerProfile {string} requestine {string} msisdn degeri kullanılarak sessionId atılır.")
    //public void addVfMallCustomerProfileRequestineMsisdnDegeriKullanilarakSessionIdAtilir(String desiredPath, String desiredMsisdn) {
    //    Assert.assertTrue(new ShoppingCart().addVfMallCustomerProfile(desiredPath, desiredMsisdn));
    //}
    //
    //@And("{string} metodu ve ürünün uuidsi ile {string} requseti atılır.")
    //public void metoduVeUrununUuidsiIleRequsetiAtilir(String desiredPath, String desiredMethod) {
    //    Assert.assertTrue(new ShoppingCart().addCartItems(desiredPath, desiredMethod));
    //}
    //
    //@Then("{string} ve {string} geldiği görülür.")
    //public void veGeldigiGorulur(String expectedResult, String expectedResultMessage) {
    //    Assert.assertTrue(new Order().checkInsertVFMallRateAndComment(expectedResult, expectedResultMessage));
    //}
    //
    //@Given("createSessionId {string} request'i ve {string} ile sessionId alınır.")
    //public void createSessionIdRequestIVeIleSessionIdAlinir(String desiredPath, String msisdn) {
    //    Assert.assertTrue(new BaseMethods().createSessionID(desiredPath, msisdn));
    //}
    //
    //@And("getVFMallRateAndComment {string} requesti ile yorumun idsi alınır.")
    //public void getVfMallRateAndCommentRequestiIleYorumunIdsiAlinir(String desiredPath) {
    //    Assert.assertTrue(new Order().getVFMallRateAndComment(desiredPath));
    //}
    //
    //@And("getVFMallRateAndComment {string} requesti ile rastgele bir yorumun id alınır.")
    //public void getVfMallRateAndCommentRequestiIleRastgeleBirYorumunIdAlinir(String desiredPath) {
    //    Assert.assertTrue(new Order().getVFMallRateAndCommentRandomID(desiredPath));
    //}
    //
    //@And("insertVfMallRateAndComment {string} requestine hideMyName {string} girilir ve sessionId girilir.")
    //public void insertvfmallrateandcommentRequestineHideMyNameGirilirVeSessionIdGirilir(String desiredPath, String desiredHideMyName) {
    //    Assert.assertTrue(new Order().enterSessionIdAtInsertVfMallRateAndComment(desiredPath, desiredHideMyName));
    //}
    //
    //@And("updateRateAndComment {string} requestine hideMyName {string} girilir ve yeni rate, comment bilgileri girilerek güncellenir.")
    //public void updateRateAndCommentRequestineHideMyNameGirilirVeYeniRateCommentBilgileriGirilerekGuncellenir(String desiredPath, String desiredHideMyName) {
    //    Assert.assertTrue(new Order().enterSessionIdAtInsertVfMallRateAndCommentUpdate(desiredPath, desiredHideMyName));
    //}
    //
    //@And("{string} requesti ile HideMyName {string} olduğundan isim ve soyisim buna göre gözükür.")
    //public void requestiIleHideMyNameOldugundanIsimVeSoyisimBunaGoreGozukur(String desiredPath, String desiredWay) {
    //    Assert.assertTrue(new Order().checkResponseForMask(desiredPath, desiredWay));
    //}
    //
    //@And("getVfMallCustomerProfileList {string} requesti atılır ve customerProfileId değeri çekilir.")
    //public void getVfMallCustomerProfileListRequestiAtilirVeCustomerProfileIdDegeriCekilir(String desiredPath) {
    //    Assert.assertTrue(new ShoppingCart().getVfMallCustomerProfileList(desiredPath));
    //}
    //
    //@And("customerProfileID parametresi {string} metoduyla {string} isteği atılarak silinir.")
    //public void customerProfileIdParametresiMetoduylaIstegiAtilarakSilinir(String desiredPath, String desiredMethod) {
    //    Assert.assertTrue(new ShoppingCart().removeCustomerProfile(desiredPath, desiredMethod));
    //}

}