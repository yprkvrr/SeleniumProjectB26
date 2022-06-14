package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T2_findElements {
    public static void main(String[] args) {
        /*
        TC #4: FindElements Task
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/abtest
3- Locate all the links in the page.
4- Print out the number of the links on the page.
5- Print out the texts of the links.
6- Print out the HREF attribute values of the links
         */
        WebDriver driver = WebdriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/abtest");

        List<WebElement> allLinks=driver.findElements(By.tagName("a"));
        System.out.println("allLinks.size() = " + allLinks.size());
        for (WebElement each : allLinks) {
            System.out.println("each.getText() = " + each.getText());
            System.out.println("each.getAttribute(\"href\") = " + each.getAttribute("href"));

        }
driver.quit();
    }

}
