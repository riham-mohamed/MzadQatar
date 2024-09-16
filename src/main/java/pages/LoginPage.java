package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
WebDriver driver;

public LoginPage(WebDriver driver)
{
    this.driver=driver;
}

private final By loginLink =  By.xpath("(//a[@class='logreg'])[1]");

private final By mobileField = By.name("phone");

private final By nextButton = By.xpath("//button[@class='button']");

private final By otpField = By.xpath("(//*[@class='phone_code'])[1]");

private final By next2Button = By.xpath("//*[@class='button']");

public void clickOnLoginLink()
    {
        driver.findElement(loginLink).click();

    }

public void insertMobile(String mobilefield)
    {
        driver.findElement(mobileField).sendKeys(mobilefield);
    }

public void clickOnNextButton()
    {
        driver.findElement(nextButton).click();
    }

public void insertOTP(String OTPfield)
    {
        driver.findElement(otpField).sendKeys(OTPfield);
    }

public void clickOnNext2Button()
    {
        driver.findElement(next2Button).click();
    }
}
