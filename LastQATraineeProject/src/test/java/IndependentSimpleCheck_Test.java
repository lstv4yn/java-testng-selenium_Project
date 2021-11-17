import TestPageClasses.BasePageC;
import TestPageClasses.HomePageC;
import TestPageClasses.RegistrationPageC;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class IndependentSimpleCheck_Test extends StartInitQuit {
    Fillo fillo = new Fillo();

    @BeforeTest
            public void Beginning() {
        new HomePageC().getOnMainPage().openRegistrationPage();
    }


    String WrongLogin = "Login is invalid";
    String ShortPassword = "Password is too short (minimum is 4 characters)";
    String MatchPassword = "Password doesn't match confirmation";
    String WrongEmail = "Email is invalid";
    String EmptyLogin = "Login can't be blank";
    String EmptyFName = "First name can't be blank";
    String EmptyLName = "Last name can't be blank";
    String EmptyEmail = "Email can't be blank";

    public String ExcelExtracting (String column) throws FilloException {
        Connection con1 = fillo.getConnection("E:\\QA Java\\LastQATraineeProject\\excelFiles\\FirstTable.xlsx");
        String data1 = "Select * from Лист1";
        Recordset recordset = con1.executeQuery(data1);
        recordset.next();
        con1.close();
        return recordset.getField(column);
    }

    public void ExcelUpdate(String error, int ID) throws FilloException {
        Connection con2 = fillo.getConnection("E:\\QA Java\\LastQATraineeProject\\excelFiles\\SecondTable.xlsx");
        String data2;
        RegistrationPageC reg = new RegistrationPageC();
        if(reg.ErrorAppeared(error)) {
            data2 = "Update Лист1 Set result = 'Successfully!' Where ID = " + ID + "";
        }
        else
        {
            data2 = "Update Лист1 Set result = 'Unsuccessfully!' Where ID = " + ID + "";
        }
        con2.executeQuery(data2);
        con2.close();

    }


    @Test(priority = 1)
    public void GetRegistrationPage() {
        new BasePageC().getOnMainPage().openRegistrationPage();
    }

    public void LoginInput()  throws FilloException, IOException {

    }
}
