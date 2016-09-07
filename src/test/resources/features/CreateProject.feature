@smoke
Feature: Create PPSA project

  Background: login
    Given I login with valid credentials

  @DeleteProjects
  Scenario: Create a  project and associate user
    Given I create a new project
      | PROJECT_NAME  | proj   |
      | DISPLAY_NAME  | disp   |
      | CUSTOMER_NAME | cust   |
      | MAPPER_FOLDER | /folde |
    And I added the user to the project
      | henrryS  |
      | danielG  |
      | mijhailV |
    Then I validate the project fields
    And I expect the user was added






