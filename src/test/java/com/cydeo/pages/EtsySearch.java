package com.cydeo.pages;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsySearch {
    public EtsySearch() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#global-enhancements-search-query")
   public WebElement searchBox;
}
