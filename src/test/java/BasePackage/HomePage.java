package BasePackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseTest{

    WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//a[contains(text(),'Signup / Login')]")
    WebElement signuporlogin;

    @FindBy(xpath = "//a[@href='/products']")
    WebElement btnproducts;

    @FindBy(xpath = "//h2[@class='title text-center' and text()='Features Items']")
    WebElement Homepagetxtconfirm;

        public void clicksignuplogin()
        {
            wait.until(ExpectedConditions.elementToBeClickable(signuporlogin));
            signuporlogin.click();
        }

        public void clickproducts()
        {
            wait.until(ExpectedConditions.elementToBeClickable(btnproducts));
            btnproducts.click();
        }

    public void homepagefeatureItems() throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",Homepagetxtconfirm);

        if(Homepagetxtconfirm.isDisplayed())
        {
                test.pass(" Feature item is present in Homepage");
        }
        js.executeScript("arguments[0].scrollIntoView();",btnproducts);
        btnproducts.click();
        Thread.sleep(3000);
        if(btnproducts.isSelected())
        {
            test.pass("Clicked on product");
        }


    }

}
