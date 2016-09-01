package com.jalasoft.xpress.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Daniel Gonzales on 9/1/2016.
 */
public class SetupDashboard extends BasePage {

    @FindBy(xpath = "//a[contains(.,'Existing')]")
    private WebElement startExistingProject;

    @FindBy(xpath = "//a[contains(.,'Scratch')]")
    private WebElement startScratchProject;
}
