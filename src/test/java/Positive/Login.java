package Positive;

import org.testng.Assert;
import org.testng.annotations.*;
import utils.BaseTest;
import utils.ExtentReportManager;
import org.testng.ITestResult;

import java.io.IOException;

public class Login extends BaseTest {


    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {
        ExtentReportManager.startTest("Positive Test Case for User Login with Valid Credentials", "<b>Login with valid credentials</b>");
        loadUrl();
        ExtentReportManager.testSteps("<b><font color='blue'>Opened the application URL</font></b>");

        webSteps.login();
        ExtentReportManager.testSteps("Entered valid credentials and clicked login");
        webSteps.waiting();
    }

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        ExtentReportManager.testSteps("Verifying login success...");

        boolean urlVerification = driver.getCurrentUrl().contains("live-tracking");
        Assert.assertTrue(urlVerification, "Expecting login success but not navigated to dashboard");

//        Assert.assertEquals("Successfully logged in", webSteps.getText("successMessage"), "Passed");
//        System.out.println("Test passed: Actual and expected messages match!");
    }


}
