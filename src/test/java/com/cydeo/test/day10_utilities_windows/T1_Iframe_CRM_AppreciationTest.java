package com.cydeo.test.day10_utilities_windows;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Iframe_CRM_AppreciationTest extends TestBase {
    /*
    1- Open a chrome browser
2- Go to: https://login2.nextbasecrm.com/
3- Login Homepage ( Login with valid username and
password)
4- Click the MORE tab and select APPRECIATION
5- Write an Appreciation message
6- Click the SEND button
7- Verify the Appreciation message is displayed on
the feed
     */
    @Test
    public void sendingAppreciationMsg() {
        driver.get("https://login2.nextbasecrm.com/");
        CRM_Utilities.login_crm(driver,"hr1@cydeo.com","UserUser");
//        WebElement userName = driver.findElement(By.name("USER_LOGIN"));
//        userName.sendKeys("hr14@cybertekschool.com");
//        WebElement passWord = driver.findElement(By.name("USER_PASSWORD"));
//        passWord.sendKeys("UserUser");
//        WebElement logIn = driver.findElement(By.xpath("//input[@value='Log In']"));
//        logIn.click();
        WebElement moreButton = driver.findElement(By.cssSelector("span[id$='link-text']"));
        moreButton.click();
        WebElement appreciation = driver.findElement(By.xpath("//span[.='Appreciation']"));
        appreciation.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"))); // .bx-editor-iframe- --> Css
        driver.findElement(By.tagName("body")).sendKeys("Hello!");

        driver.switchTo().defaultContent();
        WebElement clickBtn = driver.findElement(By.id("blog-submit-button-save"));
        clickBtn.click();

        WebElement feedText=driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body')]"));
        String actual=feedText.getText();
        String expected="Hello!";

        Assert.assertEquals(actual,expected);
    }
}
