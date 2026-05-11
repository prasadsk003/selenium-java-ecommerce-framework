package testcases;

import BasePackage.AccountRegistrationPage;
import BasePackage.BaseTest;
import BasePackage.HomePage;
import BasePackage.MyAccountPage;
import common.Listeners;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviders;
import utilities.ExtentReportUtils;

public class loginTestCaseDDT extends BaseTest {

    @Test(dataProvider="LoginData", dataProviderClass= DataProviders.class,groups = {"sanity"})
    public void verify_loginDDT(String email, String pass , String validation) {
        try {


            HomePage hp = new HomePage(driver);
            hp.clicksignuplogin();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,200)");
            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
            regpage.funloginemail(email);
            regpage.funloginpassword(pass);
            regpage.funloginbtn();

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
