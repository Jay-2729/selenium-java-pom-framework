package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {

        if (extent == null) {

            String timestamp =
                    new SimpleDateFormat(
                            "yyyyMMdd_HHmmss")
                            .format(new Date());

            String reportPath =
                    "reports/ExtentReport_"
                            + timestamp
                            + ".html";

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            reportPath);

            spark.config()
                    .setReportName(
                            "Selenium Java POM Framework");

            spark.config()
                    .setDocumentTitle(
                            "Automation Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            // System Information
            extent.setSystemInfo(
                    "Tester",
                    "Jabulile Masilela");

            extent.setSystemInfo(
                    "Framework",
                    "Selenium + TestNG");

            extent.setSystemInfo(
                    "Browser",
                    ConfigReader.getProperty(
                            "browser"));

            extent.setSystemInfo(
                    "Environment",
                    "QA");

            extent.setSystemInfo(
                    "Application",
                    "Sauce Demo");

            extent.setSystemInfo(
                    "Build Version",
                    "1.0");

            extent.setSystemInfo(
                    "Execution Type",
                    "Regression");
        }

        return extent;
    }
}