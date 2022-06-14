package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractice {
    /*
    1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfully clicked an alert” text is displayed.

     */
    WebDriver driver;
    @BeforeMethod
    public void set(){
        driver = WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }
    @Test
    public void informationAlertTest(){
        WebElement jsAlertButton=driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlertButton.click();

        Alert alert=driver.switchTo().alert();
        alert.accept();
        WebElement resultText=driver.findElement(By.id("result"));
        Assert.assertTrue(resultText.isDisplayed());

        String actualResultText=resultText.getText();
        String expected="You successfully clicked an alert";
        Assert.assertEquals(actualResultText,expected);

    }

}
