package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddAdvertiseStep3Page
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AddAdvertiseStep3Page(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

   private final By addPhotosBtn = By.cssSelector(".file_input_label.margin-top-0");
   //  By.xpath("//span[@class='file_input_span']");

   //private final By addPhotosBtn = By.xpath("//p[contains(text(),'Add photos')]");

   public void clickAddPhotos()
   {
       wait.until(ExpectedConditions.presenceOfElementLocated(addPhotosBtn));
       driver.findElement(addPhotosBtn).click();
   }

   private final By uploadPhotoBtn = By.xpath("//h5[contains(text(), 'Upload From Device')]");

   public void clickUploadPhoto()
   {
       wait.until(ExpectedConditions.visibilityOfElementLocated(uploadPhotoBtn));
       WebElement photo = driver.findElement(uploadPhotoBtn);
       String filepath = "C:\\Users\\User\\Desktop";
       photo.sendKeys(filepath);
   }
}