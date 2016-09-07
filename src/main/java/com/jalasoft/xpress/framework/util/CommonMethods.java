package com.jalasoft.xpress.framework.util;

import com.jalasoft.xpress.pages.project.ProjectSteps;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static com.jalasoft.xpress.framework.selenium.DriverManager.getInstance;


/**
 * This class groups the generic methods
 *
 * @ Mijhail Villarroel
 */
public final class CommonMethods {

    private static final WebDriverWait WEB_DRIVER_WAIT = getInstance().getWait();

    private static final Logger LOGGER = Logger.getLogger(CommonMethods.class.getSimpleName());

    private static final Environment PROPERTIES_INFO = Environment.getInstance();

    private CommonMethods() {
    }

    public static void searchElements(WebElement webElement, String nameElement){
        webElement.sendKeys(nameElement);
    }

    /**
     * This Method return false o true if the element be present.
     *
     * @param webElement element
     * @return True or false
     */
    public static boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getTagName();
            return true;
        } catch (WebDriverException e) {
            LOGGER.error("Web element not found", e);
            return false;

        }
    }

    /**
     * This method set a Web Element
     *
     * @param webElement
     * @param text
     */
    public static void setWebElement(WebElement webElement, String text) {
        WEB_DRIVER_WAIT.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        WEB_DRIVER_WAIT.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }

    /**
     * This Method do click in element
     *
     * @param webElement
     */
    public static void clickWebElement(WebElement webElement) {
        WEB_DRIVER_WAIT.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * This Method set a check box element
     *
     * @param webElement
     * @param enable
     */
    public static void setCheckBox(WebElement webElement, boolean enable) {
        if (!enable) {
            checkBox(webElement);
        }
    }

    /**
     * This Method set a unchecked box element
     *
     * @param webElement
     */
    private static void unCheckBox(WebElement webElement) {
        if (!webElement.isSelected()) {
            webElement.click();
        }
    }

    /**
     * This Method set a check box element
     *
     * @param webElement
     */
    public static void checkBox(WebElement webElement) {
        if (webElement.isSelected()) {
            webElement.click();
        }
    }

    /**
     * Select 1 element the list
     *
     * @param webElementSelect
     * @param element
     */
    public static void selectAElementComboBox(WebElement webElementSelect, String element) {
        Select oSelect = new Select(webElementSelect);
        oSelect.selectByValue(element);
    }

    /**
     * Convert a Select element
     *
     * @param webElement
     * @return
     */
    public static Select convertASelect(WebElement webElement) {
        return new Select(webElement);
    }


    public static void quitProgram(String message) {
        LOGGER.info("Element null " + message);
        Runtime.getRuntime().runFinalization();
    }
}
