package io.github.gandhivivek96.tests;

import io.github.gandhivivek96.pages.HomePage;
import io.github.gandhivivek96.pojo.User;

import static org.testng.Assert.*;

import io.github.gandhivivek96.utils.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.gandhivivek96.constants.Browser.*;

public class LoginTest {


    HomePage homePage;
    ;

    @BeforeMethod(description = "Loading homepage")
    public void setUp()
    {
        homePage = new HomePage(CHROME);
    }

    @Test(description = "verifies login test for valid user" , groups = {"e2e","sanity"} ,
    dataProviderClass = io.github.gandhivivek96.dataproviders.LoginDataProvider.class,
    dataProvider = "LoginTestDataProvider")
    public void loginTest(User user)
    {
        assertEquals(homePage.goToLoginPage().doLoginwith(user.getEmailAddress(), user.getPassword()).getUsername(),"Jon Snow") ;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.getDriver().quit();
    }

    @Test(description = "verifies login test for valid user" , groups = {"e2e","sanity"} ,
            dataProviderClass = io.github.gandhivivek96.dataproviders.LoginDataProvider.class,
            dataProvider = "LoginTestCSVDataProvider")
    public void loginTestCSV(User user)
    {
        Logger logger = LoggerUtility.getLogger(this.getClass());
        logger.info("Test started");
        assertEquals(homePage.goToLoginPage().doLoginwith(user.getEmailAddress(), user.getPassword()).getUsername(),"Jon Snow") ;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.getDriver().quit();
    }

    @Test(description = "verifies login test for valid user" , groups = {"e2e","sanity"} ,
            dataProviderClass = io.github.gandhivivek96.dataproviders.LoginDataProvider.class,
            dataProvider = "LoginTestExcelDataProvider",
            retryAnalyzer = io.github.gandhivivek96.listeners.MyRetryAnalyzer.class)
    public void loginTestExcel(User user)
    {


        assertEquals(homePage.goToLoginPage().doLoginwith(user.getEmailAddress(), user.getPassword()).getUsername(),"Jon Snow") ;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.getDriver().quit();
    }
}
