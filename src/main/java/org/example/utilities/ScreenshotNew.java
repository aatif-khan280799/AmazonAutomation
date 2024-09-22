package org.example.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenshotNew {
    public static WebDriver driver;
    public static void captureNewScreenshot() throws IOException {
        Date d = new Date();
        String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File(System.getProperty("user.dir") + "/screenshots/" + FileName));

    }
}
//    D:\Users\co02326\Desktop\Cohort008\AmazonAutomation\screenshots
