package settings;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by aatayants on 11/29/2016.
 */
public class AndroidSettings {
    protected AndroidDriver driver;

//    protected String phoneNumber = "8438017639";
//    protected String password = "11111111";


    @BeforeTest
    public void setUp() throws MalformedURLException, InterruptedException
    {
        //Temporary solution
        String andrdVersion = Helper.getAndrdVersion();

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("browserName", "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", andrdVersion);
        capabilities.setCapability("autoLaunch", true);
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("full-reset", "false");
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("newCommandTimeout", 0);
//        capabilities.setCapability("app", "C:\\Apk\\youMail-release.apk");
        capabilities.setCapability("appPackage", "com.youmail.android.vvm");
//        capabilities.setCapability("appActivity", "com.youmail.android.vvm.activity.Splash");
        capabilities.setCapability("appActivity", "com.youmail.android.vvm.main.VVMMainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}