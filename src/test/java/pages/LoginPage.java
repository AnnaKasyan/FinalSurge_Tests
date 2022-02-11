package pages;

import io.qameta.allure.Step;
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

    @Step("Setting email value: {email}")
    public void setEmailInput(String email) {
        log.info("setting email");
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    @Step("Setting password value: {password}")
    public void setPasswordInput(String password) {
        log.info("setting password");
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Clicking 'Login' button")
    public void clickLoginButton() {
        log.info("clicking 'Login' button");
        clickButton(LOGIN_BUTTON);
    }

    @Step("Login to Finalsurge.com with username {email} and password {password}")
    public void login(String email, String password) {
        setEmailInput(email);
        setPasswordInput(password);
        clickLoginButton();
    }

    @Step("Getting message about successfully logged out of the system")
    public String getLogoutMessage() {
        log.info("getting message about successfully logged out of the system");
        return driver.findElement(ACCOUNT_LOGOUT_MESSAGE).getText();
    }

    @Override
    public boolean isPageOpened() {
        return elementIsVisible(LOGIN_BUTTON);
    }

    @Override
    public LoginPage open() {
        driver.get(BASE_URl);
        return this;
    }
}
