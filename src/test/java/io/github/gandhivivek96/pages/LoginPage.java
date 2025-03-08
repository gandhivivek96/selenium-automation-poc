package io.github.gandhivivek96.pages;

import io.github.gandhivivek96.utils.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BrowserUtility {

    private static final By emailLocator = By.id("email");
    private static final By pwdLocator = By.id("passwd");
    private static final By signInButtonLocator = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginwith(String email, String password)
    {
        enterText(emailLocator,email);
        enterText(pwdLocator,password);
        clickOn(signInButtonLocator);
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        return myAccountPage;
    }
}
