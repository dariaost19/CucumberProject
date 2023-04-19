package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEmployee extends CommonMethods {
    @When("user click on PIM option")
    public void user_click_on_pim_option() {
    // WebElement pimTab= driver.findElement(By.id("menu_pim_viewPimModule"));
  doClick(addEmployeePage.pimTab);

    }
    @When("user is clicking on add employee button")
    public void user_is_clicking_on_add_employee_button() {
  //   WebElement pimAddEmployee= driver.findElement(By.id("menu_pim_addEmployee"));
     doClick(addEmployeePage.pimAddEmployee);

    }
    @When("user enters firstname and middllename and lastname")
    public void user_enters_firstname_and_middllename_and_lastname() {

    //   WebElement addFirstName= driver.findElement(By.id("firstName"));
       sendText(addEmployeePage.addFirstName, ConfigReader.getPropertyValue("firstName"));
     //  WebElement addMiddleName= driver.findElement(By.id("middleName"));
       sendText(addEmployeePage.addMiddleName,ConfigReader.getPropertyValue("middleName"));
    //   WebElement addLastName= driver.findElement(By.id("lastName"));
       sendText(addEmployeePage.addLastName,ConfigReader.getPropertyValue("lastName"));


    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
 // WebElement saveBtn= driver.findElement(By.id("btnSave"));
  doClick(addEmployeePage.saveBtn);

    }

}
