package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogoutTest extends BaseTest{

    @BeforeMethod (alwaysRun = true)
    public void navigate (){
        loginPage.open().login(EMAIL,PASSWORD);
    }

    @Test
    public void logoutTest (){
        String expected_message = "You have been successfully logged out of the system.";
        homePage.clickLogoutButton();
        assertEquals(loginPage.getLogoutMessage(),expected_message);
    }
}
