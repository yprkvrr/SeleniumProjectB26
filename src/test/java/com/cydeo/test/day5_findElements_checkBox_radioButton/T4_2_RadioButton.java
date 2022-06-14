package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_2_RadioButton {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/radio_buttons");

        List<WebElement> sportRadioButtons =driver.findElements(By.xpath("//input[@name='sport']"));

        for (WebElement sportRadioButton : sportRadioButtons) {
            Thread.sleep(3000);
            sportRadioButton.click();
            System.out.println("sportRadioButton.isSelected() = " + sportRadioButton.isSelected());
        }
    }
}
