package tests;

import io.qameta.allure.Description;
import modals.HansonsCalculatorModal;
import modals.IntensityCalculatorModal;
import modals.TinmanCalculatorModal;
import models.WorkoutCalculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestDataHelper;

import static org.testng.Assert.assertTrue;

public class WorkoutCalculatorsTest extends BaseTest {

    IntensityCalculatorModal intensityCalculatorModal;
    HansonsCalculatorModal hansonsCalculatorModal;
    TinmanCalculatorModal tinmanCalculatorModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        navigate();
        intensityCalculatorModal = new IntensityCalculatorModal(driver);
        hansonsCalculatorModal = new HansonsCalculatorModal(driver);
        tinmanCalculatorModal = new TinmanCalculatorModal(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void clearSession() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @Test(description = "Using 'Workout Calculators' to calculate the intensity of a running workout",groups = {"Regression"})
    @Description(value = "Using 'Workout Calculators' to calculate the intensity of a running workout")
    public void calculateIntensityTest() {
        WorkoutCalculator intensityForm = TestDataHelper.getIntesityInform();
        homePage.clickWorkoutCalculators()
                .fillForm(intensityForm)
                .clickCalculateButton();
        assertTrue(intensityCalculatorModal.workoutPaceTableIsVisible());
    }

    @Test(description = "Using 'Workout Calculators' to calculate Tinman's running by Tom Schwartz",groups = {"Regression"})
    @Description(value = "Using 'Workout Calculators' to calculate Tinman's running by Tom Schwartz")
    public void calculateTinmanTest() {
        WorkoutCalculator tinmanForm = TestDataHelper.getTinmanInform();
        homePage.clickWorkoutCalculators()
                .openTinmanCalculator()
                .fillForm(tinmanForm)
                .clickCalculateButton();
        assertTrue(tinmanCalculatorModal.workoutPaceTableIsVisible());
    }

    @Test(description = "Using 'Workout Calculators' to calculate the pace of Hanson's marathon method",groups = {"Regression"})
    @Description(value = "Using 'Workout Calculators' to calculate the pace of Hanson's marathon method")
    public void calculateHansonsTest() {
        WorkoutCalculator hansonForm = TestDataHelper.getHansonsInform();
        homePage.clickWorkoutCalculators()
                .openHansonCalculator()
                .fillForm(hansonForm)
                .clickCalculateButton();
        assertTrue(hansonsCalculatorModal.recentRaceInformationTableIsVisible());
    }
}
