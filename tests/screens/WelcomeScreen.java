package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import settings.Helper;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by aatayants on 11/30/2016.
 */
public class WelcomeScreen {
    private AndroidDriver driver;

    public WelcomeScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators
    By welcomeHeaderLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.TextView[@index='0' and @resource-id='com.youmail.android.vvm:id/textView14']"
    );

    By welcomeSubHeaderLocator = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.TextView[@index='1' and @resource-id='com.youmail.android.vvm:id/textView13']"
    );

    By activateButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/btn_primary']");


    public void verifyTexts() throws BiffException, IOException
    {
        /* Template */
//        AndroidElement * = (AndroidElement) driver.findElement(*Locator);
//        assertEquals(elementTexts.get("*"), *.getText());

        System.out.println("Sign In Successful");

        HashMap<String, String> elementTexts = Helper.getElementTexts(3);

//        for (String key : elementTexts.keySet())
//        {
//            System.out.println(elementTexts.get(key));
//        }

//        System.out.println(elementTexts);

        AndroidElement welcomeHeader = (AndroidElement) driver.findElement(welcomeHeaderLocator);
        assertEquals(elementTexts.get("welcomeHeader"), welcomeHeader.getText());

        AndroidElement welcomeSubHeader = (AndroidElement) driver.findElement(welcomeSubHeaderLocator);
        assertEquals(elementTexts.get("welcomeSubHeader"), welcomeSubHeader.getText());

        AndroidElement activateButton = (AndroidElement) driver.findElement(activateButtonLocator);
        assertEquals(elementTexts.get("activateButton").toLowerCase(), activateButton.getText().toLowerCase());

        System.out.println("Welcome Screen: Texts are correct!");
    }

    public void clickActivate()
    {
        Helper.waitForPresentLong(driver, activateButtonLocator);
        driver.findElement(activateButtonLocator).click();

        System.out.println("Welcome Screen Finished");
    }
}
