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
 * Created by aatayants on 12/20/2016.
 */
public class MainMenuTest extends AndroidSettings {
    @org.testng.annotations.Test
    public void mainMenuTest() throws InterruptedException, BiffException, IOException
    {
        SignInScreen signInScreen = new SignInScreen(driver);
        HashMap<String, HashMap<String, String>> testData = Helper.getTestData(1);
        signInScreen.verifyTexts();
        signInScreen.typePhone(testData.get("1").get("phone_number"));
        signInScreen.typePassword(testData.get("1").get("password"));
        signInScreen.clickSignIn();
        Helper.divideLine();

        WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
        welcomeScreen.verifyTexts();
        welcomeScreen.clickActivate();
        Helper.divideLine();

        ActivationScreen activationScreen = new ActivationScreen(driver);
        activationScreen.verifyTexts();
        activationScreen.verifyCarrierMatches();
        activationScreen.clickActivate();
        Helper.divideLine();

        VerifyActivationScreen verifyActivationScreen = new VerifyActivationScreen(driver);
        verifyActivationScreen.closecallForwardingPopup();
        verifyActivationScreen.verifyTexts();
        verifyActivationScreen.clickVerifySetup();
        verifyActivationScreen.closeIncomingCallPopup();
        Helper.divideLine();

        ActivationSuccessScreen activationSuccessScreen = new ActivationSuccessScreen(driver);
        activationSuccessScreen.verifyTexts();
        activationSuccessScreen.clickInboxButton();
        Helper.divideLine();

//        MainMenu mainMenu = new MainMenu(driver);
//        System.out.println("Main Menu");
//
//        mainMenu.openMenu();
//        Thread.sleep(2000);
//        mainMenu.closeMenu();
    }
}