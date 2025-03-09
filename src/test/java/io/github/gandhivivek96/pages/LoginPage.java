package io.github.gandhivivek96.pages;

import io.github.gandhivivek96.utils.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BrowserUtility {

    private static final By EMAIL_LOCATOR = By.id("email");
    private static final By PASSWORD_LOCATOR = By.id("passwd");
    private static final By SIGN_IN_BUTTON_LOCATOR = By.id("SubmitLogin");
    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,'alert-danger')]/ol/li");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginwith(String email, String password)
    {
        enterText(EMAIL_LOCATOR,email);
        enterText(PASSWORD_LOCATOR,password);
        clickOn(SIGN_IN_BUTTON_LOCATOR);
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        return myAccountPage;
    }

    public LoginPage doLoginWithInvalidCredentials(String email, String password)
    {
        enterText(EMAIL_LOCATOR,email);
        enterText(PASSWORD_LOCATOR,password);
        clickOn(SIGN_IN_BUTTON_LOCATOR);
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }

    public String getErrorMessage()
    {
        return getVisibleText(ERROR_MESSAGE_LOCATOR);
    }
}
