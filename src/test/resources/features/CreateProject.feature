Feature: Create PPSA project
  Background: login
    Given I login with valid credentials
  @DeleteProjects
  Scenario: Create a  project and associate user
    Given I create a new project
      | PROJECT_NAME  | project        |
      | DISPLAY_NAME  | ProjectDisplay |
      | CUSTOMER_NAME | customer       |
      | MAPPER_FOLDER | /folder        |
    And I added the user to the project
      | PROJECT_USER_NAME | henrryS |
    Then I validate the project fields
    And I expect the user was added






