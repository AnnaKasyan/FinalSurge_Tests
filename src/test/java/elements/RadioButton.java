package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RadioButton extends BaseElement{

    private final String radioButtonLocator = "//input[@type='radio']//following-sibling::span[text()='%s']";

    public RadioButton(WebDriver driver) {
        super(driver);
    }

    public void clickRadioButton(String feeling){
        log.info(String.format("click %s",feeling));
        driver.findElement(By.xpath(String.format((radioButtonLocator),feeling))).click();
    }
}
