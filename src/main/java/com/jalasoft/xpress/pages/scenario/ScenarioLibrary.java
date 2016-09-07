package com.jalasoft.xpress.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;

/**
 * Created by Mijhail Villarroel on 9/6/2016.
 */
public class ScenarioLibrary extends BasePage {

    @FindBy (css = ".button.small.ux-greeny.radius.right.ng-scope")
    WebElement addScenarioButton;

    public ScenarioForm clickButtonAddScenario() {
        clickWebElement(addScenarioButton);
        return new ScenarioForm();
    }
}
