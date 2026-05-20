package testcases;

import BasePackage.AccountRegistrationPage;
import BasePackage.BaseTest;
import BasePackage.HomePage;
import BasePackage.ProductPage;
import org.testng.annotations.Test;


public class viewAllProductTestCase extends BaseTest {

    @Test
    public void productPage() throws InterruptedException
    {
        HomePage h1 = new HomePage(driver);
        h1.clicksignuplogin();
        AccountRegistrationPage a1 = new AccountRegistrationPage(driver);
        a1.funloginemail(prop.getProperty("email"));
        a1.funloginpassword(prop.getProperty("password"));
        a1.funloginbtn();

        Thread.sleep(3000);
        h1.homepagefeatureItems();
        ProductPage p1 = new ProductPage(driver);
        Thread.sleep(3000);
        p1.getProductText();
        Thread.sleep(3000);
        p1.firstviewproduct();
        Thread.sleep(3000);
        p1.getProductCatText();
        p1.productBrandtext();
        p1.productAvailablityText();

        p1.productquanitityText();
        p1.productPriceText();
        p1.productConditionText();
        p1.getProductText();




    }
}
