package sam.com.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import sam.com.constants.constants.ConfigData;
import sam.com.constants.constants.drivers.DriverManager;
import sam.com.constants.helpers.PropertiesHelper;
import sam.com.pageObjectModal.Pages.CommonPage;

import java.io.ObjectInputFilter;
import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(String browser) {
        WebDriver driver;
        if (ConfigData.BROWSER != null && !ConfigData.BROWSER.isEmpty()) {
            driver = setUpDriver(ConfigData.BROWSER);
        } else {
            driver = setUpDriver(browser);
        }
        DriverManager.setDriver(driver);// gan gia tri driver vao threadlocal
    }

    public WebDriver setUpDriver(String browserName) {
        WebDriver driver;// driver cuc bo
        switch (browserName.trim().toLowerCase()) {
            case "safari":
                driver = initSafariDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            default:
                driver = initChromeDriver();
        }
        return driver;
    }

    private WebDriver initChromeDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initSafariDriver() {
        WebDriver driver = new SafariDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initFirefoxDriver() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }


    @AfterMethod
    public void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }

};

