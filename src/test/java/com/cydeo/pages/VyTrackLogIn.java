package com.cydeo.pages;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLogIn {

    public VyTrackLogIn() {

        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(id = "prependedInput")
    public WebElement userNameButton;

    @FindBy(id = "prependedInput2")
    public WebElement passwordButton;
}
