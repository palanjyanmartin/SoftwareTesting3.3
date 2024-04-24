package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.iStyleLoginPageAssertionMessages.*;
import static constants.iStyleLoginPageLocators.*;

public class iStyleLoginPage extends BasePage {
    private WebDriver driver;
    private By usernameField = By.id(username_id);
    private By passwordField = By.id(password_id);
    private By loginButton = By.cssSelector(sign_in_button_CSS);

    private By alert_field_1 = By.cssSelector(alert_locator_CSS_1);
    private By alert_field_2 = By.cssSelector(alert_locator_CSS_2);


    private By text_field = By.cssSelector(text_field_CSS);

    public iStyleLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setUsername(String username) {
        findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public iStyleMyAccountPage clickLoginButton() {
        findElement(loginButton).click();
        return new iStyleMyAccountPage(driver);
    }

    public String alertWrongUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(findElement(alert_field_1))).getText();
    }

    public String alertWrongPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(findElement(alert_field_2))).getText();
    }


    public String textFieldTitle() {
        return findElement(text_field).getText();
    }

}
