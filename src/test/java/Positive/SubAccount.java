package Positive;

import org.apache.logging.log4j.core.net.Priority;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ExtentReportManager;

import java.awt.*;
import java.io.IOException;

public class SubAccount extends BaseTest {

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        loadUrl();
        ExtentReportManager.testSteps("<b><font color='blue'>Opened the application URL</font></b>");

        webSteps.login();
        ExtentReportManager.testSteps("Entered valid credentials and clicked login");
        webSteps.waiting();
    }

    @Test(priority = 1)
    public void createSubAccount() throws InterruptedException, AWTException {
        ExtentReportManager.startTest("Test Cases for Sub Account Creation", "<b>Create a Sub Account</b>");

        webSteps.click("settings_Tab");
        webSteps.click("subAccount_Tab");
        webSteps.click("sct_AddBtn");

        webSteps.type("Sachinthax", "sc_companyName");
        webSteps.type("REG124780cbc", "sc_regCode");
        webSteps.type("971501234567","sc_companyNum");
        webSteps.type("TAX1247525", "sc_taxNum");
        webSteps.type("sachinthax20478@gmail.com", "sc_email");
        webSteps.type("971501234567","sc_phoneNum");
        webSteps.type("971501234567","sc_whatsappNum");
        webSteps.select("sc_country", 2, 1);
        webSteps.select("sc_state", 3, 1);

        webSteps.uploadFile("profileImage.jpg", "sc_profileImage");
        webSteps.scrollToElement("sc_state");
        webSteps.uploadFile("document.pdf", "sc_document");

        webSteps.scrollToElement("scf_AddBtn");

        webSteps.type("Sachintha", "scp_firstName");
        webSteps.type("Samarathunga", "scp_lastName");
        webSteps.type("12345@Aa", "scp_password");
        webSteps.type("12345@Aa", "scp_confPassword");
        webSteps.type("sachintha20478@gmail.com", "scp_email");
        webSteps.type("971501234567","scp_phoneNum");
        webSteps.type("971501234567","scp_whatsappNum");
        webSteps.select("scp_country", 2, 1);
        webSteps.select("scp_state", 3, 1);

        webSteps.uploadFile("companyLogo.jpg", "scp_companyLogo");
    }

}
