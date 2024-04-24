package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.iStyleHomePageLocators.*;

public class iStyleHomePage extends BasePage {
    private WebDriver driver;
    private By sign_in_button = By.cssSelector(sign_in_MUTQ_css);

    public iStyleHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public iStyleLoginPage navigateToLoginOptions() {
        findElement(sign_in_button).click();
        return new iStyleLoginPage(driver);
    }


    public String currentURL() {
        return driver.getCurrentUrl();
    }


}
