package com.cydeo.test.day10_utilities_windows;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class T3_Windows_Handle extends TestBase {
    /*
    1. Open a chrome browser
2. Go to : https://practice.cydeo.com/windows
    3. Assert: Title is “Windows”
4. Click to: “Click Here” link
5. Switch to new Window.
6. Assert: Title is “New Window”
     */

    @Test
    public void windowHandleTest(){
        driver.get("https://practice.cydeo.com/windows");

        String actualTitle=driver.getTitle();
        String expectedTitle="Windows";

        Assert.assertEquals(actualTitle,expectedTitle,"Title did not match");

        WebElement clickHere=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();

        // Use Set to prevent getting duplicate windows

        Set<String> allWindowHandles=driver.getWindowHandles();

        for (String each: allWindowHandles) {
            driver.switchTo().window(each);
            System.out.println(driver.getTitle());

        }

        String expectedTitleAfterClicking="New Window";
        actualTitle=driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitleAfterClicking);

    }
}
