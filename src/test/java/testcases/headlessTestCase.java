package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class headlessTestCase {

    public static void main(String[] args)
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        //options.setAcceptInsecureCerts(true);
       // options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://automationexercise.com/");
        System.out.println(driver.getTitle());
    }
}
