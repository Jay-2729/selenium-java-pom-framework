package pages;

import org.openqa.selenium.*;
import base.BasePage;

public class CartPage extends BasePage {

    private By product = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getText(product);
    }
}