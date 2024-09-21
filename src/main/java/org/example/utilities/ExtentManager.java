package org.example.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private static ExtentTest test;


    public static ExtentReports getExtentReports(){
        if (extent == null){
            ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("HostName", "Cohort008");
            extent.setSystemInfo("Execution by", "Aatif");

        }
        return extent;
    }

    public static ExtentTest createTest(String testName){
        test = getExtentReports().createTest(testName);
        return test;
    }

    public static void flushDownReport(){
        if(extent != null){
            extent.flush();
        }
    }

}
