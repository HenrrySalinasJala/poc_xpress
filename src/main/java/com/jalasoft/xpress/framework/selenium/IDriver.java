package com.jalasoft.xpress.framework.selenium;

import org.openqa.selenium.WebDriver;

@FunctionalInterface
public interface IDriver {

    WebDriver initDriver();
}
