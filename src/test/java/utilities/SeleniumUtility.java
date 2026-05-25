package utilities;

import BasePackage.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtility  {

    WebDriver driver;
    JavascriptExecutor js;
    public SeleniumUtility(WebDriver driver)
    {
        this.driver = driver;
       this.js = (JavascriptExecutor) driver;

    }

    public void scrollToElement(WebElement element)
    {
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void clickElement(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();


    }
}
