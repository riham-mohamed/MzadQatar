package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class MethodHandles
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public MethodHandles(WebDriver driver)
    {
        this.driver=driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    protected WebElement webElement(By locator)
    {
        return driver.findElement(locator);
    }

    protected void explicitWait(By locator, int time)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(driver -> {
            WebElement element = webElement(locator);
            return element.isDisplayed() && element.isEnabled();
        });
    }

    protected WebElement findElementWithRetry(By locator)
    {
        int attempts = 0;
        WebElement element = null;
        while (attempts < 3) {
            try {
                element = driver.findElement(locator);
                return element;
            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying due to stale element... Attempt " + (attempts + 1));
            } catch (NoSuchElementException e) {
                System.out.println("Element not found: " + locator.toString());
                break;
            }
            attempts++;
        }
        return null;
    }

    protected void click(By locator)
    {
        webElement(locator).click();
    }

    protected void sendKeys(By locator, String text)
    {
        webElement(locator).sendKeys(text);
    }

    protected String getText(By locator)
    {
        return webElement(locator).getText();
    }
}
