Feature: Create PPSA project

  Background: login
    Given I login with valid credentials

  Scenario: Create a new project
    Given I create a new project
      | PROJECT_NAME  | exampleProjectName10        |
      | DISPLAY_NAME  | exampleProjectDisplayName10 |
      | CUSTOMER_NAME | exampleCustomerName10       |
      | MAPPER_FOLDER | /exampleProject10           |
    And I added a user to the project
    Then I validate the project fields
    And I expect the user was added



