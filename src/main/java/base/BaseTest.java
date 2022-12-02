package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseTest {
    public static WebDriver oDriver;
    public  String sDriverName = "";
    @BeforeMethod
    @Parameters({"browserName"})
    public void setup( @Optional("") String browserName) throws Exception {

        if (browserName.equalsIgnoreCase("ie")) {
            sDriverName = "ie";
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            sDriverName = "firefox";
        }
        else if (browserName.equalsIgnoreCase("chrome")) {
            sDriverName = "chrome";
        }
        else if (browserName.equalsIgnoreCase("htmlunit")) {
            sDriverName = "htmlunit";
        }
        else{
            throw new Exception("Unknown driver name = " + sDriverName +
                    "Valid names are: ie,firefox,chrome,htmlunit");
        }

        oDriver = CommonLib.getDriver(sDriverName);
        LocalDriver.setTLDriver(oDriver);
    }


    @AfterMethod
    public synchronized void teardown() {
       LocalDriver.getTLDriver().quit();
    }


}