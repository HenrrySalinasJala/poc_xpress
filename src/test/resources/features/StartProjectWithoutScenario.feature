Feature: Getting Started Project

  Background: I create project
    Given I login with valid credentials
    Given I create a new project
      | PROJECT_NAME  | exampleProjectName003        |
      | DISPLAY_NAME  | exampleProjectDisplayName003 |
      | CUSTOMER_NAME | exampleCustomerName003       |
      | MAPPER_FOLDER | /exampleProject003           |
    And I added the user to the project
      | PROJECT_USER_NAME | danielG |
    Then I validate the project fields
    And I expect the user was added
    And stored as Project003

  @DeleteProjects @Regression
  Scenario: Started a project from Scratch with a empty scenery

    Given I click on Project003.PROJECT_NAME created
    When I click on Start from Scratch
    And I click on Start button
    Then I expect any scenario