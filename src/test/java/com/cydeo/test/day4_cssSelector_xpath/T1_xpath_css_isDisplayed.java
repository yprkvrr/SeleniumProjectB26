package com.cydeo.test.day4_cssSelector_xpath;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_css_isDisplayed {
    public static void main(String[] args) {
        /*
1. Open Chrome browser
2. Go to https://practice.cydeo.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
a. “Home” link
b. “Forgot password” header c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button f. “Powered by Cydeo text
4. Verify all web elements are displayed.
         */
        WebDriver driver= WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/forgot_password");
        WebElement homeLink1=driver.findElement(By.cssSelector("a[class='nav-link']"));

        WebElement homeLink2=driver.findElement(By.cssSelector("a[href='/']"));
        WebElement homeLink3=driver.findElement(By.cssSelector("a.nav-link"));

        WebElement forgotPassword=driver.findElement(By.cssSelector("div[class='example']>h2"));
        WebElement forgotPassword2=driver.findElement(By.cssSelector("div[class='example']>h2"));
        WebElement email=driver.findElement(By.cssSelector("label[for='email']"));
        WebElement emailBox=driver.findElement(By.cssSelector("input[type='text']"));

        WebElement retrieve=driver.findElement(By.cssSelector("button#form_submit"));

        WebElement poweredButton=driver.findElement(By.cssSelector("div[style='text-align: center;']"));

        System.out.println("homeLink1.isDisplayed() = " + homeLink1.isDisplayed());
        System.out.println("forgotPassword.isDisplayed() = " + forgotPassword.isDisplayed());
        System.out.println("email.isDisplayed() = " + email.isDisplayed());
        System.out.println("emailBox.isDisplayed() = " + emailBox.isDisplayed());
        System.out.println("retrieve.isDisplayed() = " + retrieve.isDisplayed());
        System.out.println("poweredButton.isDisplayed() = " + poweredButton.isDisplayed());
        driver.quit();

    }
}
