package addadvertise;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AddAdvertisePage;
import pages.LoginPage;

public class AddAdvertiseTestCases extends BaseTests
{
    @Test (priority = 0)
    public void clickAddAdvertise()
    {
        AddAdvertisePage AddAdvertisePage = new AddAdvertisePage(driver);
        AddAdvertisePage.clickAddAdvertiseButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.insertMobile("238950");
        loginPage.clickOnNextButton();
        loginPage.insertOTP("229534");
        loginPage.clickOnNext2Button();
    }
}