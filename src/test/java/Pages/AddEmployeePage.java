package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimTab;
    @FindBy(id = "menu_pim_addEmployee")
    public WebElement pimAddEmployee;
    @FindBy(id = "firstName")
    public WebElement addFirstName;
    @FindBy(id = "middleName")
    public WebElement addMiddleName;
    @FindBy(id = "lastName")
    public WebElement addLastName;
    @FindBy(id = "btnSave")
    public WebElement saveBtn;

    public AddEmployeePage(){

        PageFactory.initElements(driver,this); //initialize driver which is on this page
    }

}
