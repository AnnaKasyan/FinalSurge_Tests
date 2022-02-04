package pages;

import enums.DistanceType;
import enums.Feeling;
import enums.PaceType;
import enums.PerceivedEffort;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Workout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutDetailsPage extends BasePage {

    private static final By SHARE_LINK = By.cssSelector("[data-target='#ShareDiv']");
    private static final By ACTUAL_TIME = By.xpath("//div[@class='formSep']/div/small");
    private static final By ACTUAL_NAME = By.xpath("//span[@class='activityTypeName']/parent::div/following-sibling::div");
    private static final By ACTUAL_DESCRIPTION = By.xpath("//small[contains(text(),'Description:')]/ancestor::p");
    private static final By ACTUAL_DISTANCE_AND_DURATION = By.xpath("//small[text()='Workout Statistics:']/following-sibling::span[@class='label label-info']");
    private static final By ACTUAL_HR = By.xpath("//p[@class='formSep']");
    private static final By ACTUAL_CALORIES = By.xpath("//p[@class='formSep']/span");
    private static final By ACTUAL_PACE_TYPE = By.xpath("//small[text()='Workout Statistics:']/following-sibling::span[@class='label label']");
    private static final By ACTUAL_PERCEIVED_EFFORT = By.xpath("//div[@class='formSep'][3]");
    private static final By ACTUAL_FEELING = By.xpath("//small[text()='How I Felt:']/following-sibling::span");

    public WorkoutDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting workout details")
    public Workout getWorkoutDetails() {
        Workout workout = new Workout();
        workout.setTimeOfDay(getActualTime());
        workout.setName(getActualName());
        workout.setDescription(getDescription());
        workout.setDistance(getActualDistance());
        workout.setDuration(getActualDuration());
        workout.setAvgHR(getActualAvgHR());
        workout.setMinHR(getActualMinHR());
        workout.setMaxHR(getActualMaxHR());
        workout.setCaloriesBurned(getActualCalories());
        workout.setDistanceType(DistanceType.fromString(getActualDistanceType()));
        workout.setPaceType(PaceType.fromString(getActualPaceType()));
        workout.setPerceivedEffort(PerceivedEffort.fromString(getActualPerceivedEffort()));
        workout.setFeeling(Feeling.fromString(getActualFeeling()));
        return workout;
    }

    @Step("Getting the actual name of workout")
    public String getActualName() {
        log.info("getting the actual name of workout");
        return driver.findElement(ACTUAL_NAME).getText().trim();
    }

    @Step("Getting the actual time of workout")
    public String getActualTime() {
        log.info("getting the actual time of workout");
        return driver.findElement(ACTUAL_TIME).getText().split("-")[1].trim();
    }

    @Step("Getting the actual description of workout")
    public String getDescription() {
        log.info("getting the actual description of workout");
        return driver.findElement(ACTUAL_DESCRIPTION).getText().split(":")[1].trim();
    }

    @Step("Getting the actual distance of workout")
    public String getActualDistance() {
        log.info("getting the actual distance of workout");
        return driver.findElement(ACTUAL_DISTANCE_AND_DURATION).getText().split("~")[0].trim().split(" ")[0];
    }

    @Step("Getting the actual distance type of workout")
    public String getActualDistanceType() {
        log.info("getting the actual distance type of workout");
        return driver.findElement(ACTUAL_DISTANCE_AND_DURATION).getText().split("~")[0].trim().split(" ")[1];
    }

    @Step("Getting the actual duration of workout")
    public String getActualDuration() {
        log.info("getting the actual duration of workout");
        return driver.findElement(ACTUAL_DISTANCE_AND_DURATION).getText().split("~")[1].trim();
    }

    @Step("Getting the actual calories burned")
    public String getActualCalories() {
        log.info("getting the actual calories burned");
        return driver.findElement(ACTUAL_CALORIES).getText().split(" ")[2].trim();
    }

    @Step("Getting the actual pace type of workout")
    public String getActualPaceType() {
        log.info("getting the actual pace type of workout");
        return driver.findElement(ACTUAL_PACE_TYPE).getText().split(" ")[1].trim();
    }

    @Step("Getting the actual perceived effort of workout")
    public String getActualPerceivedEffort() {
        log.info("getting the actual perceived effort of workout");
        return driver.findElement(ACTUAL_PERCEIVED_EFFORT).getText().split("rt")[1].trim();
    }

    @Step("Getting the actual feeling of workout")
    public String getActualFeeling() {
        log.info("getting the actual feeling of workout");
        return driver.findElement(ACTUAL_FEELING).getText().trim();
    }

    @Step("Getting the actual min HR")
    public String getActualMinHR() {
        log.info("getting the actual min HR");
        return driver.findElement(ACTUAL_HR).getText().split(" ")[2].trim();
    }

    @Step("Getting the actual avg HR")
    public String getActualAvgHR() {
        log.info("getting the actual avg HR");
        return driver.findElement(ACTUAL_HR).getText().split(" ")[8].trim();
    }

    @Step("Getting the actual max HR")
    public String getActualMaxHR() {
        log.info("getting the actual max HR");
        return driver.findElement(ACTUAL_HR).getText().split(" ")[15].trim();
    }

    @Override
    public boolean isPageOpened() {
        return elementIsVisible(SHARE_LINK);
    }

    @Override
    public WorkoutDetailsPage open() {
        driver.get(BASE_URl + "/WorkoutDetails.cshtml");
        return this;
    }

}
