package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import settings.AndroidSettings;
import settings.Helper;

import java.util.List;

/**
 * Created by aatayants on 2/28/2017.
 */
public class HistoryScreen
{
    private AndroidDriver driver;

    public HistoryScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Checkbox locators
    By checkBoxLocator = By.xpath("//android.widget.CheckedTextView[@resource-id='com.youmail.android.vvm:id/select_checkbox']");

//    By fullCheckBoxPath = By.xpath("//android.widget.LinearLayout[@index='0']" +
//            "/android.widget.LinearLayout[@resource-id='com.youmail.android.vvm:id/row_content']" +
//            "/android.widget.LinearLayout[@resource-id='com.youmail.android.vvm:id/message_row_status_widget']" +
//            "/android.widget.CheckedTextView[@resource-id='com.youmail.android.vvm:id/select_checkbox']"
//    );

//    String itemIndex;
//
//    By fullCheckBoxPath = By.xpath("//android.widget.LinearLayout[@index='" + itemIndex + "']" +
//            "/android.widget.LinearLayout[@resource-id='com.youmail.android.vvm:id/row_content']" +
//            "/android.widget.LinearLayout[@resource-id='com.youmail.android.vvm:id/message_row_status_widget']" +
//            "/android.widget.CheckedTextView[@resource-id='com.youmail.android.vvm:id/select_checkbox']"
//    );

    By deleteSelectedItemsLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/menu_item_delete']");

    By firstEntryLocator = By.xpath("//android.widget.FrameLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/maincontent']" +
            "/android.widget.FrameLayout[@index='0']" +
            "/android.widget.FrameLayout[@index='0' and @resource-id='android:id/listContainer']" +
            "/android.widget.ListView[@index='0' and @resource-id='android:id/list']" +
            "/android.widget.LinearLayout[@index='0']"
    );

    String callerDetailBtnGroupLocator = "//android.widget.LinearLayout[@index='2' and @resource-id='com.youmail.android.vvm:id/caller_detail_btn_group']";

    By callButtonLocator = By.xpath(callerDetailBtnGroupLocator +
            "/android.widget.LinearLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/call_btn']"
    );

    By textButtonLocator = By.xpath(callerDetailBtnGroupLocator +
            "/android.widget.LinearLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/txt_btn']"
    );

    By emailButtonLocator = By.xpath(callerDetailBtnGroupLocator +
        "/android.widget.LinearLayout[@index='2' and @resource-id='com.youmail.android.vvm:id/email_btn']"
    );

    By ditchButtonLocator = By.xpath(callerDetailBtnGroupLocator +
        "/android.widget.LinearLayout[@index='3' and @resource-id='com.youmail.android.vvm:id/ditch_unditch_btn']"
    );

    By ditchConfirmationYesLocator = By.xpath("//android.widget.LinearLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/confirm_bottom_panel']" +
            "/android.widget.LinearLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/button_bar']" +
            "/android.widget.Button[@index='0' and @resource-id='com.youmail.android.vvm:id/button_yes']"
    );

    public static By getfullCheckBoxPath(int index)
    {
        String itemIndex = String.valueOf(index);

        By fullCheckBoxPath = By.xpath("//android.widget.LinearLayout[@index='" + itemIndex + "']" +
                "/android.widget.LinearLayout[@resource-id='com.youmail.android.vvm:id/row_content']" +
                "/android.widget.LinearLayout[@resource-id='com.youmail.android.vvm:id/message_row_status_widget']" +
                "/android.widget.CheckedTextView[@resource-id='com.youmail.android.vvm:id/select_checkbox']"
        );

        return fullCheckBoxPath;
    }

    public void openEntry()
    {
        driver.findElement(firstEntryLocator).click();
    }

    public void callEntry() throws InterruptedException
    {
        driver.findElement(callButtonLocator).click();
        System.out.println("Calling entry");
        Thread.sleep(3000);
        Helper.adbEndCall();
        System.out.println("Call ended");
    }

    public void textEntry()
    {
        Helper.waitForPresent(driver, textButtonLocator);
        driver.findElement(textButtonLocator).click();
        System.out.println("Text Entry Open");
        Helper.adbPressBack();
        Helper.adbPressBack();
        System.out.println("Text Entry Closed");
    }

    public void forwardEntry()
    {
        Helper.waitForPresent(driver, emailButtonLocator);
        driver.findElement(emailButtonLocator).click();
        System.out.println("Email Entry Open");
//        driver.findElement(emailBackButtonLocator).click();
        Helper.adbPressBack();

        System.out.println("Email Entry Closed");
    }

    public void ditchEntry() throws InterruptedException
    {
        Helper.waitForPresent(driver, ditchButtonLocator);
        driver.findElement(ditchButtonLocator).click();
        driver.findElement(ditchConfirmationYesLocator).click();
        System.out.println("Entry Blocked");
        Thread.sleep(45000);
        driver.findElement(ditchButtonLocator).click();
        System.out.println("Entry Unblocked");
    }

    public void bulkDeleteItems() throws  InterruptedException
    {
        List<AndroidElement> checkBoxes = Helper.getElementsByLocator(driver, checkBoxLocator);

        if (checkBoxes.size() >= 2)
        {
            for (int i = 0; i <= 1; i++)
            {
//                checkBoxes.get(i).click();
                By checkbox = getfullCheckBoxPath(i);
                driver.findElement(checkbox).click();
            }

            Thread.sleep(8000);
            Helper.waitForPresent(driver, deleteSelectedItemsLocator);
            driver.findElement(deleteSelectedItemsLocator).click();

            System.out.println("Deleted selected items");
        }
        else
        {
            System.out.println("Bulk delete skipped: not enough entries");
        }
    }
}