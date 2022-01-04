package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected static final String BASE_URl = "https://log.finalsurge.com";
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract boolean isPageOpened();

    public abstract BasePage open();


}
