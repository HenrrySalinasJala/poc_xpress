package com.jalasoft.express.cucumber.stepdefinition.login;

import com.jalasoft.xpress.pages.Login;
import com.jalasoft.xpress.pages.ProsHome;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

/**
 * Created by Mijhail Villarroel on 9/1/2016.
 */
public class LoginStepDef {
    @Given("^I login with valid credentials$")
    public void iLoginWithValidCredentials() throws Throwable {
        ProsHome prosHome = new ProsHome();
        Login login = prosHome.clickSingInLink();
        login.clickButtonInternalUser();
        login.setUserNameTestField("mijhailV");
        login.setPasswordTestField("admin123P");
        login.clickSignInButton();

    }
}
