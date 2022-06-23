package com.cydeo.test.my_practice;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecuter {

    @Test
    public void scrollingTest(){
        Driver.getDriver().get("http://practice.cybertekschool.com/");
        WebElement cydeoLink=Driver.getDriver().findElement(By.linkText("CYDEO"));
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",cydeoLink);
    }
}
