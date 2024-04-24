package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.iStyleMyAccountPageLocators.*;

public class iStyleMyAccountPage extends BasePage {
    private WebDriver driver;
    private By offers_button = By.cssSelector(getting_offers_button_CSS);
    private By log_out_button = By.cssSelector(log_out_CSS);
    private By home_page_button = By.cssSelector(home_page_CSS);

    private By confirm_message = By.cssSelector(alert_message);

    private By elq_log_out = By.cssSelector(elq_log_out_CSS);

    public iStyleMyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickOffersButton() {
        findElement(offers_button).click();
    }

    public iStyleLoginPage clickLogOut() {
        findElement(log_out_button).click();
        return new iStyleLoginPage(driver);
    }

    public iStyleHomePage clickElq() {
        findElement(elq_log_out).click();
        return new iStyleHomePage(driver);
    }

    public iStyleHomePage clickHomePage() {
        findElement(home_page_button).click();
        return new iStyleHomePage(driver);
    }


    public boolean alert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(findElement(confirm_message))).isDisplayed();
    }


}
