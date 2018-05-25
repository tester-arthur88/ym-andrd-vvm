package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class BlockingScreen
{
    private AndroidDriver driver;

    public BlockingScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators
    By summaryTabLocator = By.xpath("//android.widget.TextView[@text='SUMMARY']");

    By blacklistTabLocator = By.xpath("//android.widget.TextView[@text='BLACKLIST']");

    By blockingSelectorLocator = By.xpath("//android.widget.LinearLayout[@resource-id='com.youmail.android.vvm:id/blocking_status_summary']");

    /*Blocking Options Beginning*/

    By disabledBlockingLocator = By.xpath("//android.widget.CheckedTextView[@text='Disabled']");

    By standardBlockingLocator = By.xpath("//android.widget.CheckedTextView[@text='Standard']");

    By maximumBlockingLocator = By.xpath("//android.widget.CheckedTextView[@text='Maximum']");

    By whitelistBlockingLocator = By.xpath("//android.widget.CheckedTextView[@text='Block Non-Contacts']");

    By blockingOkButtonLocator = By.xpath("//android.widget.Button[@text='OK']");

    /*Blocking Options Ending*/
}
