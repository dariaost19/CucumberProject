Feature:  Employee
   @smoke
  Scenario: Adding a new Employee
  #  Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    When user click on PIM option
    And user is clicking on add employee button
    And user enters firstname and middllename and lastname
  #  And close the browser
   # And user clicks on save button


