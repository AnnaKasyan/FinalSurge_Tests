package pages;

import elements.DropdownSelectBikeBrand;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.Bike;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class BikesPage extends BasePage {

    private static final By BIKE_EDIT_FORM = By.id("BikeEditForm");
    private static final By BIKE_NAME = By.id("ShoeName");
    private static final By DROPDOWN_LOCATOR = By.xpath("//*[@id='s2id_ShoeBrand']/a");

    private static final By BIKE_MODEL = By.id("ShoeModel");
    private static final By BIKE_COST = By.id("ShoeCost");
    private static final By DATE = By.id("ShoeDate");
    private static final By DISTANCE = By.id("StartDist");
    private static final By ADD_BIKE_BUTTON = By.id("saveButton");


    public BikesPage(WebDriver driver) {
        super(driver);
    }

    public BikesPage fillForm(Bike bike) {
        new Input(driver).write(BIKE_NAME, bike.getBikeName());
        new DropdownSelectBikeBrand(driver).selectOption(DROPDOWN_LOCATOR, bike.getBikeBrand().getName());
        new Input(driver).write(BIKE_MODEL, bike.getModel());
        new Input(driver).write(BIKE_COST, bike.getCost());
        new Input(driver).write(DATE, bike.getDate());
        new Input(driver).clear(DISTANCE);
        new Input(driver).write(DISTANCE, bike.getDistance());
        return this;
    }

    public BikesPage clickAddBikeButton() {
        log.info("clicking 'Add Bike' button");
        clickButton(ADD_BIKE_BUTTON);
        return this;
    }

    public void clickBikeName(String name) {
        log.info("clicking name of new bike");
        String nameOfCurrentBikes = "//a[text()='%s']";
        driver.findElement(By.xpath(String.format(nameOfCurrentBikes, name))).click();
    }

    @Override
    public boolean isPageOpened() {
        return elementIsVisible(BIKE_EDIT_FORM);
    }

    @Override
    public BikesPage open() {
        driver.get(BASE_URl + "/EquipmentBikes.cshtml");
        return this;
    }

}
