import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Trivago {
    public  static void main(String[] args) throws InterruptedException {
        WebDriver driver  = new ChromeDriver();
        driver.get("https://www.trivago.in");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement search = driver.findElement(By.xpath("//input[@id='input-auto-complete']"));
        Actions action = new Actions(driver);
        action.moveToElement(search).click().build().perform();
        System.out.println(search.isDisplayed());
        search.sendKeys("Mumbai");
//        WebElement firstoptoin = driver.findElement(By.xpath("//li[@data-item-pos='0'"));
//        action.moveToElement(firstoptoin);
//        firstoptoin.click();
        Thread.sleep(5000);
//        WebElement checkInDate = driver.findElement(By.xpath("//time[@datetime='2024-10-15']"));
//        checkInDate.click();
        Thread.sleep(5000);
        driver.quit();
    }
}
////*[@id="suggestion-list"]/ul/li[1]/div
