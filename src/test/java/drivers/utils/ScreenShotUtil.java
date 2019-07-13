package drivers.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;

/**
 * Created by dmitriy on 7/11/19.
 */
public class ScreenShotUtil {
    public static void saveScreenshot(File screenshotFile, String screenshotName) throws IOException {
        String osName = System.getProperty("os.name").toLowerCase();
        String sceenshotPath = "";

        if (osName.contains("mac") || osName.contains("linux")){
            sceenshotPath = "..//screenshots/" + screenshotName;
        } else if (osName.contains("win")){
            sceenshotPath = "C:\\Automation\\Screenshots\\" + screenshotName;
        } else {
            throw new WebDriverException("Test supports only mac, linux, windows");
        }

        System.out.println("Saved screenshot to: " + sceenshotPath);
        FileUtils.copyFile(screenshotFile, new File(sceenshotPath));
    }
}
