package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class HomePage extends BasePage {

    private static final By ICONS_IMG = By.cssSelector(".nav-icons");
    private static final By LOGOUT_LINK = By.xpath("//a[text()='Logout']");
    private static final By WORKOUTS_MENU = By.xpath(" //a[text()='Workouts']");
    private static final By ADD_WORKOUT_LINK = By.xpath("//a[text()='Add Workout']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLogoutButton() {
        log.info("clicking 'Logout' link");
        driver.findElement(LOGOUT_LINK).click();
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(ICONS_IMG).isDisplayed();
    }

    @Override
    public HomePage open() {
        driver.get(BASE_URl);
        return this;
    }

    public void clickAddWorkout() {
        log.info("moving to 'Workouts' menu");
        Actions action = new Actions(driver);
        action.moveToElement( driver.findElement(WORKOUTS_MENU)).perform();
        log.info("clicking 'Add Workout' link");
        driver.findElement(ADD_WORKOUT_LINK).click();
    }
}
