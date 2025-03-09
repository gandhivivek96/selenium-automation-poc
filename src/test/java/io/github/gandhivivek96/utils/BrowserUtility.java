package io.github.gandhivivek96.utils;

import io.github.gandhivivek96.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() ;
    private Logger logger = LoggerUtility.getLogger(this.getClass());
    public BrowserUtility(WebDriver driver) {
        this.driver.set(driver);
    }

    public BrowserUtility(String browserName)
    {
        if(browserName.equalsIgnoreCase("chrome"))
            driver.set(new ChromeDriver());
        else if (browserName.equalsIgnoreCase("edge"))
            driver.set( new EdgeDriver());
        else
            System.err.println("Invalid browser");
    }

    public BrowserUtility(Browser browserName)
    {
        logger.info("Launching browser");
        if(browserName == Browser.CHROME)
            driver.set(new ChromeDriver());
        else if (browserName == Browser.EDGE)
            driver.set(new EdgeDriver());
        else if (browserName == Browser.FIREFOX)
            driver.set(new FirefoxDriver());
    }

    public BrowserUtility(Browser browserName, boolean isHeadless)
    {
        logger.info("Launching browser");

        if(browserName == Browser.CHROME)
        {
            if (isHeadless)
            {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--window-size=1920,1080");
                driver.set(new ChromeDriver(chromeOptions));
            }
            else {
                driver.set(new ChromeDriver());
            }

        }
        else if (browserName == Browser.EDGE) {
            if (isHeadless) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless");
                edgeOptions.addArguments("--window-size=1920,1080");
                driver.set(new EdgeDriver(edgeOptions));
            } else {
                driver.set(new EdgeDriver());
            }

        }
        else if (browserName == Browser.FIREFOX)
        {
            if (isHeadless) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-headless");
                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");
                driver.set(new FirefoxDriver(firefoxOptions));
            } else {
                driver.set(new FirefoxDriver());
            }
        }

    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void goToWebsite(String url)
    {
        logger.info("Visiting the website "+url);
        driver.get().get(url);
    }

    public String getText(By locator)
    {
        WebElement userNameElement = driver.get().findElement(locator);
        return userNameElement.getText();
    }
    public void maximizeWindow()
    {
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator)
    {
        WebElement element = driver.get().findElement(locator);
        element.click();
    }

    public void enterText(By locator, String text)
    {
        WebElement element = driver.get().findElement(locator);
        element.sendKeys(text);
    }
    public String takeScreenShot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();

        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);
        String path = "./screenshots/" + name + " - " + timeStamp + ".png";
        File screenshotFile = new File(path);
        try {
            FileUtils.copyFile(screenshotData, screenshotFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return path;
    }

    public void quit() {
        driver.get().quit();
    }

}
