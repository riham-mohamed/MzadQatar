package addadvertise;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AddAdvertisePage;
import pages.AddAdvertiseStep2Page;
import pages.AddAdvertiseStep2Page;
import pages.LoginPage;

public class AddAdvertiseTestCases extends BaseTests
{
    @Test (priority = 0)
    public void addValidAdvertise()
    {
        AddAdvertisePage AddAdvertisePage = new AddAdvertisePage(driver);
        AddAdvertisePage.clickAddAdvertiseButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.insertMobile("238950");
        loginPage.clickOnNextButton();
        loginPage.insertOTP("229534");
        loginPage.clickOnNext2Button();
        AddAdvertisePage.selectAdvertiseLanguage();
        AddAdvertisePage.selectAdvertiseCategory();
        AddAdvertisePage.clickStep1NextButton();
        AddAdvertiseStep2Page AddAdvertiseStep2Page = new AddAdvertiseStep2Page(driver);
        AddAdvertiseStep2Page.selectAdSubCategories();
        AddAdvertiseStep2Page.selectAdType();
        AddAdvertiseStep2Page.selectAdCity();
        AddAdvertiseStep2Page.clickStep2NextButton();
    }
}