Feature: Login

@positiveTest
  Scenario: Successful Login
    Given User is on Home Page
    When User click on Login icon
#    Then User verifies Login form is displayed
    And User enter valid data
    And User clicks on Anmelden button
    And User click on User icon
    Then User verifies his name