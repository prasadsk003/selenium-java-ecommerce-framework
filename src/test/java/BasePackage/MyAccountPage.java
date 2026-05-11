package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    @FindBy(xpath ="//a[text()=' Logout']")
    WebElement linklogout;

    @FindBy(xpath = "//a[contains(text(),' Logged in as ')]")
    WebElement loggedinconfirmation;
    WebDriver driver;
    public MyAccountPage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    public void funlogout()
    {
        linklogout.click();

    }

    public boolean isMyAccountPageExists()
    {
        try{
            return (loggedinconfirmation.isDisplayed());
        }
        catch (Exception e)
        {
            return false;
        }
    }



}
