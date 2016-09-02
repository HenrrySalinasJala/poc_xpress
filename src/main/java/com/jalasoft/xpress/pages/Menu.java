package com.jalasoft.xpress.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;

/**
 * Created by henrry salinas on 9/1/2016.
 */
public class Menu extends BasePage{

    ////ul[contains(@class,'menu-bar')]//a[contains(@href,'#/xpress/adminconsole/adminconsolemenu')]
    @FindBy(xpath = "//ul[contains(@class,'menu-bar')]//a[contains(text(),'ADMIN CONSOLE')]")
    private WebElement menuAdminConsole;

    @FindBy(xpath = "//ul[contains(@class,'menu-bar')]//a[contains(text(),'PROJECTS')]")
    private WebElement menuProjects;

    public AdminConsole clickOnMenuAdminConsole(){
        clickWebElement(menuAdminConsole);
        return new AdminConsole();
    }

    public Projects clickMenuProjects(){
        clickWebElement(menuProjects);
        return new Projects();
    }

}
