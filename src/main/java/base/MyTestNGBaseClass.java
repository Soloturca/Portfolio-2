package base;

import io.appium.java_client.screenrecording.CanRecordScreen;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;

public class MyTestNGBaseClass {

    public static WebDriver oDriver;
    public static int ssNumber;
    public static String reportPath;
    public static boolean dbFlag;
    public static int testCaseId = 0;
    public static String sDriverName = "";

    HashMap<String, HashMap<String, String>> myMap = new HashMap<String, HashMap<String, String>>();


    @Parameters({"browserName"})
    @BeforeSuite
    //@BeforeTest
    public void BeforeMethod(@Optional("") String browserName) throws Throwable {
        //browserName = "chrome";
        //browserName = System.getProperty("browserName");
        System.out.println("Browser Name : " + browserName);

        reportPath = "Report_" + new Date().getDate() + "-" + (new Date().getMonth() + 1) + "-" + new Date().getHours() + "-" + new Date().getMinutes() + "-" + new Date().getSeconds();
        File f = new File("Reports/" + reportPath);
        File ss = new File("Reports/" + reportPath + "/Screenshots");
        try {
            f.mkdir();
            ss.mkdir();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ssNumber = 0;

        if (browserName.equalsIgnoreCase("ie")) {
            sDriverName = "ie";
        } else if (browserName.equalsIgnoreCase("firefox")) {
            sDriverName = "firefox";
        } else if (browserName.equalsIgnoreCase("chrome")) {
            sDriverName = "chrome";
        } else if (browserName.equalsIgnoreCase("htmlunit")) {
            sDriverName = "htmlunit";
        } else if (browserName.equalsIgnoreCase("edge")) {
            sDriverName = "edge";
        } else {
            throw new Exception("Unknown driver name = " + sDriverName +
                    "Valid names are: ie,firefox,chrome,htmlunit,edge");
        }

        oDriver = CommonLib.getDriver(sDriverName);
		/*DriverFactory driverFactory =  DriverFactory.getInstance();
		driverFactory.setDriver(sDriverName);
		oDriver = driverFactory.getDriver();*/
    }



    @AfterSuite
//	@AfterTest
    public void afterSuite() throws Throwable {

        //EmailReporting.sendMail();
        oDriver.quit();
        //oDriver.remove();
    }






}