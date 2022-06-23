package com.cydeo.test.day16_actions_jsexecuter;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_JSExecutor_Scroll {
    @Test
    public void etsy_scroll_test() throws InterruptedException {
        /**
         * Goto Etsy homepage
         * Scroll down
         * Generate random email and enter into subscribe box
         * Click on Subscribe
         * Verify "Great! We've sent you an email to confirm your subscription." is displayed
         */

        Driver.getDriver().get(ConfigurationReader.getProperty("etsy"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //    js.executeScript("window.scrollBy(0, 5000)");
        WebElement element = Driver.getDriver().findElement(By.id("email-list-signup-email-input"));
        js.executeScript("arguments[0].scrollIntoView(true)", element);

        Faker faker = new Faker();
        element.sendKeys(faker.internet().emailAddress()+ Keys.ENTER);

        Thread.sleep(3000);

        WebElement successMsg = Driver.getDriver().findElement(By.xpath("//div[@class='wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01']"));

        Assert.assertEquals(successMsg.getText(),"Great! We've sent you an email to confirm your subscription.");
        Driver.closeDriver();
    }
}
