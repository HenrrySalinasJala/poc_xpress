package com.jalasoft.xpress.pages.StartedProjects;

import com.jalasoft.xpress.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;
import static com.jalasoft.xpress.framework.util.CommonMethods.setCheckBox;

/**
 * Created by Daniel Gonzales on 9/2/2016.
 */
public class FromScenarios extends BasePage{

    @FindBy(css = ".start-btn-3c30d.button.small.greeny.radius.right")
    private WebElement startBtn;

    @FindBy(xpath = "//table[contains(@class,'scroll')]")
    private WebElement tableScenarios;

    public ProjectWithoutScenarios startScratchProject() {
        clickWebElement(startBtn);
        return new ProjectWithoutScenarios();
    }

    public FromScenarios checkScenario(String scenarioName) {
        WebElement selectScenarioCheck = driver.findElement(By.xpath("//tr[td//text()[contains(.,'" + scenarioName + "')]]/td/span"));
        setCheckBox(selectScenarioCheck, true);
        return this;
    }
}
