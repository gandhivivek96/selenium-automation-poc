package io.github.gandhivivek96.pages;

import io.github.gandhivivek96.constants.Browser;
import static io.github.gandhivivek96.constants.Env.*;
import io.github.gandhivivek96.utils.BrowserUtility;

import static io.github.gandhivivek96.utils.JSONUtility.readJson;
import static io.github.gandhivivek96.utils.PropertiesUtil.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtility {

    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");

    public HomePage(WebDriver driver) {
        super(driver);
        String url = "http://www.automationpractice.pl/index.php";
        goToWebsite(url);
    }
    public HomePage(String browserName) {
        super(browserName);
        String url = "http://www.automationpractice.pl/index.php";
        goToWebsite(url);
    }
    public HomePage(Browser browserName) {
        super(browserName);
//        properties util
//        goToWebsite(readProperty(QA,"URL"));

//        json util
         goToWebsite(readJson(QA).getUrl());
    }

    public LoginPage goToLoginPage()
    {
        maximizeWindow();
        clickOn(SIGN_IN_LINK_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }
}
