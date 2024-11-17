package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddAvertiseStep2Page
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AddAvertiseStep2Page(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    private final By adType = By.xpath("//select[@class='form-control select2-hidden-accessible' and @data-select2-id='1']");

    public void selectAdType()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adType));
        WebElement adTypeselect = driver.findElement(adType);
        Select adtypeselect = new Select (adTypeselect);
        adtypeselect.selectByVisibleText("Sale");
    }
}
