package com.jalasoft.xpress.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.SystemClock;

/**
 * Created by henrry salinas on 9/6/2016.
 */
public class InternetExplorer implements IDriver{
    
    private static final String WEBDRIVER_IE_DRIVER = "webdriver.ie.driver";
    
    private static final String DRIVER_PATH = "lib/IEDriverServer.exe";
    
    private static final boolean IGNORE_ALL_ZONES = true;
    
    @Override
    public WebDriver initDriver() {
        DesiredCapabilities caps= DesiredCapabilities.internetExplorer();
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, IGNORE_ALL_ZONES);
        System.setProperty(WEBDRIVER_IE_DRIVER, DRIVER_PATH);
        return new InternetExplorerDriver(caps);
    }
}
