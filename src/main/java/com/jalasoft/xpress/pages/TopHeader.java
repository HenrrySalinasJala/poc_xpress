package com.jalasoft.xpress.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static com.jalasoft.xpress.framework.util.Constants.IMPLICIT_WAIT_TIME;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Mijhail Villarroel on 9/2/2016.
 */
public class TopHeader extends BasePage{

    private static final Logger LOGGER = Logger.getLogger(TopHeader.class.getName());

    @FindBy(xpath = "(//div[@class='ng-binding basic-dropdown'])[last()]")
    private WebElement userNameText;

    @FindBy(xpath = "//div[contains(@class,'module-selector-container')]")
    private WebElement moduleSelector;

    public String getUserNameText() {
        String userName = "";
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, SECONDS);
            userName = userNameText.getText();
        } catch (NoSuchElementException e) {
            LOGGER.warn("User name element not found", e);

        } finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, SECONDS);
        }
        return userName;
    }

    public void clickOnModuleSelector() {
        this.moduleSelector = moduleSelector;
    }
}
