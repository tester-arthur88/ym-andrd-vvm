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

    By verifyButtonLocator = By.xpath("//android.widget.Button[@text='VERIFY SETUP']");

    // Activation Success
    By doneButtonLocator = By.xpath("//android.widget.Button[@text='DONE']");

    public void clickActivate()
    {
        driver.findElement(activateButtonLocator).click();
        Helper.waitForPresentLong(driver, verifyButtonLocator);
        System.out.println("Activation Screen Finished");
    }

    public void performTestCall()
    {
        driver.findElement(verifyButtonLocator).click();
        Helper.waitForPresentSuperLong(driver, doneButtonLocator);
        driver.findElement(doneButtonLocator).click();
        System.out.println("Test Call successful");
    }
}