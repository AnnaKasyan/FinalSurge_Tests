package modals;

import elements.Dropdown;
import elements.Input;
import elements.RadioButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Workout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    @Step("Filling 'New workout' form")
    public AddNewWorkoutModal fillForm(Workout workout) {
        new Input(driver).write(TIME, workout.getTimeOfDay());
        new Input(driver).write(NAME, workout.getName());
        new Input(driver).write(DESCRIPTION, workout.getDescription());
        new Input(driver).write(DISTANCE, workout.getDistance());
        new Dropdown(driver).selectOptionByValue(DISTANCE_TYPE_SELECT, workout.getDistanceType().getValue());
        new Input(driver).write(DURATION, workout.getDuration());
        new Dropdown(driver).selectOptionByValue(PACE_TYPE_SELECT, workout.getPaceType().getValue());
        new RadioButton(driver).clickRadioButton(workout.getFeeling().getName());
        new RadioButton(driver).clickRadioButton(workout.getFeeling().getName());
        new Dropdown(driver).selectOptionByValue(PERCEIVED_EFFORT_SELECT, workout.getPerceivedEffort().getValue());
        new Input(driver).write(MIN_HR, workout.getMinHR());
        new Input(driver).write(AVG_HR, workout.getAvgHR());
        new Input(driver).write(MAX_HR, workout.getMaxHR());
        new Input(driver).write(CALORIES_BURNED, workout.getCaloriesBurned());
        return this;
    }

    @Step("Clicking 'Add Workout' button")
    public void clickAddWorkoutButton() {
        log.info("clicking 'Add Workout' button");
        clickButton(ADD_WORKOUT_BUTTON);
    }
}
