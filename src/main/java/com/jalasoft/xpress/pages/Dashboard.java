package com.jalasoft.xpress.pages;

import com.jalasoft.xpress.framework.util.Constants;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.jalasoft.xpress.framework.util.Constants.IMPLICIT_FAIL_WAIT_TIME;
import static com.jalasoft.xpress.framework.util.Constants.IMPLICIT_WAIT_TIME;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by henrry salinas on 9/1/2016.
 */
public class Dashboard extends BasePage{

    private Menu menu;

    private TopHeader topHeader;

    public Dashboard(){
        menu = new Menu();
        topHeader = new TopHeader();
    }

    public Menu getMenu() {
        return menu;
    }

    public TopHeader getTopHeader() {
        return topHeader;
    }
}
