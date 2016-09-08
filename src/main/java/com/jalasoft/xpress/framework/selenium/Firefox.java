package com.jalasoft.xpress.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox implements IDriver {
    
    private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
    
    private static final String DRIVER_PATH = "lib/geckodriver.exe";
    
    private static final String MARIONETTE_CAPABILITY_NAME = "marionette";
    
    @Override
    public WebDriver initDriver() {
        System.setProperty(WEBDRIVER_GECKO_DRIVER, DRIVER_PATH);
        DesiredCapabilities dc= DesiredCapabilities.firefox();
        FirefoxProfile profile = new FirefoxProfile();
        dc.setCapability(FirefoxDriver.PROFILE, profile);
        dc.setCapability(MARIONETTE_CAPABILITY_NAME, true);
        return  new FirefoxDriver(dc);
    }
}
