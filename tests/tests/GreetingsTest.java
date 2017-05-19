package tests;

import appcontrols.MainMenu;
import org.testng.annotations.Test;
import screens.GreetingsScreen;
import settings.AndroidSettings;
import settings.Helper;

/**
 * Created by aatayants on 4/18/2017.
 */
public class GreetingsTest extends AndroidSettings {
    @Test
    public void openGreetings()
    {
        Helper.dismissNotifications(driver);
        MainMenu mainMenu = new MainMenu(driver);
        System.out.println("Main Menu");
        mainMenu.openMenu();
        mainMenu.openGreetings();
    }

    @Test
    public void openSmartGreeting()
    {
        GreetingsScreen greetingsScreen = new GreetingsScreen(driver);
        greetingsScreen.openSmartGreeting();
    }

    @Test
    public void openTestGreeting()
    {
        GreetingsScreen greetingsScreen = new GreetingsScreen(driver);
        greetingsScreen.openTestGreeting();
    }

    @Test
    public void playGreeting() throws InterruptedException
    {
        GreetingsScreen greetingsScreen = new GreetingsScreen(driver);
        greetingsScreen.playGreeting();
        Thread.sleep(3000);
    }

    @Test
    public void deleteGreeting()
    {
        GreetingsScreen greetingsScreen = new GreetingsScreen(driver);
        greetingsScreen.deleteGreeting();
    }

    @Test
    public void recordGreeting() throws InterruptedException
    {
        MainMenu mainMenu = new MainMenu(driver);
        mainMenu.openOverflowMenu();

        GreetingsScreen greetingsScreen = new GreetingsScreen(driver);
        greetingsScreen.recordNewGreeting();
    }


    @Test
    public void addContactToGreeting()
    {
        GreetingsScreen greetingsScreen = new GreetingsScreen(driver);
        greetingsScreen.openTestGreeting();
        greetingsScreen.addContactToGreeting();
    }

    @Test
    public void setAsMainGreeting()
    {
        GreetingsScreen greetingsScreen = new GreetingsScreen(driver);
//        greetingsScreen.openTestGreeting();
        greetingsScreen.setAsMainGreeting();
    }
}
