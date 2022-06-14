package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Simple_DropDown {
    /*
    TC #1: Verifying “Simple dropdown” and “State selection”
dropdown default values
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State”
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void simpleDropDownTest() {


        Select simpleDropDown = new Select(driver.findElement(By.id("dropdown")));
        String actual = simpleDropDown.getFirstSelectedOption().getText();
        String expected = "Please select an option";
        Assert.assertEquals(actual, expected, "Failed");
    }
@Test
        public void stateDropDownTest(){
        Select stateDropDown = new Select(driver.findElement(By.id("state")));
        String actualState = stateDropDown.getFirstSelectedOption().getText();
        String expectedState="Select a State";

        Assert.assertEquals(actualState,expectedState);
    }
    @AfterMethod
    public void closed(){
        driver.quit();
    }
}