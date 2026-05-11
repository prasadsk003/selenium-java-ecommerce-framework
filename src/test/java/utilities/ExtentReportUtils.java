package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;

public class ExtentReportUtils implements ITestListener {



    public static void getScreentShot(WebDriver driver) throws IOException
    {
        Date currentdate = new Date();
        String screenshotfilename = currentdate.toString().replace(" ","-").replace(":","-");
        File screentshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File folder = new File("./screenshots");
        if(!folder.exists())
        {
            folder.mkdirs();
        }
        FileUtils.copyFile(screentshotfile,new File(folder+"/"+screenshotfilename+".png"));

    }


    public static ExtentReports extentReports;

    public static ExtentReports getReportInstance() {

        if (extentReports == null) {

            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

            String reportPath = System.getProperty("user.dir")
                    + "\\reports\\AutomationReport_" + timeStamp + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            sparkReporter.config().setReportName("Automation Test Report");
            sparkReporter.config().setDocumentTitle("Selenium Test Execution Report");

            extentReports = new ExtentReports();

            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo("Project Name", "Ecommerce Automation");
            extentReports.setSystemInfo("Tester", "Prasad");
            extentReports.setSystemInfo("Environment", "QA");
            extentReports.setSystemInfo("OS", "Windows");
            extentReports.setSystemInfo("Browser", "Chrome");
        }

        return extentReports;
    }

    public static void openReport(String reportPath) {

        File file = new File(reportPath);

        try {
            Desktop.getDesktop().browse(file.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
