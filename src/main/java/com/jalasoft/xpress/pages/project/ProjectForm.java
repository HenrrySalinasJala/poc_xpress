package com.jalasoft.xpress.pages.project;

import com.jalasoft.xpress.framework.util.IAutomationStep;
import com.jalasoft.xpress.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Calendar;
import java.util.EnumMap;
import java.util.Map;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;
import static com.jalasoft.xpress.framework.util.CommonMethods.setWebElement;
import static com.jalasoft.xpress.pages.project.ProjectSteps.*;
import static java.util.Calendar.HOUR;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.getInstance;

/**
 * Created by henrry salinas on 9/1/2016.
 */
public class ProjectForm extends BasePage {

    @FindBy(name = "projectName")
    private WebElement txtprojectName;

    @FindBy(name = "displayProjectName")
    private WebElement txtDisplayProjectName;

    @FindBy(name = "projectCustomerName")
    private WebElement txtProjectCustomerName;

    @FindBy(name = "mappedFolderPath")
    private WebElement txtMappedFolderPath;

    @FindBy(xpath = "//a[contains(text(),'Save')]")
    private WebElement saveBtn;

    public ProjectForm setTxtprojectName(String tprojectName) {
        setWebElement(txtprojectName, tprojectName);
        return this;
    }

    public ProjectForm setTxtDisplayProjectName(String displayProjectName) {
        setWebElement(txtDisplayProjectName, displayProjectName);
        return this;
    }

    public ProjectForm setTxtProjectCustomerName(String projectCustomerName) {
        setWebElement(txtProjectCustomerName, projectCustomerName);
        return this;
    }

    public ProjectForm setTxtMappedFolderPath(String mappedFolderPath) {
        setWebElement(txtMappedFolderPath, mappedFolderPath);
        return this;
    }

    public ProjectForm clickOnSaveBtn() {
        clickWebElement(saveBtn);
        return new ProjectForm();
    }




    public void strategyStepMap(Map<ProjectSteps, Object> values) {
        Map<ProjectSteps, IAutomationStep> projectSteps = new EnumMap<>(ProjectSteps.class);
        projectSteps.put(PROJECT_NAME, () -> setTxtprojectName(String.format("%s",values.get(PROJECT_NAME))));
        projectSteps.put(DISPLAY_NAME, () -> setTxtDisplayProjectName(String.format("%s",values.get(DISPLAY_NAME))));
        projectSteps.put(CUSTOMER_NAME, () -> setTxtProjectCustomerName(String.format("%s",values.get(CUSTOMER_NAME))));
        projectSteps.put(MAPPER_FOLDER, () -> setTxtMappedFolderPath(String.format("%s",values.get(MAPPER_FOLDER))));

        for (ProjectSteps step:values.keySet()){
            projectSteps.get(step).executeStep();
        }
    }
    
    public Map<ProjectSteps, Object> toModifiableMap(Map<ProjectSteps, Object> values) {
        final Calendar calendar = getInstance();
        final String newName = String.format("%s%d%d%d%d",values.get(PROJECT_NAME),calendar.get(HOUR),calendar.get(MINUTE),calendar.get(SECOND),calendar.get(MILLISECOND));
    
        Map<ProjectSteps, Object> modifiableStepMap = new EnumMap<>(ProjectSteps.class);
        values.entrySet().stream()
                .filter(step -> step.getValue() != null)
                .forEach(step -> modifiableStepMap.put(step.getKey(), step.getValue()));
        modifiableStepMap.put(PROJECT_NAME,newName);
        modifiableStepMap.put(DISPLAY_NAME,newName);
        return modifiableStepMap;
    }
}
