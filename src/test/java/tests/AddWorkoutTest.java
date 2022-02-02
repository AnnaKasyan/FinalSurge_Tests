package tests;

import modals.AddNewWorkoutModal;
import models.Workout;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WorkoutAddPage;
import pages.WorkoutDetailsPage;
import utils.TestDataHelper;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddWorkoutTest extends BaseTest {

    protected WorkoutAddPage workoutAddPage;
    protected WorkoutDetailsPage workoutDetailsPage;
    protected AddNewWorkoutModal addNewWorkoutModal;


    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        navigate();
        workoutAddPage = new WorkoutAddPage(driver);
        workoutDetailsPage = new WorkoutDetailsPage(driver);
        addNewWorkoutModal = new AddNewWorkoutModal(driver);
    }

    @Test
    public void addCrossTrainingTest() {
        homePage.clickAddWorkout();
        assertTrue(workoutAddPage.isPageOpened());
        workoutAddPage.selectCrossTrainingType();
        Workout crossTraining = TestDataHelper.getCrossTrainingWithAllData();
        addNewWorkoutModal.fillForm(crossTraining)
                .clickAddWorkoutButton();
        Workout actualWorkoutDetails = workoutDetailsPage.getWorkoutDetails();
        assertEquals(actualWorkoutDetails, crossTraining);
    }
}
