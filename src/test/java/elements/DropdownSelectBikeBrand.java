package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class DropdownSelectBikeBrand extends BaseElement {

    private static final String optionLocator = "//ul[@class='select2-results']//div[contains(.,'%s')]";

    public DropdownSelectBikeBrand(WebDriver driver) {
        super(driver);
    }

    public void selectOption(By dropdownLocator, String optionName) {
        log.info(String.format("selecting bike brand option %s", optionName));
        driver.findElement(dropdownLocator).click();
        WebElement optionToClick = driver.findElement(By.xpath(String.format(optionLocator, optionName)));
        scrollIntoView(optionToClick);
        optionToClick.click();
    }
}

