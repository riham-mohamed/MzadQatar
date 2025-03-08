package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MethodHandles;

import java.time.Duration;
import java.util.List;

public class HomePage extends MethodHandles {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public HomePage(WebDriver driver)
    {
       super(driver);
       this.driver=driver;
    }

private final By profileDDL = By.cssSelector(".all_action_dropdown");

private final By logoutButton = By.cssSelector(".logreg");

private final By logoutConfirmation = By.cssSelector(".transparent_btn.logout_btn");

private final By languageButton = By.xpath("//a[contains(@class, 'langsection')]");

private final By homeMainHeadFieldtext = By.xpath("//p[@class='mainshopmenuinfo']");

    public void switchLang()
    {
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
     WebElement langBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(languageButton));
     ((JavascriptExecutor) driver).executeScript("arguments[0].click();", langBtn);
     }

    public void clickOnLogoutButton()
    {
        explicitWait(profileDDL,10);
        click(profileDDL);
        explicitWait(logoutButton,10);
        click(logoutButton);
    }

    public String getLogoutConfirmation()
    {
        explicitWait(logoutConfirmation,10);
        List<WebElement> elements = driver.findElements(logoutConfirmation);
        String firstelement;
        return firstelement = elements.get(0).getText();
    }

    public void confirmLogout()
    {
        explicitWait(logoutConfirmation,10);
        List<WebElement> elements = driver.findElements(logoutConfirmation);
        elements.get(0).click();
    }

    public String getMainHeadText()
    {
        explicitWait(homeMainHeadFieldtext,30);
        WebElement element = webElement(homeMainHeadFieldtext);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].textContent;", element);
    }
}
