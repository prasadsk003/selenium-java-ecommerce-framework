package testcases;

import BasePackage.AccountRegistrationPage;
import BasePackage.BaseTest;
import BasePackage.HomePage;
import BasePackage.ProductPage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utilities.SeleniumUtility;

public class searchProductTestCase extends BaseTest {
    @Test
    public void searchproduct()
    {

        HomePage h1 = new HomePage(driver);
        SeleniumUtility s1= new SeleniumUtility(driver);
        h1.clicksignuplogin();
        AccountRegistrationPage a1 = new AccountRegistrationPage(driver);
        a1.funloginemail(prop.getProperty("email"));
        a1.funloginpassword(prop.getProperty("password"));
        a1.funloginbtn();

        h1.clickproducts();

        ProductPage p1 = new ProductPage(driver);
        p1.searchTabbtn();
        p1.getListofProductFiltered();

    }

}
