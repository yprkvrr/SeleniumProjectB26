package com.cydeo.test.login;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelpDesk {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://login2.nextbasecrm.com/");

        WebElement search = driver.findElement(By.name("USER_LOGIN"));
        search.sendKeys("helpdesk47@cybertekschool.com");
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));

        password.sendKeys("User" + Keys.ENTER);

        String expectedMsg = "Incorrect login or password";
        WebElement msg = driver.findElement(By.className("errortext"));
        String actual = msg.getText();
        if (actual.equals(expectedMsg)) {
            System.out.println("Test case is passed");
        } else {
            System.out.println("Test case is failed");
        }
        
        driver.quit();

    }
}
