package tests;

import org.testng.annotations.Test;
import screens.ActivationScreen;
import settings.AndroidSettings;

public class ActivationTest extends AndroidSettings
{
    @Test
    public void activate() throws InterruptedException
    {
        ActivationScreen activationScreen = new ActivationScreen(driver);

        activationScreen.clickActivate();
        activationScreen.performTestCallAfterSignUp();

        Thread.sleep(7000);
    }
}
