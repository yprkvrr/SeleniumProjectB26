package com.cydeo.test.my_practice;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class InterviewTask {
    @Test
    public void try_all() throws InterruptedException {
        Driver.getDriver().get("http://te.dev.secureci.com/Exercise2.html");
        List<WebElement> allButtons = Driver.getDriver().findElements(By.xpath("//label[@class='switch']"));

       // WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        for (WebElement each : allButtons) {
            each.click();
           // wait.until(ExpectedConditions.elementToBeClickable(each));
        }
        Thread.sleep(4000);
        Driver.closeDriver();
    }
}
