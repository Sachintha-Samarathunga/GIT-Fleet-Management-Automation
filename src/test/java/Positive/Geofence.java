package Positive;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.BaseTest;
import utils.ExtentReportManager;

import java.io.IOException;

public class Geofence extends BaseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        ExtentReportManager.startTest("Create Geofence with valid information", "<b>Create geofence</b>");
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

        webSteps.waitUntilElementToBeClickable("Geo_name");
        webSteps.type("Restricted Area", "Geo_name");
        webSteps.click("Open_colorPicker");
        webSteps.click("Color");
        webSteps.scrollToElement("Geo_saveBtn");
        webSteps.click("Geo_saveBtn");

        Assert.assertEquals("Geo fence created successfully", webSteps.getText("Toast_message"));

    }

    @Test
    public void deletePOI() throws InterruptedException {
        ExtentReportManager.testSteps("<b><font color='blue'>Test Case : </font></b>"+ "Delete POI");

        webSteps.click("Geo_sb_action_btn");
        ExtentReportManager.testSteps("Clicked Action Button");

        webSteps.click("Geo_sb_delete_btn");
        ExtentReportManager.testSteps("Clicked Delete Button");

        webSteps.scrollToElement("confirmation_delete_btn");
        webSteps.click("confirmation_delete_btn");
        ExtentReportManager.testSteps("Confirmed the deletion");

        Assert.assertEquals("GeoFence deleted successfully", webSteps.getText("Toast_message"), "Passed");
        System.out.println("Test passed: Actual and expected messages match!");
    }

    @Test
    public void CreateRoundedGeofence() throws InterruptedException {
        webSteps.click("addGeo_button");
        webSteps.click("Type_circle");

        // choose the coordinates for geofence
        webSteps.clickOnPointOfMap(250, -150);
        webSteps.clickOnPointOfMap(300, -130);// Closing the polygon

        webSteps.waitUntilElementToBeClickable("Geo_name");
        webSteps.type("Restricted Area01", "Geo_name");
        webSteps.click("Open_colorPicker");
        webSteps.click("Color");
        webSteps.scrollToElement("Geo_saveBtn");
        webSteps.click("Geo_saveBtn");

        Assert.assertEquals("Geofence has been created successfully!", webSteps.getText("Toast_message"));

    }
}
