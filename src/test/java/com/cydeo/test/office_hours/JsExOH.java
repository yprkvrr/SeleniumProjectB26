package com.cydeo.test.office_hours;

import com.cydeo.test.utilities.BrowserOfficeHours;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsExOH {
    /*
     Task 1


       - Go to  "https://techcrunch.com/"
       - Click TechCrunch from Footer > About > TechCrunch
       - Verify title contains "TechCrunch"
     */

    @Test
    public void tech_crunch(){
        Driver.getDriver().get("https://techcrunch.com/");

        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();

        WebElement tech=Driver.getDriver().findElement(By.xpath("//a[@data-ga-event-label='TechCrunch']"));
        js.executeScript("arguments[0].scrollIntoView(true)", tech);
        tech.click();

        Assert.assertTrue(Driver.getDriver().getTitle().contains("TechCrunch"));
        BrowserOfficeHours.waitFor(3);
        Driver.closeDriver();

    }
}
