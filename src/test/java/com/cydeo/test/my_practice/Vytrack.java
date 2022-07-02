package com.cydeo.test.my_practice;

import com.cydeo.test.utilities.Driver;
import com.cydeo.test.utilities.VytrackLogIn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Vytrack {
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
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");

        VytrackLogIn.login(Driver.getDriver(), "user169", "UserUser123");


        WebElement fleet = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(3000);
        actions.moveToElement(fleet).perform();

        WebElement cost = Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Costs']"));
        cost.click();
        Thread.sleep(3000);

        WebElement vehicleCostBtn = Driver.getDriver().findElement(By.xpath("//a[@title='Create Vehicle Costs']"));
        vehicleCostBtn.click();

        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='custom_entity_type[Type]']")));
        select.selectByValue("summer_tires");
        Driver.getDriver().findElement(By.name("custom_entity_type[TotalPrice]")).sendKeys("500");
        Driver.getDriver().findElement(By.xpath("//input[@placeholder='Choose a date']")).click();
        Driver.getDriver().findElement(By.xpath("//button[@data-handler='today']")).click();
        Thread.sleep(3000);
        // Driver.getDriver().findElement(By.xpath("//input[@placeholder='Choose a date']")).click();
        Driver.getDriver().findElement(By.cssSelector("textarea[id*='custom_entity_type_Cost']")).sendKeys("Snow Tires");
        Driver.getDriver().findElement(By.xpath("(//button[@class='btn btn-medium add-btn'])[1]")).click();
        Driver.getDriver().findElement(By.xpath("//td[.='7,181,224']")).click();
        Driver.getDriver().findElement(By.xpath("//button[.='Select']")).click();

        Driver.getDriver().findElement(By.xpath("(//button[@class='btn btn-medium add-btn'])[2]")).click();
        Driver.getDriver().findElement(By.xpath("(//td[.='01ADANA01'])[1]")).click();
        Driver.getDriver().findElement(By.xpath("//button[.='Select']")).click();
        // Driver.getDriver().findElement(By.xpath("(//button[@type='submit'])[1]")).click(); Saving
        Driver.getDriver().findElement(By.xpath("//a[@title='Cancel']")).click();
        Driver.getDriver().findElement(By.xpath("//td[.='Jul 15, 2020']")).click();
        Driver.getDriver().findElement(By.xpath("//a[@title='Add attachment']")).click();


        WebElement attachment = Driver.getDriver().findElement(By.xpath("//input[@name='oro_attachment[file][file]']"));

        Thread.sleep(3000);

        attachment.sendKeys("C:\\Users\\yapra\\OneDrive\\Desktop\\Java_OOP-Cheat_Sheet_Edureka.png");

        Driver.getDriver().findElement(By.xpath("//textarea[@name='oro_attachment[comment]']")).sendKeys("All done!");
        Driver.getDriver().findElement(By.xpath("//button[.='Save']")).click();

        actions.moveToElement(fleet).perform();
        cost.click();
        Driver.getDriver().findElement(By.xpath("(//i[@class='fa-refresh'])[2]")).click();

        Driver.closeDriver();

    }
}
