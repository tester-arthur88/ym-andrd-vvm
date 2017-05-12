package tests;

import jxl.read.biff.BiffException;
import org.testng.annotations.Test;
import screens.*;
import settings.AndroidSettings;
import settings.Helper;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by aatayants on 12/5/2016.
 */
public class SignInTest extends AndroidSettings {
    @org.testng.annotations.Test
    public void signInPositive() throws InterruptedException, BiffException, IOException
    {
        SignInScreen signInScreen = new SignInScreen(driver);
        HashMap<String, HashMap<String, String>> testData = Helper.getTestData(1);
//        signInScreen.verifyTexts();
//        signInScreen.typePhone(testData.get("1").get("phone_number"));
        signInScreen.typePassword(testData.get("1").get("password"));
        signInScreen.clickSignIn();
        Helper.divideLine();

        WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
//        welcomeScreen.verifyTexts();
        welcomeScreen.clickActivate();
        Helper.divideLine();

        ActivationScreen activationScreen = new ActivationScreen(driver);
//        activationScreen.verifyTexts();
        activationScreen.verifyCarrierMatches();
        activationScreen.clickActivate();
        Helper.divideLine();

        VerifyActivationScreen verifyActivationScreen = new VerifyActivationScreen(driver);
        verifyActivationScreen.closecallForwardingPopup();
//        verifyActivationScreen.verifyTexts();
        verifyActivationScreen.clickVerifySetup();
//        verifyActivationScreen.closeIncomingCallPopup();
        Helper.divideLine();

        ActivationSuccessScreen activationSuccessScreen = new ActivationSuccessScreen(driver);
//        activationSuccessScreen.verifyTexts();
        activationSuccessScreen.clickInboxButton();
        Helper.divideLine();
    }

    @Test
    public void waitForContactUpload()
    {
        ActivationSuccessScreen activationSuccessScreen = new ActivationSuccessScreen(driver);
        activationSuccessScreen.waitForContactUpload();
    }

    @org.testng.annotations.Test
    public void signInNegative() throws InterruptedException, BiffException, IOException
    {
        SignInScreen signInScreen = new SignInScreen(driver);
        HashMap<String, HashMap<String, String>> testData = Helper.getTestData(1);
        signInScreen.verifyTexts();
        signInScreen.typePhone(testData.get("2").get("phone_number"));
        signInScreen.typePassword(testData.get("2").get("password"));
        signInScreen.clickSignIn();
        signInScreen.closeErrorPopup();
    }
}