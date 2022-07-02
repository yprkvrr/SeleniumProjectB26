package com.cydeo.test.office_hours;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3 {
    /*
    Task 3
 Go to  "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx"
       - Fill form with following information
			fullname : TEST
			email    : TEST
	   - Click Login Button
	   - Verify error message equals "Invalid Login or Password."
     */

    @Test
    public void key_actions() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx");

        WebElement logIn = Driver.getDriver().findElement(By.cssSelector("input#ctl00_MainContent_username"));
        Actions actions = new Actions(Driver.getDriver());


        actions.moveToElement(logIn).keyDown(Keys.SHIFT).sendKeys("test").keyUp(Keys.SHIFT).keyDown(Keys.CONTROL).sendKeys("A").sendKeys("C").keyUp(Keys.CONTROL).sendKeys(Keys.TAB).keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).sendKeys(Keys.ENTER).perform();

        WebElement result=Driver.getDriver().findElement(By.xpath("//span[.='Invalid Login or Password.']"));
        String expected="Invalid Login or Password.";
        Assert.assertEquals(result.getText(),expected);

        Driver.closeDriver();

    }
}
