package com.cydeo.test.day8_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/*
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
 Select year using   : visible text
Select month using    : value attribute Select
day using : index number
 */

public class SelectDate_Dropdown {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void verify(){
        driver.get("https://practice.cydeo.com/dropdown");
        Select select=new Select(driver.findElement(By.id("year")));
        select.selectByValue("1923");
        Select select2=new Select(driver.findElement(By.id("month")));
        select2.selectByValue("11");
        Select select3=new Select(driver.findElement(By.id("day")));
        select3.selectByValue("1");

        for (WebElement yearOption : select.getOptions()) {
            System.out.println(yearOption.getText());
        }

        String actualYear=select.getFirstSelectedOption().getText();
        String actualMonth=select2.getFirstSelectedOption().getText();
        String actualDay=select3.getFirstSelectedOption().getText();

        Assert.assertTrue(actualYear.equals("1923"),"Year selection did not pass!");
        Assert.assertTrue(actualMonth.equals("December"),"Month selection did not pass!");
        Assert.assertTrue(actualDay.equals("1"),"Day selection did not pass!");



    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}
