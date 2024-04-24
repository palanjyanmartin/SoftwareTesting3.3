import pages.*;
import org.testng.annotations.Test;
import pages.iStyleLoginPage;
import pages.iStyleMyAccountPage;

import static org.testng.Assert.*;


public class MyAccountsTest extends BaseTest {

    // Test #4: Interaction between all created POMs
    @Test
    public void testAlertMessageAppearance() {
        iStyleLoginPage iStyleLoginPage = iStyleHomePage.navigateToLoginOptions();
        iStyleLoginPage.setUsername("testingclass");
        iStyleLoginPage.setPassword("testing2024aua");
        iStyleMyAccountPage iStyleMyAccountPage = iStyleLoginPage.clickLoginButton();
        iStyleMyAccountPage.clickOffersButton();
        assertTrue(iStyleMyAccountPage.alert());
    }

    // Test #5: Interaction between all created POMs
    @Test
    public void testLogOut() {
        iStyleLoginPage iStyleLoginPage = iStyleHomePage.navigateToLoginOptions();
        iStyleLoginPage.setUsername("testingclass");
        iStyleLoginPage.setPassword("testing2024aua");
        iStyleMyAccountPage iStyleMyAccountPage = iStyleLoginPage.clickLoginButton();
        iStyleLoginPage iStyleLoginPage1 = iStyleMyAccountPage.clickLogOut();
        assertEquals("Մուտք", iStyleLoginPage1.textFieldTitle());
    }

    // Test #6: Interaction between all created POMs
    @Test
    public void testNavigatingToHomePage() {
        iStyleLoginPage iStyleLoginPage = iStyleHomePage.navigateToLoginOptions();
        iStyleLoginPage.setUsername("testingclass");
        iStyleLoginPage.setPassword("testing2024aua");
        iStyleMyAccountPage iStyleMyAccountPage = iStyleLoginPage.clickLoginButton();
        iStyleHomePage iStyleHomePage1 = iStyleMyAccountPage.clickHomePage();
        assertEquals("https://istyle.am/", iStyleHomePage1.currentURL());
    }

    // Test #7: Interaction between all created POMs
    @Test
    public void testLogOutViaElq() {
        iStyleLoginPage iStyleLoginPage = iStyleHomePage.navigateToLoginOptions();
        iStyleLoginPage.setUsername("testingclass");
        iStyleLoginPage.setPassword("testing2024aua");
        iStyleMyAccountPage iStyleMyAccountPage = iStyleLoginPage.clickLoginButton();
        iStyleHomePage iStyleHomePage1 = iStyleMyAccountPage.clickElq();
        assertEquals("https://istyle.am/", iStyleHomePage1.currentURL());
    }
}
