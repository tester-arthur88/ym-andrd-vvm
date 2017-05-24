package tests;

import appcontrols.MainMenu;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;
import screens.*;
import settings.AndroidSettings;
import settings.Helper;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by aatayants on 1/9/2017.
 */
public class MessagesTest extends AndroidSettings {

    @Test
    public void openInbox() throws InterruptedException
    {
        MainMenu mainMenu = new MainMenu(driver);
        MessagesScreen messagesScreen = new MessagesScreen(driver);

        mainMenu.openFoldersDropdown();
        messagesScreen.openInboxFolder();
    }

    @Test
    public void openSave() throws InterruptedException
    {
        MainMenu mainMenu = new MainMenu(driver);
        MessagesScreen messagesScreen = new MessagesScreen(driver);

        mainMenu.openFoldersDropdown();
        messagesScreen.openSaveFolder();
    }

    @Test
    public void openSpam() throws InterruptedException
    {
        MainMenu mainMenu = new MainMenu(driver);
        MessagesScreen messagesScreen = new MessagesScreen(driver);

        mainMenu.openFoldersDropdown();
        messagesScreen.openSpamFolder();
    }

    @Test
    public void openTrash() throws InterruptedException
    {
        MainMenu mainMenu = new MainMenu(driver);
        MessagesScreen messagesScreen = new MessagesScreen(driver);

        mainMenu.openFoldersDropdown();
        messagesScreen.openTrashFolder();
    }

    @Test
    public void loadMoreMessages()
    {
        MessagesScreen messagesScreen = new MessagesScreen(driver);
        messagesScreen.loadMoreMessages();
    }

    @Test
    public void openMessage()
    {
        Helper.dismissNotifications(driver);
        MainMenu mainMenu = new MainMenu(driver);
        System.out.println("Main Menu");
        mainMenu.openMenu();
        mainMenu.openMessages();

        MessagesScreen messagesScreen = new MessagesScreen(driver);
        messagesScreen.openMessage();
    }

    @Test
    public void playMessage() throws InterruptedException, BiffException, IOException
    {
        MessagesScreen messagesScreen = new MessagesScreen(driver);
        messagesScreen.closeAutoplayPopup();
        messagesScreen.playMessage();
        Thread.sleep(3000);
    }

    @Test
    public void callSender() throws InterruptedException
    {
        MessagesScreen messagesScreen = new MessagesScreen(driver);
        messagesScreen.callSender();
        Thread.sleep(15000);
    }

    @Test
    public void textSender()
    {
        MessagesScreen messagesScreen = new MessagesScreen(driver);
        messagesScreen.textSender();
    }

    @Test
    public void forwardMessage()
    {
        MessagesScreen messagesScreen = new MessagesScreen(driver);
        messagesScreen.forwardMessage();
    }

    @Test
    public void ditchSender() throws InterruptedException
    {
        MessagesScreen messagesScreen = new MessagesScreen(driver);
        messagesScreen.ditchSender();
    }


    public void messagesTest() throws InterruptedException, BiffException, IOException
    {
//        SignInScreen signInScreen = new SignInScreen(driver);
//        HashMap<String, HashMap<String, String>> testData = Helper.getTestData(1);
//        signInScreen.verifyTexts();
////        signInScreen.typePhone(testData.get("1").get("phone_number"));
//        signInScreen.typePassword(testData.get("1").get("password"));
//        signInScreen.clickSignIn();
//        Helper.divideLine();
//
//        WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
//        welcomeScreen.verifyTexts();
//        welcomeScreen.clickActivate();
//        Helper.divideLine();
//
//        ActivationScreen activationScreen = new ActivationScreen(driver);
//        activationScreen.verifyTexts();
//        activationScreen.verifyCarrierMatches();
//        activationScreen.clickActivate();
//        Helper.divideLine();
//
//        VerifyActivationScreen verifyActivationScreen = new VerifyActivationScreen(driver);
//        verifyActivationScreen.closecallForwardingPopup();
//        verifyActivationScreen.verifyTexts();
//        verifyActivationScreen.clickVerifySetup();
//        verifyActivationScreen.closeIncomingCallPopup();
//        Helper.divideLine();
//
//        ActivationSuccessScreen activationSuccessScreen = new ActivationSuccessScreen(driver);
//        activationSuccessScreen.verifyTexts();
//        activationSuccessScreen.clickInboxButton();
//        Helper.divideLine();

        MainMenu mainMenu = new MainMenu(driver);
        System.out.println("Main Menu");

        mainMenu.openMenu();
        Thread.sleep(2000);
        mainMenu.closeMenu();

        Helper.dismissNotifications(driver);

        MessagesScreen messagesScreen = new MessagesScreen(driver);
        messagesScreen.openMessage();
        messagesScreen.closeAutoplayPopup();
        messagesScreen.playMessage();
        Thread.sleep(7000);
        messagesScreen.callSender();

        messagesScreen.openMessage();
        messagesScreen.textSender();
        messagesScreen.openMessage();
        messagesScreen.forwardMessage();
        messagesScreen.openMessage();
        messagesScreen.ditchSender();

        mainMenu.openMenu();
        messagesScreen.closeRateUsPopup();

        Thread.sleep(25000);
    }
}