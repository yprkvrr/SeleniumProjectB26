package com.cydeo.test.office_hours;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ExplicitOh {
    /*

		- Go to "
		- Go to "https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html"
		- Click buttons in order
		- Verify messages are equal after click all buttons
				- All Buttons Clicked
				- Clickable Buttons
				- Click Buttons In Order"
		- Click buttons in order
		- Verify messages are equal after click all buttons
				- All Buttons Clicked
				- Clickable Buttons
				- Click Buttons In Order
     */
    @Test
    public void test_pages() {
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");

        List<WebElement> buttons = Driver.getDriver().findElements(By.tagName("//button"));


        WebElement button1 = Driver.getDriver().findElement(By.id("button00"));
        System.out.println(button1.isEnabled());

        WebElement button2 = Driver.getDriver().findElement(By.id("button01"));
        System.out.println(button2.isEnabled());


        WebElement button3 = Driver.getDriver().findElement(By.id("button02"));
        System.out.println(button3.isEnabled());

        WebElement button4 = Driver.getDriver().findElement(By.id("button03"));
        System.out.println(button4.isEnabled());
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        button1.click();
        wait.until(ExpectedConditions.elementToBeClickable(button2));
        button2.click();
        wait.until(ExpectedConditions.elementToBeClickable(button3));
        button3.click();
        wait.until(ExpectedConditions.elementToBeClickable(button4));
        button4.click();

        WebElement message = Driver.getDriver().findElement(By.cssSelector("#buttonmessage"));

        Assert.assertEquals(message.getText(), "All Buttons Clicked");
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#buttonmessage"), "Clickable Buttons"));
        Assert.assertEquals(message.getText(), "Clickable Buttons");
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#buttonmessage"), "Click Buttons In Order"));
        Assert.assertEquals(message.getText(),"Click Buttons In Order");
        Driver.closeDriver();
    }
}
