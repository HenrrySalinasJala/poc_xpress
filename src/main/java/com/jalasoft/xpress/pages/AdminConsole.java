package com.jalasoft.xpress.pages;

import com.jalasoft.xpress.pages.project.ProjectManagementPPSA;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;

/**
 * Created by henrry salinas on 9/1/2016.
 */
public class AdminConsole extends BasePage{

    @FindBy(xpath = "//div[contains(@to-state,'ppsa.adminConsole.adminConsoleMenu.projectManagement')]")
    private WebElement projectManagementIcon;

    public ProjectManagementPPSA clickOnProjectManagementIcon(){
        clickWebElement(projectManagementIcon);
        return new ProjectManagementPPSA();
    }
}
