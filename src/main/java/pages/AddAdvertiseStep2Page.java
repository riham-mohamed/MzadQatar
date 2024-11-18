package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    private final By adSubCategories = By.xpath("//select[@class='form-control select2-hidden-accessible' and @data-select2-id='1']");

    public void selectAdSubCategories()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adSubCategories));
        WebElement adsubcategories = driver.findElement(adSubCategories);
        Select adtsubcategoriesselect = new Select (adsubcategories);
        adtsubcategoriesselect.selectByVisibleText("Cars");
    }

    private final By adType = By.xpath("//select[@class='form-control select2-hidden-accessible' and @data-select2-id='43']");

    public void selectAdType()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adType));
        WebElement adtype = driver.findElement(adType);
        Select adtypeselect = new Select (adtype);
        adtypeselect.selectByVisibleText("Inquire");
    }

    private final By adCity = By.xpath("//select[@class='form-control select2-hidden-accessible' and @data-select2-id='46']");

    public void selectAdCity()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adCity));
        WebElement adcity = driver.findElement(adCity);
        Select adcityselect = new Select(adcity);
        adcityselect.selectByVisibleText("test area");
    }

    private final By step2NextButton = By.xpath("//button[contains(text(), 'Next')]");

    public AddAdvertiseStep3Page clickStep2NextButton()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(step2NextButton));
        driver.findElement(step2NextButton).click();
        return new AddAdvertiseStep3Page(driver);
    }
}
