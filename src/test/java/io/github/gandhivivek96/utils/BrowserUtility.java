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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() ;
    private Logger logger = LoggerUtility.getLogger(this.getClass());
    private WebDriverWait wait;


    public BrowserUtility(WebDriver driver) {
        this.driver.set(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
    }

    public BrowserUtility(String browserName)
    {
        if(browserName.equalsIgnoreCase("chrome"))
            driver.set(new ChromeDriver());
        else if (browserName.equalsIgnoreCase("edge"))
            driver.set( new EdgeDriver());
        else
            System.err.println("Invalid browser");
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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
        wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

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
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

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
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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

    public String getVisibleText(By locator)
    {
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return userNameElement.getText();
    }

    public List<String> getAllVisibleText(By locator)
    {
        List<WebElement> webElementList = getDriver().findElements(locator);
        List<String> visibleTextList = new ArrayList<String>();
        for (WebElement e: webElementList)
        {
            visibleTextList.add(getVisibleText(e));
            System.out.println(getVisibleText(e));
        }

        return visibleTextList;
    }

    public List<WebElement> getAllElements(By locator)
    {
        List<WebElement> elementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return elementList;

    }
    public void selectFromDropDown(By dropDownLocator, String optionToSelect)
    {
        WebElement element = driver.get().findElement(dropDownLocator);
        Select select = new Select(element);
        select.selectByVisibleText(optionToSelect);
    }
    public void clearText(By textBoxLocator)
    {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
        element.clear();
    }
    public String getVisibleText(WebElement userNameElement)
    {
        return userNameElement.getText();
    }
    public void maximizeWindow()
    {
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator)
    {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
    public void clickOnCheckbox(By locator)
    {

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }
    public void clickOn(WebElement element)
    {
        element.click();
    }

    public void enterText(By locator, String text)
    {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
    }
    public void enterSpecialKey(By locator, Keys keyToEnter)
    {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(keyToEnter);
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
