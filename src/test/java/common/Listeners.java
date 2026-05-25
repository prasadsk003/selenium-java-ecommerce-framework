package common;

import BasePackage.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utilities.ExtentReportUtils;

import java.io.IOException;

public class Listeners extends ExtentReportUtils implements ITestListener {

    ExtentReports report =
            ExtentReportUtils.getReportInstance();
    //ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {
        // not implemented
        BaseTest.test = report.createTest(result.getName());
    }


    public void onTestSuccess(ITestResult result) {
        // not implemented
        String methodName = result.getMethod().getMethodName();
        BaseTest.test.pass(methodName+"Got passed");

    }

    /**
     * Invoked each time a test fails.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#FAILURE
     */
    public void onTestFailure(ITestResult result) {
        // not implemented
        System.out.println("Screenshot captured");
        try {
            BaseTest test = (BaseTest) result.getInstance();
            result.getThrowable().getMessage();

            ExtentReportUtils.getScreentShot(test.driver);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Invoked each time a test is skipped.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SKIP
     */
    public void onTestSkipped(ITestResult result) {
        // not implemented
    }

    /**
     * Invoked each time a method fails but has been annotated with successPercentage and this failure
     * still keeps it within the success percentage requested.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
     */
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

    /**
     * Invoked each time a test fails due to a timeout.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     */
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    /**
     * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt;
     * tag and calling all their Configuration methods.
     *
     * @param context The test context
     */
    public void onStart(ITestContext context) {
        // not implemented
    }

    /**
     * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
     * run and all their Configuration methods have been called.
     *
     * @param context The test context
     */
    public void onFinish(ITestContext context) {
        // not implemented
        report.flush();
    }



}

