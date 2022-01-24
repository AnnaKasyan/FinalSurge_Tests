package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class HomePage extends BasePage {

    private static final By ICONS_IMG = By.cssSelector(".nav-icons");
    private static final By LOGOUT_LINK = By.xpath("//a[text()='Logout']");
    private static final By WORKOUTS_MENU = By.xpath(" //a[text()='Workouts']");
    private static final By ADD_WORKOUT_LINK = By.xpath("//a[text()='Add Workout']");
    private static final By PRINT_WORKOUTS_LINK = By.xpath("//a[text()='Print Workouts']");
    private static final By GEAR_ROUTES_MENU = By.xpath("//a[text()='Gear & Routes']");
    private static final By BIKES_LINK = By.xpath("//a[text()='Bikes']");


    Actions action = new Actions(driver);


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void moveMenuSection(By locator){
        action.moveToElement( driver.findElement(locator)).perform();
    }

    public void clickLogoutButton() {
        log.info("clicking 'Logout' link");
        clickButton(LOGOUT_LINK);
    }

    public void moveWorkoutsMenu(){
        log.info("moving to 'Workouts' menu");
        moveMenuSection(WORKOUTS_MENU);
    }

    public HomePage moveGearRoutesMenu(){
        log.info("moving to 'Gear & Routes' menu");
        moveMenuSection(GEAR_ROUTES_MENU);
        return this;
    }

    public void clickAddWorkout() {
        moveWorkoutsMenu();
        log.info("clicking 'Add Workout' link");
        clickButton(ADD_WORKOUT_LINK);
    }

    public void clickPrintWorkouts() {
        moveWorkoutsMenu();
        log.info("clicking 'Print Workouts' link");
        clickButton(PRINT_WORKOUTS_LINK);
    }

    public void clickBikes() {
        moveGearRoutesMenu();
        log.info("clicking 'Bikes' link");
        clickButton(BIKES_LINK);
    }

    @Override
    public boolean isPageOpened() {
        return elementIsVisible(ICONS_IMG);
    }

    @Override
    public HomePage open() {
        driver.get(BASE_URl);
        return this;
    }
}
