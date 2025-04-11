package Positive;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.BaseTest;
import utils.ExtentReportManager;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class ClickObject extends BaseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        ExtentReportManager.startTest("Positive Test Case for Verify the Map Controls", "<b>Login with valid credentials</b>");
        loadUrl();
        ExtentReportManager.testSteps("<b><font color='blue'>Opened the application URL</font></b>");

        webSteps.login();
        ExtentReportManager.testSteps("Entered valid credentials and clicked login");
        webSteps.waiting();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginWithValidCredentials() throws InterruptedException, AWTException {
        ExtentReportManager.testSteps("Verifying Map Controls...");

        webSteps.dragMap();
        webSteps.scrollMouse(-30);
//      webSteps.zoomMap();
//      webSteps.dragTheMap(300, 200);
//      driver.findElement(By.xpath("//div[contains(@style, 'touch-action: pan-x pan-y')]//child::img")).click();
        webSteps.waiting();
    }
}
