package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PrintPage extends BasePage {

    private static final By PRINT_LINK = By.xpath("//table/tbody/tr[1]/td[1]");

    public PrintPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return elementIsVisible(PRINT_LINK);
    }

    @Override
    public PrintPage open() {
        driver.get(BASE_URl + "/PrintWorkouts.cshtml");
        return this;
    }
}
