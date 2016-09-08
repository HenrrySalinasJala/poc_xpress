package com.jalasoft.xpress.cucumber.stepdefinition.startproject;

import com.jalasoft.xpress.pages.project.start.Dimensions;
import cucumber.api.java.en.Then;

import static com.jalasoft.xpress.framework.util.ReadFileXML.getListDimensions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by Daniel Gonzales on 9/2/2016.
 */

public class StartedProjectAssert {

    private Dimensions dimensions;
    private StartedProjectStepDef startedProjectStepDef;

    public StartedProjectAssert(StartedProjectStepDef startedProjectStepDef ){
        this.startedProjectStepDef = startedProjectStepDef;
    }

    @Then("^I expect the next dimensions for the selected scenario$")
    public void iExpectTheNextDimensionsForTheSelectedScenario() {
        dimensions = startedProjectStepDef.getDimensions();
        assertEquals(dimensions.dimensionsList(),getListDimensions("exampleSCF.xml"));
    }

    @Then("^I expect any scenario$")
    public void iExpectAnyScenario() {
        dimensions = startedProjectStepDef.getDimensions();
        assertTrue(dimensions.dimensionsList().isEmpty());
    }

    @Then("^I expect the next dimensions for the selected project$")
    public void iExpectTheNextDimensionsForTheSelectedProject(){
        dimensions = startedProjectStepDef.getDimensions();
        assertEquals(dimensions.dimensionsList(),dimensions.getStrings());
    }
}
