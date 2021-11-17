import TestPageClasses.BasePageC;
import TestPageClasses.RegistrationPageC;
import org.testng.annotations.Test;

public class RegistrationProcess_Test extends StartInitQuit {

    @Test(description = "Вводим валидные данные в регистрационную форму.")
    public void checkRegistrationEfficiency () {


        new BasePageC().getOnMainPage().openRegistrationPage()
                .setValidDataOnce("lstvyn", "123321", "Andrii", "Khamko", "jaba@gmail.com", "pewpewpew");
    }
}