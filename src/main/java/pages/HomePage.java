package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

private final By logoutConfirmation = By.cssSelector(".transparent_btn.logout_btn");

private final By languageButton = By.cssSelector("p[data-v-4f1c2f74='']");

    public String getLogoutName()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        String logoutButtonName;
        logoutButtonName = driver.findElement(logoutButton).getText();
        return logoutButtonName;
    }

    public void switchLang()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(languageButton));
        List<WebElement> elements = driver.findElements(languageButton);
        elements.get(2).click();
    }

    public void clickOnLogoutButton()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
    }

    public String getLogoutConfirmation()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutConfirmation));
        List<WebElement> elements = driver.findElements(logoutConfirmation);
        String firstelement;
        return firstelement = elements.get(0).getText();
    }

    public void confirmLogout()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutConfirmation));
        List<WebElement> elements = driver.findElements(logoutConfirmation);
        elements.get(0).click();
    }

}
