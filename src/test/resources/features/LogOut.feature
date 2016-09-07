@smoke
Feature: Log out for xpress

  Background: login
    Given I login with valid credentials

  Scenario: Test log out
    Given I log out for the application
    Then The Login button is present