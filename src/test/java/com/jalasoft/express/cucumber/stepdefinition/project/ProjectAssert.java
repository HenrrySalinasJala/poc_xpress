package com.jalasoft.express.cucumber.stepdefinition.project;

import com.jalasoft.xpress.pages.project.ProjectManagementPPSA;
import com.jalasoft.xpress.pages.project.ProjectSteps;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertEquals;
/**
 * Created by henrry salinas on 9/1/2016.
 */
public class ProjectAssert {

    private ProjectStepDef projectStepDef;

    private ProjectManagementPPSA projectManagementPPSA;

    public ProjectAssert(ProjectStepDef projectStepDef,ProjectManagementPPSA projectManagementPPSA){
        this.projectStepDef=projectStepDef;
        this.projectManagementPPSA=projectManagementPPSA;
    }

    @Then("^i validate the project fields$")
    public void iValidateTheProjectFields()   {
        projectManagementPPSA.setTxtSearchProject(projectStepDef.getProjectSteps().get(ProjectSteps.DISPLAY_NAME).toString());
        projectManagementPPSA.clickOnEditBtn(projectStepDef.getProjectSteps().get(ProjectSteps.DISPLAY_NAME).toString());
        String x=projectStepDef.getEditProjectForm().getAssertionMap().get(ProjectSteps.CUSTOMER_NAME).toString();
        projectStepDef.getEditProjectForm().getAssertionMap().keySet().stream().forEach(step->
            assertEquals(projectStepDef.getEditProjectForm().getAssertionMap().get(step).toString(),projectStepDef.getProjectSteps().get(step))
        );
    }
}
