package com.jalasoft.xpress.pages;

import org.openqa.selenium.support.FindBy;

/**
 * Created by henrry salinas on 9/1/2016.
 */
public class Dashboard extends BasePage{

    private Menu menu;

    public Dashboard(){
        menu=new Menu();
    }

    public Menu getMenu() {
        return menu;
    }

}
