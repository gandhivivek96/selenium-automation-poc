package io.github.gandhivivek96.pages;

import io.github.gandhivivek96.utils.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BrowserUtility {

    private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']");
    private static final By SEARCH_BOX_LOCATOR = By.id("search_query_top");
    private static final By ADD_NEW_ADDRESS_LOCATOR = By.xpath("//a[@title='Add my first address']");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUsername()
    {
       return getVisibleText(USER_NAME_LOCATOR);
    }


    public SearchResultPage searchProductName(String productName)
    {
        enterText(SEARCH_BOX_LOCATOR,productName);
        enterSpecialKey(SEARCH_BOX_LOCATOR, Keys.ENTER);
        SearchResultPage searchResultPage = new SearchResultPage(getDriver());
        return searchResultPage;
    }

    public AddressPage goToAddressPage()
    {
        clickOn(ADD_NEW_ADDRESS_LOCATOR);
        AddressPage addressPage = new AddressPage(getDriver());
        return addressPage;
    }

}
