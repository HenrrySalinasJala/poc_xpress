Feature: Getting Started Project

  Background: I create project
    Given I create a new project
      | PROJECT_NAME  | exampleProjectName11        |
      | DISPLAY_NAME  | exampleProjectDisplayName11 |
      | CUSTOMER_NAME | exampleCustomerName11       |
      | MAPPER_FOLDER | /exampleProject11           |
    Then i validate the project fields
    And stored as Project11
    Given I login with valid credentials

  @CreateScenario @deleteProject
#  Scenario: Started a project from Scratch with a scenario existed
#
#    Given I click on [Project11.name] created
#    When I click on Start from Scratch
#    And I click on Scenery exits
#    Then I expect

  Scenario: Started a project from Scratch with a empty scenery

    Given I click on [project1.name] created
    When I click on Start from Scratch
    And I click on without Scenery
    Then I expect

#  Scenario: Started a project from a project exits
#
#    Given I click on [project1.name] created
#    When I click on Start from project exists
#    And I click on without Scenery
#    Then I expect