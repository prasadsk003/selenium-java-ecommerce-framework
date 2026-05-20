package testcases;

import BasePackage.BaseTest;
import BasePackage.testCasePage;
import org.testng.annotations.Test;

public class testCase extends BaseTest {
    @Test
    public void verifytestCasePage()
    {
        testCasePage t1 = new testCasePage(driver);
        t1.selecttestcase();
       int total =  t1.getTotaltestCasecount();
       BaseTest.test.info("Total test cases are"+ total);

    }
}
