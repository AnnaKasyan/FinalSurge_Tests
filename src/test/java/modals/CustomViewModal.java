package modals;

import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.DatePeriod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CustomViewModal extends BaseModal {

    private static final By STARTING_DATE = By.id("CDateStart");
    private static final By ENDING_DATE = By.id("CDateEnd");
    private static final By VIEW_BUTTON = By.id("viewButton");

    public CustomViewModal(WebDriver driver) {
        super(driver);
    }

    public CustomViewModal fillForm(DatePeriod customView) {
        new Input(driver).clear(STARTING_DATE);
        new Input(driver).write(STARTING_DATE, customView.getStartDate());
        new Input(driver).clear(ENDING_DATE);
        new Input(driver).write(ENDING_DATE, customView.getEndDate());
        return this;
    }

    public void clickViewButton() {
        log.info("clicking 'View' button");
        clickButton(VIEW_BUTTON);
    }
}
