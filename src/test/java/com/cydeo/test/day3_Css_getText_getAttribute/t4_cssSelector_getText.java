package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class t4_cssSelector_getText {
    public static void main(String[] args) {
        /*
        TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes 3- Verify “Reset password” button text is as expected:
Expected: Reset password
﻿
         */

        WebDriver driver= WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        WebElement reset=driver.findElement(By.cssSelector("button.login-btn"));
        String actual=reset.getText();
        String expected="Reset password";

        if (actual.equals(expected)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }
        driver.quit();
    }
}
