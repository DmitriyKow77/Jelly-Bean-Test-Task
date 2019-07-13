package drivers.utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmitriy on 2/11/19.
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverUtil {
    private static long DEFAULT_WAIT = 20;
    private static WebDriver driver;

    public static WebDriver get_driver() {
        if (driver != null) {
            return driver;
        }

        // Get chromedriver
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the Chrome driver
        ChromeOptions opt = new ChromeOptions();
        driver = new ChromeDriver(opt);

        //set configs
        driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT,
                TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static void close_driver() {
        if (driver != null) {
            try {
                driver.close();
                driver.quit();
            } catch (NoSuchMethodError | NoSuchSessionException | SessionNotCreatedException nsme) {
                // in case quit fails or close fails
            }
            driver = null;
        }
    }
}
