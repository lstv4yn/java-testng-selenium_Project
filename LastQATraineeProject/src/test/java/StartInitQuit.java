import driver_manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.sql.Driver;

public class StartInitQuit {

    @AfterTest
    public void kill() {

        DriverManager.closeDriver();

    }
}
