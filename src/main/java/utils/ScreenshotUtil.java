package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String capture(
            WebDriver driver,
            String testName) {

        try {

            String timestamp =
                    new SimpleDateFormat(
                            "yyyyMMdd_HHmmss")
                            .format(new Date());

            String screenshotDirectory =
                    "reports/screenshots/";

            new File(
                    screenshotDirectory)
                    .mkdirs();

            String screenshotPath =
                    screenshotDirectory
                            + testName
                            + "_"
                            + timestamp
                            + ".png";

            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(
                                    OutputType.FILE);

            File destination =
                    new File(
                            screenshotPath);

            FileUtils.copyFile(
                    source,
                    destination);

            return screenshotPath;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    public static String captureBase64(
            WebDriver driver) {

        return ((TakesScreenshot) driver)
                .getScreenshotAs(
                        OutputType.BASE64);
    }
}

