package com.cydeo.test.day6_staleElement_TestNG;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomeW {
    public static void main(String[] args) {
        /*
        1. Open a chrome browser
2. Go to: https://practice.cydeo.com/abtest
3. Locate “CYDEO” link, verify it is displayed.
4. Refresh the page.
5. Verify it is displayed, again.
         */
        WebDriver driver = WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/abtest");
        WebElement cydeo = driver.findElement(By.xpath("//a[@target='_blank']"));
        System.out.println("cydeo.isDisplayed() = " + cydeo.isDisplayed());

        driver.navigate().refresh();
        System.out.println("cydeo.isDisplayed() = " + cydeo.isDisplayed());
        try {
            System.out.println("cydeo.isDisplayed() = " + cydeo.isDisplayed());
        } catch (StaleElementReferenceException e) {
            System.out.println("Passed");
        }
        driver.quit();

    }
}
