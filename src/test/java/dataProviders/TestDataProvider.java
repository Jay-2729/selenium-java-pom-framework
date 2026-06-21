package dataProviders;

import org.testng.annotations.DataProvider;
import utils.ExcelUtil;

public class TestDataProvider {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return ExcelUtil
                .getTestData(
                        "LoginData");
    }
}