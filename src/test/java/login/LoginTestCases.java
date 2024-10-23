package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

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
        String expectedwrongOTP = "The user credentials were incorrect.";
        String actualwrongOTP = loginPage.getWrongOTPMessage();
        assertEquals(actualwrongOTP,expectedwrongOTP);
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

    @Test (priority = 3)
    public void switchLang()
    {
        HomePage homePage = new HomePage(driver);
        homePage.switchLang();
        homePage.clickOnLogoutButton();
        String actuallogoutconfirmationar = homePage.getLogoutConfirmation();
        String expectedlogoutconfirmationar = "نعم";
        assertEquals(actuallogoutconfirmationar,expectedlogoutconfirmationar);
    }

    @Test (priority = 4)
    public void validLogoutConfirmation()
    {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLogoutButton();
        String actuallogoutconfirmation = homePage.getLogoutConfirmation();
        String expectedlogoutconfirmation = "نعم";
        assertEquals(actuallogoutconfirmation,expectedlogoutconfirmation);
    }

    @Test (priority = 5)
    public void confirmLogout()
    {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLogoutButton();
        homePage.confirmLogout();
        LoginPage loginPage = new LoginPage(driver);
        String actuallogintext = loginPage.getLoginText();
        String expectedlogintext = "تسجيل الدخول";
        assertEquals(actuallogintext,expectedlogintext);
    }
}