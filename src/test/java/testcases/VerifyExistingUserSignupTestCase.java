package testcases;

import BasePackage.AccountRegistrationPage;
import BasePackage.BaseTest;
import com.beust.ah.A;
import org.testng.annotations.Test;

import utilities.DataProvidersSignUp;

public class VerifyExistingUserSignupTestCase extends BaseTest {

       @Test(dataProvider ="SignUpData", dataProviderClass = DataProvidersSignUp.class)
    public void DuplicateUserSignupTest(String email,String pass)
    {
        signupexistingfun(email,pass);

        AccountRegistrationPage a1 = new AccountRegistrationPage(driver);
        String checkMsg = "Email Address already exist!";
            String checkMsg2  =  a1.getConfirmationmsgExistingUser();
        if(checkMsg.equals(checkMsg2)){
            test.pass("Test case passed - User is already registered");
        }
        else
        {
            test.fail("User is aready registered and able to sign up");
        }

    }
}
