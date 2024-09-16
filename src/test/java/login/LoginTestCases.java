package login;

import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTestCases extends BaseTests
{
    @Test
    public void loginMazadQatar()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        //driver.findElement(By.xpath("(//a[@class='logreg'])[1]")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginLink();
        loginPage.insertMobile("238950");
        //driver.findElement(By.name("phone")).sendKeys("238950");
        loginPage.clickOnNextButton();
        //driver.findElement(By.xpath("//button[@class='button']")).click();
        loginPage.insertOTP("229534");
        //driver.findElement(By.xpath("(//*[@class='phone_code'])[1]")).sendKeys("229534");
        loginPage.clickOnNext2Button();
        //driver.findElement(By.xpath("//*[@class='button']")).click();
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        driver.findElement(By.cssSelector(".langsection")).click();
        String actualARTitle=driver.getTitle();
        System.out.println(actualARTitle);
        driver.quit();
    }
}
