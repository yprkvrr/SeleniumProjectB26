package com.cydeo.test.day10_utilities_windows;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.CRM_Utilities;
import com.cydeo.test.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T2_CRM_LOGIN extends TestBase {
    //TC #3: Login scenario
    @Test
    public void crm_login_test(){

        //2. Go to :
        driver.get(ConfigurationReader.getProperty("env"));

        //3. Enter valid username
        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys(ConfigurationReader.getProperty("username"));

        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));

        //5. Click to Log In button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();



    }

    @Test
    public void crm_login_test_2(){

        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //Calling my utility method to login helpdesk1
        CRM_Utilities.login_crm(driver);


    }


    @Test
    public void crm_login_test_3(){

        //2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //Calling my utility method to login helpdesk
        CRM_Utilities.login_crm(driver, "helpdesk2@cybertekschool.com", "UserUser" );


    }
}
