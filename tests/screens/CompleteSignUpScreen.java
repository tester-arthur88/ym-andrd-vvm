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
public class CompleteSignUpScreen {
    private AndroidDriver driver;

    public CompleteSignUpScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators
    By screenTitleTextLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.ScrollView[@index='0']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.TextView[@index='0' and @resource-id='com.youmail.android.vvm:id/textView6']"
    );

    By changePhoneLinkLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.ScrollView[@index='0']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.TextView[@index='1' and @resource-id='com.youmail.android.vvm:id/change_phone_reg']"
    );

    By fnameInputLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.ScrollView[@index='0']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.EditText[@index='3' and @resource-id='com.youmail.android.vvm:id/fname']"
    );

    By lnameInputLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.ScrollView[@index='0']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.EditText[@index='4' and @resource-id='com.youmail.android.vvm:id/lname']"
    );

    By emailInputLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.ScrollView[@index='0']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.EditText[@index='7' and @resource-id='com.youmail.android.vvm:id/email']"
    );

    By passwordInputLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.ScrollView[@index='0']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.EditText[@index='9' and @resource-id='com.youmail.android.vvm:id/pin']"
    );

    By tosCheckboxLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.ScrollView[@index='0']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.CheckBox[@index='10' and @resource-id='com.youmail.android.vvm:id/tos_checkbox']"
    );

    By tosLinkTextLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.ScrollView[@index='0']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.LinearLayout[@index='11' and @resource-id='com.youmail.android.vvm:id/tos_host']" +
            "/android.widget.TextView[@index='0' and @resource-id='com.youmail.android.vvm:id/tos_view']"
    );

    By signUpButtonLocator = By.xpath("//android.widget.FrameLayout[@index='0' and @resource-id='android:id/content']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.ScrollView[@index='0']" +
            "/android.widget.RelativeLayout[@index='0']" +
            "/android.widget.Button[@index='12' and @resource-id='com.youmail.android.vvm:id/btn_primary']"
    );

    public void verifyTexts()throws BiffException, IOException
    {
                /* Template */
//        AndroidElement * = (AndroidElement) driver.findElement(*Locator);
//        assertEquals(elementTexts.get("*"), *.getText());

        // Elements
        HashMap<String, String> elementTexts = Helper.getElementTexts(1);

        AndroidElement screenTitleText = (AndroidElement) driver.findElement(screenTitleTextLocator);
        assertEquals(elementTexts.get("screenTitleText"), screenTitleText.getText());

        AndroidElement changePhoneLink = (AndroidElement) driver.findElement(changePhoneLinkLocator);
        assertEquals(elementTexts.get("changePhoneLink"), changePhoneLink.getText());

        AndroidElement fnameInput = (AndroidElement) driver.findElement(fnameInputLocator);
        assertEquals(elementTexts.get("fnameInput"), fnameInput.getText());

        AndroidElement lnameInput = (AndroidElement) driver.findElement(lnameInputLocator);
        assertEquals(elementTexts.get("lnameInput"), lnameInput.getText());

        AndroidElement tosLinkText = (AndroidElement) driver.findElement(tosLinkTextLocator);
        assertEquals(elementTexts.get("tosLinkText"), tosLinkText.getText());

        AndroidElement signUpButton = (AndroidElement) driver.findElement(signUpButtonLocator);
        assertEquals(elementTexts.get("signUpButton"), signUpButton.getText());

        System.out.println("Texts are correct!");
    }

    public void typeFName(String fName)
    {
        driver.findElement(fnameInputLocator).sendKeys(fName);
        System.out.println("First Name: " + fName);
    }

    public void typeLName(String lName)
    {
        driver.findElement(lnameInputLocator).sendKeys(lName);
        System.out.println("Last Name: " + lName);
    }

    public void verifyEmail(String email)
    {
        AndroidElement emailInput = (AndroidElement) driver.findElement(emailInputLocator);

        if (emailInput.getText().equals(email))
        {
            System.out.println("Email is correct");
        }
        else
        {
            emailInput.clear();
            emailInput.sendKeys(email);

            System.out.println("Email typed in: " + email);
        }
    }

    public void typePassword(String password)
    {
        driver.findElement(passwordInputLocator).sendKeys(password);
        System.out.println("Password: "+ password);
    }

    public void clickSignUp()
    {
        driver.findElement(signUpButtonLocator).click();
        System.out.println("Complete SignUp Finished");
    }
}