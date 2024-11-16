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
}
