package screens;

import io.appium.java_client.android.AndroidDriver;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import settings.Helper;

import java.io.IOException;

/**
 * Created by aatayants on 1/9/2017.
 */
public class MessagesScreen
{
    private AndroidDriver driver;

    public MessagesScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators

    // Top Controls Beginning

    By backButtonLocator = By.xpath("//android.widget.ImageView[@resource-id='com.youmail.android.vvm:id/action_mode_close_button' and @content-desc='Done']");

    By bulkDeleteButtonLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/action_delete' and @content-desc='Delete']");

    By bulkMoveButtonLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/action_moveto']");

    By overflowMenuButtonLocator = By.xpath("//android.widget.ImageView[@content-desc='More options']");

    // Top Controls Ending

    // Move To Controls Beginning

    By moveToInboxLocator = By.xpath("//android.widget.TextView[@text='Inbox']");

    By moveToSpamLocator = By.xpath("//android.widget.TextView[@text='Spam']");

    By moveToTrashLocator = By.xpath("//android.widget.TextView[@text='Trash']");

    By moveToSaveLocator = By.xpath("//android.widget.TextView[@text='Save']");

    // Move To Controls Ending

    // Overflow Options Beginning

    By markAsReadLocator = By.xpath("//android.widget.TextView[@text='Mark as read']");

    By markAsUnreadLocator = By.xpath("//android.widget.TextView[@text='Mark as unread']");

    // Overflow Options Ending

    // Folder dropdown elements locators beginning

    By inboxFolderLocator = By.xpath("//android.widget.TextView[@text='Inbox']");

    By spamFolderLocator = By.xpath("//android.widget.TextView[@text='Spam']");

    By trashFolderLocator = By.xpath("//android.widget.TextView[@text='Trash']");

    By saveFolderLocator = By.xpath("//android.widget.TextView[@text='Save']");

    By createFolderLocator = By.xpath("//android.widget.TextView[@text='Create New Folder']");

    // Folder dropdown elements locators ending

    // Messages List Beginning

    String messageListContainer = "//android.view.ViewGroup[@resource-id='com.youmail.android.vvm:id/message_list_row' and index='" + "]";

    By messageIconLocator = By.xpath("//android.view.ViewGroup[@resource-id='com.youmail.android.vvm:id/icon_include_container']");

    By messageTitleLocaotr = By.xpath("//android.view.ViewGroup[@resource-id='com.youmail.android.vvm:id/message_container']");

    By messageStarLocator = By.xpath("//android.view.ViewGroup[@resource-id='com.youmail.android.vvm:id/star_container']");

    By firstMessageItemLocator = By.xpath("//android.view.ViewGroup[@resource-id='com.youmail.android.vvm:id/message_list_row' and @index='0']");

    // Messages List Ending

    /*Message Details Beginning*/

    By callerNumberLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/caller_number']");

    By callerEmailLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/caller_email']");

    By addEditContactLocator = By.xpath("//android.widget.LinearLayout[@resource-id='com.youmail.android.vvm:id/actions_add_edit_contact_button_container']");

    By blockButtonLocator = By.xpath("//android.widget.LinearLayout[@resource-id='com.youmail.android.vvm:id/actions_block_button_container']");

    By replyButtonLocator = By.xpath("//android.widget.LinearLayout[@resource-id='com.youmail.android.vvm:id/actions_reply_button_container']");

    By infoButtonLocator = By.xpath("//android.widget.LinearLayout[@resource-id='com.youmail.android.vvm:id/actions_info_button_container']");

    By messagePlayButtonLocator = By.xpath("//android.widget.ImageButton[@resource-id='com.youmail.android.vvm:id/play_button']");

    By outputSwitchLocator = By.xpath("//android.widget.ImageButton[@resource-id='com.youmail.android.vvm:id/toggle_output_phone_button']");

    By deleteButtonLocator = By.xpath("//android.widget.ImageButton[@resource-id='com.youmail.android.vvm:id/delete_button']");

    By moveButtonLocator = By.xpath("//android.widget.ImageButton[@resource-id='com.youmail.android.vvm:id/folder_button']");

    By shareButtonLocator = By.xpath("//android.widget.ImageButton[@resource-id='com.youmail.android.vvm:id/share_button']");

    By urlBarLocator = By.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/url_bar']");

    /*Message Details Ending*/

    /*Auto-Play Popup Beginning*/
    By tapPlayIconLocator = By.xpath("//android.widget.Button[@text='TAP PLAY ICON']");
    By useAutoplayLocator = By.xpath("//android.widget.Button[@text='USE AUTO-PLAY']");
    /*Auto-Play Popup Ending*/

    /*Block Screen Beginning*/
    /*Block Screen Beginning*/


    /*Folder Operations Beginning*/
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
    /*Folder Operations Ending*/

    public void openFirstMessage()
    {
        closeRateUsPopup();
//        Helper.dismissNotifications(driver);
        Helper.waitForPresent(driver, firstMessageItemLocator);
        System.out.println("Messages Open");
        driver.findElement(firstMessageItemLocator).click();
        System.out.println("Opening Message");
    }

    /*Message Details Operations Beginning*/
    public void playMessage() throws InterruptedException, BiffException, IOException
    {
        Helper.waitForPresentLong(driver, messagePlayButtonLocator);
        driver.findElement(messagePlayButtonLocator).click();
        System.out.println("Message Playback started");
        Thread.sleep(5000);
    }

    public void callSender() throws InterruptedException
    {
        driver.findElement(callerNumberLocator).click();
        System.out.println("Calling sender");
        Thread.sleep(3000);
        Helper.adbEndCall();
        System.out.println("Call ended");
    }

    public void blockSender() throws InterruptedException
    {
        Helper.waitForPresent(driver, blockButtonLocator);
        driver.findElement(blockButtonLocator).click();

//        try {
//            driver.findElement(ditchConfirmationYesLocator).click();
//        } catch (Exception e) {
//            //
//        }
//
//
//        System.out.println("Sender Blocked");
//        Thread.sleep(45000);
//        driver.findElement(blockButtonLocator).click();
//        System.out.println("Sender Unblocked");
    }

    public void replySender() throws InterruptedException
    {
        Helper.waitForPresent(driver, replyButtonLocator);
        driver.findElement(replyButtonLocator).click();

        Thread.sleep(3000);
        Helper.adbPressBack();
    }
    /*Message Details Operations Ending*/

    public void dismissTutorial() throws InterruptedException
    {
        Thread.sleep(3000);
        Helper.adbPressBack();
    }

    public void closeAutoplayPopup()
    {
        try
        {
            Helper.waitForPresent(driver, tapPlayIconLocator);
            driver.findElement(tapPlayIconLocator).click();
            System.out.println("Autoplay Popup Closed");
        } catch (Exception e)
        {
            //
        }
    }

    public void closeRateUsPopup()
    {
//        try {
//            Helper.waitForPresent(driver, rateUsPopupCloseLocator);
//            driver.findElement(rateUsPopupCloseLocator).click();
//            System.out.println("Rate Us Popup Closed");
//        } catch (Exception e) {
//            //
//        }
    }
}
