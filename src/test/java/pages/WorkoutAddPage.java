package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutAddPage extends BasePage{

    private static final By ADD_WORKOUT_FORM = By.id("AddWorkoutForm");
    private static final By CROSS_TRAINING_TYPE = By.cssSelector("[data-code='cross-trai']");


    public WorkoutAddPage(WebDriver driver) {
        super(driver);
    }

    @Step("Selecting 'Cross Training' type")
    public void selectCrossTrainingType() {
        log.info("selecting 'Cross Training' type");
        clickButton(CROSS_TRAINING_TYPE);
    }

    @Override
    public boolean isPageOpened() {
        return elementIsVisible(ADD_WORKOUT_FORM);
    }

    @Override
    public WorkoutAddPage open() {
        driver.get(BASE_URl+"/WorkoutAdd.cshtml");
        return this;
    }
}
