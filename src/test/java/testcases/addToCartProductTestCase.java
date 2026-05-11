package testcases;

import BasePackage.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviders;

public class addToCartProductTestCase extends BaseTest {


    @Test(dataProvider="LoginData", dataProviderClass= DataProviders.class,groups ={"regression"})
    public void addproducttocart(String email, String pass)
    {



            HomePage hp = new HomePage(driver);
            hp.clicksignuplogin();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,200)");
            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
            regpage.funloginemail(email);
            regpage.funloginpassword(pass);
            regpage.funloginbtn();
            //logger.info("Looged in");
            AddtoCart c1 = new AddtoCart(driver);
            c1.CategorySelect();
            c1.DressBtn();
            c1.addtocart();
            c1.viewcart();
            c1.getConfirmationMsg();
            MyAccountPage obj = new MyAccountPage(driver);
            obj.funlogout();


           // logger.info("Test case execution finished");




    }
}
