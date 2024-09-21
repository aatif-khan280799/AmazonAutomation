package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonSearchResultsPage {
    WebDriver driver;
    public AmazonSearchResultsPage(WebDriver driver){
        this.driver = driver;
    }
    By firstProduct = By.cssSelector("div.s-main-slot div[data-index='0']");
    public void clickFirstProduct(){
        driver.findElement(firstProduct).click();
    }
}
