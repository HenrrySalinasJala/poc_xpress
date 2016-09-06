package com.jalasoft.express.cucumber.stepdefinition.login;

import com.jalasoft.xpress.framework.util.Environment;

import com.jalasoft.xpress.pages.Login;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.junit.Assert;

/**
 * Created by Mijhail Villarroel on 9/1/2016.
 */
public class LoginAssert {
    private static final Environment PROPERTIES_INFO = Environment.getInstance();

    private LoginStepDef projectsStepdefs;

    public LoginAssert(LoginStepDef projectsStepdefs) {
        this.projectsStepdefs = projectsStepdefs;
    }

    @Then("^I expect the userName is displayed$")
    public void iExpectTheUserNameIsDisplayed() {
        String expectUserName = PROPERTIES_INFO.getUser();
        Assert.assertEquals(expectUserName.toUpperCase(),projectsStepdefs.getDashboard().getTopHeader().getUserNameText().toUpperCase());
}

    @Then("^The Login button is present$")
    public void theLoginButtonIsPresent() {
        Assert.assertTrue("The sing in button is not pressent",projectsStepdefs.getProsHome().isLoginButtonPresent());
    }

    @Then("^I expect the message say: (.*)$")
    public void iExpectTheMessageSayVerifyThatYouHaveEnteredYourPROSNetworkCredentialsCorrectly(String message) {
        Login login = new Login();
        Assert.assertEquals(message, login.getMessageErrorLogin());
    }
}
