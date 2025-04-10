package sam.com.constants.constants.drivers;

import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {

        return threadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        threadLocal.set(driver);

    }

    public static void quit() {
        threadLocal.get().quit();
        threadLocal.remove();
    }
}
