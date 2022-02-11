package tests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogoutTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void open() {
        navigate();
    }

    @Test(description = "FinalSurge logout positive test",groups = {"Regression"})
    @Description(value = "Logout positive test")
    public void logoutTest() {
        String expected_message = "You have been successfully logged out of the system.";
        homePage.clickLogoutButton();
        assertEquals(loginPage.getLogoutMessage(), expected_message);
    }
}
