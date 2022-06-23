package com.cydeo.test.my_practice;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class VytrackTest {
    /*
    Given the Sales manager logged in to the Vytrack Application
Then Sales manager should be able to see landing page
When Sales manager hover over Fleet module
And Sales manager clicks on Vehicle Model
Then Sales manager should be able to see all Vehicle models informations.
     */

    @Test
    public void salesManager() throws InterruptedException {
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");
        WebElement userName = Driver.getDriver().findElement(By.cssSelector("#prependedInput"));
        userName.sendKeys("salesmanager264");
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser123");
        WebElement logIn = Driver.getDriver().findElement(By.xpath("//button[.='Log in']"));
        logIn.click();

        WebElement fleet = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(3000);
        actions.moveToElement(fleet).perform();
        WebElement models = Driver.getDriver().findElement(By.xpath("(//span[.='Vehicles Model'])[1]"));
        models.click();


    }


}
