@smoke
Feature: Create PPSA project

  Background: login
    Given I login with valid credentials

  @DeleteProjects
  Scenario: Create a  project and associate user
    Given I create a new project
      | PROJECT_NAME  | projectExample  |
      | DISPLAY_NAME  | displayExample  |
      | CUSTOMER_NAME | customerExample |
      | MAPPER_FOLDER | /folderExample  |
    And I added the user to the project
      | PROJECT_USER_NAME | henrryS |
    Then I validate the project fields
    And I expect the user was added






