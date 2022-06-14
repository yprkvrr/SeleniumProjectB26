package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T4_RadioButton {
    public static void main(String[] args) {
        /*
        1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
         */


        WebDriver driver= WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/radio_buttons");

        WebElement hockey=driver.findElement(By.xpath("//input[@id='hockey']"));
        hockey.click();
        System.out.println("hockey.isSelected() = " + hockey.isSelected());

        WebElement greenRadioButton=driver.findElement(By.xpath("//input[@id='green']"));
        System.out.println("greenRadioButton.isEnabled() = " + greenRadioButton.isEnabled());



        driver.quit();

    }


}
