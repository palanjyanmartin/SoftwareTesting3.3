import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.iStyleHomePage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static constants.iStyleBaseURL.base_url;


public class BaseTest {
    private WebDriver driver;
    protected iStyleHomePage iStyleHomePage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/martinpalanjyan/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.get(base_url);
        iStyleHomePage = new iStyleHomePage(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = "failure_" + timestamp + ".png";
            FileUtils.copyFile(screenshotFile, new File("/Users/martinpalanjyan/Desktop/" + screenshotName));
        }
        driver.quit();
    }
}
