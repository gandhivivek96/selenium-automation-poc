package io.github.gandhivivek96.tests;

import io.github.gandhivivek96.pojo.User;
import io.github.gandhivivek96.utils.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners({ io.github.gandhivivek96.listeners.TestListener.class })
public class InvalidCredentialsLoginTest extends TestBase {

    private static final String INVALID_EMAIL="test@test.com";
    private static final String INVALID_PASSWORDL="123qwerty";


    @Test(description = "verifies error message valid user" , groups = {"e2e","sanity"})
    public void loginTest()
    {
        assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL,INVALID_PASSWORDL).getErrorMessage(),"Authentication failed.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
