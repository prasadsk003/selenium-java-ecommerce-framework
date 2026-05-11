package testcases;

import BasePackage.AccountRegistrationPage;
import BasePackage.BaseTest;
import BasePackage.HomePage;
import BasePackage.MyAccountPage;
import com.beust.ah.A;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviders;

public class loginTestCase extends BaseTest {

    @Test(dataProvider="LoginData", dataProviderClass= DataProviders.class)
    public void loginTests()
    {
        try {
            HomePage h1 = new HomePage(driver);
            h1.clicksignuplogin();
            logger.info("****Clicked Signup/Login");
            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
            Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,200)");
            regpage.funloginemail(prop.getProperty("email"));
            regpage.funloginpassword(prop.getProperty("password"));
            regpage.funloginbtn();

            MyAccountPage myacobj = new MyAccountPage(driver);
           boolean ismyaccountpageloogedin = myacobj.isMyAccountPageExists();
            Assert.assertTrue(ismyaccountpageloogedin);
            Thread.sleep(1000);
            myacobj.funlogout();
            logger.info("*****finished Login/Logout test case****");

        }
        catch (Exception e)
        {
           // logger.error("Test Failed Login");
            logger.debug("Debug Logs login");
        }

        logger.info("This test case is finished Login");
    }
}
