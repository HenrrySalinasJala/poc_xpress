package com.jalasoft.xpress.pages;

import com.jalasoft.xpress.pages.startedProjects.SetupDashboard;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;
import static com.jalasoft.xpress.framework.util.CommonMethods.searchElements;

import static com.jalasoft.xpress.framework.util.CommonMethods.setCheckBox;
import static com.jalasoft.xpress.framework.util.Constants.WAIT_TIME;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Daniel Gonzales on 9/1/2016.
 */
public class Projects extends BasePage {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(Menu.class.getName());

    @FindBy(css = ".generic-search-input.ng-pristine.ng-untouched.ng-valid")
    private WebElement searchProjectTextField;

    @FindBy(xpath = "//label[contains(.,'See All Projects')]")
    private WebElement allProjectsCheck;

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
        setCheckBox(allProjectsCheck,allProjectsCheck.isSelected());
        return this;
    }

}
