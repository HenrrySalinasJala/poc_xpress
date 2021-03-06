package com.jalasoft.xpress.cucumber.hooks;

import com.jalasoft.xpress.cucumber.stepdefinition.project.ProjectStepDef;
import com.jalasoft.xpress.pages.AdminConsole;
import com.jalasoft.xpress.pages.Dashboard;
import com.jalasoft.xpress.pages.project.DeleteProjectAlert;
import com.jalasoft.xpress.pages.project.ProjectManagementPPSA;
import com.jalasoft.xpress.pages.project.ProjectSteps;
import cucumber.api.java.After;

import java.util.Map;

import static com.jalasoft.xpress.pages.project.ProjectSteps.DISPLAY_NAME;
import static org.junit.Assert.assertEquals;

/**
 * Created by Mijhail Villarroel on 9/2/2016.
 */
public class Projects {

    private final Map<ProjectSteps, Object> valuesProprojectStepDef;
    private Dashboard dashboard;

    public Projects(ProjectStepDef projectStepDef) {
        valuesProprojectStepDef = projectStepDef.getProjectStepsMap();
        dashboard = projectStepDef.getDashboard();
    }

    /**
     * This method hook is used after a project is created using selenium.
     */
    @After("@DeleteProjects")
    public void tearDown() {
        AdminConsole adminConsole = dashboard.getMenu().clickOnMenuAdminConsole();
        ProjectManagementPPSA projectManagementPPSA = adminConsole.clickOnProjectManagementIcon();
        String nameProject = String.valueOf(valuesProprojectStepDef.get(DISPLAY_NAME));
        projectManagementPPSA.setTxtSearchProject(nameProject);
        projectManagementPPSA.clickOnDeleteCheckBox(nameProject);
        DeleteProjectAlert deleteAlert = projectManagementPPSA.clickOnDeleteProjects();
        deleteAlert.clickDeleteBtn();
        dashboard.getTopHeader().clickOnExpressOptionMenu();
    }
}
