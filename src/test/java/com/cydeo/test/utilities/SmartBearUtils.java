package com.cydeo.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {


    public static void logInToSmartBear(WebDriver driver,String userName,String password){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");
        WebElement userName1= driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
        userName1.sendKeys(userName);
        WebElement password1= driver.findElement(By.cssSelector("input#ctl00_MainContent_password"));
        password1.sendKeys(password);
        WebElement clickBtn=driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button"));
        clickBtn.click();

    }
}
