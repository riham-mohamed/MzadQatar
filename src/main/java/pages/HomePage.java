package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

private final By logoutButton = By.xpath("//p[@class='logreg']");

    public String getLogoutName()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        String logoutButtonName;
        logoutButtonName = driver.findElement(logoutButton).getText();
        return logoutButtonName;
    }

}
