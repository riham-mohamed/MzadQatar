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
}
