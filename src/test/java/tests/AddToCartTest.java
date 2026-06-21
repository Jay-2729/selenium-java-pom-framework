package tests;

import base.BaseTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import utils.Log;
import utils.ReportManager;

import pages.*;
import utils.ConfigReader;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;

@Listeners(TestListener.class)
public class AddToCartTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = dataProviders.TestDataProvider.class)
    public void verifyAddToCart(String username, String password) throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);

        Log.info("Logging into application");

        login.login(username, password);

        // Temp
        System.out.println(username);
        System.out.println(password);

        Assert.assertTrue(login.loginSuccessful(), "logged in failed");

        Log.pass("Login successful");

        Log.info("Adding backpack to cart");
        products.addBackpack();

        Log.pass("backpack added successfully");
        Thread.sleep(5000);

        Log.info("Opening shopping cart");
        products.openCart();
        Thread.sleep(10000);

        Log.info("Validating product in cart");
        Assert.assertEquals(cart.getProductName(), "Sauce Labs Backpack");
        Log.pass("Cart validation successful");
    }

}