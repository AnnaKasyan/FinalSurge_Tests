package modals;

import elements.Input;
import elements.RadioButtonForCalculator;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.CaloricNeeds;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CaloricNeedsModal extends BaseModal {

    private final static By WEIGHT = By.id("Weight");
    private final static By HEIGHT = By.id("HeightInchCent");
    private final static By AGE = By.id("Age");
    private final static By DISTANCE = By.id("RunDist");
    private final static By CALCULATE_BUTTON = By.name("btnSubmitSettings");
    private final static By CALORIC_NEEDS_TABLE = By.xpath("//*[@class='w-box-content']/table");
    private final static By OTHER_CALCULATOR_FRAME = By.id("OtherCalciFrame");
    private final static By PACE_CALCULATOR_BUTTON = By.xpath("//a[contains(text(),'Pace Calculator')]");


    public CaloricNeedsModal(WebDriver driver) {
        super(driver);
    }

    @Step("Filling 'Caloric Needs Calculator' form")
    public CaloricNeedsModal fillForm(CaloricNeeds caloricNeeds) {
        driver.switchTo().frame(driver.findElement(OTHER_CALCULATOR_FRAME));
        new RadioButtonForCalculator(driver).clickRadioButton("WeightType", caloricNeeds.getWeightType().getValue());
        new RadioButtonForCalculator(driver).clickRadioButton("HeightType", caloricNeeds.getHeightType().getValue());
        new RadioButtonForCalculator(driver).clickRadioButton("Gender", caloricNeeds.getGenderType().getValue());
        new RadioButtonForCalculator(driver).clickRadioButton("DistType", caloricNeeds.getDistTypeForCalculator().getValue());
        new Input(driver).write(WEIGHT, caloricNeeds.getWeight());
        new Input(driver).write(HEIGHT, caloricNeeds.getHeight());
        new Input(driver).write(AGE, caloricNeeds.getAge());
        new Input(driver).write(DISTANCE, caloricNeeds.getDistance());
        return this;
    }

    @Step("Clicking 'Calculate Caloric Needs' button")
    public void clickCalculateButton() {
        log.info("clicking 'Calculate Caloric Needs' button");
        clickButton(CALCULATE_BUTTON);
    }

    @Step("Table 'Today's caloric needs' is visible")
    public boolean caloricNeedsTableIsVisible (){
        log.info("Table 'Today's caloric needs' is visible");
        return driver.findElement(CALORIC_NEEDS_TABLE).isDisplayed();
    }

    @Step("Clicking 'Pace Calculator' button")
    public PaceCalculatorModal clickPaceCalculatorButton() {
        driver.switchTo().frame(driver.findElement(OTHER_CALCULATOR_FRAME));
        log.info("clicking 'Pace Calculator' button");
        clickButton(PACE_CALCULATOR_BUTTON);
        return new PaceCalculatorModal(driver);
    }
}
