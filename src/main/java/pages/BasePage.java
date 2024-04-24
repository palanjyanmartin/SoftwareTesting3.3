package pages;

import org.openqa.selenium.*;

public class BasePage {
    private final WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    //Just added a helper function for me


    public WebElement findElement(By by) {
        return driver.findElement(by);
    }


}






