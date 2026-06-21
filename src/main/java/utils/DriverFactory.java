package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

// Driver Factory is responsible for driver management
public class DriverFactory {
private static WebDriver driver;
    public static WebDriver getDriver() {

            if (driver == null) {

                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();

                // Disable Chrome Password Manager
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);

                options.setExperimentalOption("prefs", prefs);

                // Disable password breach warning popup
                options.addArguments("--disable-features=PasswordLeakDetection");

                // Disable browser notifications
                options.addArguments("--disable-notifications");

                // Run browser in Incognito mode
                options.addArguments("--incognito");

                driver = new ChromeDriver(options);

                driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}