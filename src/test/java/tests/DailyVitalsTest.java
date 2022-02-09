package tests;

import io.qameta.allure.Description;
import modals.CustomViewModal;
import models.DatePeriod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DailyVitalsPage;
import utils.TestDataHelper;

import static org.testng.Assert.assertEquals;

public class DailyVitalsTest extends BaseTest {

    DailyVitalsPage dailyVitalsPage;
    CustomViewModal customViewModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        navigate();
        homePage.clickViewAddVitals();
        dailyVitalsPage = new DailyVitalsPage(driver);
        customViewModal = new CustomViewModal(driver);
    }

    @Test(description = "Displaying daily vitals for the selected time period")
    @Description(value = "Displaying daily vitals for the selected time period")
    public void viewVitalsTest() {
        DatePeriod periodForView = TestDataHelper.getDatePeriod();
        dailyVitalsPage.clickCustomView()
                .fillForm(periodForView)
                .clickViewButton();
        assertEquals(dailyVitalsPage.getLastDateInTable(), periodForView.getEndDate());
    }
}
