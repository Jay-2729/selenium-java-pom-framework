package base;

import java.time.Duration;

import exceptions.FrameworkException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.Log;
import utils.ReportManager;

// The purpose of BasePage is to centralize common page actions so that every page object can reuse them instead of duplicating code
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    protected void click(By locator) {

        try {

            Log.info(
                    "Clicking : " + locator);

            wait.until(ExpectedConditions
                            .elementToBeClickable(locator))
                    .click();

            ReportManager.pass(
                    "Clicked element : "
                            + locator);

        } catch(Exception e) {

            ReportManager.fail(
                    "Failed to click : "
                            + locator);

            throw e;
        }
    }

    protected void type(By locator,
                        String value) {

        try {

            WebElement element =
                    wait.until(ExpectedConditions
                            .visibilityOfElementLocated(locator));

            element.clear();

            element.sendKeys(value);

            ReportManager.pass(
                    "Typed text into : "
                            + locator);

        } catch(Exception e) {

            ReportManager.fail(
                    "Unable to type into : "
                            + locator);

            throw e;
        }
    }

    protected String getText(By locator) {

        try {

            String text =
                    wait.until(ExpectedConditions
                                    .visibilityOfElementLocated(locator))
                            .getText();

            ReportManager.info(
                    "Retrieved text from : "
                            + locator);

            return text;

        } catch(Exception e) {

            ReportManager.fail(
                    "Unable to get text from : "
                            + locator);

            throw e;
        }
    }

    protected boolean isDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}