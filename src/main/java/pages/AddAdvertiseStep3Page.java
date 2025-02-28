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

   private final By addPhotosBtn = By.xpath("//span[@class='file_input_span']");
   //  By.cssSelector(".file_input_label.margin-top-0");

   public void clickAddPhotos()
   {
       wait.until(ExpectedConditions.visibilityOfElementLocated(addPhotosBtn));
       driver.findElement(addPhotosBtn).click();
   }

   private final By uploadPhotoBtn = By.xpath("//input[@class='file_input']");

   private final By closeBtn = By.xpath("(//button[@class='close'])[1]");

   public void clickUploadPhoto()
   {
       wait.until(ExpectedConditions.visibilityOfElementLocated(uploadPhotoBtn));
       WebElement photo = driver.findElement(uploadPhotoBtn);
       String filepath = "C:\\Users\\User\\Desktop\\Capture.PNG";
       photo.sendKeys(filepath);
       driver.findElement(closeBtn).click();

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement newSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-draggable='true']")));
       if (newSection.isDisplayed()) {
           System.out.println("File uploaded successfully!");
       } else {
           System.out.println("File upload failed.");
       }
   }
}