package com.cydeo.test.day11_webtables_utilities;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class T1_Multiple_Windows extends TestBase {

    @Test
    public void windowsHandleTest() {
//        2. Goto:https://www.amazon.com
        driver.get("https://www.amazon.com");
//        3. Copy paste the lines from below into your class

        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");



        //4. Create a logic to switch to the tab where Etsy.com is open
        Set<String> tabs = driver.getWindowHandles();
        for (String tab : tabs) {
            driver.switchTo().window(tab);
            if (driver.getCurrentUrl().contains("etsy")) {
                break;
            }
        }
        String actual = driver.getTitle();
        String expected = "Etsy";
        Assert.assertTrue(actual.contains(expected));
        //5. Assert:Title contains “Etsy”

       // BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");
    }



}