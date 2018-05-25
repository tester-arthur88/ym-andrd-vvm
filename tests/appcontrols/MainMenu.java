package appcontrols;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import settings.AndroidSettings;
import settings.Helper;

import java.util.Set;

/**
 * Created by aatayants on 12/6/2016.
 */
public class MainMenu extends AndroidSettings
{
    private AndroidDriver driver;

    public MainMenu(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators

    By drawerMenuButtonLocator = By.xpath("//android.widget.ImageButton[@content-desc='DrawOpen']");

    By folderDropDownLocator = By.xpath("//android.widget.Spinner[@resource-id='com.youmail.android.vvm:id/folder_spinner']");

    By searchButtonLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/action_search']");

    By overflowMenuLocator = By.xpath("//android.widget.ImageView[@content-desc='More options']");

    By mainMenuBackButtonLocator = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");

    public void openMenu()
    {
        Helper.waitForPresent(driver, drawerMenuButtonLocator);
        driver.findElement(drawerMenuButtonLocator).click();
    }

    public void closeMenu()
    {
//        Helper.swipeRightToLeft(driver);
    }

    public void openFolderDropDown()
    {
        Helper.waitForPresent(driver, folderDropDownLocator);
        driver.findElement(folderDropDownLocator).click();
    }
}