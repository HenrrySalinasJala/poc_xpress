package com.jalasoft.xpress.pages;

import com.jalasoft.xpress.framework.util.Environment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.*;
import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;

/**
 * Created by Mijhail Villarroel on 9/1/2016.
 */
public class Login extends BasePage {

    private static final Environment PROPERTIES_INFO = Environment.getInstance();

    @FindBy(xpath = "//*[@ng-click=\"loginType = 'internal'\"]")
    private WebElement clickInternalUser;

    @FindBy(id = "pros-login-username-textbox")
    private  WebElement userNameTextFld;

    @FindBy(id = "pros-login-password-textbox")
    private WebElement passTestFld;

    @FindBy(css = ".login-input.sign-in-button")
    private WebElement signInBtn;

    @FindBy(xpath = "//div[@ng-show='config.loginError']")
    private WebElement textMessageError;

    private static ProsHome prosHome;

    public void clickButtonInternalUser() {
        clickWebElement(clickInternalUser);
    }

    public void setUserNameTestField(String username) {
        setWebElement(userNameTextFld, username);
    }

    public void setPasswordTestField(String password) {
        setWebElement(passTestFld, password);
    }

    public static Dashboard loginAs(String userName, String password) {
        Dashboard dashboard = new Dashboard();
        if (!userName.equalsIgnoreCase(dashboard.getTopHeader().getUserNameText())) {
            prosHome = dashboard.getTopHeader().clickOnLogOut();
            Login login = prosHome.clickSingInLink();
            login.clickButtonInternalUser();
            login.setUserNameTestField(userName);
            login.setPasswordTestField(password);
            return login.clickSignInButton();
        }
        return dashboard;
    }

    public Dashboard clickSignInButton() {
        clickWebElement(signInBtn);
        return new Dashboard();
    }

    public static Dashboard loginAsPrimaryUser() {
        return loginAs(PROPERTIES_INFO.getUser(),
                PROPERTIES_INFO.getPassword());
    }

    public String getMessageErrorLogin(){
        return textMessageError.getText();
    }
}
