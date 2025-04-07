package Positive;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ExtentReportManager;

import java.awt.*;
import java.io.IOException;

public class Object extends BaseTest {

    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        ExtentReportManager.startTest("Create Object with valid information", "<b>Create Object</b>");
        loadUrl();
        ExtentReportManager.testSteps("<b><font color='blue'>Opened the application URL</font></b>");

        webSteps.login();
        ExtentReportManager.testSteps("Logged into the system");
        webSteps.waiting();
    }


    @Test
    public void createObject() throws InterruptedException, AWTException {

        webSteps.click("settingsPage");
        webSteps.click("objectsPage");
        webSteps.click("addObject");

        webSteps.click("iconSelection"); // 1. click "iconSelection"
        String randomObjectName = webSteps.generateRandomString(10);

        webSteps.type(randomObjectName, "objectDetailsObject"); // 2. type random vehicle object name
        String randomImei = webSteps.generateRandomString(15);

        webSteps.type(randomImei, "objectDetailsImei"); // 3. type random imei

        webSteps.select("objectDetailsModel", 2, 1); //4. select object model

        String randomSimNumber = webSteps.generateRandomString(12);
        webSteps.type(randomSimNumber, "objectDetailsSimNumber");// 5. Type a random object sim number

        webSteps.scrollToElement("customerDetailsCustomer"); // Scroll to customer details

        webSteps.select("customerDetailsCustomer", 1, 1); // 6. Select a customer

        webSteps.select("customerDetailsSubGroup", 1, 1); // 7. Select a sub group

        // 8. Pick today's date
        String dateToSelect = "25";
        webSteps.selectDate("installationDetailsInstallationDate", dateToSelect);

        // 9 Pick today's date
        webSteps.selectDate("installationDetailsActivationDate", dateToSelect);

        // 10. Type a random model
        String randomVehicleModel = webSteps.generateRandomString(8);
        webSteps.type(randomVehicleModel, "installationDetailsVehicleModel");

        // 11. Type a random registration number
        String randomRegistrationNumber = webSteps.generateRandomString(10);
        webSteps.type(randomRegistrationNumber, "installationDetailsRegistrationNumber");

        // 12. Type a random VIN number
        String randomVinNumber = webSteps.generateRandomString(17);
        webSteps.type(randomVinNumber, "installationDetailsVIN");

        // 13. Type random other information
        String randomOtherInfo = webSteps.generateRandomString(20);
        webSteps.type(randomOtherInfo, "installationDetailsOtherInfo");

        webSteps.scrollToElement("otherRemark"); // Scroll to customer details

        // 15. Type random other information
        String randomRemark = webSteps.generateRandomString(20);
        webSteps.type(randomRemark, "otherRemark");

        // Save form
        webSteps.click("addObjectBtn");
    }
}
