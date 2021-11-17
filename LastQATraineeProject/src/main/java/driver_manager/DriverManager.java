package driver_manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver driver;

    private static void setDriver() {
        driver = new ChromeDriver(webdriver_config.config_chrome());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        public static WebDriver getDriver () {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver.quit();
    }
}
