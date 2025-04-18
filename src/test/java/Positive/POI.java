package Positive;

import org.testng.Assert;
import org.testng.annotations.*;
import utils.BaseTest;
import utils.ExtentReportManager;

import java.io.IOException;

public class POI extends BaseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
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
        ExtentReportManager.startTest("Create POI with valid information", "<b>Create POI</b>");
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
    public void updatePOI() throws InterruptedException {
        ExtentReportManager.startTest("Update POI with valid information", "<b>Update POI</b>");
        ExtentReportManager.testSteps("<b><font color='blue'>Test Case : </font></b>"+ "Update POI");

        webSteps.click("POI_sb_action_btn");
        ExtentReportManager.testSteps("Clicked Action Button");

        webSteps.click("POI_sb_edit_btn");
        ExtentReportManager.testSteps("Clicked Edit Button");

        webSteps.elementToBeVisible("POI_name");
        webSteps.type("Coffee Shop", "POI_name");

        webSteps.type("Updated Description", "POI_description");
        webSteps.click("POI_updatedIcon");

        webSteps.scrollToElement("POI_updateBtn");

        webSteps.click("POI_coordinatesArea");
        webSteps.waitUntilElementToBeClickable("POI_editCoordinates");
        webSteps.click("POI_editCoordinates");
        webSteps.clickOnPointOfMap(250, -200);

        webSteps.click("POI_updateBtn");
        ExtentReportManager.testSteps("Clicked Update Button");

    }

    @Test(priority = 3)
    public void verifyPOIVisibilityOnTheMap() throws InterruptedException {
        ExtentReportManager.startTest("Verify POI visibility on the map", "<b>Verify POI visibility</b>");
        ExtentReportManager.testSteps("<b><font color='blue'>Test Case : </font></b>"+ "Verify POI visibility");

        webSteps.click("updated_POI_checkbox");
        webSteps.click("mapsControl_POIBtn");

        webSteps.waiting();

        webSteps.clickOnPointOfMap(250, -150);
        webSteps.waiting();
//        boolean POICardHeader = webSteps.getText("update_POI_cardH3").contains("Coffee Shop");
//        Assert.assertTrue(POICardHeader, "Verified POI visibility on the map");
    }


    @Test(priority = 4)
    public void searchPOI() throws InterruptedException {
        ExtentReportManager.startTest("Search an existing POI from the list", "<b>Search POI</b>");
        ExtentReportManager.testSteps("<b><font color='blue'>Test Case : </font></b>"+ "Search POI");

        webSteps.type("Coffee Shop", "SearchBar");
        ExtentReportManager.testSteps("Searched for a POI in the search bar");

        Assert.assertEquals("Coffee Shop", webSteps.getText("first_item_label"), "Passed");
        System.out.println("Test passed: Actual and expected messages match!");
    }

    @Test(priority = 5)
    public void deletePOI() throws InterruptedException {
        ExtentReportManager.startTest("Delete an existing POI from the list", "<b>Delete POI</b>");
        ExtentReportManager.testSteps("<b><font color='blue'>Test Case : </font></b>"+ "Delete POI");

        webSteps.click("POI_sb_afterEdit_action_btn");
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
