package tests;

import appcontrols.MainMenu;
import org.testng.annotations.Test;
import screens.HistoryScreen;
import settings.AndroidSettings;
import settings.Helper;

/**
 * Created by aatayants on 3/2/2017.
 */
public class HistoryTest extends AndroidSettings {
    @Test
    public void getAllCheckBoxes()
    {
        Helper.dismissNotifications(driver);
        MainMenu mainMenu = new MainMenu(driver);
        System.out.println("Main Menu");
        mainMenu.openMenu();
        mainMenu.openHistory();

        HistoryScreen historyScreen = new HistoryScreen(driver);
        historyScreen.getAllCheckBoxes();
    }

    @Test
    public void openEntry()
    {
        Helper.dismissNotifications(driver);
        MainMenu mainMenu = new MainMenu(driver);
        System.out.println("Main Menu");
        mainMenu.openMenu();
        mainMenu.openHistory();

        HistoryScreen historyScreen = new HistoryScreen(driver);
        historyScreen.openEntry();
    }

    @Test
    public void callEntry() throws InterruptedException
    {
        HistoryScreen historyScreen = new HistoryScreen(driver);
        historyScreen.callEntry();
        Thread.sleep(15000);
    }

    @Test
    public void textEntry()
    {
        HistoryScreen historyScreen = new HistoryScreen(driver);
        historyScreen.textEntry();
    }

    @Test
    public void forwardEntry()
    {
        HistoryScreen historyScreen = new HistoryScreen(driver);
        historyScreen.forwardEntry();
    }

    @Test
    public void ditchEntry() throws InterruptedException
    {
        HistoryScreen historyScreen = new HistoryScreen(driver);
        historyScreen.ditchEntry();
    }
}
