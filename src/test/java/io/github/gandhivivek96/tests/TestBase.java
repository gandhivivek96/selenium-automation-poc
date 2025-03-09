package io.github.gandhivivek96.tests;

import io.github.gandhivivek96.constants.Browser;
import io.github.gandhivivek96.pages.HomePage;
import io.github.gandhivivek96.utils.BrowserUtility;
import io.github.gandhivivek96.utils.LambdaTestUtility;
import io.github.gandhivivek96.utils.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static io.github.gandhivivek96.constants.Browser.FIREFOX;

public class TestBase {

    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLambdatest;


    @Parameters({"browser","isLambdaTest","isHeadless"})
    @BeforeMethod(description = "Loading homepage")
    public void setUp(
            @Optional ("firefox") String browser,  @Optional("false") boolean isLambdaTest,
            @Optional("true") boolean isHeadless, ITestResult result)
    {

        this.isLambdatest=isLambdaTest;

       WebDriver lambdaDriver;
        if(isLambdatest)
        {
            lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser,result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);
        }
        else
        { // Running it on local machine
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
        }

    }

    public BrowserUtility getInstance()
    {
        return homePage;
    }

    @AfterMethod(description = "Tear down the browser")
    public void tearDown()
    {
        if (isLambdatest)
        {
            LambdaTestUtility.quitSession();
        }
        homePage.quit();
    }

}
