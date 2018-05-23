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
public class SignUpTest extends AndroidSettings {
    @org.testng.annotations.Test
    public void signUp() throws InterruptedException, BiffException, IOException
    {
        InitialScreen initialScreen = new InitialScreen(driver);
        initialScreen.tapJoinNow();

        SignUpScreen signUpScreen = new SignUpScreen(driver);

        HashMap<String, HashMap<String, String>> testData = Helper.getTestDataOld(0);

        String phoneNum = testData.get("1").get("phone_areacode") + testData.get("1").get("phone_nxx") + Helper.getLastFour(Integer.parseInt(testData.get("1").get("phone_last4")));
        String email = testData.get("1").get("email_local") + phoneNum + testData.get("1").get("email_domain");

        signUpScreen.allowPermissions();

        signUpScreen.typePhone(phoneNum);
        Helper.keyboardHide(driver);
        signUpScreen.typeEmail(email);
        Helper.keyboardHide(driver);

        signUpScreen.clickNext();

        signUpScreen.typeFName(testData.get("1").get("first_name"));
        Helper.keyboardHide(driver);
        signUpScreen.typeLName(testData.get("1").get("last_name"));
        Helper.keyboardHide(driver);
        signUpScreen.typePassword(testData.get("1").get("password"));
        Helper.keyboardHide(driver);
        signUpScreen.checkAgree();
        signUpScreen.clickCreateAccount();

        Thread.sleep(7000);
    }
}
