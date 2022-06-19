package com.cydeo.test.my_practice;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.SmartBearUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SmartBear extends TestBase {
/*
2. Go to website:
http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page
 */

    @Test
    public void smartBear(){
//        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx ");
//        WebElement userName= driver.findElement(By.cssSelector("input#ctl00_MainContent_username"));
//        userName.sendKeys("Tester");
//        WebElement password= driver.findElement(By.cssSelector("input#ctl00_MainContent_password"));
//        password.sendKeys("test");
//        WebElement clickBtn=driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button"));
//        clickBtn.click();

        SmartBearUtils.logInToSmartBear(driver,"Tester","test");

        List<WebElement>links=driver.findElements(By.tagName("a"));
        int nums=links.size();
        System.out.println("links.size() = " + links.size());

        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getText());}
    }
}
