package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import settings.Helper;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class InitialScreen {
    private AndroidDriver driver;

    public InitialScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators
    By youMailLogoLocator = By.xpath("//android.widget.ImageView[@resource-id='com.youmail.android.vvm:id/imageView1']");

    By sloganLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/tagline']");

    By joinNowButton = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/signup']");

    By signInButton = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/signin']");

    public void switchToEnvironment(String environment) throws InterruptedException
    {
        By environmentSelectorLocator = By.xpath("//android.widget.CheckedTextView[@text='" + environment + "']");
        By okButton = By.xpath("//android.widget.Button[@text='OK']");

        Helper.waitForPresent(driver, sloganLocator);

        System.out.println("Switching environment...");

        for (int i = 0; i <= 2; i++)
        {
            driver.findElement(sloganLocator).click();
            driver.findElement(youMailLogoLocator).click();
        }

//        By environmentSelectorLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
//                "/android.widget.LinearLayout[@index='0' and @resource-id='android:id/parentPanel']" +
//                "/android.widget.FrameLayout[@index='1' and @resource-id='android:id/contentPanel']" +
//                "/android.widget.ListView[@index='0' and @resource-id='android:id/select_dialog_listview']" +
//                "/android.widget.CheckedTextView[@index='" + environment + "']"
//        );

        Helper.waitForPresent(driver, environmentSelectorLocator);

        driver.findElement(environmentSelectorLocator).click();
        driver.findElement(okButton).click();

        System.out.println("Environment switched to: " + environment);
    }

    public void turnOnDebug(String mode)
    {
        By modeSelectorLocator = By.xpath("//android.widget.CheckedTextView[@text='" + mode + "']");
        By okButton = By.xpath("//android.widget.Button[@text='OK']");

        Helper.waitForPresent(driver, youMailLogoLocator);

        System.out.println("Turning Debug Mode on...");

        for (int i = 0; i <= 2; i++)
        {
            driver.findElement(youMailLogoLocator).click();
            driver.findElement(sloganLocator).click();
        }

        Helper.waitForPresent(driver, modeSelectorLocator);

        driver.findElement(modeSelectorLocator).click();
        driver.findElement(okButton).click();

        System.out.println(mode + " mode on");
    }
}
