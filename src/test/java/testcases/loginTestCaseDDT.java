package testcases;

import BasePackage.AccountRegistrationPage;
import BasePackage.BaseTest;
import BasePackage.HomePage;
import BasePackage.MyAccountPage;
import com.aventstack.extentreports.ExtentTest;
import common.Listeners;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviders;
import utilities.ExtentReportUtils;

/* login test case using Data Provider */

public class loginTestCaseDDT extends BaseTest {


    @Test(dataProvider="LoginData", dataProviderClass= DataProviders.class,groups = {"sanity"})
    public void verify_loginDDT(String email, String pass , String validation) {
        try {


           performLogin(email,pass);

            MyAccountPage myactobj = new MyAccountPage(driver);
            boolean isMyAcDisplayed = myactobj.isMyAccountPageExists();
            Assert.assertTrue(isMyAcDisplayed);

            if (validation.equalsIgnoreCase("Valid")) {
                if (isMyAcDisplayed == true) {

                    Assert.assertTrue(true);
                    myactobj.funlogout();
                } else {

                    Assert.assertTrue(false);
                }
            }

            if (validation.equalsIgnoreCase("Invalid")) {
                if (isMyAcDisplayed == true) {

                    myactobj.funlogout();
                    Assert.assertTrue(false);
                } else {

                    Assert.assertTrue(true);
                }
            }
        }catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
        finally {
            logger.info("Test case execution finished");
        }
    }
}
