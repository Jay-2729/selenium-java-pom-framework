package listeners;

import com.aventstack.extentreports.ExtentTest;
import org.testng.*;
import utils.*;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

    @Override
    public void onStart(
            ITestContext context) {

        ExtentManager.getExtent();
    }

    @Override
    public void onTestStart(ITestResult result) {

        String className =
                result.getTestClass()
                        .getRealClass()
                        .getSimpleName();

        ExtentTest test =
                ExtentManager
                        .getExtent()
                        .createTest(
                                result.getMethod()
                                        .getMethodName())
                        .assignCategory(className)
                        .assignAuthor("Jabulile Masilela")
                        .assignDevice(
                                ConfigReader.getProperty("browser"));

        ExtentTestManager.setTest(test);
    }


    @Override
    public void onTestSuccess(
            ITestResult result) {

        ExtentTestManager
                .getTest()
                .log(
                        Status.PASS,
                        "Test Passed");
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        ExtentTestManager
                .getTest()
                .fail("Test Failed");

        ExtentTestManager
                .getTest()
                .fail(result.getThrowable());

        String base64Screenshot =
                ScreenshotUtil.captureBase64(
                        DriverFactory.getDriver());

        ExtentTestManager
                .getTest()
                .fail("Failure Screenshot")
                .addScreenCaptureFromBase64String(
                        base64Screenshot);
    }


    @Override
    public void onFinish(
            ITestContext context) {

        ExtentManager
                .getExtent()
                .flush();
    }

}