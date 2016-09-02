package com.jalasoft.xpress.pages.StartedProjects;

import com.jalasoft.xpress.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;

/**
 * Created by Daniel Gonzales on 9/1/2016.
 */
public class SetupDashboard extends BasePage {

    @FindBy(xpath = "//a[contains(.,'Existing')]")
    private WebElement startExistingProjectBtn;

    @FindBy(xpath = "//a[contains(.,'Scratch')]")
    private WebElement startScratchProjectBtn;

    public FromExistingProject clickStartExistingProject() {
        clickWebElement(startExistingProjectBtn);
        return new FromExistingProject();
    }

    public FromScenarios startScratchProject() {
        clickWebElement(startScratchProjectBtn);
        return new FromScenarios();
    }
}
