package com.cydeo.test.office_hours;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DemoBlazeIt {
    /*
    == Interview Task ( Demoblaze ) ==


SHOP: https://www.demoblaze.com/index.html


	• Customer navigation through product categories: Phones, Laptops and Monitors
	• Navigate to "Laptops" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
	• Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart". Accept pop up confirmation.
	• Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart". Accept pop up confirmation.
	• Navigate to "Cart" → Delete "Apple monitor 24" from cart.
	• Click on "Place order".
	• Fill in all web form fields.
	• Click on "Purchase"
	• Capture and log purchase Id and Amount.
	• Assert purchase amount equals expected.
	• Click on "Ok"
	• Verify that there is no product in the cart

     */

    @Test
    public void int_test02() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("demo.url"));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);

        WebElement laptop = Driver.getDriver().findElement(By.xpath("//a[.='Laptops']"));
        laptop.click();
        WebElement sony = Driver.getDriver().findElement(By.xpath("//a[.='Sony vaio i5']"));

        sony.click();
        WebElement addCart = Driver.getDriver().findElement(By.xpath("//a[.='Add to cart']"));
        addCart.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        WebElement home = Driver.getDriver().findElement(By.xpath("//a[contains(.,'Home ')]"));
        home.click();
        WebElement phones = Driver.getDriver().findElement(By.xpath("//a[.='Phones']"));
        wait.until(ExpectedConditions.elementToBeClickable(phones));
        phones.click();
        WebElement samsungPhone = Driver.getDriver().findElement(By.xpath("//a[.='Samsung galaxy s6']"));
        wait.until(ExpectedConditions.elementToBeClickable(samsungPhone));
        samsungPhone.click();
        WebElement addToCartPhone = Driver.getDriver().findElement(By.xpath("//a[.='Add to cart']"));
        addToCartPhone.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        WebElement secondHome = Driver.getDriver().findElement(By.xpath("//a[contains(.,'Home ')]"));
        secondHome.click();

        WebElement monitors = Driver.getDriver().findElement(By.xpath("//a[.='Monitors']"));
        monitors.click();
        WebElement apple = Driver.getDriver().findElement(By.xpath("  //a[.='Apple monitor 24']"));
        apple.click();
        WebElement addApple = Driver.getDriver().findElement(By.xpath("//a[.='Add to cart']"));
        addApple.click();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        WebElement cart = Driver.getDriver().findElement(By.xpath("//a[.='Cart']"));
        cart.click();


        Driver.closeDriver();
    }
}
