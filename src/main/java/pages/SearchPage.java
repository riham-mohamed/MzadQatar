package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchPage

{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    private final By searchTextBox = By.id("headerinput");

    private final By selectCategory = By.xpath("//p[contains(text(),'In all categories')]");

    private final By searchresults = By.xpath("(//h3[contains(text(),'test')])[1]");

    public void writeSearchText(String searchtext)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox));
        driver.findElement(searchTextBox).sendKeys(searchtext);
    }

    public void selectSearchCategory()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectCategory));
        driver.findElement(selectCategory).click();
    }

    public String validateSearchResults()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchresults));
        String searchreultstext = driver.findElement(searchresults).getText();
        return searchreultstext;
    }
}

