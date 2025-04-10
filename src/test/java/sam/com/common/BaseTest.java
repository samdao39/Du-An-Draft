package sam.com.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import sam.com.constants.constants.ConfigData;
import sam.com.constants.constants.drivers.DriverManager;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void createDrive(String browser) {
        // WebDriver driver;
        if (ConfigData.BROWSER != null && !ConfigData.BROWSER.isEmpty()) {
            driver = setUpBrowser(ConfigData.BROWSER);
        } else {
            driver = setUpBrowser(browser);
        }
        DriverManager.setDriver(driver);// gan gia tri driver vao threadlocal
    }

    public WebDriver setUpBrowser(String browserName) {
        // WebDriver driver;// driver cuc bo
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
        ChromeOptions options = new ChromeOptions();
        // Disable notifications
        options.addArguments("--disable-notifications");
        // Disable password saving and filling
        options.addArguments("--password-store=basic");
        // Disable Chrome's built-in password manager
        options.addArguments("--disable-features=PasswordManager");
        // Optional: Use incognito mode
        options.addArguments("--incognito");
        // Optional: Disable all extensions
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initSafariDriver() {
        driver = new SafariDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initFirefoxDriver() {
        driver = new FirefoxDriver();
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

