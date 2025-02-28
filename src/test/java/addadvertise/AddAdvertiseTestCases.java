package addadvertise;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.*;
import pages.AddAdvertiseStep2Page;

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
        System.out.println("Next button is clicked");
        AddAdvertiseStep3Page AddAdvertiseStep3Page = new AddAdvertiseStep3Page(driver);
        System.out.println("Step3Page is opened");
        AddAdvertiseStep3Page.clickAddPhotos();
        System.out.println("Add photo button is clicked");
        AddAdvertiseStep3Page.clickUploadPhoto();
    }
}