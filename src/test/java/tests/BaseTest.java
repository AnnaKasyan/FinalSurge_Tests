package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.LoginPage;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Log4j2
public abstract class BaseTest {

    protected final static String EMAIL = System.getenv().getOrDefault("", PropertyReader.getProperty("finalsurge.username"));
    protected final static String PASSWORD = System.getenv().getOrDefault("", PropertyReader.getProperty("finalsurge.password"));
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        log.info("driver initialization");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        log.info("quit from driver");
        driver.quit();
    }

}
