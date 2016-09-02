Feature: Create PPSA project

  Background: login
    Given I login with valid credentials
  @DeleteProjects
  Scenario: Create a new project
    Given I create a new project
      | PROJECT_NAME  | exampleProjectName451        |
      | DISPLAY_NAME  | exampleProjectDisplayName10 |
      | CUSTOMER_NAME | exampleCustomerName10       |
      | MAPPER_FOLDER | /exampleProject10           |
    And I added the user to the project
      | PROJECT_USER_NAME | HenrryS |
    Then i validate the project fields


