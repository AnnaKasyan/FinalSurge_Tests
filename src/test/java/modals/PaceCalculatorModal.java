package modals;

import elements.DropdownSelectByValue;
import elements.Input;
import lombok.extern.log4j.Log4j2;
import models.PaceCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PaceCalculatorModal extends BaseModal {

    private final static By DISTANCE = By.id("RunDist");
    private final static By DISTANCE_TYPE = By.id("DistType");
    private final static By HOURS = By.id("TimeHH");
    private final static By MINUTES = By.id("TimeMM");
    private final static By SECONDS = By.id("TimeSS");
    private final static By CALCULATE_PACES_BUTTON = By.id("saveButtonSettings");
    private final static By PACE_CHART_TABLE = By.xpath("//*[@class='w-box-content']/table[contains(@class,'table-condensed table-hover')]");
    private final static By OTHER_CALCULATOR_FRAME = By.id("OtherCalciFrame");


    public PaceCalculatorModal(WebDriver driver) {
        super(driver);
    }

    public PaceCalculatorModal fillForm(PaceCalculator paceCalculator) {
        new DropdownSelectByValue(driver).selectOption(DISTANCE_TYPE, paceCalculator.getDistanceType().getValue());
        new Input(driver).write(DISTANCE, paceCalculator.getDistance());
        new Input(driver).write(HOURS, paceCalculator.getHours());
        new Input(driver).write(MINUTES, paceCalculator.getMinutes());
        new Input(driver).write(SECONDS, paceCalculator.getSeconds());
        return this;
    }

    public void clickCalculateButton() {
        log.info("clicking 'Calculate Pace' button");
        clickButton(CALCULATE_PACES_BUTTON);
    }

    public boolean paceChartTableIsVisible() {
        return driver.findElement(PACE_CHART_TABLE).isDisplayed();
    }
}