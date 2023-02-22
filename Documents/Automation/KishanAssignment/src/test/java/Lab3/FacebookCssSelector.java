package Lab3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookCssSelector {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        // Search Username by css selector

        driver.findElement(By.cssSelector("input#email")).sendKeys("Kishan");

        // Search password by css selector

        driver.findElement(By.cssSelector("input#pass")).sendKeys("Tomar");

        // Search button by css selector

        driver.findElement(By.cssSelector("button[name=login]"));

    }
}
