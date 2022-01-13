package modals;

import elements.RadioButton;
import lombok.extern.log4j.Log4j2;
import models.Workout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class AddNewWorkoutModal extends BaseModal {

    private static final By ADD_WORKOUT_BUTTON = By.id("saveButton");
    private static final By TIME = By.id("WorkoutTime");
    private static final By NAME = By.id("Name");
    private static final By DESCRIPTION = By.id("Desc");
    private static final By DISTANCE = By.id("DistanceNoInt");
    private static final By DURATION = By.id("DurationNoInt");
    private static final By MIN_HR = By.id("MinHR");
    private static final By AVG_HR = By.id("AvgHR");
    private static final By MAX_HR = By.id("MaxHR");
    private static final By CALORIES_BURNED = By.id("kCal");
    private static final By DISTANCE_TYPE_SELECT = By.name("DistTypeNoInt");
    private static final By PACE_TYPE_SELECT = By.name("PaceTypeNoInt");
    private static final By PERCEIVED_EFFORT_SELECT = By.name("PerEffort");


    public AddNewWorkoutModal(WebDriver driver) {
        super(driver);
    }

    public void write(By locator, String text) {
        log.info(String.format("setting %s", text));
        driver.findElement(locator).sendKeys(text);
    }

    public void selectOption(By locator, String optionName) {
        log.info(String.format("selecting option %s", optionName));
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(optionName);
    }

    public AddNewWorkoutModal fillForm(Workout workout) {
        write(TIME, workout.getTimeOfDay());
        write(NAME, workout.getName());
        write(DESCRIPTION, workout.getDescription());
        write(DISTANCE, workout.getDistance());
        selectOption(DISTANCE_TYPE_SELECT, workout.getDistanceType().getValue());
        write(DURATION, workout.getDuration());
        selectOption(PACE_TYPE_SELECT, workout.getPaceType().getValue());
        new RadioButton(driver).clickRadioButton(workout.getFeeling().getName());
        selectOption(PERCEIVED_EFFORT_SELECT, workout.getPerceivedEffort().getValue());
        write(MIN_HR, workout.getMinHR());
        write(AVG_HR, workout.getAvgHR());
        write(MAX_HR, workout.getMaxHR());
        write(CALORIES_BURNED, workout.getCaloriesBurned());
        return this;
    }

    public void clickAddWorkoutButton() {
        log.info("clicking 'Add Workout' button");
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }
}
