package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import settings.Helper;

import static org.junit.Assert.assertEquals;

/**
 * Created by aatayants on 3/6/2017.
 */
public class GreetingsScreen {
    private AndroidDriver driver;

    public GreetingsScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators
    By smartGreetingLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/greeting_name' and @text='Smart Greeting']");

    By testGreetingLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/greeting_name' and @text='Test Greeting']");

    // Overflow menu items
    By newGreetingOverflowLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/title' and @text='New Greeting']");

    By recordGreetingOverflowLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/title' and @text='Record Greeting']");

    // Greeting record screen
    By editGreetingNameLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/edit_greeting_name']");

    By editGreetingDescriptionLocator = By.xpath("//android.widget.EditText[@resource-id='com.youmail.android.vvm:id/edit_greeting_description']");

    By recordButtonLocator = By.xpath("//android.widget.ImageView[@resource-id='com.youmail.android.vvm:id/button_record']");

    By saveRecordedGreetingButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/button_save']");

    // Greeting details
    By greetingPlayButtonLocator = By.xpath("//android.widget.ImageButton[@resource-id='com.youmail.android.vvm:id/pause']");

    By greetingTitleLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/greeting_name']");

    By greetingDescriptionLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/greeting_desc']");

    By setAsMainGreetingButtonLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/btn_set_as_default']");

    By setAsMainConfirmationLocator = By.xpath("//android.widget.Button[@resource-id='android:id/button1' and @text='OK']");

    By addContactToGreetingLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/ContactName' and @text='Add Contact']");

    String addContactGridLocator = "//android.widget.GridView[@resource-id='com.youmail.android.vvm:id/contacts_with_greeting']";

    By addedContactLocator = By.xpath(addContactGridLocator + "/android.widget.RelativeLayout[@resource-id='com.youmail.android.vvm:id/ContactListItemLayout']" +
            "/android.widget.FrameLayout[@resource-id='com.youmail.android.vvm:id/image_host']" +
            "/android.widget.TextView[@resource-id='com.youmail.android.vvm:id/ContactName' and @text='leigh company']"
    );

    By targetContactLocator = By.xpath("//android.widget.TextView[@resource-id='com.android.contacts:id/cliv_name_textview' and @text='leigh company']");

    By deleteGreetingLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/menu_item_delete']");

    By deleteConfirmationLocator = By.xpath("//android.widget.Button[@resource-id='com.youmail.android.vvm:id/button_yes']");

    public void openSmartGreeting()
    {
        Helper.waitForPresent(driver, smartGreetingLocator);
        driver.findElement(smartGreetingLocator).click();
        Helper.waitForPresent(driver, greetingPlayButtonLocator);
        System.out.println("Smart Greeting is open");
    }

    public void openTestGreeting()
    {
        Helper.waitForPresent(driver, testGreetingLocator);
        driver.findElement(testGreetingLocator).click();
        Helper.waitForPresent(driver, greetingPlayButtonLocator);
        System.out.println("Test Greeting is open");
    }

    public void playGreeting() throws InterruptedException
    {
        Helper.waitForPresent(driver, greetingPlayButtonLocator);
        driver.findElement(greetingPlayButtonLocator).click();
        System.out.println("Staring Greeting playback");
        Thread.sleep(5000);
        driver.findElement(greetingPlayButtonLocator).click();
        System.out.println("Greeting playback finished");
    }

    public void deleteGreeting()
    {
        Helper.waitForPresent(driver, deleteGreetingLocator);
        driver.findElement(deleteGreetingLocator).click();
        Helper.waitForPresent(driver, deleteConfirmationLocator);
        driver.findElement(deleteConfirmationLocator).click();

        System.out.println("Greeting deleted");
    }

    public void recordNewGreeting() throws InterruptedException
    {
        Helper.waitForPresent(driver, newGreetingOverflowLocator);
        driver.findElement(newGreetingOverflowLocator).click();
        Helper.waitForPresent(driver, recordGreetingOverflowLocator);
        driver.findElement(recordGreetingOverflowLocator).click();

        Helper.waitForPresent(driver, editGreetingNameLocator);
        driver.findElement(editGreetingNameLocator).clear();
        driver.findElement(editGreetingNameLocator).sendKeys("Test Greeting");
        driver.findElement(editGreetingDescriptionLocator).clear();
        driver.findElement(editGreetingDescriptionLocator).sendKeys("Test Description");
        Helper.keyboardHide(driver);

        driver.findElement(recordButtonLocator).click();
        System.out.println("Greeting: recording started");
        Thread.sleep(8000);
        driver.findElement(recordButtonLocator).click();
        System.out.println("Greeting: recording finished");

        driver.findElement(saveRecordedGreetingButtonLocator).click();
        Thread.sleep(3000);
        System.out.println("Greeting: greeting saved");

        Helper.waitForPresent(driver, greetingTitleLocator);
        AndroidElement greetingTitle = (AndroidElement) driver.findElement(greetingTitleLocator);
        assertEquals("Test Greeting", greetingTitle.getText());

        AndroidElement greetingDescription = (AndroidElement) driver.findElement(greetingDescriptionLocator);
        assertEquals("Test Description", greetingDescription.getText());

        System.out.println("Greeting recorded successfully");
    }

    public void setAsMainGreeting()
    {
        Helper.waitForPresent(driver, setAsMainGreetingButtonLocator);
        driver.findElement(setAsMainGreetingButtonLocator).click();

        try
        {
            Helper.waitForPresent(driver, setAsMainConfirmationLocator);
            driver.findElement(setAsMainConfirmationLocator).click();
        }
        catch (Exception e)
        {
            //
        }


        System.out.println("Greeting was set as a main greeting");
    }

    public void addContactToGreeting()
    {
        Helper.waitForPresent(driver, addContactToGreetingLocator);
        driver.findElement(addContactToGreetingLocator).click();

        // By scrollContainerLocator = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']");
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
                AndroidElement addedContact = (AndroidElement) driver.findElement(addedContactLocator);
                System.out.println("The following contact was added to the greeting: " + addedContact.getText());
                flag = false;
            }
            catch (Exception e)
            {
                AndroidElement scrollContainer = (AndroidElement) driver.findElement(scrollContainerLocator);
                Helper.swipeDownElementLight(driver, scrollContainer, 300);
            }
        }
    }
}