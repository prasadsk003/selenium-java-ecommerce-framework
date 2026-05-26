package testcases;

import BasePackage.AddtoCart;
import BasePackage.BaseTest;
import BasePackage.HomePage;
import BasePackage.ProductPage;
import com.beust.ah.A;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddProductToCartTestCase extends BaseTest {

    @Test(priority = 1)
    public void funAddProductCart()
    {
        HomePage h1 = new HomePage(driver);
        h1.clickproducts();
        ProductPage p1 = new ProductPage(driver);
        AddtoCart a1 = new AddtoCart(driver);
        p1.Hover1stProduct();
        p1.clickContinueShopping();
        p1.fun2ndproduct();
        List<String> expectedProducts = p1.getSelectedProductDetails();
        p1.fungetProductDetails();
        p1.viewcartpopup();

        List<String> actualProduct = a1.funGetCartProductDetails();

        System.out.println(expectedProducts);
        System.out.println(actualProduct);

        Assert.assertEquals(actualProduct,expectedProducts,"Cart product details mismatch");





    }


}
