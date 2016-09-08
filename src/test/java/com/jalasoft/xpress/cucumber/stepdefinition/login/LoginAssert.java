package com.jalasoft.xpress.cucumber.stepdefinition.login;

import com.jalasoft.xpress.framework.util.Environment;

import com.jalasoft.xpress.pages.Login;
import cucumber.api.java.en.Then;

import static org.junit.Assert.*;

/**
 * Created by Mijhail Villarroel on 9/1/2016.
 */
public class LoginAssert {
    private static final Environment PROPERTIES_INFO = Environment.getInstance();

    private LoginStepDef projectsStepDef;

    public LoginAssert(LoginStepDef projectsStepDef) {
        this.projectsStepDef = projectsStepDef;
    }

    @Then("^I expect the userName is displayed$")
    public void iExpectTheUserNameIsDisplayed() {
        String expectUserName = PROPERTIES_INFO.getUser();
        assertEquals(expectUserName.toUpperCase(), projectsStepDef.getDashboard().getTopHeader().getUserNameText().toUpperCase());
}

    @Then("^The Login button is present$")
    public void theLoginButtonIsPresent() {
        assertTrue("The sing in button is not present", projectsStepDef.getProsHome().isLoginButtonPresent());
    }

    @Then("^I expect the message say: (.*)$")
    public void iExpectTheMessageSayVerifyThatYouHaveEnteredYourPROSNetworkCredentialsCorrectly(String message) {
        Login login = new Login();
        assertEquals(message, login.getMessageErrorLogin());
    }
}
