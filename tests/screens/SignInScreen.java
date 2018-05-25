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
public class SignInScreen
{
    private AndroidDriver driver;

    public SignInScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators
    By permissionContinueButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/continue_btn']");

    By permissionAllowButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']");

    By phoneEmailInputLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/user_identifier']");

    By passwordInputLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/password']");

    By signInButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/primary_btn']");

    By forgotPasswordLinkLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/forgot_password']");

    By toolBarLocator = By.xpath("//android.view.ViewGroup[@resource-id='com.youmail.android.vvm:id/toolbar']");

    By folderDropDownLocator = By.xpath("//android.view.ViewGroup[@resource-id='com.youmail.android.vvm:id/main_man_folder_spinner_row']");

    public void allowPermissions()
    {
        Helper.waitForPresent(driver, permissionContinueButtonLocator);
        driver.findElement(permissionContinueButtonLocator).click();
        Helper.waitForPresent(driver, permissionAllowButtonLocator);
        driver.findElement(permissionAllowButtonLocator).click();
    }

    public void typePhone(String phoneNumber)
    {
        Helper.waitForPresent(driver, phoneEmailInputLocator);
        driver.findElement(phoneEmailInputLocator).clear();
        driver.findElement(phoneEmailInputLocator).sendKeys(phoneNumber);

        Helper.keyboardHide(driver);

        System.out.println("Phone number/email: " + phoneNumber);
    }

    public void typePassword(String password)
    {
        driver.findElement(passwordInputLocator).clear();
        driver.findElement(passwordInputLocator).sendKeys(password);
        Helper.keyboardHide(driver);

        System.out.println("Password: " + password);
    }

    public void clickSignIn() throws InterruptedException
    {
        driver.findElement(signInButtonLocator).click();
        System.out.println("Sign In Screen: Sign In clicked");
        Thread.sleep(5000);
        Helper.adbPressBack();
        Helper.waitForPresentLong(driver, folderDropDownLocator);
        System.out.println("Signed In successfully");
        Thread.sleep(5000);
    }
}