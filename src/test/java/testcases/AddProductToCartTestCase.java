package testcases;

import BasePackage.BaseTest;
import BasePackage.HomePage;
import BasePackage.ProductPage;
import com.beust.ah.A;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AddProductToCartTestCase extends BaseTest {

    @Test(priority = 1)
    public void funAddProductCart()
    {
        HomePage h1 = new HomePage(driver);
        h1.clickproducts();
        ProductPage p1 = new ProductPage(driver);
        p1.Hover1stProduct();
        p1.clickContinueShopping();
        p1.fun2ndproduct();
        p1.viewcartpopup();
    }


}
