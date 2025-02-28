package search;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTestCases extends BaseTests
{
    @Test (priority = 0)
    public void validSearch()
    {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.writeSearchText("test");
        searchPage.selectSearchCategory();
        String actualsearchresult = searchPage.validateSearchResults();
        Assert.assertTrue(actualsearchresult.contains("test"));
    }

    @Test (priority = 1)
    public void validAntiqueSearch()
    {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.writeSearchText("test");
        searchPage.selectAntiquesCategory();
        String actualantiquessearchresult = searchPage.validateAntiquesSearchResults();
        Assert.assertTrue(actualantiquessearchresult.contains("test"));
    }

    @Test (priority = 2)
    public void validNoSearchResults()
    {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.writeSearchText("hello");
        String actualnosearchresult = searchPage.validateNoSearchResults();
        String expectednosearchresult = "Search results are empty";
        Assert.assertEquals(actualnosearchresult,expectednosearchresult);
    }
}