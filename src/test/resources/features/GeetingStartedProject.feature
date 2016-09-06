Feature: Getting Started Project

  Background: I create project
    Given I login with valid credentials
    Given I create a new project
      | PROJECT_NAME  | exampleProjectName637815       |
      | DISPLAY_NAME  | exampleProjectDisplayName63715 |
      | CUSTOMER_NAME | exampleCustomerName63715      |
      | MAPPER_FOLDER | /exampleProject63715           |
    And I added the user to the project
      | PROJECT_USER_NAME | danielG |
    Then I validate the project fields
    And I expect the user was added
    And stored as Project63715

  Scenario: Started a project from Scratch with a scenario existed

    Given I click on Project63715.PROJECT_NAME created
    When I click on Start from Scratch
    And I select the scenario Bid Analysis
    And I click on Start button
    Then I expect the next dimensions for the selected scenario


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