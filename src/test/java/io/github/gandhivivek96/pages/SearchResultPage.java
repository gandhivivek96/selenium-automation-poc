package io.github.gandhivivek96.pages;

import io.github.gandhivivek96.utils.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class SearchResultPage  extends BrowserUtility  {

    private static final By SEARCH_HEADING_LOCATOR = By.xpath("//span[@class='lighter']");
    private static final By PRODUCT_LIST_LOCATOR =  By.xpath("//h5[@itemprop='name']/a");

    SearchResultPage(WebDriver driver)
    {
        super(driver);
    }

    public String getSearchResultitle()
    {
        return getVisibleText(SEARCH_HEADING_LOCATOR);
    }

    public boolean getAllVisibleProductNames(String searchName)
    {
        List<String> keywordList = Arrays.asList(searchName.toLowerCase().split(" "));

        List<String> productList = getAllVisibleText(PRODUCT_LIST_LOCATOR);
        boolean result = productList.stream()
                .anyMatch( name -> (keywordList.stream().anyMatch( name.toLowerCase()::contains )));
       return result;

    }

    public ProductDetailPage clickOnTheProductAtIndex(int index) {
        clickOn(getAllElements(PRODUCT_LIST_LOCATOR).get(index));
        ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
        return productDetailPage;

    }

}
