package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageTitleTest() {
        Assert.assertEquals(homePage.getHomePageTitle(), "Your Store");
    }

    @DataProvider
    public Object[][] testData() {
        return new Object [][]{
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }

    @Test(dataProvider = "testData")
    public void productSearchTest(String productName) {
        String  pageHeader = homePage.doSearch(productName);
        Assert.assertEquals(pageHeader, "Search - " + productName);
    }
}
