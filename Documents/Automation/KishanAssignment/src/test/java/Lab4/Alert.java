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
import java.util.concurrent.TimeUnit;

public class Alert {

    public static void main(String[] args){


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://nxtgenaiacademy.com/alertandpopup/");



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button =  driver.findElement(By.xpath("//button[@name ='alertbox']"));
        wait.until(ExpectedConditions.elementToBeClickable(button));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", button);


        //Accepting the simple alert

        driver.switchTo().alert().accept();




        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button2 =  driver.findElement(By.xpath("//button[@name ='confirmalertbox']"));
        wait.until(ExpectedConditions.elementToBeClickable(button));

        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();", button2);

        //Accepting the confirm alert box

        driver.switchTo().alert().dismiss();


        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button3 =  driver.findElement(By.xpath("//button[text() ='Prompt Alert Box']"));
        wait.until(ExpectedConditions.elementToBeClickable(button));

        JavascriptExecutor js2 = (JavascriptExecutor)driver;
        js2.executeScript("arguments[0].click();", button2);


        //Accepting the prompt alert box

        String alerttext = driver.switchTo().alert().getText();
        System.out.println("Alert box text is " + alerttext);






    }
}
