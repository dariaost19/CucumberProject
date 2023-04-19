Feature: Searching the employee
  Background:
    When user enters valid email and valid password
    And click on login button
    When user click on PIM option
  @smoke1
  Scenario: Search employee by Id
   # Given open the browser and launch HRMS application
  #  When user enters valid email and valid password
   # And click on login button
   # When user click on PIM option
    When user enters valid employee Id
    And clicks on search button
    And user see employee info is displayed
  #  And close the browser

@smoke1
    Scenario: Search employee by Job Title
     # Given open the browser and launch HRMS application
   #   When user enters valid email and valid password
     # And click on login button
    #  When user click on PIM option
      When user select job title
      And clicks on search button
      And user see employee info is displayed
     # And close the browser

  #Background is used to define all the common steps that multiple test scenarios have in the same feature file till the flow is not broken
