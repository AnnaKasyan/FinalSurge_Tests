package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class DropdownSelectByValue extends BaseElement{

    public DropdownSelectByValue(WebDriver driver) {
        super(driver);
    }

    public void selectOption(By locator, String optionName) {
        log.info(String.format("selecting option %s", optionName));
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(optionName);
    }
}
