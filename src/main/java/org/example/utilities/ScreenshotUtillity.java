package org.example.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class ScreenshotUtillity {

    // Get the current timestamp
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd_HHmmss");
    static String timestamp = dateFormat.format(new Date());
    static long now = Instant.now().toEpochMilli();


    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        String destinationPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + now +".png"  ;

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        try {
            Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/screenshots/"));
            Files.copy(source.toPath(), new File(destinationPath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinationPath;

    }
}
