package com.jalasoft.xpress.pages;

import com.jalasoft.xpress.pages.startedprojects.SetupDashboard;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.*;
import static com.jalasoft.xpress.framework.util.Constants.WAIT_TIME;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Daniel Gonzales on 9/1/2016.
 */
public class Projects extends BasePage {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(Menu.class.getName());

    @FindBy(css = ".generic-search-input.ng-pristine.ng-untouched.ng-valid")
    private WebElement searchProjectTextField;

    @FindBy(xpath = "//span[@class='pros-checkbox']")
    private WebElement checkAllProjectsLabel;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement verifyCheckBoxAllProject;

    public SetupDashboard clickProjectLink(String projectName) {
        try{
            Thread.sleep(10000);
            searchElements(searchProjectTextField, projectName);
            Thread.sleep(5000);
            clickWebElement(driver.findElement(By.cssSelector("span[title='" + projectName + "']")));
                } catch (NoSuchElementException e) {
            LOGGER.error("The element was not found",e);
            throw new NoSuchElementException("The element was not found");

        } catch (InterruptedException e) {
            LOGGER.error("Interrupted !", e);
            Thread.currentThread().interrupt();
        } finally {
            wait.withTimeout(WAIT_TIME, SECONDS);
        }

        return new SetupDashboard();
    }

    public Projects checkSeeAllProjects() {
        setCheckBox(checkAllProjectsLabel, verifyCheckBoxAllProject.isSelected());
        return this;
    }

}
