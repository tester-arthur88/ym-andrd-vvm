package tests;

import jxl.read.biff.BiffException;
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
        String phoneModel = Helper.getPhoneModel();
        HashMap<String, String> testData = Helper.getTestData(1, phoneModel);

        System.out.println("Phone Model: " + phoneModel + ", Android Version: " + Helper.getAndrdVersion());

        InitialScreen initialScreen = new InitialScreen(driver);
        initialScreen.tapSignIn();

        SignInScreen signInScreen = new SignInScreen(driver);
        signInScreen.allowPermissions();
        signInScreen.typePhone(testData.get("phone_number"));
        signInScreen.typePassword(testData.get("password"));
        signInScreen.clickSignIn();
        Helper.divideLine();
    }

    @org.testng.annotations.Test
    public void signInNegative() throws InterruptedException, BiffException, IOException
    {
        SignInScreen signInScreen = new SignInScreen(driver);
        HashMap<String, HashMap<String, String>> testData = Helper.getTestDataOld(1);
//        signInScreen.typePhone(testData.get("2").get("phone_number"));
        signInScreen.typePassword(testData.get("2").get("password"));
        signInScreen.clickSignIn();
    }
}