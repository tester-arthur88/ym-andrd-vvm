package tests;

import jxl.read.biff.BiffException;
import screens.*;
import settings.AndroidSettings;
import settings.Helper;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by aatayants on 12/6/2016.
 */
public class SignUpTest extends AndroidSettings
{
    @org.testng.annotations.Test
    public void signUp() throws InterruptedException, BiffException, IOException
    {
        String phoneModel = Helper.getPhoneModel();
        HashMap<String, String> testData = Helper.getTestData(0, phoneModel);

        System.out.println("Phone Model: " + phoneModel + ", Android Version: " + Helper.getAndrdVersion());

        InitialScreen initialScreen = new InitialScreen(driver);
        initialScreen.tapJoinNow();

        SignUpScreen signUpScreen = new SignUpScreen(driver);

//        HashMap<String, HashMap<String, String>> testData = Helper.getTestDataOld(0);

        String phoneNum = testData.get("phone_number");
        String email = testData.get("email");

        signUpScreen.allowPermissions();

        signUpScreen.typePhone(phoneNum);
        Helper.keyboardHide(driver);
        signUpScreen.typeEmail(email);
        Helper.keyboardHide(driver);

        signUpScreen.clickNext();

        signUpScreen.typeFName(testData.get("first_name"));
        Helper.keyboardHide(driver);
        signUpScreen.typeLName(testData.get("last_name"));
        Helper.keyboardHide(driver);
        signUpScreen.typePassword(testData.get("password"));
        Helper.keyboardHide(driver);
        signUpScreen.checkAgree();
        signUpScreen.clickCreateAccount();

        ActivationScreen activationScreen = new ActivationScreen(driver);

        activationScreen.clickActivate();
        activationScreen.performTestCallAfterSignUp();

        Thread.sleep(7000);
    }
}