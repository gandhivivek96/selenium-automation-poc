package io.github.gandhivivek96.tests;

import io.github.gandhivivek96.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.github.gandhivivek96.constants.Size.L;

@Listeners({ io.github.gandhivivek96.listeners.TestListener.class })
public class ProductCheckoutTest extends TestBase{
    private static final String SEARCH_TERM = "Printed Summer dress";

    private SearchResultPage searchResultPage;

    @BeforeMethod(description = "User Logs into the application and searches for a product")
    public void setup(){
        searchResultPage = homePage.goToLoginPage().doLoginwith("bakomam596@skrak.com", "password").searchProductName(SEARCH_TERM);
    }

    @Test(description = "Verify if the logged in User is able to buy a dress", groups = { "e2e", "smoke", "sanity" })
    public void checkoutTest() {

        String result = searchResultPage.clickOnTheProductAtIndex(0).changeSize(L).addProductToCart().proceedToCheckout().goToConfirmAddressPage().goToShippmentPage().goToPaymentPage().makePaymentByWire();
        Assert.assertTrue(result.contains("complete"));
    }
}
