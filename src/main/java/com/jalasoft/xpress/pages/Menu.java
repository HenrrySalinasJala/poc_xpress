package com.jalasoft.xpress.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;
import static com.jalasoft.xpress.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static com.jalasoft.xpress.framework.util.Constants.IMPLICIT_WAIT_TIME;

import static com.jalasoft.xpress.framework.util.Constants.WAIT_TIME;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by henrry salinas on 9/1/2016.
 */
public class Menu extends BasePage {

    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(Menu.class.getName());
    @FindBy(xpath = "//ul[contains(@class,'menu-bar')]//a[contains(text(),'ADMIN CONSOLE')]")
    private WebElement menuAdminConsole;

    @FindBy(xpath = "//ul[contains(@class,'menu-bar')]//a[contains(text(),'PROJECTS')]")
    private WebElement menuProjects;

    public AdminConsole clickOnMenuAdminConsole() {
        try {
            Thread.sleep(10000);
            clickWebElement(menuAdminConsole);
        } catch (NoSuchElementException e) {
            LOGGER.error("The menu admin console element was not found",e);
            throw new NoSuchElementException("The menu admin console element was not found");

        } catch (InterruptedException e) {
            LOGGER.error("Interrupted !", e);
            Thread.currentThread().interrupt();
        } finally {
            wait.withTimeout(WAIT_TIME, SECONDS);
        }
        return new AdminConsole();
    }

    public Projects clickMenuProjects(){
        clickWebElement(menuProjects);
        return new Projects();
    }
}
