package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import settings.Helper;

/**
 * Created by aatayants on 3/6/2017.
 */
public class UpgradeScreen {
    private AndroidDriver driver;

    public UpgradeScreen(AndroidDriver driver)
    {
        this.driver = driver;
    }

    // LP Upgrade button
//    By lpUpgradeButtonLocator = By.xpath("android.webkit.WebView[@index='0']" +
//            "/android.view.View[@index='0' and @resource-id='lp-pom-root']" +
//            "/android.view.View[@index='0']" +
//            "/android.view.View[@index='5' and @resource-id='lp-pom-button-16']"
//    );

    By lpUpgradeButtonLocator = By.xpath("//android.view.View[@resource-id='lp-pom-button-19']");

//    By upgradeContinueButton = By.xpath("android.view.View[@index='6' and @resource-id='planPrice'" +
//            "/android.widget.Button[@index='3' and @resource-id='Continue']"
//    );

    By upgradeContinueButton = By.xpath("//android.view.View[@index='6' and @resource-id='planPrice'" +
            "/android.widget.Button[@index='3' and @resource-id='Continue']"
    );

    String cardInformationContainer = "//android.view.View[@index='4' and @resource-id='creditcard']";

    By cardNumberLocator = By.xpath(cardInformationContainer +
            "/android.widget.EditText[@index='2' and @resource-id='cardNumber']"
    );

    By expirationYearLocator = By.xpath(cardInformationContainer +
            "/android.widget.Spinner[@index='4' and @resource-id='cardExpirationYearSelect']"
    );

    By expirationYearOptionLocator = By.xpath("android.widget.CheckedTextView[@index='5' and @resource-id='android:id/text1']");

    By cvcLocator = By.xpath(cardInformationContainer +
            "/android.widget.EditText[@index='7' and @resource-id='ncc.cvv2']"
    );

    By purchaseButtonLocator = By.xpath("android.view.View[@index='8' and @resource-id='planPrice']" +
            "/android.widget.Button[@index='3' and @resource-id='Purchase']"
    );

    public void tapLpUpgrade()
    {
        Helper.waitForPresent(driver, lpUpgradeButtonLocator);
        driver.findElement(lpUpgradeButtonLocator).click();
    }

    public void tapUpgradeContinue()
    {
        Helper.waitForPresent(driver, upgradeContinueButton);
        driver.findElement(upgradeContinueButton).click();
    }

    public void inputCardNumber()
    {
        Helper.waitForPresent(driver, cardNumberLocator);
        driver.findElement(cardNumberLocator).sendKeys("4758273523592365");
        Helper.keyboardHide(driver);
    }

    public void selectExpirationYear()
    {
        driver.findElement(expirationYearLocator).click();
        driver.findElement(expirationYearOptionLocator).click();
    }

    public void inputCVC()
    {
        driver.findElement(cvcLocator).sendKeys("345");
        Helper.keyboardHide(driver);
    }

    public void tapPurchase()
    {
        driver.findElement(purchaseButtonLocator).click();
    }
}
