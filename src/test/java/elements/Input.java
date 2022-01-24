package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input extends BaseElement{

    public Input(WebDriver driver) {
        super(driver);
    }

    public void write(By locator, String text) {
        log.info(String.format("setting %s", text));
        driver.findElement(locator).sendKeys(text);
    }

    public void clear (By locator){
        log.info("clearing field");
        driver.findElement(locator).clear();
    }
}
