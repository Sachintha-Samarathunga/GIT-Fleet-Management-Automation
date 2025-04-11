package Positive;

import org.apache.logging.log4j.core.net.Priority;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ExtentReportManager;

import java.awt.*;
import java.io.IOException;

public class SubAccount extends BaseTest {

    String companyEmail;
    String personalEmail;

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        loadUrl();
        ExtentReportManager.testSteps("<b><font color='blue'>Opened the application URL</font></b>");

        webSteps.login();
        ExtentReportManager.testSteps("Entered valid credentials and clicked login");
        webSteps.waiting();

        webSteps.click("settings_Tab");
        webSteps.click("subAccount_Tab");
    }

    @Test(priority = 1)
    public void createSubAccount() throws InterruptedException, AWTException {
        ExtentReportManager.startTest("Test Cases for Sub Account Creation", "<b>Create a Sub Account</b>");

        this.companyEmail = webSteps.randomPersonalEmailAddress();
        this.personalEmail = webSteps.randomPersonalEmailAddress();

        webSteps.click("sct_AddBtn");

        webSteps.type("Sachinthax", "sc_companyName");
        webSteps.type("REG124780cbc", "sc_regCode");
        webSteps.type("971501234567","sc_companyNum");
        webSteps.type("TAX1247525", "sc_taxNum");
        webSteps.type(this.companyEmail, "sc_email");
        webSteps.type("971501234567","sc_phoneNum");
        webSteps.type("971501234567","sc_whatsappNum");
        webSteps.select("sc_country", 2, 1);
        webSteps.select("sc_state", 3, 1);

//      webSteps.uploadFile("profileImage.jpg", "sc_profileImage");
        webSteps.scrollToElement("sc_state");
//      webSteps.uploadFile("document.pdf", "sc_document");

        webSteps.scrollToElement("scf_AddBtn");

        webSteps.type("Sachintha", "scp_firstName");
        webSteps.type("Samarathunga", "scp_lastName");
        webSteps.type("12345@Aa", "scp_password");
        webSteps.type("12345@Aa", "scp_confPassword");
        webSteps.type(this.personalEmail, "scp_email");
        webSteps.type("971501234567","scp_phoneNum");
        webSteps.type("971501234567","scp_whatsappNum");
        webSteps.select("scp_country", 2, 1);
        webSteps.select("scp_state", 3, 1);

//      webSteps.uploadFile("companyLogo.jpg", "scp_companyLogo");
        webSteps.click("scf_AddBtn");
        Thread.sleep(5000);
//
//        String expectMessage = "Sub company created successfully";
//        String actualMessage = webSteps.getText("Toast_message");
//
//        if(expectMessage.equals(actualMessage)){
//            System.out.println("The Sub account created successfully");
//        } else {
//            System.out.println("The company email or personal email already exist");
//        }
    }

    @Test(priority = 2)
    public void searchSubAccount() throws InterruptedException {
        ExtentReportManager.startTest("Test Cases for Sub Account Creation", "<b>Search a Sub Account</b>");

        webSteps.click("sct_searchBar");
        webSteps.type(this.personalEmail, "sct_searchBar");
        webSteps.waiting();

        Assert.assertEquals(this.personalEmail, webSteps.getText("sct_firstRowEmail"));
    }

}
