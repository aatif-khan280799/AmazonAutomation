package org.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.AmazonHomePage;
import org.example.pages.AmazonSearchResultsPage;
import org.example.utilities.ExcelUtility;
import org.example.utilities.ExtentManager;
import org.example.utilities.ScreenshotUtillity;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.time.Duration;

public class AmazonSearchTest {
    WebDriver driver;
    AmazonHomePage amazonHomePage;
    AmazonSearchResultsPage amazonSearchResultsPage;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setExtent(){
        extent = ExtentManager.getExtentReports();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        Thread.sleep(10000);

        amazonHomePage = new AmazonHomePage(driver);
        amazonSearchResultsPage = new AmazonSearchResultsPage(driver);
    }

    @DataProvider(name = "excelData")
    public Object[][] getData() throws IOException {
        String filePath = "data/file.xlsx";
        String sheetName = "Sheet1";
        return ExcelUtility.getExcelData(filePath, sheetName);
    }

    @Test(dataProvider = "excelData")
    public void searchProduct(String productName)  {
        test = ExtentManager.createTest("Search Product: " + productName);
        amazonHomePage.searchProduct(productName);
        test.log(Status.INFO, "Searching for product: " + productName);

        amazonSearchResultsPage.clickFirstProduct();
        test.log(Status.INFO, "Clicked on the first product in search results");
//        ScreenshotUtillity.captureScreenshot(driver, productName);

    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            String screenshotPath = ScreenshotUtillity.captureScreenshot(driver, result.getName());
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
            test.addScreenCaptureFromPath(screenshotPath, result.getName());
        }else if (result.getStatus() == ITestResult.SUCCESS){
            String screenshotPath = ScreenshotUtillity.captureScreenshot(driver, result.getName());
            test.log(Status.PASS, "Test Passed");
            test.addScreenCaptureFromPath(screenshotPath, result.getName());

        }else if(result.getStatus() == ITestResult.SKIP){
            String screenshotPath = ScreenshotUtillity.captureScreenshot(driver, result.getName());
            test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
            test.addScreenCaptureFromPath(screenshotPath, result.getName());
        }
        driver.quit();
    }

    @AfterTest
    public void endReport(){
        ExtentManager.flushDownReport();
    }
}
