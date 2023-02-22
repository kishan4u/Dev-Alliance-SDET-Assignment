package Lab5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEvent {

    public static void main (String [] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.automationtesting.in/Register.html");

        WebElement element = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea"));

        // Create an Actions object
        Actions actions = new Actions(driver);

        Action build = actions.build();

        // Send various keyboard events to the element
       actions.sendKeys(element, "Test Keyboard event").perform();

       actions.keyDown(element, Keys.CONTROL).sendKeys(element, "Kishan").keyUp(Keys.CONTROL).build().perform();

      actions.keyDown(element, Keys.SHIFT).sendKeys(Keys.ARROW_LEFT).keyUp(Keys.SHIFT).build().perform();


    }
}
