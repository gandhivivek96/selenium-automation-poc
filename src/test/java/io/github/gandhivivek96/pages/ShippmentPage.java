package io.github.gandhivivek96.pages;

import io.github.gandhivivek96.utils.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippmentPage extends BrowserUtility {

    private static final By ACCEPT_TERMS_CHECKBOX_LOCATOR = By.id("uniform-cgv");
    private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.name("processCarrier");

    public ShippmentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage goToPaymentPage() {
        clickOnCheckbox(ACCEPT_TERMS_CHECKBOX_LOCATOR);
        clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
        return new PaymentPage(getDriver());
    }

}
