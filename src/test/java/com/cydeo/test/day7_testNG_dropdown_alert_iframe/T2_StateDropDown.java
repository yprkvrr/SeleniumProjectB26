package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T2_StateDropDown {
    /*
    1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
     */
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @Test
    public void stateDropdownTest() throws InterruptedException {
        Select stateDropdown = new Select(driver.findElement(By.id("state")));
        Thread.sleep(3000);
        stateDropdown.selectByVisibleText("Illinois");
        Thread.sleep(3000);
        stateDropdown.selectByVisibleText("Virginia");
        Thread.sleep(3000);
        stateDropdown.selectByVisibleText("California");
        Thread.sleep(3000);
        String actual = stateDropdown.getFirstSelectedOption().getText();
        String expected = "California";
        Assert.assertEquals(actual, expected);

    }

    /*
    1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.

     */
    @Test
    public void multiSelectDropdownTest() throws InterruptedException {
        Select languages = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        System.out.println("languages.isMultiple() = " + languages.isMultiple());

        languages.selectByValue("java");
        languages.selectByVisibleText("C#");
        languages.selectByIndex(3);
//        4. Print out all selected values.
        // getOptions() method will return to all options in dropdown
        List<WebElement> allOptions = languages.getOptions();
        for (WebElement each : languages.getOptions()) {

                each.click();
            Thread.sleep(3000);
            System.out.println("each.getText() = " + each.getText());
        }
        Thread.sleep(3000);
        languages.deselectAll();
        //        5. Deselect all values.
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
