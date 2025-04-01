package POI;

import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.BaseTest;
import utils.ExtentReportManager;

import java.io.IOException;

public class AddGeoFence extends BaseTest {

    @BeforeSuite
    public void setupReport() {
        ExtentReportManager.initReport();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        ExtentReportManager.startTest("Create POI with valid information", "<b>Create POI</b>");
        loadUrl();
        ExtentReportManager.testSteps("<b><font color='blue'>Opened the application URL</font></b>");

        webSteps.login();
        ExtentReportManager.testSteps("Logged into the system");
        webSteps.waiting();
        webSteps.click("settings_Icon");
        webSteps.click("Geofencing_tab");
    }

    @Test
    public void CreateGeofence() throws InterruptedException {
        webSteps.click("addGeo_button");
        webSteps.click("Type_ploygon");

        // choose the coordinates for geofence
        webSteps.clickOnPointOfMap(200, -110);
        webSteps.clickOnPointOfMap(238, -126);
        webSteps.clickOnPointOfMap(226, -168);
        webSteps.clickOnPointOfMap(174, -168);
        webSteps.clickOnPointOfMap(162, -126);
        webSteps.clickOnPointOfMap(200, -110); // Closing the polygon

    }

    @AfterMethod
    public void tearDownBrowser(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentReportManager
                    .logFail("❌ <b><font color='red'> FAILED : </font></b>" + result.getThrowable().getMessage());
        } else {
            ExtentReportManager.logPass("✅ <b><font color='green'> PASSED </font></b>");
        }

        ExtentReportManager.captureScreenshot(driver, result);
        tearDown();
    }

    @AfterSuite
    public void finalizeReport() {
        ExtentReportManager.flushReport(); // Ensures the report is generated
        ExtentReportManager.openReport(); // Opens the report automatically
    }
}
