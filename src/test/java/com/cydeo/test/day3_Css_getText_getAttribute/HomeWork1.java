package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeWork1 {
    /*
    TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: "FORGOT YOUR PASSWORD?"
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes
PS: Inspect and decide which locator you should be using to locate web
elements.
     */
    public static void main(String[] args) {
        WebDriver driver = WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/");

        WebElement remember=driver.findElement(By.cssSelector(".login-item-checkbox-label"));
        String actual= remember.getText();
        String expected="Remember me on this computer";
        if (actual.equals(expected)){
            System.out.println("Text verification is passed");
        }else{
            System.out.println("Text verification is failed");
        }

        WebElement forgot=driver.findElement(By.cssSelector("a[href='/?forgot_password=yes']"));
        String actual2=forgot.getText();
        String expected2="FORGOT YOUR PASSWORD?";
        if (actual2.equals(expected2)){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }
        driver.quit();
    }
}
