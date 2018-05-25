package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

/**
 * Created by aatayants on 12/6/2016.
 */
public class PhoneVerificationScreen
{

    private AndroidDriver driver;

    public PhoneVerificationScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // Element locators
    By appBarTitleLocator = By.xpath("//android.view.ViewGroup[@index='0' and @resource-id='com.youmail.android.vvm:id/appbar']" +
            "/android.widget.TextView[@index='1']"
    );

    By appBarSubTitleLocator = By.xpath("//android.view.ViewGroup[@index='0' and @resource-id='com.youmail.android.vvm:id/appbar']" +
            "/android.widget.TextView[@index='2']"
    );


}