package io.github.gandhivivek96.tests;

import io.github.gandhivivek96.pages.HomePage;
import io.github.gandhivivek96.utils.BrowserUtility;
import io.github.gandhivivek96.utils.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import static io.github.gandhivivek96.constants.Browser.FIREFOX;

public class TestBase {

    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    @BeforeMethod(description = "Loading homepage")
    public void setUp()
    {
        homePage = new HomePage(FIREFOX);
    }

    public BrowserUtility getInstance()
    {
        return homePage;
    }
}
