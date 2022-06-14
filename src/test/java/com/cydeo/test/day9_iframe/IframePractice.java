package com.cydeo.test.day9_iframe;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IframePractice extends TestBase {

/*
TC #6: Iframe Task
2- Go to: https://practice.cydeo.com/iframe
3- Clear text from comment body
4- Type "Hello World" in comment body
5- Verify "Hello World" text is written in comment body
6- Verify header "An iFrame containing the TinyMCE
WYSIWYG Editor" is displayed
 */

    @Test
    public void iframeTest() throws InterruptedException {
// NOSuchElement exception comes with reasons:
        // 1- Not locationg correctly element
        //2- There is an iframe and you have switch to frame to reach this element


        driver.get("https://practice.cydeo.com/iframe");
        driver.switchTo().frame("mce_0_ifr"); // 3 ways of switching iframe -id,index,locator
        WebElement commentBody = driver.findElement(By.id("tinymce"));

        commentBody.clear();
        Thread.sleep(3000);
        commentBody.sendKeys("Hello World");
        assertEquals(commentBody.getText(),"Hello World");

        driver.switchTo().parentFrame();
        WebElement header=driver.findElement(By.tagName("h3"));
       assertTrue(header.isDisplayed(),"Header text did not appear");

    }
}
