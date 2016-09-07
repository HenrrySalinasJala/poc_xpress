package com.jalasoft.xpress.pages.project;

import com.jalasoft.xpress.pages.BasePage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;
import static com.jalasoft.xpress.framework.util.CommonMethods.isElementPresent;
import static com.jalasoft.xpress.framework.util.CommonMethods.setWebElement;
import static com.jalasoft.xpress.framework.util.Constants.WAIT_TIME;
import static com.jalasoft.xpress.pages.project.ProjectSteps.PROJECT_USER_NAME;
import static java.util.concurrent.TimeUnit.*;

/**
 * Created by henrry salinas on 9/1/2016.
 */
public class EditProjectUsersForm extends BasePage {
    
    private static final Logger LOGGER=Logger.getLogger(EditProjectUsersForm.class.getSimpleName());
    
    private static final String USER_NAME_NOT_FOUND = "The user name cannot be clicked";
    
    @FindBy(xpath = "//button[contains(@title,'Add selected items')]")
    private WebElement addUserBtn;
    
    @FindBy(xpath = "//button[contains(@title,'Add all')]")
    private WebElement addAllUsersBtn;
    
    @FindBy(xpath = "//button[contains(@title,'Remove all')]")
    private WebElement removeAllUsersBtn;
    
    @FindBy(xpath = "//button[contains(@title,'Remove selected items')]")
    private WebElement removeUserBtn;
    
    @FindBy(xpath = "//td[contains(@class,'available-users-list')]//input")
    private WebElement txtAvailableUser;
    
    @FindBy(xpath = "//div[contains(@class,'dialog-footer')]//a[@class='dialog-ok-button' and contains(.,'Associate')]")
    private WebElement associateAllBtn;
    
    public EditProjectUsersForm clickOnAddItemBtn() {
        clickWebElement(addUserBtn);
        return this;
    }
    
    public EditProjectUsersForm clickOnAssociateAllBtn() {
        clickWebElement(associateAllBtn);
        return this;
    }
    
    public EditProjectUsersForm setTxtAvailableUser(String userName) {
        setWebElement(txtAvailableUser, userName);
        return this;
    }
    
    public EditProjectUsersForm clickUserAvailableRow(String userName) {
        final String xpath = String.format("//span[contains(.,'%s')]/..", userName);
        try {
            final int timeToClickUserRow = 3000;
            Thread.sleep(timeToClickUserRow);
            WebElement rowUser = driver.findElement(By.xpath(xpath));
            clickWebElement(rowUser);
        }catch (NoSuchElementException e){
            LOGGER.error(USER_NAME_NOT_FOUND);
            throw new NoSuchElementException(USER_NAME_NOT_FOUND,e);
        } catch (InterruptedException e) {
            LOGGER.warn("Thread interrupted!");
            Thread.currentThread().interrupt();
        }finally {
            wait.withTimeout(WAIT_TIME, SECONDS);
        }
        
        return this;
    }
    
    public boolean userIsAdded(String userName) {
        final String xpath = String.format("//td[contains(.,'%s')]/ancestor::fieldset[contains(.,'Current users')]", userName);
        WebElement userInTableAdded = driver.findElement(By.xpath(xpath));
        return isElementPresent(userInTableAdded);
    }
    
    public void associateUser(List<String> userValues) {
        userValues.forEach(user->{
                    setTxtAvailableUser(user)
                    .clickUserAvailableRow(user)
                    .clickOnAddItemBtn()
                    .clickOnAssociateAllBtn();
        });
        
    }
}
