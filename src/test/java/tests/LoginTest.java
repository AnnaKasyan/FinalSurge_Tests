package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginTest() {
        loginPage.open()
                .login(EMAIL, PASSWORD);
        assertTrue(homePage.isPageOpened());
    }
}
