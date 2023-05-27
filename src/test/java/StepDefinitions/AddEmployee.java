package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import Utils.DBUtility;
import Utils.GlobalVariables;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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
        Assert.assertTrue(addEmployeePage.saveBtn.isDisplayed());
        System.out.println("my assertion is returning true");
  doClick(addEmployeePage.saveBtn);

    }
    @When("user enters  {string} and {string} and {string}")
    public void user_enters_and_and(String fname, String mname, String lname) {
        sendText(addEmployeePage.addFirstName,fname);
        sendText(addEmployeePage.addMiddleName,mname);
        sendText(addEmployeePage.addLastName,lname);



    }
    @When("user captures the employee id")
    public void user_captures_the_employee_id() {
        GlobalVariables.emp_id=addEmployeePage.empidLocator.getAttribute("value");
        System.out.println("Emp id is : " +GlobalVariables.emp_id);

    }
    @When("query the information in back end")
    public void query_the_information_in_back_end() {
        String query="select * from hs_hr_employees where employee_id='"+GlobalVariables.emp_id+"'";
        //in this variable we got all the keys and values from the employee search
       GlobalVariables.tabledata= DBUtility.getListOfMapsFromRset(query); //to store the table coming from database we use global variable

    }
    @Then("verify the results from front end and back end")
    public void verify_the_results_from_front_end_and_back_end() {
        //from all these values we need to compare one by one value
       String firstNaneFromDB=GlobalVariables.tabledata.get(0).get("emp_firstname"); // will return the first value for this key
        System.out.println(firstNaneFromDB);
        String lastNameFromDB=GlobalVariables.tabledata.get(0).get("emp_lastname");
        System.out.println(lastNameFromDB);
        String middleNameFromBD=GlobalVariables.tabledata.get(0).get("emp_middle_name");
        System.out.println(middleNameFromBD);
         //adding assertion
        Assert.assertEquals(firstNaneFromDB,"nesha");
        Assert.assertEquals(middleNameFromBD,"sania");
        Assert.assertEquals(lastNameFromDB,"standart");
        System.out.println("my assertion has passed my test case");




    }

}
