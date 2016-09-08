package com.jalasoft.xpress.cucumber.stepdefinition.startedproject;

import com.jalasoft.xpress.cucumber.stepdefinition.login.LoginStepDef;
import com.jalasoft.xpress.cucumber.stepdefinition.project.ProjectStepDef;
import com.jalasoft.xpress.pages.Dashboard;
import com.jalasoft.xpress.pages.Projects;
import com.jalasoft.xpress.pages.startedprojects.Dimensions;
import com.jalasoft.xpress.pages.startedprojects.FromExistingProject;
import com.jalasoft.xpress.pages.startedprojects.FromScenarios;
import com.jalasoft.xpress.pages.startedprojects.SetupDashboard;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static com.jalasoft.xpress.framework.util.Mapper.addProjects;
import static com.jalasoft.xpress.framework.util.Mapper.getValueProject;

/**
 * Created by Daniel Gonzales on 9/2/2016.
 */

public class StartedProjectStepDef {

    private ProjectStepDef projectStepDef;
    private LoginStepDef loginStepDef;
    private Dashboard dashboard;
    private Projects projects;
    private SetupDashboard setupDashboard;
    private FromScenarios fromScenarios;
    private FromExistingProject fromExistingProject;
    private Dimensions dimensions;

    public StartedProjectStepDef(ProjectStepDef projectStepDef, LoginStepDef loginStepDef) {
        this.projectStepDef = projectStepDef;
        this.loginStepDef = loginStepDef;
    }

    @And("^stored as (.*)$")
    public void storedAsProject(String key) {
        addProjects(key, projectStepDef.getProjectStepsMap());
    }

    @Given("^I click on (.*) created$")
    public void iClickOnProjectNameCreated(String mapValue) {
        String myNameProject = getValueProject(mapValue);
        dashboard = loginStepDef.getDashboard();
        projects = dashboard.getMenu().clickMenuProjects();
        projects.checkSeeAllProjects();
        setupDashboard = projects.clickProjectLink(myNameProject);
    }

    @When("^I click on Start from Scratch$")
    public void iClickOnStartFromScratch() {
        fromScenarios = setupDashboard.startScratchProject();
    }

    @And("^I click on Start button$")
    public void iClickOnWithoutScenery() {
        dimensions = fromScenarios.clickStartBtn();
    }

    @And("^I select the scenario (.*)$")
    public void iSelectAScenario(String scenarioName) {
        fromScenarios.checkScenario(scenarioName);
    }

    @When("^I click on Start from Existing Project$")
    public void iClickOnStartFromExistingProject() {
        fromExistingProject = setupDashboard.startExistingProject();
    }

    @And("^I select the (.*) project as template$")
    public void iSelectAProjectExistAsTemplate(String nameProject) {
        fromExistingProject.selectProjectCheck(nameProject);
    }

    @And("^I click on Start project$")
    public void iClickOnStartProject() {
        dimensions = fromExistingProject.clickStartBtn();
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
}
