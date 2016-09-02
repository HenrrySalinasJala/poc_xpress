package com.jalasoft.express.cucumber.stepdefinition.project;

import com.jalasoft.xpress.pages.AdminConsole;
import com.jalasoft.xpress.pages.project.EditProjectForm;
import com.jalasoft.xpress.pages.project.ProjectManagementPPSA;
import com.jalasoft.xpress.pages.project.ProjectSteps;

import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by henrry salinas on 9/1/2016.
 */
public class ProjectAssert {
    
    private ProjectStepDef projectStepDef;
    
    private ProjectManagementPPSA projectManagementPPSA;
    
    private EditProjectForm editProjectForm;
    
    public ProjectAssert(ProjectStepDef projectStepDef, ProjectManagementPPSA projectManagementPPSA, EditProjectForm editProjectForm) {
        this.projectStepDef = projectStepDef;
        this.projectManagementPPSA = projectManagementPPSA;
        this.editProjectForm = editProjectForm;
    }
    
    @Then("^I validate the project fields$")
    public void iValidateTheProjectFields() {
        
        AdminConsole adminConsole = projectStepDef.getDashboard().getMenu().clickOnMenuAdminConsole();
        projectManagementPPSA = adminConsole.clickOnProjectManagementIcon();
        
        projectManagementPPSA.setTxtSearchProject(projectStepDef.getProjectStepsMap().get(ProjectSteps.DISPLAY_NAME).toString());
        projectManagementPPSA.clickOnEditBtn(projectStepDef.getProjectStepsMap().get(ProjectSteps.DISPLAY_NAME).toString());
        editProjectForm.getAssertionMap().keySet().forEach(step ->
                assertEquals(editProjectForm.getAssertionMap().get(step).toString(), projectStepDef.getProjectStepsMap().get(step))
        );
    }
    
    @Then("^I expect the user was added$")
    public void iExpectTheUserWasAdded() {
        final String userName = projectStepDef.getProjectUsersMap().get(ProjectSteps.PROJECT_USER_NAME).toString();
        assertTrue(projectStepDef.getEditProjectUsersForm().userIsAdded(userName));
        
    }
}
