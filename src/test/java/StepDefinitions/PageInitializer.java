package StepDefinitions;

import Pages.AddEmployeePage;
import Pages.LoginPage;

public class PageInitializer {

    public  static LoginPage login;
    public  static AddEmployeePage addEmployeePage;
    public  static void initializePageObjects()
    {
        login = new LoginPage();
        addEmployeePage= new AddEmployeePage();
    }

}
//this class will manage object creation of different page objects in our framework instead of calling the page object again and again