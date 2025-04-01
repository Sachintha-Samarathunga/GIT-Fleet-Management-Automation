package Map;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.BaseTest;
import utils.ExtentReportManager;

import java.io.IOException;
import java.time.Duration;

public class Map extends BaseTest {
    @BeforeSuite
    public void setupReport() throws InterruptedException {
        ExtentReportManager.initReport();
    }

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
    public void loginWithValidCredentials() throws InterruptedException {
        ExtentReportManager.testSteps("Verifying Map Controls...");

        webSteps.click("Map");
        webSteps.MoveMap("Map");
    }

    @AfterMethod
    public void tearDownBrowser(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentReportManager.logFail("❌ <b><font color='red'> FAILED : </font></b>" + result.getThrowable().getMessage());
        } else {
            ExtentReportManager.logPass("✅ <b><font color='green'> PASSED </font></b>");
        }

        ExtentReportManager.captureScreenshot(driver, result);
        tearDown();
    }

    @AfterSuite
    public void finalizeReport() {
        ExtentReportManager.flushReport(); // Ensures the report is generated
        ExtentReportManager.openReport();  // Opens the report automatically
    }
}
