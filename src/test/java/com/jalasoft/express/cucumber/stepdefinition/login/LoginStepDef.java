package com.jalasoft.express.cucumber.stepdefinition.login;

import com.jalasoft.xpress.pages.Dashboard;
import com.jalasoft.xpress.pages.Login;
import com.jalasoft.xpress.pages.ProsHome;
import com.sun.javafx.collections.MappingChange;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.Map;

import static com.jalasoft.xpress.pages.Login.loginAs;
import static com.jalasoft.xpress.pages.Login.loginAsPrimaryUser;

/**
 * Created by Mijhail Villarroel on 9/1/2016.
 */
public class LoginStepDef {

    private Dashboard dashboard;
    private ProsHome prosHome;

    @When("^I login with valid credentials$")
    public void iLoginWithValidCredentials() {
        dashboard = loginAsPrimaryUser();
    }

    @Given("^I log out for the application$")
    public void iLogOutForTheApplication() {
        prosHome = dashboard.getTopHeader().clickOnLogOut();
    }

    @Given("^I login with credentials$")
    public void iLoginWithCredentials(Map<String, String> values) {
        dashboard = loginAs(values.get("userName"), values.get("password"));
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public ProsHome getProsHome() {
        return prosHome;
    }
}
