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
public class ActivationScreen {
    private AndroidDriver driver;

    public ActivationScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators
    By appBarTitleLocator = By.xpath("//android.view.ViewGroup[@index='0' and @resource-id='com.youmail.android.vvm:id/appbar']" +
            "/android.widget.TextView[@index='2']"
    );

    By appBarSubTitleLocator = By.xpath("//android.view.ViewGroup[@index='0' and @resource-id='com.youmail.android.vvm:id/appbar']" +
            "/android.widget.TextView[@index='3']"
    );

    By activateHeaderLocator = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/activate_carrier']" +
            "/android.widget.TextView[@index='1' and @resource-id='com.youmail.android.vvm:id/textView9']"
    );

    /*!! Dynamic, depends on the Carrier*/
    By forCarrierNameLocator = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/activate_carrier']" +
            "/android.widget.TextView[@index='2' and @resource-id='com.youmail.android.vvm:id/tv_on_your_carrier_phone']"
    );

    By changeCarrierLinkLocator = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/activate_carrier']" +
            "/android.widget.TextView[@index='3' and @resource-id='com.youmail.android.vvm:id/tv_not_on_carrier']"
    );

    By forwardingExplanationLocator = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/activate_carrier']" +
            "/android.widget.TextView[@index='4' and @resource-id='com.youmail.android.vvm:id/tv_explanation']"
    );

    By activateButtonLocator = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/activate_carrier']" +
            "/android.widget.Button[@index='6' and @resource-id='com.youmail.android.vvm:id/btn_primary']"
    );

    By skipActivationLinkLocator = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/activate_carrier']" +
            "/android.widget.TextView[@index='7' and @resource-id='com.youmail.android.vvm:id/skip_activation']"
    );

    By additionalInfoLinkLocator = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/activate_carrier']" +
            "/android.widget.TextView[@index='8' and @resource-id='com.youmail.android.vvm:id/additional_info']"
    );

    public void verifyTexts() throws BiffException, IOException
    {
        /* Template */
//        AndroidElement * = (AndroidElement) driver.findElement(*Locator);
//        assertEquals(elementTexts.get("*"), *.getText());

        HashMap<String, String> elementTexts = Helper.getElementTexts(4);

        Helper.waitForPresent(driver, appBarTitleLocator);

        AndroidElement appBarTitle = (AndroidElement) driver.findElement(appBarTitleLocator);
        assertEquals(elementTexts.get("appBarTitle"), appBarTitle.getText());

        AndroidElement appBarSubTitle = (AndroidElement) driver.findElement(appBarSubTitleLocator);
        assertEquals(elementTexts.get("appBarSubTitle"), appBarSubTitle.getText());

        AndroidElement activateHeader = (AndroidElement) driver.findElement(activateHeaderLocator);
        assertEquals(elementTexts.get("activateHeader"), activateHeader.getText());

        AndroidElement changeCarrierLink = (AndroidElement) driver.findElement(changeCarrierLinkLocator);
        assertEquals(elementTexts.get("changeCarrierLink"), changeCarrierLink.getText());

        /*AndroidElement forwardingExplanation = (AndroidElement) driver.findElement(forwardingExplanationLocator);
        String deviceCarrierName = Helper.getCarrierName();
        deviceCarrierName = deviceCarrierName.substring(0, 1).toUpperCase() + deviceCarrierName.substring(1);
        String explanationText = elementTexts.get("forwardingExplanation");
        explanationText = explanationText.replace("CarrierName", deviceCarrierName);
        assertEquals(explanationText, forwardingExplanation.getText());*/

        AndroidElement activateButton = (AndroidElement) driver.findElement(activateButtonLocator);
        assertEquals(elementTexts.get("activateButton").toLowerCase(), activateButton.getText().toLowerCase());

        AndroidElement skipActivationLink = (AndroidElement) driver.findElement(skipActivationLinkLocator);
        assertEquals(elementTexts.get("skipActivationLink"), skipActivationLink.getText());

        AndroidElement additionalInfoLink = (AndroidElement) driver.findElement(additionalInfoLinkLocator);
        assertEquals(elementTexts.get("additionalInfoLink"), additionalInfoLink.getText());

        System.out.println("Activation Screen: Texts are correct!");
    }

    public void selectCarrier()
    {
        String carrierLocatorPart1 = "//android.widget.TextView[@resource-id='android:id/text1' and @text='";
        String deviceCarrierName = Helper.getCarrierName();
        deviceCarrierName = deviceCarrierName.substring(0, 1).toUpperCase() + deviceCarrierName.substring(1);
        String carrierLocatorPart2 = "']";

        System.out.println("Device Carrier: " + deviceCarrierName);

        By carrierLocator = By.xpath(carrierLocatorPart1 + deviceCarrierName + carrierLocatorPart2);

        By scrollContainerLocator = By.xpath("//android.widget.ListView[@resource-id='com.youmail.android.vvm:id/carriers_listview']");

        driver.findElement(changeCarrierLinkLocator).click();

        boolean flag = true;

        while (flag)
        {
            try
            {
                driver.findElement(carrierLocator).click();
                flag = false;

            }
            catch (Exception e)
            {
                AndroidElement scrollContainer = (AndroidElement) driver.findElement(scrollContainerLocator);
                Helper.swipeDownElementLight(driver, scrollContainer, 2000);
            }
        }
    }

    public void verifyCarrierMatches()
    {
        AndroidElement forCarrierName = (AndroidElement) driver.findElement(forCarrierNameLocator);
        String forCarrierNameText = forCarrierName.getText();
        System.out.println(forCarrierNameText);
        String deviceCarrierName = Helper.getCarrierName();
        deviceCarrierName = deviceCarrierName.substring(0, 1).toUpperCase() + deviceCarrierName.substring(1);
        System.out.println(deviceCarrierName);
        assertTrue(forCarrierNameText.contains(deviceCarrierName));

        System.out.println("Activation Screen: Carrier is correct!");

    }

    public void clickActivate()
    {
        driver.findElement(activateButtonLocator).click();
        System.out.println("Activation Screen Finished");
    }
}