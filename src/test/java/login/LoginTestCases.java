package login;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginTestCases extends BaseTests
{
   @Test (priority = 0)
      public void emptyMobileNumber()
   {
       LoginPage loginPage = new LoginPage(driver);
       loginPage.clickOnLoginLink();
       Assert.assertFalse(loginPage.checkNextButton(),"Empty Mobile Number cannot login test case is Pass");

   }

    @Test (priority = 1)
    public void wrongOTP()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginLink();
        loginPage.insertMobile("238950");
        loginPage.clickOnNextButton();
        loginPage.insertOTP("229533");
        loginPage.clickOnNext2Button();

    }

    @Test (priority = 2)
    public void validLogin()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginLink();
        loginPage.insertMobile("238950");
        loginPage.clickOnNextButton();
        loginPage.insertOTP("229534");
        loginPage.clickOnNext2Button();
        HomePage homePage = new HomePage(driver);
        String logoutexpectedname = "Logout";
        String logoutactualname = homePage.getLogoutName();
        assertEquals(logoutactualname,logoutexpectedname);

    }


}
