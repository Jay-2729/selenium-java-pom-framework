package base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import utils.ConfigReader;
import utils.DriverFactory;
import utils.Log;

    public class BaseTest {

        protected WebDriver driver;

        @BeforeMethod

        public void setup() {

            Log.info(
                    "Launching Browser");

            driver =
                    DriverFactory.getDriver();

            System.out.println(
                    "Driver = " + driver);

            driver.get(
                    ConfigReader.getProperty(
                            "url"));

            Log.info(
                    "Opening URL : "
                            + ConfigReader.getProperty(
                            "url"));
        }

        @AfterMethod

        public void tearDown() {

            Log.info(
                    "Closing Browser");

            DriverFactory.quitDriver();
        }
    }
