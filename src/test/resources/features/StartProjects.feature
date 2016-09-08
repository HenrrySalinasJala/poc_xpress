@regression
Feature: Getting Started Project

  Background: I create project
    Given I login with valid credentials
    Given I create a new project
      | PROJECT_NAME  | ProjectName            |
      | DISPLAY_NAME  | ProjectDisplayName     |
      | CUSTOMER_NAME | exampleCustomerName    |
      | MAPPER_FOLDER | /exampleProject        |
    And I added the user to the project
      | danielG  |
      | mijhailV |
    Then I validate the project fields
    And I expect the user was added
    And stored as myProject

  @DeleteProjects
  Scenario: Started a project from Scratch with a scenario existed, but other user

    Given I login with credentials
      | userName | mijhailV  |
      | password | admin123P |
    And I click on myProject.PROJECT_NAME created
    When I click on Start from Scratch
    And I select the scenario Bid Analysis
    And I click on Start button

  @DeleteProjects
  Scenario: Started a project from Scratch with a empty scenario

    Given I click on myProject.PROJECT_NAME created
    When I click on Start from Scratch
    And I click on Start button
    Then I expect any scenario

  @DeleteProjects
  Scenario: Started a project from Scratch with a scenario existed

    Given I click on myProject.PROJECT_NAME created
    When I click on Start from Scratch
    And I select the scenario Bid Analysis
    And I click on Start button
    Then I expect the next dimensions for the selected scenario

  @DeleteProjects
  Scenario: Started a project from a project exits

    Given I click on myProject.PROJECT_NAME created
    When I click on Start from Existing Project
    And I select the Automation1 project as template
    And I click on Start project
    Then I expect the next dimensions for the selected project
