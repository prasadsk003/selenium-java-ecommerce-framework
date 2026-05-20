package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class testCasePage {

    @FindBy(xpath ="//a[@data-toggle='collapse']//following::u")
    List<WebElement> testcases;

    @FindBy(xpath = "//a[@href='/test_cases']")
            WebElement btntestcase;

    WebDriver driver;
    public testCasePage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public int getTotaltestCasecount(){
        System.out.println("Total test cases present "+testcases.size());
        return testcases.size();
    }

    public void selecttestcase()
    {
        btntestcase.click();
    }


}
