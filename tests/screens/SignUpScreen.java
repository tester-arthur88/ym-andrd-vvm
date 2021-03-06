package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import settings.Helper;

import static org.junit.Assert.assertEquals;

/**
 * Created by aatayants on 12/6/2016.
 */
public class SignUpScreen
{
    private AndroidDriver driver;

    public SignUpScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators
    By permissionContinueButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/continue_btn']");

    By permissionAllowButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.android.packageinstaller:id/permission_allow_button']");

    By phoneInputLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/phone']");

    By emailInputLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/email']");

    By nextButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/primary_btn']");

    // Complete Sign Up Screen:
    By carrierSelectorLocator = By.xpath("//android.widget.Spinner[@resource-id='com.youmail.android.vvm:id/carriers_spinner']");

    By carriersListContainerLocator = By.xpath("//android.widget.FrameLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.ListView[@index='0']");

    // Should select from a list later
    By carrierListItemLocator = By.xpath("android.widget.TextView[@resource-id='android:id/text1']");

    By fNameInputLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/first_name']");

    By lNameInputLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/last_name']");

    By passwordInputLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/password']");

    By iAgreeCheckboxLocator = By.xpath("//android.widget.CheckBox[@resource-id='com.youmail.android.vvm:id/tos_checkbox']");

    By createAccountButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/primary_btn']");

    By activationScreenTitleLocator = By.xpath("//android.widget.Button[@text='ACTIVATE']");

    public void allowPermissions()
    {
        Helper.waitForPresent(driver, permissionContinueButtonLocator);
        driver.findElement(permissionContinueButtonLocator).click();
        Helper.waitForPresent(driver, permissionAllowButtonLocator);
        driver.findElement(permissionAllowButtonLocator).click();
    }

    public void typePhone(String phoneNumber)
    {
        Helper.waitForPresent(driver, phoneInputLocator);
        driver.findElement(phoneInputLocator).clear();
        driver.findElement(phoneInputLocator).sendKeys(phoneNumber);

        System.out.println("Phone number: " + phoneNumber);
    }

    public void typeEmail(String email)
    {
        driver.findElement(emailInputLocator).sendKeys(email);

        System.out.println("Email: " + email);
    }

    public void clickNext()
    {
        driver.findElement(nextButtonLocator).click();

        System.out.println("Next clicked");
    }

    public void typeFName(String fName)
    {
        Helper.waitForPresent(driver, fNameInputLocator);
        driver.findElement(fNameInputLocator).clear();
        driver.findElement(fNameInputLocator).sendKeys(fName);
    }

    public void typeLName(String lName)
    {
        driver.findElement(lNameInputLocator).clear();
        driver.findElement(lNameInputLocator).sendKeys(lName);
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

    public void clickCreateAccount() throws InterruptedException
    {
        driver.findElement(createAccountButtonLocator).click();
        Helper.waitForPresentLong(driver, activationScreenTitleLocator);

        System.out.println("Account created successfully!");
        Thread.sleep(7000);
    }
}