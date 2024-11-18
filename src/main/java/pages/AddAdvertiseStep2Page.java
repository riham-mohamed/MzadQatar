package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddAdvertiseStep2Page
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AddAdvertiseStep2Page(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    private final By adSubCategories = By.xpath("(//span[contains(@class, 'select2-selection--single')])[1]");

    public void selectAdSubCategories()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adSubCategories));
        WebElement adsubcategories = driver.findElement(adSubCategories);
        adsubcategories.click();
        adsubcategories.sendKeys(Keys.ARROW_DOWN);
        adsubcategories.sendKeys(Keys.ENTER);
        //Select adtsubcategoriesselect = new Select (adsubcategories);
        //adtsubcategoriesselect.selectByVisibleText("Cars");
    }

    private final By adType = By.xpath("(//span[contains(@class, 'select2-selection--single')])[2]");

    public void selectAdType()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adType));
        WebElement adtype = driver.findElement(adType);
        adtype.click();
        adtype.sendKeys(Keys.ARROW_DOWN);
        adtype.sendKeys(Keys.ENTER);
        //Select adtypeselect = new Select (adtype);
        //adtypeselect.selectByVisibleText("Inquire");
    }

   private final By adCity = By.xpath("(//span[contains(@class, 'select2-selection--single')])[3]");

    public void selectAdCity()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adCity));
        WebElement adcity = driver.findElement(adCity);
        adcity.click();
        adcity.sendKeys(Keys.ARROW_DOWN);
        adcity.sendKeys(Keys.ARROW_DOWN);
        adcity.sendKeys(Keys.ENTER);
    }

    private final By step2NextButton = By.cssSelector(".next_btn.first.disabled.custom_margin_b");

    public AddAdvertiseStep3Page clickStep2NextButton()
    {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(step2NextButton));
       // driver.findElement(step2NextButton).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement button = driver.findElement(step2NextButton);
        js.executeScript("arguments[0].click();",button);
        return new AddAdvertiseStep3Page(driver);
    }
}
