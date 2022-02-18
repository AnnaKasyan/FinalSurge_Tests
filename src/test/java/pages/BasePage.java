package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
