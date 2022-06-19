package com.cydeo.test.base;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebdriverFactory.getDriver(ConfigurationReader.getProperty("env"));
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

}