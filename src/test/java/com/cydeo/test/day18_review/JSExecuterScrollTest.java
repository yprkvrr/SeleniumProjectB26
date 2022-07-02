package com.cydeo.test.day18_review;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JSExecuterScrollTest {
    @Test
    public void js_executer_scroll_test() throws InterruptedException {
/*
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/infinite_scroll
3- Use below JavaScript method and scroll
a.  750 pixels down 10 times.
b.  750 pixels up 10 times

 */

        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,750)");
        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            js.executeScript("window.scrollBy(0,-750)");
        }


        Driver.closeDriver();
    }



}
