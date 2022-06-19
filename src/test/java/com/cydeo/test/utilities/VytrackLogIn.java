package com.cydeo.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VytrackLogIn {

    public static void login(WebDriver driver,String username, String password){
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(username + Keys.ENTER);
        WebElement password1 = driver.findElement(By.id("prependedInput2"));
        password1.sendKeys(password + Keys.ENTER);
    }
}
