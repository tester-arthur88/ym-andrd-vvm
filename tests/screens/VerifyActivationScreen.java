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
 * Created by aatayants on 12/2/2016.
 */
public class VerifyActivationScreen {
    private AndroidDriver driver;

    public VerifyActivationScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators
    By verifyActivationTitleLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/textView11']");

    By verifyExplanationLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/textView12']");

    By verifySetupButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/btn_primary']");


    By skipButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/btn_secondary']");

    By incomingCallPopupLocator = By.xpath("//android.widget.RelativeLayout[@index='0' and @resource-id='com.youmail.callerid:id/toast_background_container']"
    );

    By incomingCallPopupCloseBtnLocator = By.xpath("//android.widget.RelativeLayout[@index='0' and @resource-id='com.youmail.callerid:id/toast_background_container']" +
            "/android.widget.LinearLayout[@index='0']" +
            "/android.widget.LinearLayout[@index='0']" +
            "/android.widget.LinearLayout[@index='0']" +
            "/android.widget.LinearLayout[@index='2']" +
            "/android.widget.LinearLayout[@index='0' and @resource-id='com.youmail.callerid:id/closebutton']"
    );

//    By callForwardingPopupCloseLocator = By.xpath("//android.widget.FrameLayout[@index='0']" +
//            "/android.widget.FrameLayout[@index='0']" +
//            "/android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
//            "/android.widget.LinearLayout[@index='0' and @resource-id='android:id/parentPanel']" +
//            "/android.widget.ScrollView[@index='1' and @resource-id='android:id/buttonPanel']" +
//            "/android.widget.LinearLayout[@index='0']" +
//            "/android.widget.Button[@index='0' and @resource-id='android:id/button1']"
//    );

    By callForwardingPopupCloseLocator = By.xpath("//android.widget.Button[@index='0' and @resource-id='android:id/button1']");

    public void verifyTexts() throws BiffException, IOException
    {
        /* Template */
//        AndroidElement * = (AndroidElement) driver.findElement(*Locator);
//        assertEquals(elementTexts.get("*"), *.getText());

        HashMap<String, String> elementTexts = Helper.getElementTexts(5);

        Helper.waitForPresent(driver, verifyActivationTitleLocator);

        AndroidElement verifyActivationTitle = (AndroidElement) driver.findElement(verifyActivationTitleLocator);
        assertEquals(elementTexts.get("verifyActivationTitle"), verifyActivationTitle.getText());

        AndroidElement verifyExplanation = (AndroidElement) driver.findElement(verifyExplanationLocator);
        assertEquals(elementTexts.get("verifyExplanation"), verifyExplanation.getText());

        AndroidElement verifySetupButton = (AndroidElement) driver.findElement(verifySetupButtonLocator);
        assertEquals(elementTexts.get("verifySetupButton"), verifySetupButton.getText());

        AndroidElement skipButton = (AndroidElement) driver.findElement(skipButtonLocator);
        assertEquals(elementTexts.get("skipButton"), skipButton.getText());

        System.out.println("Verify Activation Screen: Texts are correct!");
    }

    public void clickVerifySetup()
    {
        Helper.waitForPresentLong(driver, verifySetupButtonLocator);
        driver.findElement(verifySetupButtonLocator).click();
        System.out.println("Verify Activation Screen Finished");
    }

    public void closeIncomingCallPopup()
    {
        try
        {
            Helper.waitForPresent(driver, incomingCallPopupLocator);
            System.out.println("Verify Activation Screen: Incoming call popup found");
            driver.findElement(incomingCallPopupCloseBtnLocator).click();

            System.out.println("Verify Activation Screen: Incoming call Popup closed");
        }
        catch (Exception e)
        {

        }
    }

    public void closecallForwardingPopup()
    {
        try
        {
            Helper.waitForPresentLong(driver, callForwardingPopupCloseLocator);
            System.out.println("Call Forwarding popup found");
            driver.findElement(callForwardingPopupCloseLocator).click();
            System.out.println("Call Forwarding popup closed");
        }
        catch (Exception e)
        {
//            e.printStackTrace();
        }

    }
}
