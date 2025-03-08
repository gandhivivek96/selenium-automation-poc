package io.github.gandhivivek96.utils;

import io.github.gandhivivek96.constants.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BrowserUtility {

    private WebDriver driver;

    public BrowserUtility(WebDriver driver) {
        this.driver = driver;
    }

    public BrowserUtility(String browserName)
    {
        if(browserName.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (browserName.equalsIgnoreCase("edge"))
            driver =  new EdgeDriver();
        else
            System.err.println("Invalid browser");
    }

    public BrowserUtility(Browser browserName)
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        if(browserName == Browser.CHROME)
            driver = new ChromeDriver(chromeOptions);
        else if (browserName == Browser.EDGE)
            driver =  new EdgeDriver();
        else if (browserName == Browser.FIREFOX)
            driver =  new FirefoxDriver();
    }


    public WebDriver getDriver()
    {
        return driver;
    }
    public void goToWebsite(String url)
    {
        driver.get(url);
    }

    public String getText(By locator)
    {
        WebElement userNameElement = driver.findElement(locator);
        return userNameElement.getText();
    }
    public void maximizeWindow()
    {
        driver.manage().window().maximize();
    }

    public void clickOn(By locator)
    {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void enterText(By locator, String text)
    {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

}
