package pages;

import org.openqa.selenium.*;
import base.BasePage;

public class ProductsPage extends BasePage {

    private By backpack = By.id("add-to-cart-sauce-labs-backpack");
    private By cart = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addBackpack() {
        click(backpack);
    }

    public void openCart() {
        click(cart);
    }
}