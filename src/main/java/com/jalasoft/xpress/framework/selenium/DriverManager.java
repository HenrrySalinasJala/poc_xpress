package com.jalasoft.xpress.framework.selenium;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import com.jalasoft.xpress.framework.util.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.jalasoft.xpress.framework.util.Constants.IMPLICIT_WAIT_TIME;
import static com.jalasoft.xpress.framework.util.Constants.LOAD_PAGE_TIME;
import static com.jalasoft.xpress.framework.util.Constants.WAIT_TIME;



public class DriverManager {

    private static final String SRC_MAIN_RESOURCES_LOG4J_PROPERTIES = "src/main/resources/log4j.properties";

    private static DriverManager instance;

    private WebDriver driver;

    private WebDriverWait wait;

    private DriverManager() {
        initWebDriver();
        PropertyConfigurator.configure(SRC_MAIN_RESOURCES_LOG4J_PROPERTIES);
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    private void initWebDriver() {
        driver = FactoryDriver.getDriver(Environment.getInstance().getBrowser()).initDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(LOAD_PAGE_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, WAIT_TIME);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
