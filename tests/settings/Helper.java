package settings;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * Created by aatayants on 11/29/2016.
 */
public class Helper {
    public static void divideLine()
    {
        System.out.println("=============================================");
    }

    public static void waitForPresent(AndroidDriver driver, By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForPresentLong(AndroidDriver driver, By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitForPresentSuperLong(AndroidDriver driver, By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void swipeDownElementLight(AndroidDriver driver, AndroidElement element, int duration)
    {
        int topY = element.getLocation().getY();
        int bottomY = (topY + element.getSize().getHeight()) / 3;
        int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        driver.swipe(centerX, bottomY, centerX, topY, duration);
    }

    public static void swipeDownElement(AndroidDriver driver, AndroidElement element, int duration)
    {
        int topY = element.getLocation().getY();
        int bottomY = topY + element.getSize().getHeight() - 2;
        int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        driver.swipe(centerX, bottomY, centerX, topY, duration);
    }

    public static void swipeUpElement(AndroidDriver driver, AndroidElement element, int duration)
    {
        int topY = element.getLocation().getY();
        int bottomY = topY + element.getSize().getHeight() - 2;
        int centerX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
        driver.swipe(centerX, topY, centerX, bottomY, duration);
    }

    public static void swipeRightToLeft(AndroidDriver driver)
    {
        Dimension screenSize = driver.manage().window().getSize();
        int startX = (int) (screenSize.width * 0.7);
        int endX = (int) (screenSize.width * 0.3);
        int y = screenSize.height / 2;

        driver.swipe(startX, y, endX, y, 300);
    }

    public static void dismissNotifications(AndroidDriver driver)
    {
        try
        {
            System.out.println("Opening Notifications");
            driver.openNotifications();
            System.out.println("Notifications open");
            waitForPresent(driver, By.id("com.android.systemui:id/clear_button"));
            driver.findElement(By.id("com.android.systemui:id/clear_button")).click();
        }
        catch (Exception e)
        {
            adbPressBack();
            System.out.println("returned to app");
        }
    }

    public static String adbExecute(String cmd)
    {
        String output = null;
        try
        {
            Process result = Runtime.getRuntime().exec(cmd);
            InputStream inputStream = result.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            output = bufferedReader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return output;
    }

    public static void adbEndCall()
    {
        String cmd = "adb shell input keyevent KEYCODE_ENDCALL";
        adbExecute(cmd);
    }

    public static void adbPressBack()
    {
        String cmd = "adb shell input keyevent KEYCODE_BACK";
        adbExecute(cmd);
    }

    public static void adbRestartApp()
    {
        String cmd1 = "adb shell pm clear com.youmail.android.vvm";
        String cmd2 = "adb shell am start -n com.youmail.android.vvm/com.youmail.android.vvm.activity.Splash";

        String exec1 = adbExecute(cmd1);
        String exec2 = adbExecute(cmd2);
    }

    public static String getCarrierName()
    {
        String cmd = "adb shell getprop gsm.sim.operator.alpha";
        String carrierName = adbExecute(cmd);

        return carrierName;
    }

    public static String getCurrentActivity()
    {
        String cmd = "adb shell dumpsys activity activities | grep mFocusedActivity | cut -d . -f 5 | cut -d ' ' -f 1";
        String activity = adbExecute(cmd);

        return activity;
    }

    public static void keyboardHide(AndroidDriver driver)
    {
        String cmd = "adb shell dumpsys input_method | grep mInputShown";
        String inputStatus = adbExecute(cmd);

        if (inputStatus.contains("mInputShown=true"))
        {
            driver.hideKeyboard();
            System.out.println("Keyboard hidden");
        }
        else
        {
            System.out.println("Keyboard was hidden");
        }

//        try
//        {
//            Process result = Runtime.getRuntime().exec(cmd);
//            InputStream inStream = result.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(inStream));
//            String output = br.readLine();
//
//            if (output.contains("mInputShown=true"))
//            {
//                driver.hideKeyboard();
//                System.out.println("Keyboard hidden");
//            }
//            else
//            {
//                System.out.println("Keyboard was hidden");
//            }
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
    }

    public static List<AndroidElement> getElementsByLocator(AndroidDriver driver, By elementLocator)
    {
        List<AndroidElement> elements = driver.findElements(elementLocator);

        return elements;
    }

    public static Sheet readFile(int sheetNum, String fileName) throws BiffException, IOException
    {

        Sheet sheet;
        FileInputStream xls = new FileInputStream(fileName);
        Workbook workbook = Workbook.getWorkbook(xls);

        sheet = workbook.getSheet(sheetNum);

//        for (int row = 1; row < sheet.getRows() - 1; row++)
//        {
//            System.out.println(row);
//            for (int cols = 0; cols <= sheet.getColumns() - 1; cols++)
//            {
//                String index = sheet.getCell(cols, 0).getContents();
//                String run = sheet.getCell(cols, row).getContents();
//                System.out.println(index + ":" + run);
//            }
//        }

        return sheet;
    }

    public static HashMap<String, HashMap<String, String>> getTestData(int sheetNum) throws BiffException, IOException
    {
//        Sheet sheet;
//        FileInputStream xls = new FileInputStream("TestData.xls");
//        Workbook workbook = Workbook.getWorkbook(xls);
//
//        sheet = workbook.getSheet(sheetNum);

        Sheet sheet = readFile(sheetNum, "TestData.xls");
        HashMap<String, HashMap<String, String>> testData = new HashMap<>();

        for (int row = 1; row < sheet.getRows(); row++)
        {
            String flag = sheet.getCell(0, row).getContents();

            if (flag.equalsIgnoreCase("Y"))
            {
                //System.out.println("Run: " + row);
                String indexPrimary = String.valueOf(row);
                testData.put(indexPrimary, new HashMap<>());
                for (int cols = 0; cols <= sheet.getColumns() - 1; cols++)
                {
                    String index = sheet.getCell(cols, 0).getContents();
                    String run = sheet.getCell(cols, row).getContents();
                    testData.get(indexPrimary).put(index, run);
                    //System.out.println(index + ":" + run);
                }
            }
            else
            {
                // Don't add this data set
            }
        }

        return testData;
    }

    public static HashMap<String, String> getElementTexts(int sheetNum) throws BiffException, IOException
    {
        Sheet sheet = readFile(sheetNum, "Texts.xls");
        HashMap<String, String> elementTexts = new HashMap<>();

//        for (int row = 0; row <= sheet.getRows() - 1; row++)
        for (int row = 0; row < sheet.getRows(); row++)
        {
            String index = sheet.getCell(0, row).getContents();
//            System.out.println("Index:" + index);

            String value = sheet.getCell(1, row).getContents();
//            System.out.println("Value:" + value);

            elementTexts.put(index, value);
        }

        return elementTexts;
    }

    public static String getLastFour(int num)
    {
        if (num >= 0 && num <= 9999)
        {
            String lastFour = "";
            int denominator = 1000;

            while (denominator != 0)
            {
                if (num / denominator <= 9)
                {
                    lastFour += String.valueOf(num / denominator);
                }

                num %= denominator;
                denominator /= 10;
            }

            return lastFour;
        }
        else
        {
            System.out.println("Invalid lastFour value, exceeds limits");

            return null;
        }
    }

//    int random = (int)(Math.random() * 9999);
}