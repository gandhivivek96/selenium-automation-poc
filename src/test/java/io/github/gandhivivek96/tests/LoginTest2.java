package io.github.gandhivivek96.tests;

import io.github.gandhivivek96.pages.HomePage;
import io.github.gandhivivek96.pages.LoginPage;
import io.github.gandhivivek96.utils.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest2 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver(); // loose coupling

       HomePage homePage = new HomePage(driver);

        homePage.maximizeWindow();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.doLoginwith("koyene5739@oziere.com","password");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
