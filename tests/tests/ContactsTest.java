package tests;

import appcontrols.MainMenu;
import org.testng.annotations.Test;
import screens.ContactsScreen;
import settings.AndroidSettings;
import settings.Helper;

/**
 * Created by aatayants on 4/25/2017.
 */
public class ContactsTest extends AndroidSettings
{
    @Test
    public void openContacts()
    {
        Helper.dismissNotifications(driver);
        MainMenu mainMenu = new MainMenu(driver);
        System.out.println("Main Menu");
//        mainMenu.openMenu();
//        mainMenu.openContacts();
//        mainMenu.openYouMailersContacts();
    }

    @Test
    public void openTargetContact()
    {
        ContactsScreen contactsScreen = new ContactsScreen(driver);
        contactsScreen.openTargetContact();
    }

    @Test
    public void callContact() throws InterruptedException
    {
        ContactsScreen contactsScreen = new ContactsScreen(driver);
        contactsScreen.callContact();
    }

    @Test
    public void textContact()
    {
        ContactsScreen contactsScreen = new ContactsScreen(driver);
        contactsScreen.textContact();
    }

    @Test
    public void dropVmToContact() throws InterruptedException
    {
        ContactsScreen contactsScreen = new ContactsScreen(driver);
        contactsScreen.dropVmToContact();
    }

    @Test
    public void ditchContact()
    {
        ContactsScreen contactsScreen = new ContactsScreen(driver);
        contactsScreen.ditchContact();
    }

    @Test
    public void createContact()
    {
        ContactsScreen contactsScreen = new ContactsScreen(driver);
        contactsScreen.createContact();
    }
}