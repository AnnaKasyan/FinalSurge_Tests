package tests;

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

    @Test
    public void calculateIntensityTest() {
        WorkoutCalculator intensityForm = TestDataHelper.getIntesityInform();
        homePage.clickWorkoutCalculators()
                .fillForm(intensityForm)
                .clickCalculateButton();
        assertTrue(intensityCalculatorModal.workoutPaceTableIsVisible());
    }

    @Test
    public void calculateTinmanTest() {
        WorkoutCalculator tinmanForm = TestDataHelper.getTinmanInform();
        homePage.clickWorkoutCalculators()
                .openTinmanCalculator()
                .fillForm(tinmanForm)
                .clickCalculateButton();
        assertTrue(tinmanCalculatorModal.workoutPaceTableIsVisible());
    }

    @Test
    public void calculateHansonsTest() {
        WorkoutCalculator hansonForm = TestDataHelper.getHansonsInform();
        homePage.clickWorkoutCalculators()
                .openHansonCalculator()
                .fillForm(hansonForm)
                .clickCalculateButton();
        assertTrue(hansonsCalculatorModal.recentRaceInformationTableIsVisible());
    }
}
