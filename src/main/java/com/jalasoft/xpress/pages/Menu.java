package com.jalasoft.xpress.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;
import static com.jalasoft.xpress.framework.util.Constants.WAIT_TIME;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by henrry salinas on 9/1/2016.
 */
public class Menu extends BasePage {
    
    private static final Logger LOGGER = Logger.getLogger(Menu.class.getSimpleName());
    
    private static final String ADMIN_CONSOLE_MENU_NOT_FOUND = "The menu admin console element was not found";
    
    @FindBy(xpath = "//ul[contains(@class,'menu-bar')]//a[contains(text(),'ADMIN CONSOLE')]")
    private WebElement menuAdminConsole;
    
    @FindBy(xpath = "//a[contains(.,'SCENARIO LIBRARY')]")
    private WebElement menuScenarioLibrary;
    
    @FindBy(xpath = "//ul[contains(@class,'menu-bar')]//a[contains(text(),'PROJECTS')]")
    private WebElement menuProjects;
    
    public AdminConsole clickOnMenuAdminConsole() {
        try {
            final int timeToClickAdminConsoleMenu = 10000;
            Thread.sleep(timeToClickAdminConsoleMenu);
            clickWebElement(menuAdminConsole);
        } catch (NoSuchElementException e) {
            LOGGER.error(ADMIN_CONSOLE_MENU_NOT_FOUND, e);
            throw new NoSuchElementException(ADMIN_CONSOLE_MENU_NOT_FOUND);
        } catch (InterruptedException e) {
            LOGGER.error("Interrupted !", e);
            Thread.currentThread().interrupt();
        } finally {
            wait.withTimeout(WAIT_TIME, SECONDS);
        }
        return new AdminConsole();
    }
    
    public Projects clickMenuProjects() {
        clickWebElement(menuProjects);
        return new Projects();
    }
}
