package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {
    // set up chrome and create WebDriver instance
// Get "https://google.com/"
// Assert: title is  "Google"
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Before method is running");
        WebDriver driver = WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running");
        driver.close();
    }
    @Test
    public void googleTitle() {


        driver.get("https://google.com/");
        String actual = driver.getTitle();
        String expected = "Google";
        // 3rd argumant is optional for failed message. It will only appear when verification is failed
        Assert.assertEquals(actual, expected,"Title verification is failed!");

    }
    @Test
    public void yahooTitle(){
        driver.get("https://yahoo.com");

    }


    @Test
    public void etsyTitle(){
        driver.get("https://etsy.com");

    }

}
