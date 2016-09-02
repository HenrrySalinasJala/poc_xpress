package com.jalasoft.express.cucumber.stepdefinition.project;

import com.jalasoft.xpress.pages.AdminConsole;
import com.jalasoft.xpress.pages.Dashboard;
import com.jalasoft.xpress.pages.project.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.Collections;
import java.util.Map;
import java.util.stream.IntStream;


/**
 * Created by henrry salinas on 9/1/2016.
 */
public class ProjectStepDef {

    private ProjectManagementPPSA projectManagementPPSA;
    private Map<ProjectSteps,Object> projectStepValues;

    private EditProjectForm editProjectForm;

    public ProjectStepDef() {

        this.projectManagementPPSA=new ProjectManagementPPSA();
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

    @And("^I added the users? to the project$")
    public void iAddedTheUserToTheProject(String userName) {
        projectManagementPPSA.setTxtSearchProject(getProjectSteps().get(ProjectSteps.DISPLAY_NAME).toString());
        editProjectForm=projectManagementPPSA.clickOnEditBtn(getProjectSteps().get(ProjectSteps.DISPLAY_NAME).toString());
        EditProjectUsersForm editProjectUsersForm=editProjectForm.clickOnAddRemoveUserBtn();
        editProjectUsersForm.setTxtAvailableUser(userName)
                            .clickUserAvailableRow(userName)
                            .clickOnAddItemBtn();

    }
}
