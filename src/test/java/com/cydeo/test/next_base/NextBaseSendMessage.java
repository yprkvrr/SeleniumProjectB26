package com.cydeo.test.next_base;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NextBaseSendMessage extends TestBase {
    /*
    "1. Verify users can send message by clicking ""MESSAGE"" tab
2. Verify users can cancel message.
3. Veriy users can attach link by clicking on the link icon."
     */

    @Test
    public void sendMessage() throws InterruptedException {
        driver.get("https://login2.nextbasecrm.com/");
        CRM_Utilities.login_crm(driver, "hr1@cydeo.com", "UserUser");
        WebElement msgArea = driver.findElement(By.xpath("//span[.='Send message …']"));
        msgArea.click();
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[1]")));
        driver.findElement(By.tagName("body")).sendKeys("MESSAGE");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        WebElement clicking = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        clicking.click();

        WebElement msgArea2 = driver.findElement(By.xpath("//span[@class='feed-add-post-micro-title']"));
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@class='bx-editor-iframe'])[1]")));

        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        WebElement cancel = driver.findElement(By.xpath("//button[@id='blog-submit-button-cancel']"));
        cancel.click();
        Thread.sleep(3000);
        WebElement msgArea3 = driver.findElement(By.xpath("//span[@class='feed-add-post-micro-title']"));
        msgArea3.click();
        WebElement link = driver.findElement(By.xpath("//span[@title='Link']"));
        link.click();
        Thread.sleep(3000);

        WebElement attach = driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-text']"));
        attach.click();
        attach.sendKeys("Link");

        WebElement linkUrl = driver.findElement(By.xpath("//input[@id='linkidPostFormLHE_blogPostForm-href']"));
        linkUrl.click();
        linkUrl.sendKeys("https://www.etsy.com/");
        Thread.sleep(3000);
        WebElement save = driver.findElement(By.xpath("//input[@id='undefined']"));
        save.click();

    }
}
