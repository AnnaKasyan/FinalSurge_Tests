package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected static final String BASE_URl = "https://log.finalsurge.com";
    WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract boolean isPageOpened();

    public abstract BasePage open();

    public boolean elementIsVisible(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public void clickButton(By locator) {
        driver.findElement(locator).click();
    }
}
