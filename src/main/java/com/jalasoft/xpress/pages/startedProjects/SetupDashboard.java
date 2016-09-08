package com.jalasoft.xpress.pages.startedprojects;

import com.jalasoft.xpress.pages.BasePage;
import com.jalasoft.xpress.pages.Menu;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;
import static com.jalasoft.xpress.framework.util.Constants.WAIT_TIME;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Daniel Gonzales on 9/1/2016.
 */
public class SetupDashboard extends BasePage {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(Menu.class.getName());

    private static final String THE_ELEMENT_WAS_NOT_FOUND = "The element was not found";

    @FindBy(xpath = "//a[contains(.,'Start from Existing')]")
    private WebElement startExistingProjectBtn;

    @FindBy(xpath = "//a[contains(.,'Start from Scratch')]")
    private WebElement startScratchProjectBtn;

    public FromExistingProject clickStartExistingProject() {
        clickWebElement(startExistingProjectBtn);
        return new FromExistingProject();
    }

    public FromScenarios startScratchProject() {

        try {
            Thread.sleep(3000);
        clickWebElement(startScratchProjectBtn);
        } catch (NoSuchElementException e) {
            LOGGER.error(THE_ELEMENT_WAS_NOT_FOUND,e);
            throw new NoSuchElementException(THE_ELEMENT_WAS_NOT_FOUND);

        } catch (InterruptedException e) {
            LOGGER.error("Interrupted !", e);
            Thread.currentThread().interrupt();
        } finally {
            wait.withTimeout(WAIT_TIME, SECONDS);
        }
        return new FromScenarios();
    }

    public FromExistingProject startExistingProject() {
        try {
            Thread.sleep(3000);
            clickWebElement(startExistingProjectBtn);
        } catch (NoSuchElementException e) {
            LOGGER.error(THE_ELEMENT_WAS_NOT_FOUND,e);
            throw new NoSuchElementException(THE_ELEMENT_WAS_NOT_FOUND);

        } catch (InterruptedException e) {
            LOGGER.error("Interrupted !", e);
            Thread.currentThread().interrupt();
        } finally {
            wait.withTimeout(WAIT_TIME, SECONDS);
        }
        return new FromExistingProject();
    }

    }
