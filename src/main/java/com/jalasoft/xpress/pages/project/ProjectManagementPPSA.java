package com.jalasoft.xpress.pages.project;

import com.jalasoft.xpress.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;
import static com.jalasoft.xpress.framework.util.CommonMethods.setWebElement;

/**
 * Created by henrry salinas on 9/1/2016.
 */
public class ProjectManagementPPSA extends BasePage {

    @FindBy(xpath = "//a[contains(@ui-sref,'ppsa.adminConsole.adminConsoleMenu.projectManagement.add')]")
    private WebElement createProjectBtn;

    @FindBy(xpath = "//table[contains(@ng-table,'tableParams')]")
    private WebElement projectTableGrd;

    @FindBy(xpath = "//input[contains(@ng-model,'form.search')]")
    private WebElement txtSearchProject;


    @FindBy(css = ".button.small.ghost.radius.left.user-admin-margin-left-button")
    private WebElement deleteButton;

    public ProjectForm clickOnCreateProjectBtn(){
        createProjectBtn.click();
        return new ProjectForm();
    }



    public EditProjectForm clickOnEditBtn(String projectName){
        WebElement editBtn=projectTableGrd.findElement(By.xpath("//tr[td//text()[contains(.,'"+projectName+"')]]/td/a"));
        clickWebElement(editBtn);
        return new EditProjectForm();
    }

    public void clickOnDeleteCheckBox(String projectName){
        WebElement deleteCh = projectTableGrd.findElement(By.xpath("//tr[td//text()[contains(.,'"+projectName+"')]]/td/span"));
        deleteCh.click();
    }

    public DeleteProjectAlert clickOnDeleteProjects(){
        clickWebElement(deleteButton);
        return new DeleteProjectAlert();
    }




    public void setTxtSearchProject(String projectName) {
        setWebElement(txtSearchProject,projectName);
    }

}
