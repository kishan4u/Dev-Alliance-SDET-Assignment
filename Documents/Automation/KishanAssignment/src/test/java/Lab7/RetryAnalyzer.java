package Lab7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer {


    @Test
    public void testMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
    }

    public class MyRetryAnalyzer implements IRetryAnalyzer {
        private int count = 0;
        private static final int MAX_RETRY_COUNT = 3;

        @Override
        public boolean retry(ITestResult result) {
            if (count < MAX_RETRY_COUNT) {
                count++;
                return true;
            }
            return false;
        }
    }

}
