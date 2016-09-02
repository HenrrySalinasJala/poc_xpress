package com.jalasoft.xpress.pages.StartedProjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;

/**
 * Created by Daniel Gonzales on 9/2/2016.
 */
public class FromScenarios {

    @FindBy(css = ".start-btn-3c30d.button.small.greeny.radius.right")
    private WebElement startBtn;

    public ProjectWithoutScenarios startScratchProject() {
        clickWebElement(startBtn);
        return new ProjectWithoutScenarios();
    }

}
