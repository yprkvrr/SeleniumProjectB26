package com.cydeo.test.my_practice;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWorkOfficeHours extends TestBase {
    /*
    HOMEWORK1
	TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
	1- Open a chrome browser
	2- Go to: https://login1.nextbasecrm.com/
	3- Verify “remember me” label text is as expected:
	Expected: Remember me on this computer
	4- Verify “forgot password” link text is as expected:
	Expected: Forgot your password?
	5- Verify “forgot password” href attribute’s value contains expected:
	Expected: forgot_password=yes
     */

    @Test
    public void nextBaseLogIn(){
        driver.get("https://login1.nextbasecrm.com/");
        WebElement rememberMe= driver.findElement(By.xpath("//label[.='Remember me on this computer']"));
        String expectedLabel="Remember me on this computer";

        Assert.assertEquals(rememberMe.getText(),expectedLabel);

        WebElement forgotPassword = driver.findElement(By.cssSelector("a.login-link-forgot-pass"));
        String expectedLinkText="FORGOT YOUR PASSWORD?";

        Assert.assertEquals(forgotPassword.getText(),expectedLinkText);

        String actualHref = forgotPassword.getAttribute("href");
        String expectedHref="forgot_password=yes";

        Assert.assertTrue(actualHref.contains(expectedHref));


    }
}
