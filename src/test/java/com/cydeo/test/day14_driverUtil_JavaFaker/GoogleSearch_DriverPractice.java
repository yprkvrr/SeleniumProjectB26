package com.cydeo.test.day14_driverUtil_JavaFaker;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearch_DriverPractice {
    /*
    // Go to "https://www.google.com/"
// Write “apple” in search box
 // Verify title:
 //Expected: apple - Google Search
     */

    @Test
    public void google_search_driver_practice(){
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));

        WebElement searchBox=Driver.getDriver().findElement(By.name("q"));
        searchBox.sendKeys("apple"+ Keys.ENTER);

        String actualTitle=Driver.getDriver().getTitle();
        String expected="apple - Google Search";

        Assert.assertEquals(actualTitle,expected);
    }
}
