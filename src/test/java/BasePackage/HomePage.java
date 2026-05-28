package BasePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.SeleniumUtility;

import java.time.Duration;

public class HomePage extends BaseTest{

    WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        util = new SeleniumUtility(driver);
    }
    @FindBy(xpath="//a[contains(text(),'Signup / Login')]")
    WebElement signuporlogin;

    @FindBy(xpath = "//a[@href='/products']")
    WebElement btnproducts;

    @FindBy(xpath = "//h2[@class='title text-center' and text()='Features Items']")
    WebElement Homepagetxtconfirm;

    @FindBy(xpath ="//input[@type='email']")
    WebElement inputSubscription;

    @FindBy(xpath = "//div[text()='You have been successfully subscribed!']")
    WebElement txtsubscriptionconfirm;

    @FindBy(xpath = "//a[@href='/view_cart']")
    WebElement btncart;

    @FindBy(xpath ="//button[@type='submit']")
            WebElement btnsubscription;

    SeleniumUtility util = new SeleniumUtility(driver);

        public void clicksignuplogin()
        {
            wait.until(ExpectedConditions.elementToBeClickable(signuporlogin));
            signuporlogin.click();
        }

        public void clickproducts()
        {
            wait.until(ExpectedConditions.elementToBeClickable(btnproducts));
            btnproducts.click();
            try{
                Thread.sleep(3000);
                WebElement ads = driver.findElement(By.xpath("//iframe[@id='aswift_6']"));
                driver.switchTo().frame(ads);

                driver.findElement(By.xpath("//*[@id='dismiss-button-element']/div")).click();
                driver.switchTo().defaultContent();
            }
            catch(Exception e)
            {
                System.out.println("Pop up not displayed");
            }

            try{
                Thread.sleep(3000);
                //WebElement ads2 = driver.findElement(By.xpath("//iframe[@name='google_esf']"));
                //driver.switchTo().frame(ads2);
                WebElement ads3= driver.findElement(By.xpath("//iframe[@id='aswift_3']"));
                driver.switchTo().frame(ads3);
                //WebElement ads = driver.findElement(By.xpath("//iframe[@title='Advertisement' and @name='ad_iframe']"));
                //driver.switchTo().frame(ads);
                driver.findElement(By.xpath("//*[@id='dismiss-button-element']/div")).click();
                driver.switchTo().defaultContent();
            }catch(Exception e)
            {
                System.out.println("no pop ads2");
            }

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

    public void selectSubscriptionInputType(String email)
    {
        util.scrollToElement(inputSubscription);
        util.clickElement(inputSubscription);
        inputSubscription.sendKeys(email);
        btnsubscription.click();
    }

    public String funsubscriptionconfirmation()
    {
        return txtsubscriptionconfirm.getText();
    }

    public void buttoncart()
    {
        btncart.click();
    }
}
