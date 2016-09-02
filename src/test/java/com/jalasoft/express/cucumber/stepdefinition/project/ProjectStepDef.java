package com.jalasoft.express.cucumber.stepdefinition.project;

import com.jalasoft.express.cucumber.stepdefinition.login.LoginStepDef;
import com.jalasoft.xpress.pages.AdminConsole;
import com.jalasoft.xpress.pages.Dashboard;
import com.jalasoft.xpress.pages.project.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.Map;

import static com.jalasoft.xpress.pages.project.ProjectSteps.*;


/**
 * Created by henrry salinas on 9/1/2016.
 */
public class ProjectStepDef {

    private ProjectManagementPPSA projectManagementPPSA;

    private Map<ProjectSteps, Object> projectStepValues;

    private Map<ProjectSteps, Object> projectUsers;

    private EditProjectUsersForm editProjectUsersForm;
    private ProjectForm projectForm;

    private EditProjectForm editProjectForm;
    private Dashboard dashboard;

    public ProjectStepDef(LoginStepDef loginStepDef) {
        this.dashboard = loginStepDef.getDashboard();
    }

    @Given("^I created? a new project$")
    public void iCreateANewProject(Map<ProjectSteps, Object> values) {

        projectStepValues = values;
        AdminConsole adminConsole = dashboard.getMenu().clickOnMenuAdminConsole();
        projectManagementPPSA = adminConsole.clickOnProjectManagementIcon();
        projectForm = projectManagementPPSA.clickOnCreateProjectBtn();
        projectForm.strategyStepMap(values);
        projectForm.clickOnSaveBtn();
    }

    @And("^I added the users? to the project$")
    public void iAddedTheUserToTheProject(Map<ProjectSteps, Object> userValues) {
        projectUsers=userValues;

        AdminConsole adminConsole = dashboard.getMenu().clickOnMenuAdminConsole();
        projectManagementPPSA = adminConsole.clickOnProjectManagementIcon();
        projectManagementPPSA.setTxtSearchProject(getProjectStepsMap().get(DISPLAY_NAME).toString());
        editProjectForm = projectManagementPPSA.clickOnEditBtn(getProjectStepsMap().get(DISPLAY_NAME).toString());

        editProjectUsersForm = editProjectForm.clickOnAddRemoveUserBtn();
        editProjectUsersForm.setTxtAvailableUser(userValues.get(PROJECT_USER_NAME).toString())
                .clickUserAvailableRow(userValues.get(PROJECT_USER_NAME).toString())
                .clickOnAddItemBtn()
                .clickOnAssociateAllBtn();

    }

    @And("^I added a user to the project$")
    public void iAddedAUserToTheProject()   {


    }

    public EditProjectUsersForm getEditProjectUsersForm() {
        return editProjectUsersForm;
    }
    public Map<ProjectSteps, Object> getProjectStepsMap() {
        return projectStepValues;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public Map<ProjectSteps, Object> getProjectUsersMap() {
        return projectUsers;
    }

}
