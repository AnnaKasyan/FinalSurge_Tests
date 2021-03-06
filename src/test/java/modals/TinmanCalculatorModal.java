package modals;

import elements.Dropdown;
import elements.Input;
import elements.RadioButtonForCalculator;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TinmanCalculatorModal extends BaseModal {

    private final static By CALCULATE_PACES_BUTTON = By.id("saveButtonSettings");
    private final static By RACE_DISTANCE = By.name("distance");
    private final static By HOURS = By.id("TimeHH");
    private final static By MINUTES = By.id("TimeMM");
    private final static By SECONDS = By.id("TimeSS");
    private final static By RACE_INFORMATION_TABLE = By.xpath("//*[text()='Race Information']");

    public TinmanCalculatorModal(WebDriver driver) {
        super(driver);
    }

    @Step("Filling 'Tinman's running calculator by Tom Schwartz' form")
    public TinmanCalculatorModal fillForm(WorkoutCalculator tinmanCalculator) {
        new Dropdown(driver).selectOptionByValue(RACE_DISTANCE, tinmanCalculator.getRaceDistance().getValue());
        new Input(driver).write(HOURS, tinmanCalculator.getHours());
        new Input(driver).write(MINUTES, tinmanCalculator.getMinutes());
        new Input(driver).write(SECONDS, tinmanCalculator.getSeconds());
        new RadioButtonForCalculator(driver).clickRadioButton("Gender", tinmanCalculator.getGenderType().getValue().toUpperCase());
        return this;
    }

    @Step("Clicking 'Calculate Pace' button")
    public void clickCalculateButton() {
        log.info("clicking 'Calculate Pace' button");
        clickButton(CALCULATE_PACES_BUTTON);
    }

    @Step("Table 'Race Information' is visible")
    public boolean workoutPaceTableIsVisible() {
        log.info("Table 'Race Information' is visible");
        return driver.findElement(RACE_INFORMATION_TABLE).isDisplayed();
    }
}
