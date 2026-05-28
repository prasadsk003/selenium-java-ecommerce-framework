package BasePackage;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AddtoCart {

    //Select Women
    @FindBy(xpath = "//a[@href='#Women']")
    WebElement catwomen;
    @FindBy(linkText = "Dress")
    WebElement optiondress;
    @FindBy(xpath = "(//p[text()='Sleeveless Dress']/following-sibling::a)[1]")
    WebElement btnsleevlessdressAdtoCart;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement btncontinueShop;

    @FindBy(xpath = "//a[@href='/view_cart']/child::u")
    WebElement btnviewcart;

    @FindBy(xpath = "//a[@href='/product_details/3' and text()='Sleeveless Dress']")
    WebElement confirmaddedproduct;



    @FindBy(xpath = "//td[@class='cart_price']//p")
            WebElement cartAddedProductPrice;

    @FindBy(xpath ="//td[@class='cart_description']//h4")
            WebElement cartaddedproductName;

    @FindBy(xpath = "//table[@class='table table-condensed']//tbody/tr")
    List<WebElement> getCartProductDetails;

    @FindBy(xpath = "//table[@class='table table-condensed']//td[@class='cart_price']")
    List<WebElement> getCartProductPrice;

    WebDriver driver;
    public AddtoCart(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void CategorySelect()
    {
        catwomen.click();
    }
    public void DressBtn()
    {
        optiondress.click();
    }

    public void addtocart()
    {
        btnsleevlessdressAdtoCart.click();
    }

    public void viewcart()
    {
        btnviewcart.click();
    }

    //String addedproduct = "Sleeveless Dress";

    public String getConfirmationMsg() {
        try {
            return (confirmaddedproduct.getText());
        }
        catch(Exception e)
        {
            return(e.getMessage());
        }

    }

        public List<String> funGetCartProductDetails()
        {
            List<String> CartPageProductList = new ArrayList<>();

            for(WebElement list :getCartProductDetails )
            {
                String cartProductPrice = list.findElement(By.xpath(".//td[@class='cart_price']//p")).getText();
                String cartProductName = list.findElement(By.xpath(".//td[@class='cart_description']//h4")).getText();

                CartPageProductList.add(cartProductName);
                CartPageProductList.add(cartProductPrice);

                BaseTest.test.info(CartPageProductList.toString());


            }
            return  CartPageProductList;
        }

}
