package com.jalasoft.express.cucumber.stepdefinition.StartedProject;

import com.jalasoft.express.cucumber.stepdefinition.login.LoginStepDef;
import com.jalasoft.express.cucumber.stepdefinition.project.ProjectStepDef;
import com.jalasoft.xpress.pages.Dashboard;
import com.jalasoft.xpress.pages.Mapper;
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
//        dashboard = loginStepDef.
    }

    @When("^I click on Start from Scratch$")
    public void iClickOnStartFromScratch() {

    }

    @And("^I click on without Scenery$")
    public void iClickOnWithoutScenery()  {

    }


}
