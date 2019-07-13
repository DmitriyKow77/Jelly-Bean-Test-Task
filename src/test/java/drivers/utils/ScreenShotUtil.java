package drivers.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by dmitriy on 7/11/19.
 */
public class ScreenShotUtil {
    public static void saveScreenshot(File screenshotFile, String screenshotName) throws IOException {
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac") || osName.contains("linux")){
            FileUtils.copyFile(screenshotFile, new File("..//screenshots/" + screenshotName));
        } else if (osName.contains("win")){
            FileUtils.copyFile(screenshotFile, new File("C:\\Automation\\Screenshots\\" + screenshotName));
        }
    }
}
