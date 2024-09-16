package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class BaseTests
{
    protected WebDriver driver;

    @BeforeClass
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

@AfterClass
public void tearDown()
{
    driver.quit();
}

@BeforeMethod
public void goHome()
{
    driver.get("https://newwebsite.mzadqatar.com/en/login");
}

}
