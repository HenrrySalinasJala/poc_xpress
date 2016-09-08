package com.jalasoft.xpress.cucumber.stepdefinition.project;

import com.jalasoft.xpress.cucumber.stepdefinition.login.LoginStepDef;
import com.jalasoft.xpress.pages.AdminConsole;
import com.jalasoft.xpress.pages.Dashboard;
import com.jalasoft.xpress.pages.project.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.List;
import java.util.Map;

import static com.jalasoft.xpress.pages.project.ProjectSteps.DISPLAY_NAME;

/**
 * Created by henrry salinas on 9/1/2016.
 */
public class ProjectStepDef {
    
    private ProjectManagementPPSA projectManagementPPSA;
    
    private Map<ProjectSteps, Object> projectStepValues;
    
    private List<String> projectUsers;
    
    private EditProjectUsersForm editProjectUsersForm;
    
    private ProjectForm projectForm;
    
    private EditProjectForm editProjectForm;
    
    private Dashboard dashboard;
    
    public ProjectStepDef(LoginStepDef loginStepDef) {
        this.dashboard = loginStepDef.getDashboard();
    }
    
    @Given("^I created? a new project$")
    public void iCreateANewProject(Map<ProjectSteps, Object> values) {
        AdminConsole adminConsole = dashboard.getMenu().clickOnMenuAdminConsole();
        projectManagementPPSA = adminConsole.clickOnProjectManagementIcon();
        projectForm = projectManagementPPSA.clickOnCreateProjectBtn();
        projectStepValues= projectForm.toModifiableMap(values);
        projectForm.strategyStepMap(projectStepValues);
        projectForm.clickOnSaveBtn();
    }
    
    @And("^I added the users? to the project$")
    public void iAddedTheUserToTheProject(List<String> userValues) {
        projectUsers = userValues;
        AdminConsole adminConsole = dashboard.getMenu().clickOnMenuAdminConsole();
        projectManagementPPSA = adminConsole.clickOnProjectManagementIcon();
        projectManagementPPSA.setTxtSearchProject(getProjectStepsMap().get(DISPLAY_NAME).toString());
        editProjectForm = projectManagementPPSA.clickOnEditBtn(getProjectStepsMap().get(DISPLAY_NAME).toString());
        editProjectUsersForm = editProjectForm.clickOnAddRemoveUserBtn();
        editProjectUsersForm.associateUser(userValues);
        
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
    
    public List<String> getProjectUsersMap() {
        return projectUsers;
    }
}
