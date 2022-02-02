package modals;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public abstract class  BaseModal {

    WebDriver driver;
    WebDriverWait wait;

    public BaseModal(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void clickButton(By locator) {
        driver.findElement(locator).click();
    }
}
