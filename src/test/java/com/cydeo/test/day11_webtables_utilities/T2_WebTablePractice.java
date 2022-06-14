package com.cydeo.test.day11_webtables_utilities;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_WebTablePractice extends TestBase {

    /*
    TC #1: Web table practice
1. Goto : https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021

     */

    @Test
    public void orderNameVerifyTest() {
        driver.get("https://practice.cydeo.com/web-tables");
        WebElement name=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));

        String expected="Bob Martin";

        Assert.assertEquals(name.getText(),expected);
        WebElement orderDate=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]"));
        String expectedDate="12/31/2021";

        Assert.assertEquals(orderDate.getText(),expectedDate);
    }

}
