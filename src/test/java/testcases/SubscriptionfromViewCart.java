package testcases;

import BasePackage.BaseTest;
import BasePackage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscriptionfromViewCart extends BaseTest {

    @Test
    public void subscriptionViewCartPage()
    {
        HomePage h1 = new HomePage(driver);
        h1.buttoncart();
        h1.selectSubscriptionInputType("webdeveieio@gmail.com");
        String actualmsg = h1.funsubscriptionconfirmation();
        Assert.assertEquals(actualmsg,"You have been successfully subscribed!","Subscription adding failed");

    }
}
