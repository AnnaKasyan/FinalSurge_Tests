package elements;

import org.openqa.selenium.WebDriver;

public abstract class BaseElement {

    WebDriver driver;

    public BaseElement(WebDriver driver) {
        this.driver = driver;
    }

}
