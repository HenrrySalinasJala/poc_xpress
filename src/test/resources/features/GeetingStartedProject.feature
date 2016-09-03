Feature: Getting Started Project

  Background: I create project
    Given I login with valid credentials
    Given I create a new project
      | PROJECT_NAME  | exampleProjectName49        |
      | DISPLAY_NAME  | exampleProjectDisplayName49 |
      | CUSTOMER_NAME | exampleCustomerName49       |
      | MAPPER_FOLDER | /exampleProject49           |
    And I added the user to the project
      | PROJECT_USER_NAME | danielG |
    Then I validate the project fields
    And I expect the user was added
    And stored as Project49

#  @CreateScenario @deleteProject
  Scenario: Started a project from Scratch with a scenario existed

    Given I click on Project49.PROJECT_NAME created
    When I click on Start from Scratch
    And I select the scenario Bid Analysis
    And I click on Start button
#    Then I expect

#  Scenario: Started a project from Scratch with a empty scenery
#
#    Given I click on Project49.PROJECT_NAME created
#    When I click on Start from Scratch
#    And I click on Start button
##    Then I expect

#  Scenario: Started a project from a project exits

#    Given I click on Project49.PROJECT_NAME created
#    When I click on Start from Existing Project
#    And I click on without Scenery
#    Then I expect