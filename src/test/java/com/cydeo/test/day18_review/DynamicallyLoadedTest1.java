package com.cydeo.test.day18_review;

import com.cydeo.pages.DynamicallyLoadedPage1;
import com.cydeo.test.utilities.BrowserUtils;
import com.cydeo.test.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicallyLoadedTest1 {
    /*
    1. Go to https://practice.cydeo.com/dynamic_loading/1
    2. Click to start
    3. Wait until loading bar disappears
    4. Assert username inputbox is displayed
    5. Enter username: tomsmith
    6. Enter password: incorrectpassword
    7. Click to Submit button
    8. Assert “Your password is invalid!” text is displayed.
     */
    @Test
    public void dynamically_loaded_page_1() {
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");
        DynamicallyLoadedPage1 dynamicallyLoadedPage1 = new DynamicallyLoadedPage1();
        dynamicallyLoadedPage1.startBtn.click();

        BrowserUtils.waitForInvisibilityOf(dynamicallyLoadedPage1.loadingBar);
        Assert.assertTrue(dynamicallyLoadedPage1.userName.isDisplayed());

        dynamicallyLoadedPage1.userName.sendKeys("tomsmith");
        dynamicallyLoadedPage1.password.sendKeys("hola");
        dynamicallyLoadedPage1.submitButton.click();
        Assert.assertTrue(dynamicallyLoadedPage1.errorMsg.isDisplayed());

        Driver.closeDriver();
    }
}
