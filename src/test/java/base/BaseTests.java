package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public class BaseTests
{
    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.get("https://newwebsite.mzadqatar.com/en");
    }

@AfterClass
public void tearDown()
{
    driver.quit();
}
}
