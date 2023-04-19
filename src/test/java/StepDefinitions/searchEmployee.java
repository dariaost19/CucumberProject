package StepDefinitions;

import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class searchEmployee extends CommonMethods {
    @When("user enters valid employee Id")
    public void user_enters_valid_employee_id() {
      WebElement empIdTextBox= driver.findElement(By.id("empsearch_id"));
      sendText(empIdTextBox, ConfigReader.getPropertyValue("empId"));


    }
    @When("clicks on search button")
    public void clicks_on_search_button() {
        WebElement searchBtn=driver.findElement(By.id("searchBtn"));
        doClick(searchBtn);

    }
    @When("user see employee info is displayed")
    public void user_see_employee_info_is_displayed() {
        System.out.println("The employee is Displayed ");

    }
    @When("user select job title")
    public void user_select_job_title() {
       WebElement jobTitle= driver.findElement(By.id("empsearch_job_title"));
selectByOptions(jobTitle,"Singer");
        //WebElement empStatusDetail=driver.findElement(By.id("empsearch_employee_status"));
        //selectByOptions(empStatusDetail,"Active");

     //   WebElement includeDdl= driver.findElement(By.id("empsearch_termination"));
      //  selectByOptions(includeDdl, "Current and Past Employees");
    }


}
