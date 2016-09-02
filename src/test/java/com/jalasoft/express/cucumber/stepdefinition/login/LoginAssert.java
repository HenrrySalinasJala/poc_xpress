package com.jalasoft.express.cucumber.stepdefinition.login;

import com.jalasoft.xpress.framework.util.PropertiesInfo;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.junit.Assert;

/**
 * Created by Mijhail Villarroel on 9/1/2016.
 */
public class LoginAssert {
    private static final PropertiesInfo PROPERTIES_INFO = PropertiesInfo.getInstance();

    private LoginStepDef projectsStepdefs;

    public LoginAssert(LoginStepDef projectsStepdefs) {
        this.projectsStepdefs = projectsStepdefs;
    }

    @Then("^I expect the userName is displayed$")
    public void iExpectTheUserNameIsDisplayed() {
        String expectUserName = PROPERTIES_INFO.getEmail();
        Assert.assertEquals(expectUserName.toUpperCase(),projectsStepdefs.getDashboard().getTopHeader().getUserNameText().toUpperCase());
}
}
