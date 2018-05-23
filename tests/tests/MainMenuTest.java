package tests;

import jxl.read.biff.BiffException;
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
        HashMap<String, HashMap<String, String>> testData = Helper.getTestDataOld(1);
//        signInScreen.verifyTexts();
//        signInScreen.typePhone(testData.get("1").get("phone_number"));
        signInScreen.typePassword(testData.get("1").get("password"));
        signInScreen.clickSignIn();
        Helper.divideLine();


    }
}