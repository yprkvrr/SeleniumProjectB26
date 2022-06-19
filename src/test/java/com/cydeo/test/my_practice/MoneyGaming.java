package com.cydeo.test.my_practice;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoneyGaming extends TestBase {
    /*
    1. Navigate to: https://moneygaming.qa.gameaccount.com/
        2. Click the JOIN NOW button to open the registration page
        3. Select a title value from the dropdown
        4. Enter your first name and surname in the form
        5. Check the tickbox with text "I accept the Terms and Conditions and certify that I am over the age of 18.
        6. Submit the form by clicking the JOIN NOW button
        7. Validate that a validation message with text "This field is required" appears under the date of birth box
     */
    @Test
    public void moneyGaming() {
        driver.get("https://moneygaming.qa.gameaccount.com/");
        driver.findElement(By.cssSelector(".newUser.green")).click();
        Select select = new Select(driver.findElement(By.cssSelector("select#title")));
        select.selectByVisibleText("Mrs");

        driver.findElement(By.cssSelector("input#forename")).sendKeys("Nazli");
        driver.findElement(By.xpath("//input[@name='map(lastName)']")).sendKeys("Vurur");
        driver.findElement(By.xpath("//input[@name='map(terms)']")).click();
        driver.findElement(By.cssSelector("input#form")).click();
        WebElement msg= driver.findElement(By.xpath("//label[@for='dob']"));
        Assert.assertEquals(msg.getText(),"This field is required");
    }
}
