package org.example.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtillity {
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        String destinationPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
//        D:\Users\co02326\OneDrive - Oriental Bank\Desktop\UploadID\UploadID\front-1.JPG
//        src/java/com/example/screenshots/screenshotName1.png

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
