package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_isDisplayedFalse {
    public static void main(String[] args) {
        /*
        //1- Open a Chrome browser
    //2- Go to: https://www.tesla.com/
    //3- Locate Solar Panels header
    //4- Verify if it is dispayed on the page
         */
        WebDriver driver = WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.tesla.com/");

        WebElement solarPanels = driver.findElement(By.xpath("(//h1[contains(text(),'Solar Panels')])[1]"));

        if (solarPanels.isDisplayed()){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }
    }
}
