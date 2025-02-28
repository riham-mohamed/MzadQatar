package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

private final By profileDDL = By.cssSelector(".all_action_dropdown");

private final By logoutButton = By.cssSelector(".logreg");

private final By logoutConfirmation = By.cssSelector(".transparent_btn.logout_btn");

private final By languageButton = By.xpath("//a[contains(@class, 'langsection')]");

private final By homeMainHeadFieldtext = By.xpath("//p[@class='mainshopmenuinfo']");

    public void switchLang()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement langBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(languageButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", langBtn);
    }

    public void clickOnLogoutButton()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileDDL));
        driver.findElement(profileDDL).click();
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

    public String getMainHeadText()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeMainHeadFieldtext));
        WebElement element = driver.findElement(homeMainHeadFieldtext);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].textContent;", element);
    }
}
