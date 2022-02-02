package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RadioButtonForCalculator extends BaseElement{

    private final String radioButtonLocator = "//input[@name='%s' and @value='%s']";


    public RadioButtonForCalculator(WebDriver driver) {
        super(driver);
    }

    public void clickRadioButton(String label, String optionValue){
        log.info(String.format("selecting %s option %s",label, optionValue));
        driver.findElement(By.xpath(String.format((radioButtonLocator),label,optionValue))).click();
    }
}
