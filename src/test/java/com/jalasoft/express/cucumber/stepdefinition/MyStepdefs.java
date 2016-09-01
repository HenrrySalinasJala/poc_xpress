package com.jalasoft.express.cucumber.stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by henrry salinas on 9/1/2016.
 */
public class MyStepdefs {
    @Given("^I logged with valid credwntials$")
    public void iLoggedWithValidCredwntials()   {
        System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://lfernandez-dh25:4443");
    }

    @Given("^I am on admin  console page$")
    public void iAmOnAdminConsolePage()   {

    }
}
