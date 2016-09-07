@smoke
Feature: Testing for login Xpress

  Scenario: Login with valid credentials

    Given I login with valid credentials
    Then I expect the userName is displayed

  Scenario: Login with invalid credentials
    Given I login with credentials
      | userName | pedroP |
      | password | 1123   |
    Then I expect the message say: Verify that you have entered your PROS network credentials correctly.
