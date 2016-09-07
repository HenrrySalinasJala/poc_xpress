@regression
Feature: Getting Started Project

  Background: I create project
    Given I login with valid credentials
    Given I create a new project
      | PROJECT_NAME  | exampleProjectName013        |
      | DISPLAY_NAME  | exampleProjectDisplayName013 |
      | CUSTOMER_NAME | exampleCustomerName013       |
      | MAPPER_FOLDER | /exampleProject013           |
    And I added the user to the project
      | PROJECT_USER_NAME | danielG |
    Then I validate the project fields
    And I expect the user was added
    And stored as Project013

  @DeleteProjects
  Scenario: Started a project from Scratch with a scenario existed

    Given I click on Project013.PROJECT_NAME created
    When I click on Start from Scratch
    And I select the scenario Bid Analysis
    And I click on Start button
    Then I expect the next dimensions for the selected scenario