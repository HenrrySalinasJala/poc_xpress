package com.jalasoft.express.cucumber.stepdefinition.login;

import com.jalasoft.xpress.pages.Dashboard;
import com.jalasoft.xpress.pages.Login;
import com.jalasoft.xpress.pages.ProsHome;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static com.jalasoft.xpress.pages.Login.loginAsPrimaryUser;

/**
 * Created by Mijhail Villarroel on 9/1/2016.
 */
public class LoginStepDef {

    private Dashboard dashboard;

    @When("^I login with valid credentials$")
    public void iLoginWithValidCredentials() {
        dashboard = loginAsPrimaryUser();
    }

    public Dashboard getDashboard() {
        return dashboard;
    }
}
