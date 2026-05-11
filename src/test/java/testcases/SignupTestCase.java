package testcases;

import BasePackage.AccountRegistrationPage;
import BasePackage.BaseTest;
import BasePackage.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class SignupTestCase extends BaseTest {

    @Test
    public void AccountRegistration()
    {
        try {
            logger.info("***** Starting Sign up Test Case*****");
            HomePage hp = new HomePage(driver);
           // Thread.sleep(1000);
            hp.clicksignuplogin();
            logger.info("***** Clicked on Sighup/Login button****");
            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
            logger.info("***** Adding account creation details****");
            logger.info("***** Adding Name****");
            Thread.sleep(1000);
            regpage.setNameofsignup("Name");
            logger.info("***** Adding Email ****");
            regpage.setEmailsignUp(randomString()+"@gmail.com");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,200)");
            regpage.funsignupbtn();
            regpage.setFirstname(randomString().toUpperCase());
            regpage.setLastName(randomString().toUpperCase());

            //regpage.setEmail(randomString()+"@gmail.com");

            logger.info("Validating expected message");
            String confirmmsg = regpage.getConfirmationMsg();
           // Assert.assertEquals(confirmmsg, "Your Account Has Been Created!");

        }
        catch (Exception e)
        {
            logger.error("Test Failed");
            logger.debug("Debug Logs");
            //Assert.fail();
        }

        logger.info("This test case is finished");

    }

}
