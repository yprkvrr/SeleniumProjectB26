package com.cydeo.test.day13_configuration_reader;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T1_Config_Practice extends TestBase {
    /*
2. Go to : http://login1.nextbasecrm.com/
3. Enter valid username
4. Enter valid password
5. Click to Log In button
6. Verify title is as expected:
Expected: Portal
     */
    @Test
    public void login_crm_app() {
//        driver.get("http://login1.nextbasecrm.com/");
        driver.get(ConfigurationReader.getProperty("env"));

        WebElement search = driver.findElement(By.name("USER_LOGIN"));
        search.sendKeys(ConfigurationReader.getProperty("username"));
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));

        password.sendKeys(ConfigurationReader.getProperty("password") + Keys.ENTER);

    }
}
