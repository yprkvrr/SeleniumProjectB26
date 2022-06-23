package com.cydeo.test.day16_actions_jsexecuter;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T2_Actions_Scroll {
    /*
    //    1- Open a chrome browser
//    2- Go to: https://practice.cydeo.com/
//    3- Scroll down to “Powered by CYDEO”
//    4- Scroll using Actions class “moveTo(element)” method

//    1- Continue from where previous task left in the same test.
//    2- Scroll back up to “Home” link using PageUP button
     */
    @Test
    public void actions_scroll_test() {
        Driver.getDriver().get(ConfigurationReader.getProperty("practice.page.url"));
        WebElement cydeo = Driver.getDriver().findElement(By.linkText("CYDEO"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(cydeo).perform();


        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
       // actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();
        actions.moveToElement(homeLink).perform();
        Driver.closeDriver();
    }

}
