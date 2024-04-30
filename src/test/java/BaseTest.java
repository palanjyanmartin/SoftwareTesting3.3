import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.iStyleHomePage;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.URL;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static constants.iStyleBaseURL.base_url;

public class BaseTest {
    protected WebDriver driver;
    protected iStyleHomePage iStyleHomePage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        FirefoxOptions capabilities = new FirefoxOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
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
