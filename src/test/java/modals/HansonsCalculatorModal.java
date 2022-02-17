package modals;

import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HansonsCalculatorModal extends BaseModal {

    private final static By DISTANCE = By.id("RaceDist");
    private final static By HOURS = By.id("TimeHH");
    private final static By MINUTES = By.id("TimeMM");
    private final static By SECONDS = By.id("TimeSS");
    private final static By TEMPERATURE = By.id("Temp");
    private final static By TEMPERATURE_TYPE = By.id("TempType");
    private final static By HUMIDITY = By.id("Humid");
    private final static By WIND_SPEED_TYPE = By.id("SpeedType");
    private final static By WIND_SPEED = By.id("Wind");
    private final static By CALCULATE_PACES_BUTTON = By.id("saveButtonSettings");
    private final static By RECENT_RACE_INFORMATION_TABLE = By.xpath("//*[text()='Recent Race Information']");


    public HansonsCalculatorModal(WebDriver driver) {
        super(driver);
    }

    @Step("Filling 'Hansons Marathon Method pace calculator' form")
    public HansonsCalculatorModal fillForm(WorkoutCalculator hansonsCalculator) {
        new Dropdown(driver).selectOptionByValue(DISTANCE, hansonsCalculator.getEvent().getName());
        new Input(driver).write(HOURS, hansonsCalculator.getHours());
        new Input(driver).write(MINUTES, hansonsCalculator.getMinutes());
        new Input(driver).write(SECONDS, hansonsCalculator.getSeconds());
        new Dropdown(driver).selectOptionByValue(TEMPERATURE_TYPE, hansonsCalculator.getTemperatureType().getValue());
        new Dropdown(driver).selectOptionByValue(WIND_SPEED_TYPE, hansonsCalculator.getWindSpeedType().getValue());
        new Input(driver).write(TEMPERATURE, hansonsCalculator.getTemperature());
        new Input(driver).write(HUMIDITY, hansonsCalculator.getHumidity());
        new Input(driver).write(WIND_SPEED, hansonsCalculator.getWindSpeed());
        return this;
    }

    @Step("Clicking 'Calculate Pace' button")
    public void clickCalculateButton() {
        log.info("clicking 'Calculate Pace' button");
        clickButton(CALCULATE_PACES_BUTTON);
    }

    @Step("Table 'Recent Race Information' is visible")
    public boolean recentRaceInformationTableIsVisible() {
        log.info("Table 'Recent Race Information' is visible");
        return driver.findElement(RECENT_RACE_INFORMATION_TABLE).isDisplayed();
    }
}
