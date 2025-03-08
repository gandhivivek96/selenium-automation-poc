package io.github.gandhivivek96.pages;

import io.github.gandhivivek96.utils.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BrowserUtility {

    private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUsername()
    {
       return getText(USER_NAME_LOCATOR);
    }
}
