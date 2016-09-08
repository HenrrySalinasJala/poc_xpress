package com.jalasoft.xpress.pages;

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
