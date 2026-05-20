package BasePackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumUtility;

import java.util.List;


import static BasePackage.BaseTest.test;

public class ProductPage {


        @FindBy(xpath = "//h2[contains(text(),'All Products')]")
        WebElement txtallproduct;

        @FindBy(xpath = "//a[@href='/product_details/1']")
    WebElement viewProductFirst;

        @FindBy(xpath = "//h2/parent::div[@class='product-information']")
    WebElement productdetail;



      //  @FindBy(xpath ="//p/parent::div[@class='product-information']")
                @FindBy(xpath = "//div[@class='product-information']//p")
    WebElement productcat;

        @FindBy(xpath = "//span/parent::span")
    WebElement productPrice;

        @FindBy(xpath = "//input[@id='quantity']")
    WebElement productQuantity;

        @FindBy(xpath ="//p[b[contains(text(),'Availability:')]]")
    WebElement productAvailablity;

        @FindBy(xpath ="//p[b[contains(text(),'Condition:')]]")
    WebElement productcondition;

        @FindBy(xpath ="//p[b[contains(text(),'Brand:')]]")
    WebElement productbrand;

        //*** Product Search and Get list of product filtered

    //div[@class='productinfo text-center']//child::p[contains(text(),'T-Shirt') or contains(text(),'Tshirt') or contains(text(),'T SHIRT')]

    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    List<WebElement> searchProductDetails;

    @FindBy(id="search_product")
    WebElement searchtab;

    @FindBy(xpath = "//button[@type='button' or id='submit_search']")
            WebElement searchicon;



        WebDriver driver;

    SeleniumUtility utility;
        public ProductPage(WebDriver driver)
        {
            this.driver = driver;
            PageFactory.initElements(driver,this);
            utility = new SeleniumUtility(driver);
        }
        public String getProductText()
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block:'center'});",txtallproduct);
            test.info("Product page is selected"+txtallproduct.getText());
            return txtallproduct.getText();

        }

        public void firstviewproduct()
        {
            JavascriptExecutor js =(JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();",viewProductFirst);
            test.info("CLicked to view product");
            viewProductFirst.click();

        }
        public String getProductCatText()
        {
            test.info("Product cat is "+productcat.getText());
            return productcat.getText();

        }

        public String productPriceText(){
            test.info("Product price is "+productPrice.getText());
            return productPrice.getText();
        }

        public String productquanitityText(){
            test.info("Product Quantity is "+productQuantity.getAttribute("value"));
            return productQuantity.getAttribute("value");
        }

        public String productAvailablityText(){
            test.info("Product availablity is"+productAvailablity.getText());
            return productAvailablity.getText();
        }

        public String productConditionText(){
            test.info("Product condition is"+productcondition.getText());
          return  productcondition.getText();
        }

        public String productBrandtext(){
            test.info("Product brand is"+productbrand.getText());
            return productbrand.getText();

        }

        public void searchTabbtn()
        {
            searchtab.sendKeys("Tshirt");
            utility.clickElement(searchicon);
        }
        public void getListofProductFiltered()
        {
            List<WebElement> products = searchProductDetails;

            for(WebElement product : products)
            {
                String productName = product.getText();

                if(productName.toUpperCase().contains("TSHIRT") ||
                    productName.contains("T-Shirt")  || productName.contains("T SHIRT"))
                {
                    test.pass(productName);
                    System.out.println(productName);
                }
            }

        }



}
