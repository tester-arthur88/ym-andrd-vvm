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
 * Created by aatayants on 12/6/2016.
 */
public class SignUpScreen {
    private AndroidDriver driver;

    public SignUpScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Container locators
    By bottomContainerLocator = By.xpath("//android.widget.ScrollView[@index='0' and @resource-id='com.youmail.android.vvm:id/scrollView']" /*+
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='2']"*/
    );

    // Element locators
    By billboardHeaderLocator = By.xpath("//android.widget.LinearLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/billboard']" +
            "/android.widget.TextView[@index='0' and @resource-id='com.youmail.android.vvm:id/textView']"
    );

    By billboardSubHeaderLocator = By.xpath("//android.widget.LinearLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/billboard']" +
            "/android.widget.TextView[@index='1' and @resource-id='com.youmail.android.vvm:id/textView3']"
    );

    By phoneLabelLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.ScrollView[@index='0' and @resource-id='com.youmail.android.vvm:id/scrollView']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/relativeLayout1']" +
            "/android.widget.TextView[@index='0' and @resource-id='com.youmail.android.vvm:id/signup']"
    );

    By phoneInputLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.ScrollView[@index='0' and @resource-id='com.youmail.android.vvm:id/scrollView']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/relativeLayout1']" +
            "/android.widget.EditText[@index='1' and @resource-id='com.youmail.android.vvm:id/phone']"
    );

    By emailLabelLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.ScrollView[@index='0' and @resource-id='com.youmail.android.vvm:id/scrollView']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/relativeLayout1']" +
            "/android.widget.TextView[@index='3' and @resource-id='com.youmail.android.vvm:id/emailText']"
    );

    By emainInputLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.ScrollView[@index='0' and @resource-id='com.youmail.android.vvm:id/scrollView']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/relativeLayout1']" +
            "/android.widget.EditText[@index='4' and @resource-id='com.youmail.android.vvm:id/email']"
    );

    By nextButtonLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.ScrollView[@index='0' and @resource-id='com.youmail.android.vvm:id/scrollView']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/relativeLayout1']" +
            "/android.widget.Button[@index='6' and @resource-id='com.youmail.android.vvm:id/btn_primary']"
    );

    By haveAccountLinkLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.ScrollView[@index='0' and @resource-id='com.youmail.android.vvm:id/scrollView']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/relativeLayout1']" +
            "/android.widget.TextView[@index='7' and @resource-id='com.youmail.android.vvm:id/have_account']"
    );

    By whatYouGetTextLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.ScrollView[@index='0' and @resource-id='com.youmail.android.vvm:id/scrollView']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='2']" +
            "/android.widget.TextView[@index='1' and @resource-id='com.youmail.android.vvm:id/whatYouGet']"
    );

    By itemFirstTextLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.ScrollView[@index='0' and @resource-id='com.youmail.android.vvm:id/scrollView']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='2']" +
            "/android.widget.TextView[@index='4' and @resource-id='com.youmail.android.vvm:id/autoDial']"
    );

    By itemSecondTextLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.ScrollView[@index='0' and @resource-id='com.youmail.android.vvm:id/scrollView']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='2']" +
            "/android.widget.TextView[@index='6' and @resource-id='com.youmail.android.vvm:id/textView6']"
    );

    By itemThirdTextLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.ScrollView[@index='0' and @resource-id='com.youmail.android.vvm:id/scrollView']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='2']" +
            "/android.widget.TextView[@index='8' and @resource-id='com.youmail.android.vvm:id/textView5']"
    );

    By itemFourthTextLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.ScrollView[@index='0' and @resource-id='com.youmail.android.vvm:id/scrollView']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='2']" +
            "/android.widget.TextView[@index='10' and @resource-id='com.youmail.android.vvm:id/textView4']"
    );

    // Secret trigger
    By secretTriggerLocator = By.xpath("//android.widget.LinearLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/billboard']");

    // Cannot create account error popup
    By errorPopUpCloseButtonLocator = By.xpath("//android.widget.LinearLayout[@index='2' and @resource-id='android:id/buttonPanel']" +
            "/android.widget.Button[@index='0' and @resource-id='android:id/button1']"
    );

    // Complete Sign Up Screen:
    By fNameInputLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/fname']");

    By lNameInputLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/lname']");

    By emailInputLocator2 = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/email']");

    By passwordInputLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/pin']");

    By iAgreeCheckboxLocator = By.xpath("//android.widget.CheckBox[@resource-id='com.youmail.android.vvm:id/tos_checkbox']");

    By signUpButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/btn_primary']");

    // Account Created Screen
    By accountCreatedNextButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/btn_primary']");


    public void verifyTexts() throws BiffException, IOException
    {
                /* Template */
//        AndroidElement * = (AndroidElement) driver.findElement(*Locator);
//        assertEquals(elementTexts.get("*"), *.getText());

        // Elements
        HashMap<String, String> elementTexts = Helper.getElementTexts(0);

//        Helper.waitForPresent(driver, itemFirstTextLocator);

        System.out.println("Verifying texts");

        AndroidElement billboardHeader = (AndroidElement) driver.findElement(billboardHeaderLocator);
        assertEquals(elementTexts.get("billboardHeader"), billboardHeader.getText());

        AndroidElement billboardSubHeader = (AndroidElement) driver.findElement(billboardSubHeaderLocator);
        assertEquals(elementTexts.get("billboardSubHeader"), billboardSubHeader.getText());

        AndroidElement phoneLabel = (AndroidElement) driver.findElement(phoneLabelLocator);
        assertEquals(elementTexts.get("phoneLabel"), phoneLabel.getText());

        AndroidElement emailLabel = (AndroidElement) driver.findElement(emailLabelLocator);
        assertEquals(elementTexts.get("emailLabel"), emailLabel.getText());

        AndroidElement nextButton = (AndroidElement) driver.findElement(nextButtonLocator);
        assertEquals(elementTexts.get("nextButton"), nextButton.getText());

        AndroidElement haveAccountLink = (AndroidElement) driver.findElement(haveAccountLinkLocator);
        assertEquals(elementTexts.get("haveAccountLink"), haveAccountLink.getText());

        System.out.println("Swiping down...");
        AndroidElement bottomContainer = (AndroidElement) driver.findElement(bottomContainerLocator);
        Helper.swipeDownElement(driver, bottomContainer, 2000);

        AndroidElement whatYouGetText = (AndroidElement) driver.findElement(whatYouGetTextLocator);
        assertEquals(elementTexts.get("whatYouGetText"), whatYouGetText.getText());

        AndroidElement itemFirstText = (AndroidElement) driver.findElement(itemFirstTextLocator);
        assertEquals(elementTexts.get("itemFirstText"), itemFirstText.getText());

        AndroidElement itemSecondText = (AndroidElement) driver.findElement(itemSecondTextLocator);
        assertEquals(elementTexts.get("itemSecondText"), itemSecondText.getText());

        AndroidElement itemThirdText = (AndroidElement) driver.findElement(itemThirdTextLocator);
        assertEquals(elementTexts.get("itemThirdText"), itemThirdText.getText());

        AndroidElement itemFourthText = (AndroidElement) driver.findElement(itemFourthTextLocator);
        assertEquals(elementTexts.get("itemFourthText"), itemFourthText.getText());

        System.out.println("Texts are correct!");

        System.out.println("Swiping up...");
        Helper.swipeUpElement(driver, bottomContainer, 2000);
    }

    public void typePhone(String phoneNumber)
    {
        driver.findElement(phoneInputLocator).clear();
        driver.findElement(phoneInputLocator).sendKeys(phoneNumber);

        System.out.println("Phone number: " + phoneNumber);
    }

    public void typeEmail(String email)
    {
        driver.findElement(emainInputLocator).sendKeys(email);

        System.out.println("Email: " + email);
    }

    public void clickNext()
    {
        driver.findElement(nextButtonLocator).click();

        System.out.println("Next clicked");
    }

    public void typeFName(String fName)
    {
        driver.findElement(fNameInputLocator).clear();
        driver.findElement(fNameInputLocator).sendKeys(fName);
    }

    public void typeLName(String lName)
    {
        driver.findElement(lNameInputLocator).clear();
        driver.findElement(lNameInputLocator).sendKeys(lName);
    }

    public void typeEmail2(String email)
    {
        driver.findElement(emailInputLocator2).clear();
        driver.findElement(emailInputLocator2).sendKeys(email);
    }

    public void typePassword(String password)
    {
        driver.findElement(passwordInputLocator).clear();
        driver.findElement(passwordInputLocator).sendKeys(password);
        Helper.keyboardHide(driver);
    }

    public void checkAgree()
    {
        driver.findElement(iAgreeCheckboxLocator).click();
    }

    public void clickSignUp()
    {
        driver.findElement(signUpButtonLocator).click();
    }

    public void clickNextComplete()
    {
        Helper.waitForPresent(driver, accountCreatedNextButtonLocator);
        driver.findElement(accountCreatedNextButtonLocator).click();
    }

    public void closeErrorPopUp()
    {
        driver.findElement(errorPopUpCloseButtonLocator).click();

        System.out.println("Error pop-up closed");
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
