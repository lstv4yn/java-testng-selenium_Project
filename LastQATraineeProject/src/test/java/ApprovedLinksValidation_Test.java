import TestPageClasses.HomePageC;
import org.testng.annotations.Test;

public class ApprovedLinksValidation_Test extends StartInitQuit{

    @Test(description = "Проверяем работоспособность главных реферальных ссылок.")
    public void RefsEfficiency() {

        new HomePageC().getOnMainPage()
                .openHelpPage()
                .openHomePage()
                .openProjectsPage()
                .openSignInPage()
                .openRegistrationPage();
    }
}
