package io.github.gandhivivek96.tests;

import io.github.gandhivivek96.constants.Browser;
import io.github.gandhivivek96.pages.HomePage;
import io.github.gandhivivek96.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.gandhivivek96.constants.Browser.*;

public class LoginTest3 {


    HomePage homePage;

    @BeforeMethod(description = "Loading homepage")
    public void setUp()
    {
        homePage = new HomePage(CHROME);
    }

    @Test(description = "verifies login test for valid user" , groups = {"e2e","sanity"})
    public void loginTest()
    {
//        String email = "koyene5739@oziere.com";
//        String pwd = "password";
//        String u = homePage.goToLoginPage().doLoginwith(email,pwd).getUsername();
//        System.out.println("USername = "+u);
        assertEquals(homePage.goToLoginPage().doLoginwith("koyene5739@oziere.com","password").getUsername(),"Jon Snow") ;


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.getDriver().quit();

    }
}
