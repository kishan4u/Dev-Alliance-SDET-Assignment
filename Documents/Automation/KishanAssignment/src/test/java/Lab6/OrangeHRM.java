package Lab6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.*;

import javax.swing.*;

import static org.apache.poi.sl.usermodel.PresetColor.Orange;


public class OrangeHRM implements ITestListener {



    @BeforeClass
  //  @Test(priority = 0)
      public void launch() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

       // WebElement element = driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea"));

      OrangeHRM org = new OrangeHRM();
      org.getTitle(driver);
      driver.quit();
    }

    @Test
    public void getTitle(WebDriver driver) {

        String ActualTitle =driver.getTitle();
        System.out.println(ActualTitle);

        String ExpectedTitle ="OrangeHRM";

        //Validating the title of the page

        Assert.assertEquals(ExpectedTitle, ActualTitle);

        // Validate page URL for dashboard

        String URL = driver.getCurrentUrl();

        if(URL.contains("/login"))
            System.out.println("Page verified");
        else
            System.out.println("Page not verified");
    }




}
