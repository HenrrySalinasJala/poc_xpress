
Feature: Create PPSA project

  Background: login
    Given I login with valid credentials

  Scenario: Create a  project and associate user
    Given I create a new project
      | PROJECT_NAME  | exampleProjectName12        |
      | DISPLAY_NAME  | exampleProjectDisplayName12 |
      | CUSTOMER_NAME | exampleCustomerName12       |
      | MAPPER_FOLDER | /exampleProject12           |
    And I added the user to the project
      | PROJECT_USER_NAME | henrryS |
    Then I validate the project fields
    And I expect the user was added



