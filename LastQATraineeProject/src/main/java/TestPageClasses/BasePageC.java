package TestPageClasses;

import com.codoid.products.fillo.Fillo;
import driver_manager.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class BasePageC {

    protected WebDriver driver;

    protected String MainPage = "https://www.redmine.org/";

    public BasePageC() {
        this.driver = DriverManager.getDriver();
    }

    public WebElement findByXpath(String xpath, Duration duration) {
        return driver.findElement(waitForElementVisible(By.xpath(xpath), duration.getSeconds()));
    }

    public WebElement findByID(String ID, Duration duration) {
        return driver.findElement(waitForElementVisible(By.id(ID), duration.getSeconds()));
    }

    public WebElement findByCSS(String CSS, Duration duration) {
        return driver.findElement(waitForElementVisible(By.cssSelector(CSS), duration.getSeconds()));
    }

    private WebDriverWait getWaiter(long timeOutInSeconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds);
        webDriverWait.ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class);
        return webDriverWait;
    }

    public By waitForElementVisible(By findStrategy, long timeOutInSeconds) {
        getWaiter(timeOutInSeconds).until(visibilityOfElementLocated(findStrategy));
        return findStrategy;
    }

    public HomePageC getOnMainPage() {
        DriverManager.getDriver().get(MainPage);
        return new HomePageC();
    }
}
