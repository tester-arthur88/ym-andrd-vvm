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
        SignInScreen signInScreen = new SignInScreen(driver);
        SignUpScreen signUpScreen = new SignUpScreen(driver);

        HashMap<String, HashMap<String, String>> testData = Helper.getTestData(0);

        // Switching PROD > QA > PROD to avoid sending confirmation number
//        signInScreen.switchToEnvironment("2");
//        signUpScreen.switchToEnvironment("0");

//        signInScreen.clickNoAccount();

        signUpScreen.verifyTexts();

        String phoneNum = testData.get("1").get("phone_areacode") + testData.get("1").get("phone_nxx") + Helper.getLastFour(Integer.parseInt(testData.get("1").get("phone_last4")));
//        signUpScreen.typePhone(phoneNum);

        String email = testData.get("1").get("email_local") + phoneNum + testData.get("1").get("email_domain");
        signUpScreen.typeEmail(email);

        signUpScreen.clickNext();

        signUpScreen.typeFName(testData.get("1").get("first_name"));
        signUpScreen.typeLName(testData.get("1").get("last_name"));
        signUpScreen.typeEmail2(email);
        signUpScreen.typePassword(testData.get("1").get("password"));
        signUpScreen.checkAgree();
        signUpScreen.clickSignUp();

        Thread.sleep(2000);

        signUpScreen.clickNextComplete();

        ActivationScreen activationScreen = new ActivationScreen(driver);
        activationScreen.selectCarrier();
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

        Thread.sleep(7000);
    }
}
