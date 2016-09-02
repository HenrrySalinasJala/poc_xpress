package com.jalasoft.express.cucumber.hooks;

import cucumber.api.java.After;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mijhail Villarroel on 9/2/2016.
 */
public class Projects {

    /**
     * This method hook is used after a project is created using selenium.
     */
    @After("@ProjectSelenium")
    public void tearDown() {
       
    }
}
