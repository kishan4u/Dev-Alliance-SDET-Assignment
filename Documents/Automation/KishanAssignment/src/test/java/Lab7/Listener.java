package Lab7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class Listener implements ITestListener {
   WebDriver driver;
    @Test
    public void launch() throws FileNotFoundException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

    }
    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("Test case " + result.getMethod().getMethodName() + " failed.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("Test case " + result.getMethod().getMethodName() + " passed.");
        printPageTitle();
    }

    private void printPageTitle() {
        String pageTitle = driver.getTitle();
        System.out.println("Page title: " + pageTitle);

}}

