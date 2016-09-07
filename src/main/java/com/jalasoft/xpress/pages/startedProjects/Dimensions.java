package com.jalasoft.xpress.pages.startedProjects;

import com.jalasoft.xpress.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Daniel Gonzales on 9/6/2016.
 */
public class Dimensions extends BasePage {

    @FindBy(xpath = " //property-title[@title-value='dimension.title.value']/span")
    private List<WebElement> dimensionsLocator;

    public List<String> dimensionsList() {
        List<String> stringDimensionList = new ArrayList<>();
        for (WebElement myElem : dimensionsLocator) {
            stringDimensionList.add(myElem.getText());
        }
        Collections.sort(stringDimensionList);
        return stringDimensionList;
    }
}
