package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MethodHandles;

import java.time.Duration;

public class LoginPage extends MethodHandles
{
protected WebDriver driver;
protected WebDriverWait wait;

public LoginPage(WebDriver driver)
{
    super(driver);
    this.driver=driver;
    PageFactory.initElements(driver,this);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
}

private final By profileDDL = By.cssSelector(".all_action_dropdown");

private final By loginLink =  By.xpath("(//a[@class='logreg'])[1]");

private final By mobileField = By.name("phone");

private final By nextButton = By.xpath("//button[@class='button']");

private final By wrongOTPMsg = By.cssSelector(".text-red-500.text-xs.mt-1");

private final By otpField = By.xpath("(//*[@class='phone_code'])[1]");

private final By next2Button = By.xpath("//*[@class='button']");

public void clickOnLoginLink()
    {
       explicitWait(profileDDL,60);
       findElementWithRetry(profileDDL);
       click(profileDDL);
       explicitWait(loginLink,10);
       click(loginLink);
    }

public void insertMobile(String mobilefield)
    {
       explicitWait(mobileField,10);
       sendKeys(mobileField,mobilefield);
    }

public void clickOnNextButton()
    {
       click(nextButton);
    }

public boolean checkNextButton()
{
    wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
    return driver.findElement(nextButton).isEnabled();
}

public void insertOTP(String OTPfield)
    {
        explicitWait(otpField,10);
        sendKeys(otpField,OTPfield);
    }

public String getWrongOTPMessage()
{
    explicitWait(wrongOTPMsg,10);
    return getText(wrongOTPMsg);
}

public HomePage clickOnNext2Button()
    {
       explicitWait(nextButton,10);
       click(next2Button);
       return new HomePage(driver);
    }

public String getLoginText()
{
    explicitWait(profileDDL,10);
    click(profileDDL);
    explicitWait(loginLink,10);
    return getText(loginLink);
}
}