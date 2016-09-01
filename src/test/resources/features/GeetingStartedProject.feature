Feature: Getting Started Project

  Background: I login into pivotal
    Given I create project
      | name | testPOC1 |
    And stored as project1
    Given I login with valid credentials

  @CreateScenery @deleteProject
  Scenario: Started a project from Scratch with a scenery exited

    Given I click on [project1.name] created
    When I click on Start from Scratch
    And I click on Scenery exits
    Then I expect

  Scenario: Started a project from Scratch with a empty scenery

    Given I click on [project1.name] created
    When I click on Start from Scratch
    And I click on without Scenery
    Then I expect

  Scenario: Started a project from a project exits

    Given I click on [project1.name] created
    When I click on Start from project exists
    And I click on without Scenery
    Then I expect