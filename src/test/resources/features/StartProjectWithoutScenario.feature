@Regression
Feature: Getting Started Project

  Background: I create project
    Given I login with valid credentials
    Given I create a new project
      | PROJECT_NAME  | exampleProjectName002        |
      | DISPLAY_NAME  | exampleProjectDisplayName002 |
      | CUSTOMER_NAME | exampleCustomerName002       |
      | MAPPER_FOLDER | /exampleProject002           |
    And I added the user to the project
      | PROJECT_USER_NAME | danielG |
    Then I validate the project fields
    And I expect the user was added
    And stored as Project002

  @DeleteProjects
  Scenario: Started a project from Scratch with a empty scenery

    Given I click on Project002.PROJECT_NAME created
    When I click on Start from Scratch
    And I click on Start button
    Then I expect any scenario