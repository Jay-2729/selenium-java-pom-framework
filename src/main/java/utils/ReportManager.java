package utils;

import com.aventstack.extentreports.Status;

public class ReportManager {

    public static void info(String message) {

        ExtentTestManager
                .getTest()
                .log(Status.INFO, message);
    }

    public static void pass(String message) {

        ExtentTestManager
                .getTest()
                .log(Status.PASS, message);
    }

    public static void fail(String message) {

        ExtentTestManager
                .getTest()
                .log(Status.FAIL, message);
    }

    public static void warning(String message) {

        ExtentTestManager
                .getTest()
                .log(Status.WARNING, message);
    }
}
