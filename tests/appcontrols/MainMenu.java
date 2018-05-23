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

    By mainMenuButtonLocator = By.xpath("//android.widget.ImageButton[@content-desc='DrawOpen']");

    By folderDropDownLocator = By.xpath("//android.widget.Spinner[@resource-id='com.youmail.android.vvm:id/folder_spinner']");

    By searchButtonLocator = By.xpath("//android.widget.TextView[@resource-id='com.youmail.android.vvm:id/action_search']");

    By overflowMenuLocator = By.xpath("//android.widget.ImageView[@content-desc='More options']");

    By mainMenuBackButtonLocator = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");

    public void closeMenu()
    {
//        Helper.swipeRightToLeft(driver);
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