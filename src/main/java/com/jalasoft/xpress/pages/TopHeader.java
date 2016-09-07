package com.jalasoft.xpress.pages;

import com.jalasoft.xpress.pages.project.ProjectManagementPPSA;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;
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
    private WebElement moduleSelectorCbo;

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
    

    public TopHeader clickOnExpressOptionMenu() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            LOGGER.error("Interrupted !", e);
            Thread.currentThread().interrupt();
        }
        final String xpath="//span[contains(.,'XPRESS')]";
        clickWebElement(moduleSelectorCbo);
        WebElement xpressOptionMenu=moduleSelectorCbo.findElement(By.xpath(xpath));
        clickWebElement(xpressOptionMenu);
        return this;
    }

    public ProsHome clickOnLogOut() {
        try {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_FAIL_WAIT_TIME, SECONDS);
            final String xpath = "//span[contains(.,'Log out')]";
            userNameText.click();
            WebElement LogOutOptionMenu = moduleSelectorCbo.findElement(By.xpath(xpath));
            clickWebElement(LogOutOptionMenu);

        } catch (NoSuchElementException e) {
            LOGGER.warn("Button log out not found", e);

        }
        catch (TimeoutException e) {
            LOGGER.warn("Time out exception Button log out not found", e);

        }
        finally {
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, SECONDS);
        }
        return new ProsHome();
    }

}
