package com.jalasoft.xpress.pages.project;

import com.jalasoft.xpress.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.EnumMap;
import java.util.Map;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;
import static com.jalasoft.xpress.pages.project.ProjectSteps.CUSTOMER_NAME;
import static com.jalasoft.xpress.pages.project.ProjectSteps.DISPLAY_NAME;

/**
 * Created by henrry salinas on 9/1/2016.
 */
public class EditProjectForm extends BasePage {

    @FindBy(xpath = "//a[contains(@ui-sref,'ppsa.adminConsole.adminConsoleMenu.projectManagement.users')]")
    private WebElement addRemoveUserBtn;

    @FindBy(xpath = "//input[contains(@ng-model,'project.displayName')]")
    private WebElement txtDisplayProjectName;

    @FindBy(xpath="//input[contains(@ng-model,'project.customer')]")
    private WebElement txtProjectCustomerName;

    public EditProjectUsersForm clickOnAddRemoveUserBtn() {
        clickWebElement(addRemoveUserBtn);
        return new EditProjectUsersForm();
    }

    public String getTxtProjectCustomerName() {
        return txtProjectCustomerName.getAttribute("value");
    }

    public String getTxtDisplayProjectName() {
        return txtDisplayProjectName.getAttribute("value");
    }

    public Map<ProjectSteps, Object> getAssertionMap() {
        Map<ProjectSteps,Object> assertionsMap=new EnumMap<>(ProjectSteps.class);
        assertionsMap.put(DISPLAY_NAME,getTxtDisplayProjectName());
        assertionsMap.put(CUSTOMER_NAME,getTxtProjectCustomerName());

        return assertionsMap;
    }

}
