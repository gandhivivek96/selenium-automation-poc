package io.github.gandhivivek96.tests;

import io.github.gandhivivek96.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ io.github.gandhivivek96.listeners.TestListener.class })
public class SearchProductTest extends TestBase{

    private MyAccountPage myAccountPage;
    private static final String SEARCH_PRODUCT_NAME = "Printed Summer Dress";

    @BeforeMethod(description = "valid user login")
    public void setUp()
    {
       myAccountPage= homePage.goToLoginPage().doLoginwith("koyene5739@oziere.com","password");
    }

    @Test(description = "verifying product search" , groups={"ete","smoke","sanity"})
    public void verifyProductSearchTest() throws Exception
    {
//        String data = myAccountPage.searchProductName("Printed Summer Dress").getSearchResultitle();
        boolean result= myAccountPage.searchProductName(SEARCH_PRODUCT_NAME).getAllVisibleProductNames(SEARCH_PRODUCT_NAME);
        Assert.assertEquals(result,true);

    }
}
