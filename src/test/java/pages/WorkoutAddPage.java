package pages;

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

    @Override
    public boolean isPageOpened() {
        return driver.findElement(ADD_WORKOUT_FORM).isDisplayed();
    }

    @Override
    public WorkoutAddPage open() {
        driver.get(BASE_URl+"/WorkoutAdd.cshtml");
        return this;
    }

    public void selectCrossTrainingType() {
        log.info("selecting 'CROSS_TRAINING' type");
        driver.findElement(CROSS_TRAINING_TYPE).click();
    }
}
