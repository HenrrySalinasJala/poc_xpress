package com.jalasoft.xpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.searchElements;

/**
 * Created by Daniel Gonzales on 9/1/2016.
 */
public class Projects extends BasePage{

    @FindBy(css = ".generic-search-input.ng-pristine.ng-untouched.ng-valid")
    private WebElement searchProjectTextField;

    public SetupDashboard clickProjectLink(String projectName) {
        //wait.until(ExpectedConditions.visibilityOf(getCreateWorkspaceContainer));

        searchElements(searchProjectTextField, projectName);

        driver.findElement(By.cssSelector("span[linkText='projectName']")).click();

        return new SetupDashboard();
    }


}
