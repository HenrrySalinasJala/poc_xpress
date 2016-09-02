package com.jalasoft.express.cucumber.hooks;

import com.jalasoft.express.cucumber.stepdefinition.project.ProjectStepDef;
import com.jalasoft.xpress.pages.AdminConsole;
import com.jalasoft.xpress.pages.Dashboard;
import com.jalasoft.xpress.pages.project.ProjectManagementPPSA;
import com.jalasoft.xpress.pages.project.ProjectSteps;
import cucumber.api.java.After;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mijhail Villarroel on 9/2/2016.
 */
public class Projects {

    private final Map<ProjectSteps, Object> valuesProprojectStepDef;

    public Projects(ProjectStepDef projectStepDef) {
        valuesProprojectStepDef = projectStepDef.getProjectSteps();
    }

    /**
     * This method hook is used after a project is created using selenium.
     */
    @After("@DeleteProjects")
    public void tearDown() {
        Dashboard dashboard = new Dashboard();
        AdminConsole adminConsole = dashboard.getMenu().clickOnMenuAdminConsole();
        ProjectManagementPPSA projectManagementPPSA = adminConsole.clickOnProjectManagementIcon();
        valuesProprojectStepDef.keySet().forEach(step -> {
            projectManagementPPSA.setTxtSearchProject(String.valueOf(valuesProprojectStepDef.get(step)));
            projectManagementPPSA.clickOnDeleteProjects();
        });

    }
}
