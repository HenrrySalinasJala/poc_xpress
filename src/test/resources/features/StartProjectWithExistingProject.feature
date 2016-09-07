Feature: Getting Started Project

  Background: I create project
    Given I login with valid credentials
    Given I create a new project
      | PROJECT_NAME  | exampleProjectName004        |
      | DISPLAY_NAME  | exampleProjectDisplayName004 |
      | CUSTOMER_NAME | exampleCustomerName004       |
      | MAPPER_FOLDER | /exampleProject004          |
    And I added the user to the project
      | PROJECT_USER_NAME | danielG |
    Then I validate the project fields
    And I expect the user was added
    And stored as Project004
  @DeleteProjects @Regression
  Scenario: Started a project from a project exits

    Given I click on Project004.PROJECT_NAME created
    When I click on Start from Existing Project
    And I select the Automation1 project as template
    And I click on Start project
    Then I expect the next dimensions for the selected project