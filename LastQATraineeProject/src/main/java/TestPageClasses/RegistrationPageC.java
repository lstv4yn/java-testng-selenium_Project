package TestPageClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationPageC extends BasePageC {

    WebElement user_login = findByID("user_login", Duration.ofSeconds(10));
    WebElement password = findByID("user_password", Duration.ofSeconds(10));
    WebElement pass_confirm = findByID("user_password_confirmation", Duration.ofSeconds(10));
    WebElement first_name = findByID("user_firstname", Duration.ofSeconds(10));
    WebElement last_name = findByID("user_lastname", Duration.ofSeconds(10));
    WebElement user_email = findByID("user_mail", Duration.ofSeconds(10));
    WebElement irc_nickname = findByID("user_custom_field_values_3", Duration.ofSeconds(10));
    WebElement submitButton = findByCSS("[name='commit']", Duration.ofSeconds(10));
    WebElement ErrorWindow = findByID("errorExplanation", Duration.ofSeconds(10));

    public RegistrationPageC setValidDataOnce(String login, String pass, String fName, String lName, String email, String ircNick) {
        user_login.sendKeys(login);
        password.sendKeys(pass);
        pass_confirm.sendKeys(pass);
        first_name.sendKeys(fName);
        last_name.sendKeys(lName);
        user_email.sendKeys(email);
        irc_nickname.sendKeys(ircNick);
        submitButton.click();
        return this;
    }

    public void SetUserLogin(String login) {
        user_login.sendKeys(login);
    }
    public void SetPassword(String passw) {
        password.sendKeys(passw);
    }
    public void SetPassConfirm(String passw) {
        pass_confirm.sendKeys(passw);
    }
    public void SetFirstname(String fName) {
        first_name.sendKeys(fName);
    }
    public void SetLastName(String lName) {
        last_name.sendKeys(lName);
    }
    public void SetUserEmail(String email) {
        user_email.sendKeys(email);
    }
    public void SetIRC_Nick(String IRC) {
        irc_nickname.sendKeys(IRC);
    }
    public void SendData() {
        submitButton.click();
    }

    public String ErrorDisplay() {
        return ErrorWindow.getText();
    }


    public boolean ErrorAppeared(String error) {
        if(ErrorDisplay().contains(error))
        {
            Assert.assertEquals(ErrorDisplay(), error);
            return false;
        }
        else
        {
            return true;
        }

    }
}
