package Lab6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class HRMAdmin {

    @Test
    public void launch() throws FileNotFoundException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");


        FileInputStream fis = new FileInputStream("/Users/kishantomar/IdeaProjects/KishanAssignment/src/test/java/Config/Config.properties");
        Properties prop = new Properties();

        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading data from property file

        String user = prop.getProperty("Username");
        String pword = prop.getProperty("Password");
        //login

        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5));

      WebElement field =  driver.findElement(By.xpath("//input[@name='username']"));
      field.sendKeys(user);

        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5));
      WebElement field1 =   driver.findElement(By.xpath("//input[@name='password']"));
        field1.sendKeys(pword);

       WebElement field2 =  driver.findElement(By.xpath("//button[@type='submit']"));
        field2.click();


        // Search functionality is not working on site




         WebElement search = driver.findElement(By.xpath("//div[@class='oxd-input-group__label-wrapper']/following::div/input[@class='oxd-input oxd-input--active']"));
         search.sendKeys("Newboo");

        WebElement search2 = driver.findElement(By.xpath("//button[@type='submit']"));
        search2.click();



    }


}
