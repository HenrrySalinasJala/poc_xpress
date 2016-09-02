package com.jalasoft.express.cucumber.stepdefinition.project;

import com.jalasoft.express.cucumber.stepdefinition.login.LoginStepDef;
import com.jalasoft.xpress.pages.AdminConsole;
import com.jalasoft.xpress.pages.Dashboard;
import com.jalasoft.xpress.pages.Login;
import com.jalasoft.xpress.pages.project.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.Collections;
import java.util.Map;
import java.util.stream.IntStream;

import static com.jalasoft.xpress.pages.project.ProjectSteps.*;
import static javax.swing.UIManager.put;


/**
 * Created by henrry salinas on 9/1/2016.
 */
public class ProjectStepDef {

    private ProjectManagementPPSA projectManagementPPSA;

    private Map<ProjectSteps, Object> projectStepValues;

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

        //modifableMap.put(PROJECT_USER_NAME,userValues.get(PROJECT_USER_NAME));
        projectStepValues.put(PROJECT_USER_NAME, userValues.get(PROJECT_USER_NAME));
        AdminConsole adminConsole = dashboard.getMenu().clickOnMenuAdminConsole();
        projectManagementPPSA = adminConsole.clickOnProjectManagementIcon();
        projectManagementPPSA.setTxtSearchProject(getProjectSteps().get(DISPLAY_NAME).toString());
        editProjectForm = projectManagementPPSA.clickOnEditBtn(getProjectSteps().get(DISPLAY_NAME).toString());

        editProjectUsersForm = editProjectForm.clickOnAddRemoveUserBtn();
        editProjectUsersForm.setTxtAvailableUser(userValues.get(PROJECT_USER_NAME).toString())
                .clickUserAvailableRow(userValues.get(PROJECT_USER_NAME).toString())
                .clickOnAddItemBtn();

    }

    public EditProjectUsersForm getEditProjectUsersForm() {
        return editProjectUsersForm;
    }

    public Map<ProjectSteps, Object> getProjectSteps() {
        return projectStepValues;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

}
