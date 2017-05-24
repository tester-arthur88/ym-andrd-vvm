package screens;

import io.appium.java_client.android.AndroidDriver;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import settings.AndroidSettings;
import settings.Helper;

import java.io.IOException;

/**
 * Created by aatayants on 1/9/2017.
 */
//public class MessagesScreen extends AndroidSettings {
public class MessagesScreen {
    private AndroidDriver driver;

    public MessagesScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    // Element locators
//    By firstMessageItemLocator = By.xpath("//android.widget.ListView[@index='0' and @resource-id='android:id/list']" +
//            "/android.widget.LinearLayout[@index='0']" +
//            "/android.widget.RelativeLayout[@resource-id='com.youmail.android.vvm:id/row_container']" +
//            "/android.widget.FrameLayout[@index='2' and @resource-id='com.youmail.android.vvm:id/row_slider']" +
//            "/android.widget.LinearLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/row_content']" +
//            "/android.widget.LinearLayout[@index='2' and @resource-id='com.youmail.android.vvm:id/name_time_transcription_host']"
//    );

    // Folder dropdown elements locators
    By inboxFolderLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/folder_name' and @text='Inbox']");

    By saveFolderLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/folder_name' and @text='Save']");

    By spamFolderLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/folder_name' and @text='Spam']");

    By trashFolderLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/folder_name' and @text='Trash']");

    By loadMoreLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/empty_list_text']");

    By firstMessageItemLocator = By.xpath("//android.widget.ListView[@index='0' and @resource-id='android:id/list']" +
            "/android.widget.LinearLayout[@index='0']" +
            "/android.widget.RelativeLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/row_container']"
    );

    By messageDeleteButton = By.xpath("android.widget.TextView[@index='0' and @resource-id='com.youmail.android.vvm:id/menu_item_delete']");

    /*Middle Button Bar Beginning*/

    String middleBtnBarLocator = "//android.widget.LinearLayout[@index='2' and @resource-id='com.youmail.android.vvm:id/caller_detail_btn_group']";

    By callButtonLocator = By.xpath(middleBtnBarLocator +
            "/android.widget.LinearLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/call_btn']"
    );

    By textButtonLocator = By.xpath(middleBtnBarLocator +
            "/android.widget.LinearLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/txt_btn']" /*+
            "/android.widget.ImageView[@index='0' and @resource-id='com.youmail.android.vvm:id/txt']"*/
    );

    By textBackButtonLocator = By.xpath("android.widget.ImageView[@index='0' and @resource-id='com.android.mms:id/actionbar_arrow']");

    By emailButtonLocator = By.xpath(middleBtnBarLocator +
            "/android.widget.LinearLayout[@index='2' and @resource-id='com.youmail.android.vvm:id/email_btn']"
    );

    By emailBackButtonLocator = By.xpath("//android.view.ViewGroup[@index='0' and @resour2ce-id='com.youmail.android.vvm:id/appbar']" +
            "/android.widget.ImageButton[@index='0' and @content-desc='Navigate up']"
    );

    By ditchButtonLocator = By.xpath(middleBtnBarLocator +
            "/android.widget.LinearLayout[@index='3' and @resource-id='com.youmail.android.vvm:id/ditch_unditch_btn']"
    );

    /*Middle Button Bar Ending*/

    By messagePlayButtonLocator = By.xpath("//android.widget.ImageButton[@resource-id='com.youmail.android.vvm:id/pause']");

    By autoplayPopupCloseLocator = By.xpath("//android.widget.Button[@resource-id='android:id/button2']"
    );

    By ditchConfirmationYesLocator = By.xpath("//android.widget.LinearLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/confirm_bottom_panel']" +
            "/android.widget.LinearLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/button_bar']" +
            "/android.widget.Button[@index='0' and @resource-id='com.youmail.android.vvm:id/button_yes']"
    );

    By ditchConfirmationNoLocator = By.xpath("//android.widget.LinearLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/confirm_bottom_panel']" +
            "/android.widget.LinearLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/button_bar']" +
            "/android.widget.Button[@index='1' and @resource-id='com.youmail.android.vvm:id/button_no']"
    );

    By rateUsPopupCloseLocator = By.xpath("//android.widget.LinearLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/confirm_bottom_panel']" +
            "/android.widget.LinearLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/button_bar']" +
            "/android.widget.Button[@index='2' and @resource-id='com.youmail.android.vvm:id/button_skip']"
    );

    By forwardVoicemailExitConfirm = By.xpath("//android.widget.LinearLayout[@index='2' and @resource-id='android:id/buttonPanel']" +
            "/android.widget.Button[@index='1' and @resource-id='android:id/button1']"
    );

    public void openInboxFolder() throws InterruptedException
    {
        Helper.waitForPresent(driver, inboxFolderLocator);
        driver.findElement(inboxFolderLocator).click();
        Thread.sleep(3000);

        System.out.println("Inbox open");
    }

    public void openSaveFolder() throws InterruptedException
    {
        Helper.waitForPresent(driver, saveFolderLocator);
        driver.findElement(saveFolderLocator).click();
        Thread.sleep(3000);

        System.out.println("Save open");
    }

    public void openSpamFolder() throws InterruptedException
    {
        Helper.waitForPresent(driver, spamFolderLocator);
        driver.findElement(spamFolderLocator).click();
        Thread.sleep(3000);

        System.out.println("Spam open");
    }

    public void openTrashFolder() throws InterruptedException
    {
        Helper.waitForPresent(driver, trashFolderLocator);
        driver.findElement(trashFolderLocator).click();
        Thread.sleep(3000);

        System.out.println("Trash open");
    }

    public void loadMoreMessages() {
        try {
            Helper.waitForPresent(driver, loadMoreLocator);
            driver.findElement(loadMoreLocator).click();
            System.out.println("Load More Pressed");
            Thread.sleep(7000);
        } catch (Exception e) {

        }
    }

    public void openMessage() {
        closeRateUsPopup();
//        Helper.dismissNotifications(driver);
        Helper.waitForPresent(driver, firstMessageItemLocator);
        System.out.println("Messages Open");
        driver.findElement(firstMessageItemLocator).click();
        System.out.println("Opening Message");
    }

    public void playMessage() throws InterruptedException, BiffException, IOException {
        Helper.waitForPresentLong(driver, messagePlayButtonLocator);
        driver.findElement(messagePlayButtonLocator).click();
        System.out.println("Message Playback started");
        Thread.sleep(5000);
    }

    public void callSender() throws InterruptedException {
        driver.findElement(callButtonLocator).click();
        System.out.println("Calling sender");
        Thread.sleep(3000);
        Helper.adbEndCall();
        System.out.println("Call ended");
    }

    public void textSender() {
        Helper.waitForPresent(driver, textButtonLocator);
        driver.findElement(textButtonLocator).click();
        System.out.println("Text Sender Open");
        Helper.adbPressBack();
        Helper.adbPressBack();
        System.out.println("Text Sender Closed");
    }

    public void forwardMessage() {
        Helper.waitForPresent(driver, emailButtonLocator);
        driver.findElement(emailButtonLocator).click();
        System.out.println("Email Sender Open");
//        driver.findElement(emailBackButtonLocator).click();
        Helper.adbPressBack();

        try {
            driver.findElement(forwardVoicemailExitConfirm).click();
        } catch (Exception e) {
            //
        }

        System.out.println("Email Sender Closed");
    }

    public void ditchSender() throws InterruptedException {
        Helper.waitForPresent(driver, ditchButtonLocator);
        driver.findElement(ditchButtonLocator).click();

        try {
            driver.findElement(ditchConfirmationYesLocator).click();
        } catch (Exception e) {
            //
        }


        System.out.println("Sender Blocked");
        Thread.sleep(45000);
        driver.findElement(ditchButtonLocator).click();
        System.out.println("Sender Unblocked");
    }

    public void closeAutoplayPopup() {
        try {
            Helper.waitForPresent(driver, autoplayPopupCloseLocator);
            driver.findElement(autoplayPopupCloseLocator).click();
            System.out.println("Autoplay Popup Closed");
        } catch (Exception e) {
            //
        }
    }

    public void closeRateUsPopup() {
        try {
            Helper.waitForPresent(driver, rateUsPopupCloseLocator);
            driver.findElement(rateUsPopupCloseLocator).click();
            System.out.println("Rate Us Popup Closed");
        } catch (Exception e) {
            //
        }
    }
}
