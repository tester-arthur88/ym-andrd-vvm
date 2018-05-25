package tests;

import appcontrols.MainMenu;
import org.testng.annotations.Test;
import screens.UpgradeScreen;
import settings.AndroidSettings;
import settings.Helper;

/**
 * Created by aatayants on 3/6/2017.
 */
public class UpgradeTest extends AndroidSettings
{
    @Test
    public void tapMenuUpgrade()
    {
        Helper.dismissNotifications(driver);
        MainMenu mainMenu = new MainMenu(driver);
//        mainMenu.openMenu();
//        mainMenu.tapUpgradeButton();
    }

    @Test
    public void completeAccountUpgrade()
    {
        UpgradeScreen upgradeScreen = new UpgradeScreen(driver);
        upgradeScreen.tapLpUpgrade();
        upgradeScreen.tapUpgradeContinue();
        upgradeScreen.inputCardNumber();
        upgradeScreen.selectExpirationYear();
        upgradeScreen.inputCVC();
        upgradeScreen.tapPurchase();
    }
}