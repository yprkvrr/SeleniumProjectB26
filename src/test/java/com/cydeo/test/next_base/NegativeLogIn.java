package com.cydeo.test.next_base;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NegativeLogIn extends TestBase {
    @Test
    public void invalidLogin() throws InterruptedException {
        //User cannot login  with invalid username
        //User can click on remember me on this computer icon
        //User can access to "Forgot your password?" link page

        driver.get("https://login2.nextbasecrm.com/");


        WebElement inputUserName = driver.findElement(By.name("USER_LOGIN"));
        inputUserName.sendKeys("help@cydeoschool.com");

        WebElement inputPassWord = driver.findElement(By.name("USER_PASSWORD"));
        inputPassWord.sendKeys("UserUser");

        Thread.sleep(3000);
        WebElement logIn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logIn.click();
        Thread.sleep(3000);

        WebElement rememberBtn=driver.findElement(By.cssSelector("input#USER_REMEMBER"));
        rememberBtn.click();

        WebElement forgotBtn=driver.findElement(By.xpath("//a[.='Forgot your password?']"));
        forgotBtn.click();
        Thread.sleep(3000);

    }
}
