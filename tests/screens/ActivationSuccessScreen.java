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
 * Created by aatayants on 12/5/2016.
 */
public class ActivationSuccessScreen {
    private AndroidDriver driver;

    public ActivationSuccessScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators
    By successTextLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/results']");
    By inboxButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/btn_primary']");

    // Contact upload push locator
    By contactUploadPushLocator = By.xpath("//android.widget.TextView[@resource-id='android:id/title' and @text='Contact Upload']");

    public void verifyTexts() throws BiffException, IOException
    {
        /* Template */
//        AndroidElement * = (AndroidElement) driver.findElement(*Locator);
//        assertEquals(elementTexts.get("*"), *.getText());

        Helper.waitForPresentLong(driver, successTextLocator);

        HashMap<String, String> elementTexts = Helper.getElementTexts(6);

        AndroidElement successText = (AndroidElement) driver.findElement(successTextLocator);
        assertEquals(elementTexts.get("successText"), successText.getText());

        AndroidElement inboxButton = (AndroidElement) driver.findElement(inboxButtonLocator);
        assertEquals(elementTexts.get("inboxButton"), inboxButton.getText());

        System.out.println("Activation Success Screen: Texts are correct");
    }

    public void clickInboxButton()
    {
        Helper.waitForPresentLong(driver, inboxButtonLocator);
        driver.findElement(inboxButtonLocator).click();
        System.out.println("Activation Success Screen Finished");
    }

    public void waitForContactUpload()
    {
        driver.openNotifications();
        Helper.waitForPresentSuperLong(driver, contactUploadPushLocator);
        System.out.println("Contact upload: Upload successful");

        try
        {
            Helper.dismissNotifications(driver);
        }
        catch (Exception e)
        {
            Helper.adbPressBack();
        }
    }
}
