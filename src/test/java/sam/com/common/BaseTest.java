package sam.com.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import sam.com.constants.constants.drivers.DriverManager;
import sam.com.pageObjectModal.Pages.CommonPage;

import java.time.Duration;

public class BaseTest extends CommonPage {

    @BeforeMethod
    public void createDriver() {

        WebDriver driver = setUpDriver("");
        DriverManager.setDriver(driver);
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

        private WebDriver initFirefoxDriver(){
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

