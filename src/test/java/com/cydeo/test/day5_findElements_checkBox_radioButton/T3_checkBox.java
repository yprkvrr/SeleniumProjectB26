package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_checkBox {
    public static void main(String[] args) throws InterruptedException {
        /*
       1 . Go to http://practice.cydeo.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.
         */

        WebDriver driver = WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cydeo.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='box1']"));
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());

        WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='box2']"));
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());
        Thread.sleep(3000);
        checkBox1.click();
        Thread.sleep(3000);
        checkBox2.click();

        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        driver.quit();

    }
}
