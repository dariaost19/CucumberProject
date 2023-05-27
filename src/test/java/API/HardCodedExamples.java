package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.checkerframework.checker.fenum.qual.SwingTextOrientation;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardCodedExamples {
    static String employee_id;
    String baseURI=RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUxOTQwODcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTIzNzI4NywidXNlcklkIjoiNTI0NyJ9.gw9y1rOMB-IhNikNkVotH1aO6XKz-QmuYL22oWPLCHg";

    @Test
    public void bGetCreatedEmployee() {
        RequestSpecification prepareRequest = given().header("Content-Type", "application/json").header("Authorization", token).queryParam("employee_id", employee_id);
        Response response = prepareRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        // verify the response
        response.then().assertThat().statusCode(200);
       String tempEmpId= response.jsonPath().getString("employee.employee_id");
       // we have 2 employee id (1 is global , 1 is local )
        Assert.assertEquals(employee_id,tempEmpId);
    }


        @Test
    public void acreateEmployee(){
        //prepare the request
        RequestSpecification prepareRequest=given().header("Content-Type","application/json").header("Authorization",token).body("{\n" +
                "  \"emp_firstname\": \"Helana\",\n" +
                "  \"emp_lastname\": \"Sariaf\",\n" +
                "  \"emp_middle_name\": \"j\",\n" +
                "  \"emp_gender\": \"F\",\n" +
                "  \"emp_birthday\": \"1995-05-20\",\n" +
                "  \"emp_status\": \"Confirmed\",\n" +
                "  \"emp_job_title\": \"Engineer\"\n" +
                "}");
        //hitting the endpoint
      Response response= prepareRequest.when().post("/createEmployee.php"); // we are making a record in the DB


        //verifying the assertions
        response.then().assertThat().statusCode(201);
        // we are capturing employee id from the response
      employee_id= response.jsonPath().getString("Employee.employee_id");
       System.out.println(employee_id);

        // verifying firstname in the response body
       response.then().assertThat().body("Employee.employee_id",equalTo(employee_id));
        response.then().assertThat().body("Employee.emp_firstname",equalTo("Helana"));
        response.then().assertThat().body("Employee.emp_lastname",equalTo("Sariaf"));
        response.then().assertThat().body("Employee.emp_birthday",equalTo("1995-05-20"));
        response.then().assertThat().body("Employee.emp_job_title",equalTo("Engineer"));
       System.out.println("My test case is passed");

        // it will print the output in the console
        response.prettyPrint();


    }
    @Test
    public void cUpdateEmployee(){
        RequestSpecification prepareRequest=given().header("Content-Type","application/json").header("Authorization",token).body("{\n" +
                "  \"employee_id\": \""+employee_id+"\",\n" +
                "  \"emp_firstname\": \"Human\",\n" +
                "  \"emp_lastname\": \"Kind\",\n" +
                "  \"emp_middle_name\": \"k\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1998-05-20\",\n" +
                "  \"emp_status\": \"full time\",\n" +
                "  \"emp_job_title\": \"QA Lead\"\n" +
                "}");

        // hitting the end point
       Response response=prepareRequest.put("/updateEmployee.php");
       response.then().assertThat().statusCode(200);
       response.then().assertThat().body("Message",equalTo("Employee record Updated"));
    }
    @Test
    public void dGetUpdatedEmployee(){
        RequestSpecification prepareRequest = given().header("Content-Type", "application/json").header("Authorization", token).queryParam("employee_id", employee_id);
        Response response=prepareRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //if you want to verify the body of the response you can do it using Hamcrest matchers

    }
    @Test
    public void eGetEmployeeStatus(){
        RequestSpecification prepareRequest=given().header("Content-Type","application/json").header("Authorization",token);
        Response response=prepareRequest.when().get("/employeementStatus.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
    @Test
    public void fGetJobTitle(){
        RequestSpecification prepareRequest=given().header("Content-Type","application/json").header("Authorization",token);
        Response response=prepareRequest.when().get("/jobTitle.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

}

