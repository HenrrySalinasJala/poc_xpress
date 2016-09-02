package com.jalasoft.xpress.pages.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;
import static com.jalasoft.xpress.framework.util.CommonMethods.setWebElement;

/**
 * Created by henrry salinas on 9/1/2016.
 */
public class EditProjectUsersForm {

    @FindBy(xpath = "//button[contains(@title,'Add selected items')]")
    private WebElement addItemBtn;

    @FindBy(xpath = "//button[contains(@title,'Add all')]")
    private WebElement addAllItemsBtn;

    @FindBy(xpath = "//button[contains(@title,'Remove all')]")
    private WebElement removeAllItemsBtn;

    @FindBy(xpath = "//button[contains(@title,'Remove selected items')]")
    private WebElement removeItemBtn;

    @FindBy(xpath = "//td[contains(@class,'available-users-list')]//input")
    private WebElement txtAvailableUser;

    public EditProjectUsersForm clickOnAddItemBtn() {
        clickWebElement(addItemBtn);
        return this;
    }

    public EditProjectUsersForm setTxtAvailableUser(String userName) {
        setWebElement(txtAvailableUser,userName);
        return this;
    }

}
