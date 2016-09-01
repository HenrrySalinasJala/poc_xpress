package com.jalasoft.xpress.framework.selenium;

import org.openqa.selenium.WebDriverException;


public final class FactoryDriver {

    private FactoryDriver() {
    }

    public static IDriver getDriver(String browser) {
        switch (Browser.valueOf(browser.toUpperCase())) {
            case CHROME:
                return new Chrome();
            case FIREFOX:
                return new Firefox();
            case REMOTE:
                return new RemoteBrowser();
            default:
                throw new WebDriverException("Browser not found : " + browser);
        }
    }
}
