package com.jalasoft.xpress.pages;

import com.jalasoft.xpress.framework.util.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.jalasoft.xpress.framework.util.CommonMethods.checkBox;
import static com.jalasoft.xpress.framework.util.CommonMethods.clickWebElement;
import static com.jalasoft.xpress.framework.util.CommonMethods.setWebElement;

/**
 * Created by Mijhail Villarroel on 9/6/2016.
 */
public class ScenarioForm extends BasePage {

    @FindBy(css = ".xp-margin-none.ng-pristine.ng-untouched.ng-invalid.ng-invalid-required")
    WebElement nameScenarioTextField;

    @FindBy(xpath = "//input [@type='checkbox']")
    List<WebElement> listCheckBox;

    @FindBy(css = ".file-drop-box.file-loader-button.ng-scope")
    WebElement selectFile;

    public ScenarioForm setTxtprojectName(String tprojectName) {
        setWebElement(nameScenarioTextField, tprojectName);
        return this;
    }

    public ScenarioForm setcheckBox(String nameItem) {
        for (WebElement webElement : listCheckBox) {
            if (nameItem.equalsIgnoreCase(webElement.getText())){
                checkBox(webElement);
            }
        }
        return this;
    }
    public ScenarioForm setSelectFile() {
        clickWebElement(selectFile);
        return this;
    }

}
