package tests;

import modals.PrintWorkoutModal;
import models.PrintWorkouts;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PrintPage;
import utils.TestDataHelper;

import static org.testng.Assert.assertTrue;

public class PrintWorkoutsTest extends BaseTest {

    PrintWorkoutModal printWorkoutModal;
    PrintPage printPage;


    @BeforeMethod (alwaysRun = true)
    public void navigate() {
        loginPage.open().login(EMAIL, PASSWORD);
        printWorkoutModal = new PrintWorkoutModal(driver);
        printPage = new PrintPage(driver);
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        driver.switchTo().defaultContent();
        driver.manage().deleteAllCookies();
    }


    @Test
    public void printWorkoutsTest() {
        homePage.clickPrintWorkouts();
        PrintWorkouts periodForPrint = TestDataHelper.getPeriodPrintWorkouts();
        printWorkoutModal.fillForm(periodForPrint);
        assertTrue(printPage.isPageOpened());
    }
}