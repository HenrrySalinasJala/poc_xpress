package com.jalasoft.xpress.pages;

import com.jalasoft.xpress.pages.StartedProjects.SetupDashboard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;
import static com.jalasoft.xpress.framework.util.CommonMethods.searchElements;

/**
 * Created by Daniel Gonzales on 9/1/2016.
 */
public class Projects extends BasePage {

    @FindBy(css = ".generic-search-input.ng-pristine.ng-untouched.ng-valid")
    private WebElement searchProjectTextField;

    @FindBy(xpath = "//label[contains(.,'See All Projects')]")
    private WebElement allProjectsCheck;

    public SetupDashboard clickProjectLink(String projectName) {
        searchElements(searchProjectTextField, projectName);
        clickWebElement(driver.findElement(By.cssSelector("span[linkText='" + projectName + "']")));
        return new SetupDashboard();
    }

    public Projects checkSeeAllProjects() {
        clickWebElement(allProjectsCheck);
        return this;
    }

}
