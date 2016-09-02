package com.jalasoft.express.cucumber.stepdefinition.StartedProject;

import com.jalasoft.express.cucumber.stepdefinition.login.LoginStepDef;
import com.jalasoft.express.cucumber.stepdefinition.project.ProjectStepDef;
import com.jalasoft.xpress.pages.Dashboard;
import com.jalasoft.xpress.pages.Mapper;
import com.jalasoft.xpress.pages.Menu;
import com.jalasoft.xpress.pages.Projects;
import com.jalasoft.xpress.pages.StartedProjects.FromExistingProject;
import com.jalasoft.xpress.pages.StartedProjects.FromScenarios;
import com.jalasoft.xpress.pages.StartedProjects.SetupDashboard;
import com.jalasoft.xpress.pages.project.ProjectSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.Map;

import static com.jalasoft.xpress.pages.Mapper.addProjects;

/**
 * Created by Daniel Gonzales on 9/2/2016.
 */

public class StartedProjectStepDef {

    private ProjectStepDef projectStepDef;
    LoginStepDef loginStepDef;
    Dashboard dashboard;
    Projects projects;
    SetupDashboard setupDashboard;
    FromExistingProject fromExistingProject;
    FromScenarios fromScenarios;
    Map<String, Map> valuesProject;
    String key;


    public StartedProjectStepDef(ProjectStepDef projectStepDef, LoginStepDef loginStepDef) {
        this.projectStepDef = projectStepDef;
        this.loginStepDef = loginStepDef;
    }

    @And("^stored as (.*)$")
    public void storedAsProject(String key) {
        valuesProject = addProjects(key, projectStepDef.getProjectSteps());
        this.key = key;
    }

    @Given("^I click on (.*) created$")
    public void iClickOnProjectNameCreated(String nameProject) {
        String myNameProject = String.valueOf(valuesProject.get(key).get(ProjectSteps.PROJECT_NAME));
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

    }


}
