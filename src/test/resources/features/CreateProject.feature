Feature: Create PPSA project

  Background: login
    Given I login with valid credentials

  Scenario: Create a  project and associate user
    Given I create a new project
      | PROJECT_NAME  | exampleProjectName13        |
      | DISPLAY_NAME  | exampleProjectDisplayName13 |
      | CUSTOMER_NAME | exampleCustomerName13       |
      | MAPPER_FOLDER | /exampleProject13           |
    And I added the user to the project
      | PROJECT_USER_NAME | henrryS |
    Then I validate the project fields
    And I expect the user was added



