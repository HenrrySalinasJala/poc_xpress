package com.jalasoft.express.cucumber.stepdefinition.project;

import com.jalasoft.xpress.pages.AdminConsole;
import com.jalasoft.xpress.pages.Dashboard;
import com.jalasoft.xpress.pages.project.EditProjectForm;
import com.jalasoft.xpress.pages.project.ProjectForm;
import com.jalasoft.xpress.pages.project.ProjectManagementPPSA;
import com.jalasoft.xpress.pages.project.ProjectSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.Collections;
import java.util.Map;
import java.util.stream.IntStream;


/**
 * Created by henrry salinas on 9/1/2016.
 */
public class ProjectStepDef {

    private Map<ProjectSteps,Object> projectStepValues;

    private EditProjectForm editProjectForm;

    public ProjectStepDef() {
        this.editProjectForm = new EditProjectForm();
    }

    @Given("^I created? a new project$")
    public void iCreateANewProject(Map<ProjectSteps,Object> values) {

        projectStepValues=values;
        Dashboard dashboard=new Dashboard();
        AdminConsole adminConsole=dashboard.getMenu().clickOnMenuAdminConsole();
        ProjectManagementPPSA projectManagementPPSA=adminConsole.clickOnProjectManagementIcon();
        ProjectForm projectForm=projectManagementPPSA.clickOnCreateProjectBtn();
        projectForm.strategyStepMap(values);

        projectForm.clickOnSaveBtn();
    }


    public Map<ProjectSteps, Object> getProjectSteps() {
        return projectStepValues;
    }


    public EditProjectForm getEditProjectForm() {
        return editProjectForm;
    }
}
