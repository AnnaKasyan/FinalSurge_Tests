package tests;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.PropertyReader;
import utils.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
@Log4j2
public abstract class BaseTest {

    protected final static String EMAIL = System.getenv().getOrDefault("FINALSURGE_USERNAME", PropertyReader.getProperty("finalsurge.username"));
    protected final static String PASSWORD = System.getenv().getOrDefault("FINALSURGE_PASSWORD", PropertyReader.getProperty("finalsurge.password"));
    private static final By USER_IMAGE = By.id("LayoutProfilePic");
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected HomePage homePage;


    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    @Step("Opening browser")
    public void setUp(ITestContext testContext, @Optional("chrome") String browser) {
        log.info("driver initialization");
        System.getProperty("browser");
        driver = DriverFactory.getDriver(browser);
        testContext.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @AfterClass(alwaysRun = true)
    @Step("Closing browser")
    public void tearDown() {
        driver.manage().deleteAllCookies();
        log.info("quit from driver");
        driver.quit();
    }

    public void navigate() {
        loginPage.open().login(EMAIL, PASSWORD);
        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_IMAGE));
    }
}
