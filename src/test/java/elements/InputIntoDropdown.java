package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class InputIntoDropdown extends BaseElement {


    public InputIntoDropdown(WebDriver driver) {
        super(driver);
    }


    public void write(By locatorOption, By locatorSelect, String text) {
        log.info(String.format("setting %s", text));
        driver.findElement(locatorSelect).click();
        Select select = new Select(driver.findElement(locatorOption));
        select.selectByVisibleText(text);
    }
}
