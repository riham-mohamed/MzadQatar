package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage
{
protected WebDriver driver;
protected WebDriverWait wait;

public LoginPage(WebDriver driver)
{
    this.driver=driver;
    PageFactory.initElements(driver,this);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
}

private final By loginLink =  By.xpath("(//a[@class='logreg'])[1]");

private final By mobileField = By.name("phone");

private final By nextButton = By.xpath("//button[@class='button']");

private final By wrongOTPMsg = By.cssSelector(".text-red-500.text-xs.mt-1");

private final By otpField = By.xpath("(//*[@class='phone_code'])[1]");

private final By next2Button = By.xpath("//*[@class='button']");

public void clickOnLoginLink()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
        driver.findElement(loginLink).click();
    }

public void insertMobile(String mobilefield)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileField));
        driver.findElement(mobileField).sendKeys(mobilefield);
    }

public void clickOnNextButton()
    {
        driver.findElement(nextButton).click();
    }

public boolean checkNextButton()
{
    wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
    return driver.findElement(nextButton).isEnabled();
}

public void insertOTP(String OTPfield)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(otpField));
        driver.findElement(otpField).sendKeys(OTPfield);
    }

public String getWrongOTPMessage()
{
    wait.until(ExpectedConditions.visibilityOfElementLocated(wrongOTPMsg));
    return driver.findElement(wrongOTPMsg).getText();
}

public HomePage clickOnNext2Button()
    {
        driver.findElement(next2Button).click();
        return new HomePage(driver);
    }

public String getLoginText()
{
    wait.until(ExpectedConditions.visibilityOfElementLocated(loginLink));
    return driver.findElement(loginLink).getText();
}

}
