package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import settings.Helper;

/**
 * Created by aatayants on 4/25/2017.
 */
public class ContactsScreen
{
    private AndroidDriver driver;

    public ContactsScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators
    By targetContactLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/ContactName' and @text='qa Testing']");

    // Overflow menu items
    By addContactOverflowLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/title' and @text='Add Contact']");

    // Add Contact Locators
    By fNameLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/first_name']");

    By lNameLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/last_name']");

    By phoneLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/phone_1']");

    By saveContactLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/btn_save']");

    // Contact details
    By callContactButtonLocator = By.xpath("//android.widget.ImageView[@resource-id='com.youmail.android.vvm:id/call']");

    By textContactButtonLocator = By.xpath("//android.widget.ImageView[@resource-id='com.youmail.android.vvm:id/txt']");

    By vmDropButtonLocator = By.xpath("//android.widget.ImageView[@resource-id='com.youmail.android.vvm:id/dropbox']");

    By ditchContactButtonLocator = By.xpath("//android.widget.ImageView[@resource-id='com.youmail.android.vvm:id/ditch_unditch']");

    // VM Drop elements
    By popupDismissButtonLocator = By.xpath("//android.widget.Button[@resource-id='android:id/button1' and @text='OK']");

    By vmRecordButtonLocator = By.xpath("//android.widget.ImageView[@resource-id='com.youmail.android.vvm:id/button_record']");

    By sendRecordedVmButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/button_save']");

    public void openTargetContact()
    {
        By scrollContainerLocator = By.xpath("//android.widget.ListView[@resource-id='android:id/list']");

        try
        {
            driver.findElement(scrollContainerLocator);
        }
        catch (Exception e)
        {
            scrollContainerLocator = By.xpath("//android.widget.AbsListView[@resource-id='android:id/list']");
        }

        boolean flag = true;

        while (flag)
        {
            try
            {
                driver.findElement(targetContactLocator).click();
                System.out.println("Target contact opened");
                flag = false;
            }
            catch (Exception e)
            {
                AndroidElement scrollContainer = (AndroidElement) driver.findElement(scrollContainerLocator);
//                Helper.swipeDownElementLight(driver, scrollContainer, 2000);
            }
        }
    }

    public void callContact() throws InterruptedException
    {
        driver.findElement(callContactButtonLocator).click();
        System.out.println("Calling contact");
        Thread.sleep(3000);
        Helper.adbEndCall();
        System.out.println("Call ended");
    }

    public void textContact()
    {
        Helper.waitForPresent(driver, textContactButtonLocator);
        driver.findElement(textContactButtonLocator).click();
        System.out.println("Text Sender Open");
        Helper.adbPressBack();
        Helper.adbPressBack();
        System.out.println("Text Sender Closed");
    }

    public void dropVmToContact() throws InterruptedException
    {
        driver.findElement(vmDropButtonLocator).click();
        System.out.println("VM Drop screen open");
        driver.findElement(popupDismissButtonLocator).click();

        driver.findElement(vmRecordButtonLocator).click();
        System.out.println("VM recording started");
        Thread.sleep(8000);
        driver.findElement(vmRecordButtonLocator).click();
        System.out.println("VM recording stopped");

        driver.findElement(sendRecordedVmButtonLocator).click();
        Thread.sleep(3000);
        System.out.println("VM sent");
    }

    public void ditchContact()
    {
        driver.findElement(ditchContactButtonLocator).click();
    }

    public void createContact()
    {
        Helper.waitForPresent(driver, addContactOverflowLocator);
        driver.findElement(addContactOverflowLocator).click();

        Helper.waitForPresent(driver, fNameLocator);
        driver.findElement(fNameLocator).sendKeys("Test");
        driver.findElement(lNameLocator).sendKeys("Contact");
        driver.findElement(phoneLocator).sendKeys("0007150000");

        driver.findElement(saveContactLocator).click();
        System.out.println("Contact created: Test Contact 0007150000");
    }
}