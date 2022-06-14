package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_Locators_getText {
    public static void main(String[] args) {
        WebDriver driver = WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        driver.get("https://login1.nextbasecrm.com/");
        WebElement userName = driver.findElement(By.className("login-inp"));
        userName.sendKeys("incorrect");


        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("incorrect");

//        5- Click to login button.
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();

//        6- Verify error message text is as expected:
//        Expected: Incorrect login or password
        WebElement errorMsg = driver.findElement(By.className("errortext"));

        String expectedText = "Incorrect login or password";

        // getText() method; it will get the content(text) form in between the opening and closing tag
        String actualText = errorMsg.getText();

        if (actualText.equals(expectedText)) {
            System.out.println("Error message verification passed!");
        } else {
            System.out.println("Error message verification failed!");
        }

        driver.quit();

    }
}
