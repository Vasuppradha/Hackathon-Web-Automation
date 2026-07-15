package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if(extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("C:/Users/2497740/IdeaProjects/FinalProject/Reports/ExtentReport.html");

            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Regression Suite");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}


