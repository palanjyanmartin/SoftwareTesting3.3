import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.*;
import static constants.iStyleLoginPageAssertionMessages.*;
import static constants.iStyleMyAccountPageLocators.*;
import static org.testng.Assert.*;


public class LoginTest extends BaseTest {
    //Test #1 that contains interaction between  all created POM’s
    @Test
    public void testSuccessfulLogin() {
        iStyleLoginPage iStyleLoginPage = iStyleHomePage.navigateToLoginOptions();
        iStyleLoginPage.setUsername("testingclass");
        iStyleLoginPage.setPassword("testing2024aua");
        iStyleMyAccountPage iStyleMyAccountPage = iStyleLoginPage.clickLoginButton();
        assertTrue(iStyleMyAccountPage.findElement(By.cssSelector(getting_offers_button_CSS)).isDisplayed());
    }


    //Test #2 that contains interaction between HomePage and LoginPage

    @Test
    public void testInvalidLogin() {
        iStyleLoginPage iStyleLoginPage = iStyleHomePage.navigateToLoginOptions();
        iStyleLoginPage.setUsername("1@@@dfjdfifji$$$$...");
        iStyleLoginPage.setPassword("testing2024aua");
        iStyleLoginPage.clickLoginButton();
        assertEquals(alert_message_text, iStyleLoginPage.alertWrongUsername());
    }

    //Test #3 that contains interaction between HomePage and LoginPage

    // I am putting assertNotEquals in purpose for my test to fail such that I can check
    // how the screenshot works. It works correctly!

    @Test
    public void testInvalidPassword() {
        iStyleLoginPage iStyleLoginPage = iStyleHomePage.navigateToLoginOptions();
        iStyleLoginPage.setUsername("testingclass");
        iStyleLoginPage.setPassword("someinvalidpassword");
        iStyleLoginPage.clickLoginButton();
        assertNotEquals(alert_message_password_text, iStyleLoginPage.alertWrongPassword());
    }
}
