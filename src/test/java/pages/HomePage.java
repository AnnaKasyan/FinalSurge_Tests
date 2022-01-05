package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage {

    private static final By ICONS_IMG = By.cssSelector(".nav-icons");
    private static final By LOGOUT_LINK = By.xpath("//a[text()='Logout']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLogoutButton() {
        log.info("clicking 'Logout' link");
        driver.findElement(LOGOUT_LINK).click();
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(ICONS_IMG).isDisplayed();
    }

    @Override
    public BasePage open() {
        driver.get(BASE_URl);
        return this;
    }
}
