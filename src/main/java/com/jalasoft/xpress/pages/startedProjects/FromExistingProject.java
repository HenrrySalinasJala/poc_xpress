package com.jalasoft.xpress.pages.startedProjects;

import com.jalasoft.xpress.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;

/**
 * Created by Daniel Gonzales on 9/2/2016.
 */
public class FromExistingProject extends BasePage{

    @FindBy(css = ".li-input.ng-binding.ng-scope")
    private WebElement numPages;

    @FindBy(xpath = "//button[contains(text(), 'Start')]")
    private WebElement startBtn;

    @FindBy(xpath = "//li[contains(@title,'Next Page')]")
    private WebElement nextPageBtn;


    public FromExistingProject selectProjectCheck(String nameProject){
        String myNumPages = numPages.getText();
        Pattern pattern = Pattern.compile("[^\\d]");
        Matcher matcher = pattern.matcher(myNumPages);
        int numPage = Integer.parseInt(matcher.replaceAll(""));
        for(int i = 0; i<numPage; i++) {
            if (!(driver.findElement(By.xpath("//span[contains(text(), '" + nameProject + "')]")).getText().isEmpty())) {
                WebElement selectProjectCheck = driver.findElement(By.xpath("//tr[td//text()[contains(., '"+nameProject+"')]]//input[@type='radio']"));
                clickWebElement(selectProjectCheck);
                break;
            }
            clickWebElement(nextPageBtn);
        }
        return this;
    }

    public Dimensions clickStartBtn(){
        clickWebElement(startBtn);
        return new Dimensions();
    }


}
