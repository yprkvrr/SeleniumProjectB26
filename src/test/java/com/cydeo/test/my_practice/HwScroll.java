package com.cydeo.test.my_practice;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HwScroll {
    @Test
    public void scroll_test() throws InterruptedException {
        /*
2- Go to: https://practice.cydeo.com/large
3- Scroll down to “Cydeo” link
4- Scroll up to “Home” link
5- Use below provided JS method only
 JavaScript method to use : arguments[0].scrollIntoView(true)
Note: You need to locate the links as web elements and pass them as
arguments into executeScript() method
         */

        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement cydeo = Driver.getDriver().findElement(By.linkText("CYDEO"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", cydeo);
        Thread.sleep(3000);
        WebElement home = Driver.getDriver().findElement(By.linkText("Home"));

//        Actions actions=new Actions(Driver.getDriver());
//        actions.moveToElement(home).perform();

        js.executeScript("arguments[0].scrollIntoView(true)", home);
        Thread.sleep(3000);

        Driver.closeDriver();

    }
}
