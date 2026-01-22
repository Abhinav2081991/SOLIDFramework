Feature: Smoketesting

@Main
Scenario:
Given I am on the Register page of Automation Practice url
When I enter the details in the form
And I CLick on submit button
Then I am able to successfully register

  @Main
  Scenario: Scenario 2
    Given I am on the Register page of Automation Practice url
    When I enter the details in the form
    And I CLick on submit button
    Then I am able to successfully register



  @Datatable
Scenario:
Given I am using a datatable as maps
Then I can fetch data from Datatable


