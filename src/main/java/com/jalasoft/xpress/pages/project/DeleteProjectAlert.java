package com.jalasoft.xpress.pages.project;

import com.jalasoft.xpress.framework.util.CommonMethods;
import com.jalasoft.xpress.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.jalasoft.xpress.framework.util.CommonMethods.*;

/**
 * @ Mijhail Villarroel.
 */
public class DeleteProjectAlert extends BasePage {

    @FindBy(css = ".dialog-popup.auto-height-dialog-pop-up.ng-scope")
    private WebElement deleteAlertContainer;

    @FindBy(css = ".dialog-ok-button")
    private WebElement deleteProjectBtn;

    public ProjectManagementPPSA clickDeleteBtn() {
        wait.until(ExpectedConditions.visibilityOf(deleteAlertContainer));
        clickWebElement(deleteProjectBtn);
        return new ProjectManagementPPSA();
    }
}
