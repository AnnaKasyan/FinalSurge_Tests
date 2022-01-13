package modals;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class UpdateWorkoutModal extends BaseModal{

    private static final By DELETE_BUTTON = By.cssSelector("a[id='del-workout']");
    private static final By OK_BUTTON = By.xpath("//a[text()='OK']");

    public UpdateWorkoutModal(WebDriver driver) {
        super(driver);
    }

    public UpdateWorkoutModal clickDeleteButton() {
        log.info("clicking 'Delete' button");
        driver.findElement(DELETE_BUTTON).click();
        return this;
    }

    public void clickOkButton() {
        log.info("clicking 'OK' button");
        driver.findElement(OK_BUTTON).click();
    }
}
