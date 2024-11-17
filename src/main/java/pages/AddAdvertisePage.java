package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddAdvertisePage

{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AddAdvertisePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    private final By addAdvertiseButton = By.xpath("//button[@class='header_search_button' and text()='Add advertise']");

    public void clickAddAdvertiseButton()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addAdvertiseButton));
        driver.findElement(addAdvertiseButton).click();
    }

    private final By advertiseLanguage = By.xpath("//p[contains(text(), 'Your advert will appear for all people')]");

    public void selectAdvertiseLanguage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(advertiseLanguage));
        driver.findElement(advertiseLanguage).click();
    }

    private final By advertiseCategory = By.id("category-2");

    public void selectAdvertiseCategory()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(advertiseCategory));
        driver.findElement(advertiseCategory).click();
    }

    private final By step1NextButton = By.xpath("(//button[contains(text(), 'Next')])[2]");

    public AddAvertiseStep2Page clickStep1NextButton()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(step1NextButton));
        driver.findElement(step1NextButton).click();
        return new AddAvertiseStep2Page(driver);
    }
}
