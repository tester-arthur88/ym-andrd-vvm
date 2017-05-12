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
 * Created by aatayants on 11/29/2016.
 */
public class SignInScreen {
    private AndroidDriver driver;

    public SignInScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators
    By appBarTitleLocator = By.xpath("//android.view.ViewGroup[@resource-id='com.youmail.android.vvm:id/appbar']" +
            "/android.widget.TextView[@index='1']"
    );

    By headerSloganLocator = By.xpath("//android.widget.LinearLayout[@resource-id='com.youmail.android.vvm:id/action_bar_root']" +
            "/android.widget.FrameLayout[@resource-id='android:id/content']" +
            "/android.widget.LinearLayout[@index='0']" +
            "/android.widget.LinearLayout[@index='1']" +
            "/android.widget.TextView[@resource-id='com.youmail.android.vvm:id/textView' and @index='0']"
    );

    By subHeaderLocator = By.xpath("//android.widget.LinearLayout[@resource-id='com.youmail.android.vvm:id/action_bar_root']" +
            "/android.widget.FrameLayout[@resource-id='android:id/content']" +
            "/android.widget.LinearLayout[@index='0']" +
            "/android.widget.LinearLayout[@index='1']" +
            "/android.widget.TextView[@resource-id='com.youmail.android.vvm:id/textView3' and @index='1']"
    );

    By welcomeTextLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/detected_phone']");

    By signInLabelLocator = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']" +
            "/android.widget.LinearLayout[@index='0']" +
            "/android.widget.ScrollView[@index='2']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.TextView[@index='1' and @resource-id='com.youmail.android.vvm:id/textView5']"
    );

    By phoneInputLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/phone']");

    By passwordInputLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/pin']");

    By signInButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/btn_primary']");

    By noAccountLinkLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/no_account']");

    By forgotPinLinkLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/forgot_pin']");

    // Error pop-up
    By errorPopupCloseLocator = By.xpath("//android.widget.LinearLayout[@index='0' and @resource-id='android:id/parentPanel']" +
            "/android.widget.LinearLayout[@index='2' and @resource-id='android:id/buttonPanel']" +
            "/android.widget.Button[@index='0' and @resource-id='android:id/button1']"
    );

    // Secret trigger
    By secretTriggerLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.LinearLayout[@index='0']" +
            "/android.widget.LinearLayout[@index='1']"
    );

    public void verifyTexts() throws BiffException, IOException
    {
        // Elements
        HashMap<String, String> elementTexts = Helper.getElementTexts(2);

        AndroidElement appBarTitle = (AndroidElement) driver.findElement(appBarTitleLocator);
        assertEquals(elementTexts.get("appBarTitle"), appBarTitle.getText());

        AndroidElement headerSlogan = (AndroidElement) driver.findElement(headerSloganLocator);
        assertEquals(elementTexts.get("headerSlogan"), headerSlogan.getText());

        AndroidElement subHeader = (AndroidElement) driver.findElement(subHeaderLocator);
        assertEquals(elementTexts.get("subHeader"), subHeader.getText());

        AndroidElement welcomeText = (AndroidElement) driver.findElement(welcomeTextLocator);
        assertEquals(elementTexts.get("welcomeText"), welcomeText.getText());

        AndroidElement signInLabel = (AndroidElement) driver.findElement(signInLabelLocator);
        assertEquals(elementTexts.get("signInLabel"), signInLabel.getText());

        AndroidElement signInButton = (AndroidElement) driver.findElement(signInButtonLocator);
        assertEquals(elementTexts.get("signInButton"), signInButton.getText());

        AndroidElement noAccountLink = (AndroidElement) driver.findElement(noAccountLinkLocator);
        assertEquals(elementTexts.get("noAccountLink"), noAccountLink.getText());

        AndroidElement forgotPinLink = (AndroidElement) driver.findElement(forgotPinLinkLocator);
        assertEquals(elementTexts.get("forgotPinLink"), forgotPinLink.getText());

        System.out.println("Sign In Screen: Texts are correct!");
    }

    public void typePhone(String phoneNumber)
    {
        driver.findElement(phoneInputLocator).clear();
        driver.findElement(phoneInputLocator).sendKeys(phoneNumber);
        Helper.keyboardHide(driver);

        System.out.println("Phone number: " + phoneNumber);
    }

    public void typePassword(String password)
    {
        driver.findElement(passwordInputLocator).clear();
        driver.findElement(passwordInputLocator).sendKeys(password);
        Helper.keyboardHide(driver);

        System.out.println("Password: " + password);
    }

    public void clickSignIn()
    {
        driver.findElement(signInButtonLocator).click();

        System.out.println("Sign In Screen: Sign In clicked");
    }

    public void clickNoAccount()
    {
        driver.findElement(noAccountLinkLocator).click();

        System.out.println("Switched to Sign Up screen");
    }

    public void closeErrorPopup()
    {
        Helper.waitForPresent(driver, errorPopupCloseLocator);
        driver.findElement(errorPopupCloseLocator).click();
        System.out.println("Sign In Screen: Error Popup closed");
    }

    public void switchToEnvironment(String environment) throws InterruptedException
    {
        Helper.waitForPresent(driver, secretTriggerLocator);

        System.out.println("Switching environment...");

        for (int i = 1; i <= 6; i++)
        {
            driver.findElement(secretTriggerLocator).click();
            System.out.println("touch");
        }

        By environmentSelectorLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
                "/android.widget.LinearLayout[@index='0' and @resource-id='android:id/parentPanel']" +
                "/android.widget.FrameLayout[@index='1' and @resource-id='android:id/contentPanel']" +
                "/android.widget.ListView[@index='0' and @resource-id='android:id/select_dialog_listview']" +
                "/android.widget.CheckedTextView[@index='" + environment + "']"
        );

        Helper.waitForPresent(driver, environmentSelectorLocator);

        driver.findElement(environmentSelectorLocator).click();

        System.out.println("Environment switched");
    }
}