package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AmazonSearchResultsPage {
    WebDriver driver;
    By firstProduct = By.cssSelector("div.s-main-slot div[data-index='0']");

    public AmazonSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFirstProduct() {
        driver.findElement(firstProduct).click();
    }
//    body > div:nth-child(1) > div:nth-child(27) > div:nth-child(9) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2) > div:nth-child(1) > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1) > a:nth-child(1) > span:nth-child(1)
}
