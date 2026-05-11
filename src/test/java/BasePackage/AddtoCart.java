package BasePackage;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

}
