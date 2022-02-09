package tests;

import io.qameta.allure.Description;
import models.Report;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WorkoutReportPage;
import utils.TestDataHelper;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WorkoutReportTest extends BaseTest {

    WorkoutReportPage workoutReportPage;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        navigate();
        workoutReportPage = new WorkoutReportPage(driver);
    }

    @Test(description = "Reporting on workouts of the selected type for the selected period",groups = {"Smoke"})
    @Description(value = "Reporting on workouts of the selected type for the selected period")
    public void reportWorkoutTest() {
        homePage.clickReportsAndStatistics();
        assertTrue(workoutReportPage.isPageOpened());
        Report reportView = TestDataHelper.getReportInform();
        workoutReportPage.fillForm(reportView)
                .clickViewReportButton();
        assertEquals(workoutReportPage.getActivityFromTable(), reportView.getActivityType().getName());
    }
}
