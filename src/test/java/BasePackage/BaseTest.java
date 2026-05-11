package BasePackage;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

    public  WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties loc = new Properties();
    public static FileReader fr;
    public static FileReader fr1;
   //public Logger logger;

    public Logger logger = LogManager.getLogger(this.getClass());

    @BeforeClass(alwaysRun = true)
    @Parameters({"os","browser"})
    public void setUpBaseTest(@Optional("windows") String os,@Optional("chrome") String br) throws IOException {
        if(driver ==null)
        {
            //fr = new FileReader(System.getProperty("user.dir")+"src/test/resources/locators");
            fr1= new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\properties");
            //loc.load(fr);
            prop.load(fr1);
        }



        switch (br.toLowerCase())
        {
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "edge" :
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "firefox" :

                driver = new FirefoxDriver();
                break;

            default: System.out.println("Invalid browser name"); return;
        }


       /* if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
        {

            logger = LogManager.getLogger(this.getClass());
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-popup-blocking");
            driver= new ChromeDriver(options);

        }
        else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
        {
            logger = LogManager.getLogger(this.getClass());
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            //driver.get(prop.getProperty("testurl"));
        }

        else if(prop.getProperty("browser").equalsIgnoreCase("Edge"))
        {
            logger = LogManager.getLogger(this.getClass());
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            //driver.get(prop.getProperty("testurl"));
        }*/

        driver.manage().window().maximize();
        driver.get(prop.getProperty("testurl"));
        logger.info("Browser launched: ");

    }

    /* @AfterClass
      public void closeBrowser()
        {
           if(driver!=null) {
                driver.close();
                logger.info("Browser closed");
            }
        }*/

        public String randomString()
        {
            String generatedstring = RandomStringUtils.randomAlphabetic(5);
            return generatedstring;
        }

        public String randoNumber()
        {
            String generatednumber = RandomStringUtils.randomNumeric(5);
            return generatednumber;
        }

        public String randomAlphaNumeric()
        {

                    String generatednumber = RandomStringUtils.randomAlphabetic(3);
                    String generateString = RandomStringUtils.randomNumeric(3);
                    return(generateString+"@"+generatednumber);

        }


}
