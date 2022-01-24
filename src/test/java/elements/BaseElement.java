package elements;

import org.openqa.selenium.WebDriver;

public abstract class BaseElement {

    static WebDriver driver;

    public BaseElement(WebDriver driver) {
        BaseElement.driver = driver;
    }



}
