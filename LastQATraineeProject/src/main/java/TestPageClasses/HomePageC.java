package TestPageClasses;

import com.codoid.products.fillo.Fillo;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePageC extends BasePageC {

    public RegistrationPageC openRegistrationPage () {
        findByCSS("[href='/account/register']", Duration.ofSeconds(10)).click();
        return new RegistrationPageC();
    }

    public HomePageC openHomePage () {
        findByXpath("(//a[@href='/'])[1]", Duration.ofSeconds(10)).click();
        return new HomePageC();
    }

    public HomePageC openProjectsPage() {
        findByCSS("[href='/projects']", Duration.ofSeconds(10)).click();
        return new HomePageC();
    }

    public HomePageC openHelpPage() {
        findByCSS("[href='http://www.redmine.org/guide']", Duration.ofSeconds(10)).click();
        return new HomePageC();
    }

    public HomePageC openSignInPage() {
        findByCSS("[href='/login']", Duration.ofSeconds(10)).click();
        return new HomePageC();
    }
}
