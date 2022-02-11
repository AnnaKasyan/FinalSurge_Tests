package tests;

import io.qameta.allure.Description;
import modals.CaloricNeedsModal;
import modals.PaceCalculatorModal;
import models.CaloricNeeds;
import models.PaceCalculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestDataHelper;

import static org.testng.Assert.assertTrue;

public class OtherCalculatorsTest extends BaseTest {

    protected CaloricNeedsModal caloricNeedsModal;
    protected PaceCalculatorModal paceCalculatorModal;

    @BeforeMethod(alwaysRun = true)
    public void initialize() {
        navigate();
        caloricNeedsModal = new CaloricNeedsModal(driver);
        paceCalculatorModal = new PaceCalculatorModal(driver);
        homePage.clickOtherCalculators();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.switchTo().defaultContent();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @Test(description = "Using 'Other Calculators' to calculate daily caloric needs",groups = {"Regression"})
    @Description(value = "Using 'Other Calculators' to calculate daily caloric needs")
    public void calculateCaloricNeedsTest() {
        CaloricNeeds form = TestDataHelper.getCaloricNeedInform();
        caloricNeedsModal.fillForm(form)
                .clickCalculateButton();
        assertTrue(caloricNeedsModal.caloricNeedsTableIsVisible());
    }

    @Test(description = "Using 'Other Calculators' to calculate pace",groups = {"Regression"})
    @Description(value = "Using 'Other Calculators' to calculate pace")
    public void paceCalculatorTest() {
        PaceCalculator form = TestDataHelper.getPaceCalculatorInform();
        caloricNeedsModal.clickPaceCalculatorButton()
                .fillForm(form)
                .clickCalculateButton();
        assertTrue(paceCalculatorModal.paceChartTableIsVisible());
    }
}
