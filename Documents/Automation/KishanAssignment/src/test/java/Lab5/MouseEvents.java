package Lab5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MouseEvents {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.automationtesting.in/Register.html");


        Actions click = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[6]/a"));
       // Action action = click.build();
        click.moveToElement(element).perform();

       WebElement element1 = driver.findElement(By.xpath("//a[text()='Drag and Drop ']"));
       click.moveToElement(element1).perform();

       WebElement element2 = driver.findElement(By.xpath("//ul[@class='childmenu ']/li[1]/a"));

       // Select drop =new Select(element);
        //drop.selectByVisibleText("Drag and Drop");
       //  mouse hover

       click.moveToElement(element2).click().perform();



      //  WebElement element2 = driver.findElement(By.xpath(""));





    }
}
