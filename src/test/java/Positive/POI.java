package Positive;

import org.testng.Assert;
import org.testng.annotations.*;
import utils.BaseTest;
import utils.ExtentReportManager;

import java.io.IOException;

public class POI extends BaseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        ExtentReportManager.startTest("Create POI with valid information", "<b>Create POI</b>");
        loadUrl();
        ExtentReportManager.testSteps("<b><font color='blue'>Opened the application URL</font></b>");

        webSteps.login();
        ExtentReportManager.testSteps("Logged into the system");
        webSteps.waiting();
        webSteps.click("settings_Icon");
        webSteps.click("POI_tab");
    }

    @Test(priority = 1)
    public void createPOI() throws InterruptedException {
        ExtentReportManager.testSteps("<b><font color='blue'>Test Case : </font></b>"+ "Create POI");

        webSteps.click("addPOI_button");
        ExtentReportManager.testSteps("Clicked Add Button");

        webSteps.click("select_location");
        webSteps.clickOnPointOfMap(200, -150);
        ExtentReportManager.testSteps("Selected POI location");

        webSteps.waitUntilElementToBeClickable("POI_name");
        webSteps.type("Bus Stop", "POI_name");
        webSteps.type("This is dummy description", "POI_description");
        webSteps.click("POI_icon");
        ExtentReportManager.testSteps("Entered valid POI details.");

        webSteps.scrollToElement("POI_saveBtn");
        webSteps.click("POI_saveBtn");
        ExtentReportManager.testSteps("Clicked Save Button");

        Assert.assertEquals("Poi created successfully!", webSteps.getText("Toast_message"), "Passed");
        System.out.println("Test passed: Actual and expected messages match!");
    }

    @Test(priority = 2)
    public void searchPOI() throws InterruptedException {
        ExtentReportManager.testSteps("<b><font color='blue'>Test Case : </font></b>"+ "Search POI");

        webSteps.type("Bus Stop", "SearchBar");
        ExtentReportManager.testSteps("Searched for a POI in the search bar");

        Assert.assertEquals("Bus Stop", webSteps.getText("first_item_label"), "Passed");
        System.out.println("Test passed: Actual and expected messages match!");
    }

    @Test(priority = 3)
    public void deletePOI() throws InterruptedException {
        ExtentReportManager.testSteps("<b><font color='blue'>Test Case : </font></b>"+ "Delete POI");

        webSteps.click("POI_sb_action_btn");
        ExtentReportManager.testSteps("Clicked Action Button");

        webSteps.click("POI_sb_delete_btn");
        ExtentReportManager.testSteps("Clicked Delete Button");

        webSteps.scrollToElement("confirmation_delete_btn");
        webSteps.click("confirmation_delete_btn");
        ExtentReportManager.testSteps("Confirmed the deletion");

        Assert.assertEquals("Poi item has been deleted successfully!", webSteps.getText("Toast_message"), "Passed");
        System.out.println("Test passed: Actual and expected messages match!");
    }

}
