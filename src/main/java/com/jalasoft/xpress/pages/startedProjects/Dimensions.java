package com.jalasoft.xpress.pages.startedprojects;

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

    public List<String> getStrings() {
        return Arrays.asList("Customer", "Date", "Price Guidance Level", "Price Guidance Validity", "Product", "Sales Org", "Transaction Segment");
    }
}
