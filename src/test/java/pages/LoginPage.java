package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    private static final By EMAIL_INPUT = By.id("login_name");
    private static final By PASSWORD_INPUT = By.id("login_password");
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Login']");
    private static final By ACCOUNT_LOGOUT_MESSAGE = By.cssSelector("[class^='alert']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    @Override
    public LoginPage open() {
        driver.get(BASE_URl);
        return this;
    }

    public LoginPage setEmailInput(String email) {
        log.info("setting email");
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        return this;
    }

    public LoginPage setPasswordInput(String password) {
        log.info("setting password");
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        log.info("clicking 'Login' button");
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void login(String email, String password) {
        setEmailInput(email);
        setPasswordInput(password);
        clickLoginButton();
    }

    public String getLogoutMessage() {
        log.info("getting message about successfully logged out of the system");
        return driver.findElement(ACCOUNT_LOGOUT_MESSAGE).getText();
    }
}
