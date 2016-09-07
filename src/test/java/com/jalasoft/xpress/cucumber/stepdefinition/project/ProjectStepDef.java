package com.jalasoft.xpress.cucumber.stepdefinition.project;

import com.jalasoft.xpress.cucumber.stepdefinition.login.LoginStepDef;
import com.jalasoft.xpress.framework.util.CommonMethods;
import com.jalasoft.xpress.pages.AdminConsole;
import com.jalasoft.xpress.pages.Dashboard;
import com.jalasoft.xpress.pages.project.EditProjectForm;
import com.jalasoft.xpress.pages.project.EditProjectUsersForm;
import com.jalasoft.xpress.pages.project.ProjectForm;
import com.jalasoft.xpress.pages.project.ProjectManagementPPSA;
import com.jalasoft.xpress.pages.project.ProjectSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.*;

import static com.jalasoft.xpress.pages.project.ProjectSteps.DISPLAY_NAME;
import static com.jalasoft.xpress.pages.project.ProjectSteps.PROJECT_NAME;
import static java.util.Calendar.*;

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
    
    @And("^I added a user to the project$")
    public void iAddedAUserToTheProject() {
        
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
