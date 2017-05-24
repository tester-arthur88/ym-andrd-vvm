package appcontrols;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import settings.AndroidSettings;
import settings.Helper;

import java.util.Set;

/**
 * Created by aatayants on 12/6/2016.
 */
public class MainMenu extends AndroidSettings {
    private AndroidDriver driver;

    public MainMenu(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators
//    By appBarLocator = By.xpath("//android.view.ViewGroup[@index='0' and @resource-id='com.youmail.android.vvm:id/appbar']");
    String appBarLocator = "//android.view.ViewGroup[@index='0' and @resource-id='com.youmail.android.vvm:id/appbar']";

//    By menuBackButtonLocator = By.xpath(appBarLocator +
//            "/android.widget.ImageButton[@index='0' and @content-desc='Navigate up']"
//    );

    By menuBackButtonLocator = By.xpath(appBarLocator +
            "/android.widget.ImageButton[@index='0']"
    );

    By folderDropDownLocator = By.xpath(appBarLocator +
            "/android.widget.Spinner[@index='2']"
    );

    By appbarTitleLocator = By.xpath(appBarLocator +
            "/android.widget.TextView[@index='2']"
    );

    By overflowMenuLocator = By.xpath(appBarLocator +
            "/android.support.v7.widget.LinearLayoutCompat[@index='3']"
    );

//    By mainMenuLocator = By.xpath("//android.widget.LinearLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/layout_for_left_drawer_list']/android.widget.ListView[@index='0' and @resource-id='com.youmail.android.vvm:id/left_drawer']"
//    );

    String mainMenuLocator = "//android.widget.LinearLayout[@index='1' and @resource-id='com.youmail.android.vvm:id/layout_for_left_drawer_list']/android.widget.ListView[@index='0' and @resource-id='com.youmail.android.vvm:id/left_drawer']";

    By userFirstLastNameLocator = By.xpath(mainMenuLocator +
            "/android.widget.FrameLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/drawer_item_layout']" +
            "/android.widget.LinearLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/drawer_item_row']" +
            "/android.widget.LinearLayout[@index='2']" +
            "/android.widget.TextView[@index='0' and @resource-id='com.youmail.android.vvm:id/drawer_item_label']"
    );

    By userPhoneNumberLocator = By.xpath(mainMenuLocator +
            "/android.widget.FrameLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/drawer_item_layout']" +
            "/android.widget.LinearLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/drawer_item_row']" +
            "/android.widget.LinearLayout[@index='2']" +
            "/android.widget.TextView[@index='1' and @resource-id='com.youmail.android.vvm:id/drawer_phone_number']"
    );

    By userAccoutTypeLocator = By.xpath(mainMenuLocator +
            "/android.widget.FrameLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/drawer_item_layout']" +
            "/android.widget.LinearLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/drawer_item_row']" +
            "/android.widget.LinearLayout[@index='2']" +
            "/android.widget.TextView[@index='2' and @resource-id='com.youmail.android.vvm:id/drawer_account_type']"
    );

    By messagesMenuItemLocator = By.xpath(mainMenuLocator +
            "/android.widget.FrameLayout[@index='2' and @resource-id='com.youmail.android.vvm:id/drawer_item_layout']"
    );

    By hangupsMenuItemLocator = By.xpath(mainMenuLocator +
            "/android.widget.FrameLayout[@index='3' and @resource-id='com.youmail.android.vvm:id/drawer_item_layout']"
    );

    By greetingsMenuItemLocator = By.xpath(mainMenuLocator +
            "/android.widget.FrameLayout[@index='4' and @resource-id='com.youmail.android.vvm:id/drawer_item_layout']"
    );

    By contactsMenuItemLocator = By.xpath(mainMenuLocator +
            "/android.widget.FrameLayout[@index='6' and @resource-id='com.youmail.android.vvm:id/drawer_item_layout']"
    );

    By youMailersMenuItemLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/drawer_item_label' and @text='        YouMailers']"
    );

    By everyoneMenuItemLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/drawer_item_label'] and @text='        Everyone'");

    By conferenceCallMenuItemLocator = By.xpath(mainMenuLocator +
            "/android.widget.FrameLayout[@index='8' and @resource-id='com.youmail.android.vvm:id/drawer_item_layout']"
    );

    By moreMenuItemLocator = By.xpath(mainMenuLocator +
            "/android.widget.FrameLayout[@index='9' and @resource-id='com.youmail.android.vvm:id/drawer_item_layout']"
    );

    By inviteFriendsMenuItemLocator = By.xpath(mainMenuLocator +
            "/android.widget.FrameLayout[@index='10' and @resource-id='com.youmail.android.vvm:id/drawer_item_layout']"
    );


    By upgradeButtonLocator = By.xpath(mainMenuLocator +
            "/android.widget.FrameLayout[@index='11' and @resource-id='com.youmail.android.vvm:id/drawer_item_layout']" +
            "/android.widget.LinearLayout[@index='0' and @resource-id='com.youmail.android.vvm:id/drawer_item_row']" +
            "/android.widget.LinearLayout[@index='2']"
    );

    By helpMenuItemLocator = By.xpath(mainMenuLocator +
            "/android.widget.FrameLayout[@index='13' and @resource-id='com.youmail.android.vvm:id/drawer_item_layout']"
    );

    By settingsMenuItemLocator = By.xpath(mainMenuLocator +
            "/android.widget.FrameLayout[@index='14' and @resource-id='com.youmail.android.vvm:id/drawer_item_layout']"
    );

    public void openFoldersDropdown()
    {
        driver.findElement(folderDropDownLocator).click();
    }

    public void openOverflowMenu()
    {
        driver.findElement(overflowMenuLocator).click();
    }

    public void openMenu()
    {
        driver.findElement(menuBackButtonLocator).click();

        System.out.println("Menu open");
    }

    public void closeMenu()
    {
        Helper.swipeRightToLeft(driver);
    }

    public void openMessages()
    {
        driver.findElement(messagesMenuItemLocator).click();
    }

    public void openHistory()
    {
        driver.findElement(hangupsMenuItemLocator).click();
    }

    public void openGreetings()
    {
        driver.findElement(greetingsMenuItemLocator).click();
    }


    public void openContacts()
    {
        driver.findElement(contactsMenuItemLocator).click();
    }

    public void openYouMailersContacts()
    {
        Helper.waitForPresent(driver, youMailersMenuItemLocator);
        driver.findElement(youMailersMenuItemLocator).click();
    }

    public void openEveryoneContacts()
    {
        Helper.waitForPresent(driver, everyoneMenuItemLocator);
        driver.findElement(everyoneMenuItemLocator);
    }

    public void openHelp()
    {
        driver.findElement(helpMenuItemLocator).click();
    }

    public void openSettings()
    {
        driver.findElement(settingsMenuItemLocator).click();
    }

    public void openMore()
    {
        driver.findElement(moreMenuItemLocator).click();
    }

    public void openInviteFriends()
    {
        driver.findElement(inviteFriendsMenuItemLocator).click();
    }

    public void openConferenceCall()
    {
        driver.findElement(conferenceCallMenuItemLocator).click();
    }


    public void openEmailUs()
    {
        driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.youmail.android.vvm:id/send_us_question_image']")).click();
    }

    public void tapUpgradeButton()
    {
        driver.findElement(upgradeButtonLocator).click();
    }

    public void getUrl()
    {
        Set<String> contextHandlers = driver.getContextHandles();
        while (contextHandlers.size() < 2) {
            contextHandlers = driver.getContextHandles();
            System.out.println(contextHandlers);
        }
        for (String context : contextHandlers) {
            System.out.println("---context---" + context);
            if (context.contains("WEB")) {
                driver.context(context);
                driver.switchTo().window(context);
            }
        }



//        System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getPageSource());
    }
}