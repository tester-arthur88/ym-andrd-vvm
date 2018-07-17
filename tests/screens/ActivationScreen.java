package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import settings.Helper;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by aatayants on 12/1/2016.
 */
public class ActivationScreen
{
    private AndroidDriver driver;

    public ActivationScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Forward to YouMail
    By forwardToYouMailLocator = By.xpath("//android.widget.TextView[@text='Forward to YouMail']");

    By activateButtonLocator = By.xpath("//android.widget.Button[@text='ACTIVATE']");

    // Verify YouMail is working
    By verifyYouMailIsWorkingLocator = By.xpath("//android.widget.TextView[@text='Forward to YouMail']");

    By verifyButtonLocator = By.xpath("//android.widget.Button[@text='VERIFY ACTIVATION']");

    // Call Forwarding Popup
    By callForwardingSuccessLocator = By.xpath("//android.widget.TextView[@text='Call forwarding\n" +
            "Registration was successful.']");
    By callForwardingPopupDismissLocator = By.xpath("//android.widget.Button[@resource-id='android:id/button1' and @text='OK']");

    // Activation Success
    By doneButtonLocator = By.xpath("//android.widget.Button[@text='DONE']");

    /*Success Screen*/
    By activationSuccessTitleLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/title_tv' and " +
            "@text='Success!']");

    By goToInboxButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/primary_btn' and " +
            "@text='GO TO INBOX']");

    By setupGreetingButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/setup_greeting_btn' and " +
            "@text='SETUP GREETING']");


    public void clickActivate()
    {
        driver.findElement(activateButtonLocator).click();
        Helper.waitForPresentSuperLong(driver, verifyButtonLocator);
        System.out.println("Activation Screen Finished");
    }

    public void performTestCallAfterSignUp()
    {
        for (int i = 0; i <= 5; i++)
        {
            try
            {
                System.out.println("Trying to close popup" + i + " time");
                Helper.waitForPresentLong(driver, callForwardingSuccessLocator);
                driver.findElement(callForwardingSuccessLocator);
                driver.findElement(callForwardingPopupDismissLocator).click();
            }
            catch (Exception e)
            {
                driver.findElement(verifyButtonLocator).click();
                Helper.waitForPresentLong(driver, doneButtonLocator);
                driver.findElement(goToInboxButtonLocator).click();
                System.out.println("Test Call successful");
            }
        }
    }
}