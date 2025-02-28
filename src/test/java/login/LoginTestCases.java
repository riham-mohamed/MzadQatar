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
        loginPage.insertMobile("14755555");
        loginPage.clickOnNextButton();
        loginPage.insertOTP("111111");
        HomePage homePage = loginPage.clickOnNext2Button();
        String expectedwrongOTP = "The user credentials were incorrect.";
        String actualwrongOTP = loginPage.getWrongOTPMessage();
        assertEquals(actualwrongOTP,expectedwrongOTP);
    }

    @Test (priority = 2)
    public void validLogin()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginLink();
        loginPage.insertMobile("14755555");
        loginPage.clickOnNextButton();
        loginPage.insertOTP("123456");
        HomePage homePage = loginPage.clickOnNext2Button();
        String mainHeaderText = homePage.getMainHeadText();
        String expectedhomepagetext = "Bid now & win the auction";
        assertEquals(mainHeaderText,expectedhomepagetext);
    }

    @Test (priority = 3)
    public void switchLang()
    {
        HomePage homePage = new HomePage(driver);
        homePage.switchLang();
        String mainHeaderText = homePage.getMainHeadText();
        String expectedhomepagetext = "زاود بأعلى سعر و اكسب المزاد";
        assertEquals(mainHeaderText,expectedhomepagetext);
    }

    @Test (priority = 4)
    public void validLogoutConfirmation()
    {
        validLogin();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLogoutButton();
        String actuallogoutconfirmation = homePage.getLogoutConfirmation();
        String expectedlogoutconfirmation = "Yes";
        assertEquals(actuallogoutconfirmation,expectedlogoutconfirmation);
    }

    @Test (priority = 5)
    public void confirmLogout()
    {
        validLogin();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLogoutButton();
        homePage.confirmLogout();
        LoginPage loginPage = new LoginPage(driver);
        String actuallogintext = loginPage.getLoginText();
        String expectedlogintext = "Login";
        assertEquals(actuallogintext,expectedlogintext);
    }
}