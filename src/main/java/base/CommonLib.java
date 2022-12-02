package base;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CommonLib extends BaseTest{
    public static WebDriver oDriver;
    public String page = "common";
    Parser parser= new Parser();
    Actions actions = new Actions(oDriver);

    public static String itemValue;

    WebDriverWait wait = new WebDriverWait(oDriver, 30);
    int timeout = 30;

    public CommonLib(WebDriver driver) {
        oDriver = driver;
    }


    //-------------------------------------------------------------------------------------------------------------------------------
    //It allows to wait on the page for as long as required.
    //-------------------------------------------------------------------------------------------------------------------------------
    public static void waitSeconds(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //-------------------------------------------------------------------------------------------------------------------------------
    // This method compares the given String with a String expression.
    //------------------------------------------------------------------------------------------------------------

    public static boolean controlText(String actualText, String expectedText) {
        boolean flag = false;
        try {
            if (actualText.contains(expectedText)) {
                flag = true;
            }
        } catch (NoSuchElementException e) {
            Assert.fail("The words do not match. Expected: " + expectedText + ", Actual: " + actualText);
        }
        return flag;
    }

    //-------------------------------------------------------------------------------------
    // This method checks if there is a String expression given in the list.
    //-------------------------------------------------------------------------------------

    public static boolean controlText(String expectedText, List<String> oList) {
        boolean flag = false;
        int i = 1;
        for (String text : oList) {
            if (expectedText.contains(text)) {
                flag = true;
                i++;
                if (oList.size() == i) {
                    break;
                }
            }
        }
        return flag;
    }

    //-------------------------------------------------------------------------------------
    // The method that integrates the return result set with the response class.
    //-------------------------------------------------------------------------------------
    public static String prepJson(Object dataClass) {
        // Creating Object of ObjectMapper define in Jackson API
        ObjectMapper Obj = new ObjectMapper();
        try {
            // Converting the Java object into a JSON string
            // Java objects to JSON string - pretty-print
            return Obj.writerWithDefaultPrettyPrinter().writeValueAsString(dataClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //-------------------------------------------------------------------------------------
    // The method that integrates the return result set with the response class.
    //-------------------------------------------------------------------------------------
    public static <T> T getResponse(String stringResponse, Class<T> dataClass) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(stringResponse, dataClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    //-------------------------------------------------------------------------------------
    // The method that integrates the return result set with the response class.
    //-------------------------------------------------------------------------------------
//   public static Map<String, String> queryMap(String name, String status, String species, String type, String gender) {
//       Map<String, String> map = new HashMap<>();
//       try {
//           map.put(String.valueOf(ParameterDTO.name), name);
//           map.put(String.valueOf(ParameterDTO.status), status);
//           map.put(String.valueOf(ParameterDTO.species), species);
//           map.put(String.valueOf(ParameterDTO.type), type);
//           map.put(String.valueOf(ParameterDTO.gender), gender);
//           return map;
//       } catch (NullPointerException e) {
//           e.printStackTrace();
//       }
//       return null;
//   }

    //-------------------------------------------------------------------------------------
    // The method that will add a zero to the left side.
    //-------------------------------------------------------------------------------------
    public static String addZeroLeft(String value) {
        boolean status = false;
        StringBuilder valueBuilder = new StringBuilder(value);
        do {
            if (valueBuilder.length() == 10) {
                status = true;
            } else {
                valueBuilder.insert(0, "0");
            }
        } while (!status);
        value = valueBuilder.toString();
        return value;
    }

    public static long generateRandomNumber(int numberCount) {
        Random rnd = new Random();
        char[] digits = new char[numberCount];
        digits[0] = (char) (rnd.nextInt(9) + '1');
        for (int i = 1; i < digits.length; i++) {
            digits[i] = (char) (rnd.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }

    public static void allureReport(String status, String message) {
        try {
            if (status.equalsIgnoreCase("PASS")) {
                Allure.step(message, Status.PASSED);
            } else if (status.equalsIgnoreCase("FAIL")) {
                Allure.step(message, Status.FAILED);
            } else {
                Allure.step(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String integerToString(String variable){
        int x = Integer.parseInt(variable.substring(0,variable.lastIndexOf(".")));
        x=x+1;
        variable = Integer.toString(x);
        return variable;
    }


    public static DesiredCapabilities getCapability() throws Exception {
        DesiredCapabilities oCapability = new DesiredCapabilities();
        oCapability.setJavascriptEnabled(true);
        //oCapability.setCapability("proxy", getProxy());

        return oCapability;
    }
    //-----------------------------------------------
    //set InterExplorer options by merging the Desired Capability
    //-----------------------------------------------
    public static InternetExplorerOptions getIEOptions() throws Exception {
        InternetExplorerOptions oIEOptions = new InternetExplorerOptions();
        oIEOptions.merge(getCapability());
        oIEOptions.ignoreZoomSettings();
        oIEOptions.introduceFlakinessByIgnoringSecurityDomains();

        return oIEOptions;
    }

    //-----------------------------------------------
    //set ChromeOptions by merging the Desired Capability
    //-----------------------------------------------
    public static ChromeOptions getChromeOptions() throws Exception {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(getCapability());
        chromeOptions.addArguments("test-type");
        //Dil çevirme penceresini kapattırma.
        chromeOptions.addArguments("disable-translate");
        //Browser tam ekranda gösterilir.
        chromeOptions.addArguments("start-maximized");
        //Pop-uplar bloklanır.
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        return chromeOptions;
    }



    //-----------------------------------------------
    //set FirefoxOptions by merging the Desired Capability
    //-----------------------------------------------
    public static FirefoxOptions getFirefoxOptions() throws Exception {
        FirefoxOptions oFirefoxOptions = new FirefoxOptions();
        oFirefoxOptions.merge(getCapability());

        return oFirefoxOptions;
    }

    //-----------------------------------------------
    //set EdgeOptions by merging the Desired Capability
    //-----------------------------------------------
    public static EdgeOptions getEdgeOptions() throws Exception {
        EdgeOptions oEdgeOptions = new EdgeOptions();
        oEdgeOptions.merge(getCapability());

        return oEdgeOptions;
    }

    public static int getBrowserId(String sBrowserName) throws Exception {
        if (sBrowserName.equalsIgnoreCase("ie")) return 1;
        else if (sBrowserName.equalsIgnoreCase("firefox")) return 2;
        else if (sBrowserName.equalsIgnoreCase("chrome")) return 3;
        else if (sBrowserName.equalsIgnoreCase("htmlunit")) return 4;
        else if (sBrowserName.equalsIgnoreCase("edge")) return 5;
        else return -1;
    }
    public static WebDriver getDriver(String sBrowserName) throws Exception {

        switch (getBrowserId(sBrowserName)) {
            case 1:
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + AutomationConstants.sIEDriverPath);
                WebDriverManager.iedriver().setup();
                oDriver = new InternetExplorerDriver(getIEOptions());
                break;

            case 2:
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + AutomationConstants.sGeckoDriverPath);
                WebDriverManager.firefoxdriver().setup();
                oDriver = new FirefoxDriver(getFirefoxOptions());
                break;

            case 3:
                //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + AutomationConstants.sChromeDriverPath);
                WebDriverManager.chromedriver().setup();
                oDriver = new ChromeDriver(getChromeOptions());
                break;

            case 5:
                //System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + AutomationConstants.sMsEdgeDriverPath);
                WebDriverManager.edgedriver().setup();
                oDriver = new EdgeDriver(getEdgeOptions());
                break;

            default:
                throw new Exception("Unknown browsername =" + sBrowserName +
                        " valid names are: ie,firefox,chrome,htmlunit");
        }

        oDriver.manage().deleteAllCookies();
        oDriver.manage().timeouts().pageLoadTimeout(AutomationConstants.lngPageLoadTimeout, TimeUnit.SECONDS);
        oDriver.manage().timeouts().implicitlyWait(AutomationConstants.lngImplicitWaitTimeout, TimeUnit.SECONDS);

        return oDriver;

    }

    public static void navigateToURL(WebDriver oDriver, String URL) {
        System.out.println("My URL: " + URL);
        oDriver.navigate().to(URL);
    }

    public WebElement findElement(String elem, int index) {
        WebElement object = null;
        String element = parser.getElement(page, elem);

        try {
            if (element != null) {
                if (element.startsWith("//") || element.startsWith("(//")) {
                    object = oDriver.findElements(By.xpath(element)).get(index - 1);

                    System.out.println("Element found : " + elem);
                } else if (element.startsWith("#") || element.startsWith(".")) {
                    object = oDriver.findElements(By.cssSelector(element)).get(index - 1);
                    System.out.println("Element found : " + elem);
                } else {
                    object = oDriver.findElements(By.id(element)).get(index - 1);
                    System.out.println("Element found : " + elem);
                }
            } else if (element == null) {
                object = oDriver.findElement(By.xpath("//*[text()='" + elem + "'or contains(text(),'" + elem + "')]"));
            }

            if (object == null) {
                System.out.println("Element not found: " + elem);
                Assert.fail("Element not found : " + elem);
            }
            return object;
        } catch (Exception e) {
            System.out.println("Element not found: " + elem);
            Allure.addAttachment("There is no such element.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            Assert.fail("Element not found : " + elem);

            return null;

        }
    }


    public WebElement waitElement(String element, int timeout, int index) throws InterruptedException {
        WebElement object;
        try {
            for (int i = 0; i < timeout; i++) {

                object = findElement(element, index);
                if (object != null) {
                    Thread.sleep(2000);
                    return object;
                } else {
                    Thread.sleep(500);
                }
            }
        } catch (Exception e) {
            Assert.fail("Waiting element is not found!");
        }
        return null;
    }

    public String seePage(String page) {
        List<String> returnValue = parser.isPageExist (page);

        try {
            if (returnValue.get(0).equalsIgnoreCase(page)) {
                System.out.println(page + " page found!");
                this.page = page;

                if (returnValue.get(1).length() > 0) {
                    waitElement(returnValue.get(1), timeout, 1);
                }
                return page;
            }
        } catch (Exception e) {
            Assert.fail("Page not found! '" + page + "'");
        }
        return null;
    }

    public void doubleClickElement(WebElement object) {
        actions.doubleClick(object).perform();

    }

    public String getTheItemValue(String elem, int index) {
        String elementText = (findElement(elem, index).getText());
        //System.out.println(elementText);
        this.itemValue = elementText;
        //System.out.println(itemValue);
        return elementText;
    }

    public String getTheItemValueFromAttribute(String elem, int index) {
        String elementText = (findElement(elem, index).getAttribute("value"));
        //System.out.println(elementText);
        this.itemValue = elementText;
        //System.out.println(itemValue);
        return elementText;
    }


}
