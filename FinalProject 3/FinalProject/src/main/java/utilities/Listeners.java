
package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listeners implements ITestListener {

    private static ExtentReports extent =
            ExtentManager.getReportInstance();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = extent.createTest(
                result.getTestClass().getName()
                        + " :: "
                        + result.getMethod().getMethodName());

        ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest()
                .pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTestManager.getTest()
                .fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTestManager.getTest()
                .skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
        System.out.println("Report generated successfully");
    }
}
