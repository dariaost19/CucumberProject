package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.lang.annotation.Target;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features",
        glue = "StepDefinitions",
        dryRun = false,
        plugin = {"pretty",
               "html:target/Cucumber.html",
               "json:target/Cucumber.json","rerun:target/failed.txt"},
        tags = "@database")


public class SmokeRunner {
    /*
   #HOOKS: For defining pre and Post steps in any Cucumber framework
    #     : This is always created inside the StepDefinitions folder
    #     : Hooks will take care of pre and post conditions irrespective
    #     : of what goes in between the test steps

    #BACKGROUND: Its the clubbing of common steps in different scenarios of a feature file
   #             till flow is not broken
   #1. Hard Code
   #2. Config file
   #-----------------Cucumber itself provides multiple option through which we can feed data from
   # feature file into Step Definition---------------------------------------------
   #3. Regular Expressions
       # put the data in double quotes [""]
  #===================================PARAMETERIZATION================================
  # Executing the same test case with multiple data

  #If you want to use parameterization
#If you wish to implement data driven testing
  # Scenario Outline is always used along with the keyword 'Examples'

#If you want to use parameterization
#If you wish to implement data driven testing
  # Scenario Outline is always used along with the keyword 'Examples'

#If you want to use parameterization
#If you wish to implement data driven testing
  # Scenario Outline is always used along with the keyword 'Examples'
     */

    //Target folder is mostly used for storing the test case execution reports generated  using Cucumber

}

