package pages;

import lombok.extern.log4j.Log4j2;
import modals.CustomViewModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class DailyVitalsPage extends BasePage {

    private static final By CUSTOM_VIEW = By.id("CustomLink");
    private static final By LAST_DATE_IN_TABLE = By.xpath("//table[contains(@class,'table-striped')]/tbody/tr[1]/td[1]");

    public DailyVitalsPage(WebDriver driver) {
        super(driver);
    }

    public CustomViewModal clickCustomView() {
        log.info("clicking 'Custom View' link");
        clickButton(CUSTOM_VIEW);
        return new CustomViewModal(driver);
    }

    public String getLastDateInTable() {
        return driver.findElement(LAST_DATE_IN_TABLE).getText();
    }

    @Override
    public boolean isPageOpened() {
        return elementIsVisible(CUSTOM_VIEW);
    }

    @Override
    public DailyVitalsPage open() {
        driver.get(BASE_URl + "/DailyVitals.cshtml");
        return this;
    }
}