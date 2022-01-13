package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void navigate() {
        loginPage.open();
    }

    @AfterMethod(alwaysRun = true)
    public void clearSession() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @Test
    public void positiveLoginTest() {
        loginPage.login(EMAIL, PASSWORD);
        assertTrue(homePage.isPageOpened());
    }

    @Test(dataProvider = "Negative Login Test Data")
    public void negativeLoginTest(String email, String password) {
        loginPage.login(email, password);
        assertTrue(loginPage.isPageOpened());
    }

    @DataProvider(name = "Negative Login Test Data")
    public Object[][] getNegativeLoginData() {
        return new Object[][]{
                {"", ""},
                {EMAIL, ""},
                {EMAIL, "123"},
        };
    }
}
