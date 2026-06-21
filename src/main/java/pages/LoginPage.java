package pages;

import org.openqa.selenium.*;
import base.BasePage;

public class LoginPage extends BasePage{

private By username=By.id("user-name");
private By password=By.id("password");
private By login=By.id("login-button");
private By title=By.className("app_logo");

    public LoginPage(WebDriver driver) {

        super(driver);
    }
    public void login(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(login);
    }

    public boolean loginSuccessful() {
        return isDisplayed(title);
    }
}