Feature: Login

@positiveTest
  Scenario: Successful Login
    Given User is on Home Page
    When User click on Login icon
    And User enter valid data
    And User clicks on Anmelden button
    And User click on User icon
    Then User verifies his name

  @negativeTest
  Scenario: Unsccessful Login
    Given User is on Home Page
    When User click on Login icon
    And User enter invalid data
    And User clicks on Anmelden button
    Then User verifies incorrect email prompt
