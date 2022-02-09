package tests;

import io.qameta.allure.Description;
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

    @Test(description = "FinalSurge login positive test", groups = {"Smoke"})
    @Description(value = "Login positive test")
    public void positiveLoginTest() {
        loginPage.login(EMAIL, PASSWORD);
        assertTrue(homePage.isPageOpened());
    }

    @Test(description = "FinalSurge login negative test", groups = {"Negative"}, dataProvider = "Negative Login Test Data")
    @Description(value = "Login negative test with 3 various test data")
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
