package com.cydeo.test.next_base;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Vytrack extends TestBase {
    /*
    "5. As a truck driver I should be able to access
    Vehicle Costs page"
     */
/*
"1.Verify that truck driver should be able to see all cars' cost informations on the Vehicle Costs
page.
2.Verify that truck driver should be able to create Vehicle cost an cancel it.
3.Verify that truck driver should be able to edit or delet Vehicle cost
4. Verify that truck driver should be able to add Attachement on General information
page by click on any of the car on the grid.

6.Verify that truck driver should be able to reset the grid by click on Grid setting
 "
 */
    @Test
    public void access() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("user169" + Keys.ENTER);
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123" + Keys.ENTER);


        WebElement fleet = driver.findElement(By.xpath("(//i[@class='fa-asterisk menu-icon'])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(fleet);
        Thread.sleep(3000);
        WebElement c = driver.findElement(By.xpath("//span[.='Vehicle Costs']"));
        action.moveToElement(c).click();
        Thread.sleep(3000);

//        WebElement vehicleCostBtn=driver.findElement(By.xpath("//a[@title='Create Vehicle Costs']"));
//        vehicleCostBtn.click();

    }
}
