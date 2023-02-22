package Lab4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class MultipleWindows {

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.automationtesting.in/Windows.html");



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement element =  driver.findElement(By.xpath("//div[@id='Tabbed']/a/button"));

        wait.until(ExpectedConditions.elementToBeClickable(element));

        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();", element);

        String parent=driver.getWindowHandle();
        System.out.println(parent);

        Set<String> s=driver.getWindowHandles();
        System.out.println(s);


        //Handling multiple windows

        for (String screen: s) {
            System.out.println("Switching to window - > " + screen);
            driver.switchTo().window(screen);
        }



    }


}
