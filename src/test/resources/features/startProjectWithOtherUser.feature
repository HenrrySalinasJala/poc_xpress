@Regression
Feature: Getting Started Project

  Background: I create project
    Given I login with valid credentials
    Given I create a new project
      | PROJECT_NAME  | ProjectName            |
      | DISPLAY_NAME  | ProjectDisplayName     |
      | CUSTOMER_NAME | exampleCustomerName013 |
      | MAPPER_FOLDER | /exampleProject013     |
    And I added the user to the project
      | danielG  |
      | mijhailV |
    Then I validate the project fields
    And I expect the user was added
    And stored as Project

  @DeleteProjects
  Scenario: Started a project from Scratch with a scenario existed, but other user

    Given I login with credentials
      | userName | mijhailV  |
      | password | admin123P |
    And I click on Project.PROJECT_NAME created
    When I click on Start from Scratch
    And I select the scenario Bid Analysis
    And I click on Start button