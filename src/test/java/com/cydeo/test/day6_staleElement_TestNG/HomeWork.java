package com.cydeo.test.day6_staleElement_TestNG;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomeWork {
    /*
    TC: Etsy checkbox and radio button
1. Go to https://www.etsy.com
2. Search for “wooden spoon”
3. Click on filters
4. Select free shipping, on sale
5. Select under $25 Click on apply filters
6. Print count of results
     */
    public static void main(String[] args) {

        WebDriver driver = WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.etsy.com");
        WebElement searchBox=driver.findElement(By.xpath("//input[@name='search_query']"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);
        WebElement filter=driver.findElement(By.xpath("//span[@class='wt-icon wt-icon--smaller-xs']"));
        filter.click();

        WebElement freeShipping= driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));
        freeShipping.click();

        WebElement under25=driver.findElement(By.xpath("//label[@for='price-input-1']"));
        under25.click();
    }
}
