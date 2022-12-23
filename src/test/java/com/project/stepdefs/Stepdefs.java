package com.project.stepdefs;

import api.base.TestUtils;
import api.baseMethods.BaseMethods;
import api.body.Responses;
import api.base.AutomationConstants;
import api.base.CommonLib;
import api.base.LocalDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Stepdefs {

    CommonLib commonLib;
    WebDriver oDriver;
    InputStream stringsis;
    public static HashMap<String, String> strings = new HashMap<String, String>();
    TestUtils utils;

    int timeout = 30;

    @Before
    public void setup() {

        oDriver = LocalDriver.getTLDriver();
        commonLib = new CommonLib(oDriver);

    }

    @Given("createPaytionToken service is sent and take the token")
    public void createPaytionTokenServiceIsSentAndTakeTheToken() {
        Assert.assertTrue(new BaseMethods().createPaytionTokenRequest());
    }

    @And("KolayPackPreAuth {string} request {string}, {string} , {string}, {string} , {string} , {string} , {string} , {string} , {string} , {string},{string},{string},{string},{string},{string}")
    public void KolayPackPreAuthPostRequest(String desiredRequestMethod, String transactionId, String transactionGroupId, String reconDate, String ipAddress, String companyId, String institutionId, String productId, String bankId, String transactionDate, String description, String paymentMethod, String customerReferenceType, String sun, String customerCode, String installment) {
        Assert.assertTrue(new Responses().KolaypackPreauthPostResponse(desiredRequestMethod, transactionId, transactionGroupId, reconDate, ipAddress, companyId, institutionId, productId, bankId, transactionDate, description, paymentMethod, customerReferenceType, sun, customerCode, installment));
    }

    @Given("^Open the (.*) URL$")
    public void openUrl(String URL) throws Exception {
        commonLib.navigateToURL(oDriver, URL);

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

    @Then("^I enter (.*) random telephone number to at index (\\d+)")
    public boolean enterRandomText(String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        commonLib.randomTelNumber();
        String text = AutomationConstants.txtTelNumber;
        boolean flag = false;
        try {
            if (object != null) {
                object.click();
                object.clear();
                object.sendKeys(AutomationConstants.txtTelNumber);
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

    @Then("^I enter (.*) random seven digits to at index (\\d+)")
    public boolean enterRandomSevenDigits(String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        commonLib.randomSevenDigits();
        String text = AutomationConstants.lastSevenDigits;
        boolean flag = false;
        try {
            if (object != null) {
                object.click();
                object.clear();
                object.sendKeys(AutomationConstants.lastSevenDigits);

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

    @When("^(?:I )?have to verify the text for: (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean verifyText(String element, int index) throws Exception {
        WebElement object = commonLib.findElement(element, index);
        boolean flag = false;
        System.out.println("text: " + object.getText());
        try {
            if (object != null) {
                String xmlFileName = "strings.xml";
                stringsis = this.getClass().getClassLoader().getResourceAsStream(xmlFileName);
                strings = utils.parseStringXML(stringsis);

                //object.click();
                String actualErrTxt = object.getText(); //xpath'ten okuduğu.
                System.out.println(actualErrTxt);
                if (element.contains("approve popup")) {
                    String expectedErrText = strings.get("approve popup"); //strings.xml dosyası
                    System.out.println("actual popup text - " + actualErrTxt + "\n" + "expected popup text - " + expectedErrText);
                    Assert.assertEquals(actualErrTxt, expectedErrText); //kıyaslıyor.
                    Allure.addAttachment("Verification completed.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    flag = true;
                } else if (element.contains("assign to pool popup")) {
                    String expectedErrText = strings.get("assign to pool popup");
                    System.out.println("actual popup text - " + actualErrTxt + "\n" + "expected popup text - " + expectedErrText);
                    Assert.assertEquals(actualErrTxt, expectedErrText);
                    Allure.addAttachment("Verification completed.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    flag = true;
                } else if (element.contains("cancel popup")) {
                    String expectedErrText = strings.get("cancel popup");
                    System.out.println("actual popup text - " + actualErrTxt + "\n" + "expected popup text - " + expectedErrText);
                    Assert.assertEquals(actualErrTxt, expectedErrText);
                    Allure.addAttachment("Verification completed.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    flag = true;
                } else if (element.contains("welcome page text area")) {
                    String expectedErrText = strings.get("welcome page text area");
                    System.out.println("actual popup text - " + actualErrTxt + "\n" + "expected popup text - " + expectedErrText);
                    Assert.assertEquals(actualErrTxt, expectedErrText);
                    Allure.addAttachment("Verification completed.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    flag = true;
                }
            }
        } catch (Exception e) {
            Allure.addAttachment("Verification does not completed.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            Assert.fail("Could not clicked the element:" + element);
            flag = false;
        } finally {
            if (stringsis != null) {
                stringsis.close();
            }
        }
        return flag;
    }

    @And("^I wait (.*) element (\\d+) seconds at index (\\d+)")
    public void waitElement(String element, int timeout, int index) throws InterruptedException {
        commonLib.waitElement(element, timeout, index);
        System.out.println(element);
        Allure.addAttachment("Element found", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));

    }

    @Then("I go back previous page")
    public void goBackToPreviousPage() {
        //go back to previous page
        oDriver.navigate().back();
        CommonLib.waitSeconds(5);
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

    @And("^I need to just wait")
    public void justWait() throws InterruptedException {
        Thread.sleep(10000);
    }

    @When("^(?:I )?double click element: (\\w+(?: \\w+)*) at index (\\d+)")
    public void doubleClickElement(String element, int index) {
        WebElement object = commonLib.findElement(element, index);
        commonLib.doubleClickElement(object);
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

    @Then("^(?:I )?get the text area information: (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean getTextFromAttribute(String element, int index) {
        String object = commonLib.getTheItemValueFromAttribute(element, index);
        boolean flag = false;
        try {
            if (object != null) {
                System.out.println(object);
                AutomationConstants.value = object;
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

    @When("^(?:I )?select element: \"([^\"]*)\" under (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean selectElement(String text, String element, int index) {
        WebElement object = commonLib.findElement(element, index);
        boolean flag = false;
        try {
            if (object != null) {
                object.click();
                System.out.println("Select the object type-->" + text + element);
                Select select = new Select(object);
                select.selectByVisibleText(text);
                Allure.addAttachment("The selection is done.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));

                return true;
            }
        } catch (Exception e) {
            System.out.println("The selection cannot be done.");
            Allure.addAttachment("The selection cannot be done.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            Assert.fail("The selection cannot be done!");
            flag = false;
        }
        return flag;
    }

    @Then("^I scroll to the (\\w+(?: \\w+)*)")
    public void scrollToElement(String element) throws InterruptedException {
        WebElement elementToSee = commonLib.findElement(element, 1);
        ((JavascriptExecutor) oDriver).executeScript("arguments[0].scrollIntoView(true);", elementToSee);
        Thread.sleep(1000);
    }

    @Then("^I verify (\\w+(?: \\w+)*) (exists|notExists) at index (\\d+)")
    public boolean verifyElementExistOrNot(String element, String rule, int index) {
        WebElement elementToSee = commonLib.checkElement(element, index);
        boolean flag = false;
        switch (rule) {
            case "exists":
                if (elementToSee != null) {
                    System.out.println("Element is exist: " + element);
                    Allure.addAttachment("Element is exist: " + element, new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    flag = true;
                    break;
                }
            case "notExists":
                if (elementToSee == null) {
                    System.out.println("Element is not exist: " + element);
                    Allure.addAttachment("Element is not exist: " + element, new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    flag = true;
                    break;
                }
            default:
                flag = false;
                break;
        }
        return flag;
    }

    @Then("^I check number of elements for: (\\w+(?: \\w+)*) is (\\d+)")
    public void checkElementIs(String element, int count) {
        System.out.println(element);
        List<WebElement> elements = commonLib.findElements(element);

        if (elements.size() == count) {
            System.out.println("Number of " + element + " is " + count);
            Allure.addAttachment("Number of " + element + " is " + count, new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));

        } else {
            System.out.println("Number of " + element + " is not" + count);
            Allure.addAttachment("Number of " + element + " is not" + count, new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
        }

    }

    @When("^(?:I )?click element with action: (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean clickElementA(String element, int index) throws InterruptedException {
        scrollToElement(element);
        Actions builder = new Actions(oDriver);

        WebElement object = commonLib.findElement(element, index);
        boolean flag = false;
        try {
            if (object != null) {
                builder.moveToElement(object).click().build().perform();
                System.out.println("Clicked on object --> " + element);
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


    @Then("I check {string} contains {string} or {string} in {string} at index {int} for {string} at index {int}")
    public void checkTariffTypes(String tariffsType, String text, String text2, String tariffs, int index, String tariffForAge, int index2) throws InterruptedException {

        clickElementA(tariffForAge, index2);
        clickElementA(tariffs, index);
        List<WebElement> tariffsList = commonLib.findElements(tariffsType);
        CommonLib.waitSeconds(10);
        scrollToElement(tariffsType);
        try {
            for (int i = 0; i < tariffsList.size(); i++) {
                if (CommonLib.controlText(tariffsList.get(i).getText(), text) || CommonLib.controlText(tariffsList.get(i).getText(), text2)) {
                    System.out.println("Tariff is in " + text2 + " Tariffs");
                    Allure.addAttachment("tariff is " + text + "tariffs", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                }

            }
        } catch (Exception e) {
            Allure.addAttachment("tariff is not " + text + "tariffs", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));

        }
    }

    @Then("^I check (\\w+(?: \\w+)*) in (\\w+(?: \\w+)*) at index (\\d+)")
    public void elementsTarifelerTabsAtIndex(String tariffs, String tariffsTab, int index) throws InterruptedException {
        WebElement object = commonLib.findElement(tariffsTab, index);
        clickElementA(tariffsTab, index);
        List<WebElement> tariffsList = commonLib.findElements(tariffs);
        try {
            if (object != null) {
                System.out.println(tariffsList.size() + " tarifss in " + object.getText() + " tab");
                Allure.addAttachment(tariffsList.size() + " tarifss in " + object.getText() + " tab", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            }
        } catch (Exception e) {
            Allure.addAttachment(tariffsList.size() + " tarifss are not in " + object.getText() + " tab", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));

        }
    }


    @Then("^I click (\\w+(?: \\w+)*) at index (\\d+) and check (\\w+(?: \\w+)*)")
    public void clickTariffTagsAtIndexAndCheckTariffs(String tariffTag, int index, String tariffs) {
        WebElement object = commonLib.findElement(tariffTag, index);
        object.click();
        CommonLib.waitSeconds(3);
        List<WebElement> tariffsList = commonLib.findElements(tariffs);
        try {
            if (object != null) {
                System.out.println(tariffsList.size() + " tarifss for tag ");
                Allure.addAttachment(tariffsList.size() + " tarifss for tag ", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            }
        } catch (Exception e) {
            Allure.addAttachment(tariffsList.size() + " tarifss are not for tag ", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
        }
    }

    @When("^I click (\\w+(?: \\w+)*) and check (\\d+) tariffs added to (\\w+(?: \\w+)*)")
    public void clickDahaFazlaGosterButtonAndCheckTariffsAdded(String element, int number, String tariffs) {
        List<WebElement> tariffsList = commonLib.findElements(tariffs);
        int numberOfListBefore = tariffsList.size();
        WebElement object = commonLib.findElement(element, 1);
        object.click();
        CommonLib.waitSeconds(3);
        List<WebElement> tariffsList2 = commonLib.findElements(tariffs);
        int numberOfListAfter = tariffsList2.size();
        try {
            if (numberOfListAfter == numberOfListBefore + number) {
                System.out.println(number + " additional tariffs are displayed.");
                Allure.addAttachment(number + "additional tariffs are displayed.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            }
        } catch (Exception e) {
            Allure.addAttachment(number + "additional tariffs are not displayed.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
        }
    }

    @Then("^I click element (\\w+(?: \\w+)*) and check (\\w+(?: \\w+)*)")
    public void clickElementAndCheckElement(String elementHeader, String elementDetail) throws InterruptedException {

        List<WebElement> kullanimEsaslariList = commonLib.findElements(elementHeader);
        System.out.println(kullanimEsaslariList.size());
        for (int i = 2; i <= kullanimEsaslariList.size(); i++) {
            WebElement object = commonLib.findElement(elementHeader, i);
            clickElementA(elementHeader, i);
            CommonLib.waitSeconds(5);
            scrollToElement(elementDetail);
            commonLib.checkElement(elementDetail, i);
        }
    }

    @Then("^I check element: (.*) is (enabled|disabled)")
    public void iCheckElementCampaignDescriptionIsEnabled(String element, String rule) {
        WebElement object = commonLib.findElement(element, 1);
        boolean flag = false;
        switch (rule) {
            case "enabled":
                if (object.isEnabled() == true) flag = true;
                System.out.println("Element is enable." + element);
                Allure.addAttachment("Element is enable.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));

                break;
            case "disabled":
                if (object.isEnabled() == false) flag = true;
                System.out.println("Element is disable." + element);
                Allure.addAttachment("Element is disable.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));

                break;
            default:
                flag = false;
                break;
        }
    }

    @And("^I need to wait for (\\d+) seconds")
    public void waitForIt(int seconds) throws InterruptedException {

        int secondsToMilis = seconds * 1000;
        Thread.sleep(secondsToMilis);

    }

    @Then("^I check (\\w+(?: \\w+)*) and (\\w+(?: \\w+)*)")
    public void checkDijitaldenBasvuruAvantajlariSssAndDijitaldenBasvuruAvantajlariSssAnswer(String questions, String answers) {
        List<WebElement> questionList = commonLib.findElements(questions);
        //System.out.println(questionList.size() + "questions");
        List<WebElement> answerList = commonLib.findElements(answers);
        //System.out.println(answerList.size() + "answers");
        if (questionList.size() == answerList.size()) {
            System.out.println("Questions and Answers checked.");
            Allure.addAttachment("Questions and Answers checked.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));


        } else {
            System.out.println("Questions and Answers unsuccessfully checked.");
            Allure.addAttachment("Questions and Answers unsuccessfully checked.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));

        }
    }

}