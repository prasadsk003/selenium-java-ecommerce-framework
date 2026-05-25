package testcases;

import BasePackage.BaseTest;
import BasePackage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class subscriptionTestCase extends BaseTest {

    @Test
    public void checksubscription()
    {
        HomePage h1 = new HomePage(driver);
        driver.getTitle();
        h1.selectSubscriptionInputType("webdevelopment2k@gmail.com");
        String actualMsg =h1.funsubscriptionconfirmation();
        Assert.assertEquals(actualMsg,"You have been successfully subscribed!","Subscription adding failed");


    }
}
