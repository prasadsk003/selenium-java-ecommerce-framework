package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AccountRegistrationPage {

    //New User Signup
    @FindBy(xpath="//input[@data-qa='signup-name']")
    WebElement signupname;

    @FindBy(xpath="//input[@data-qa='signup-email']")
    WebElement signupemail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupbtn;

    //Login user using Email and Password
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginxpath;

    @FindBy(xpath ="//input[@data-qa='login-password']")
    WebElement passwordxpath;

    @FindBy(xpath="//button[@data-qa='login-button']")
    WebElement btnloginxpath;


    //Account Creation details
    @FindBy(xpath = "")
    WebElement txtFirstname;

    @FindBy(xpath = "")
    WebElement txtLastName;

    @FindBy(xpath= "")
    WebElement msgConfirmation;

    @FindBy(xpath= "")
    WebElement txtemail;
    WebDriver driver;
    WebDriverWait wait;
    public AccountRegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    //login and sign up functions

    public void setNameofsignup(String strSignupname)
    {
       // wait.until(ExpectedConditions.elementToBeClickable(signupname));
       signupname.sendKeys(strSignupname);
    }

    public void setEmailsignUp(String strEmail)
    {
        signupemail.sendKeys(strEmail);
    }

    public void funsignupbtn()
    {
        wait.until(ExpectedConditions.elementToBeClickable(signupbtn));
        signupbtn.click();
    }

    //Login Username and password function

    public void funloginemail(String femaillogin)
    {

        loginxpath.sendKeys(femaillogin);
    }

    public void funloginpassword(String fpasswordlogin)
    {

        passwordxpath.sendKeys(fpasswordlogin);
    }

    public void funloginbtn()
    {
        wait.until(ExpectedConditions.elementToBeClickable(btnloginxpath));
        btnloginxpath.click();
    }

    //Sign up details account creation//

    public void setFirstname(String fname)
    {
        txtFirstname.sendKeys(fname);
    }

    public void setLastName(String lname)
    {
        txtFirstname.sendKeys(lname);
    }

    public void setEmail(String email)
    {
        txtemail.sendKeys(email);
    }

    public String getConfirmationMsg() {
        try {
            return (msgConfirmation.getText());
        }
        catch(Exception e)
        {
            return(e.getMessage());
        }

    }

}
