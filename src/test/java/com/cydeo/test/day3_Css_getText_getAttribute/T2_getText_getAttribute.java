package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {
    public static void main(String[] args) {
        /*
        TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected: Expected: first name
T2_getText_getAttribute

         */
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        WebDriver driver= WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/registration_form ");

//        WebElement header = driver.findElement(By.cssSelector("div[class='page-header']>h2"));
        WebElement header = driver.findElement(By.tagName("h2"));
        String expectedText = "Registration form";
        String actual = header.getText();
        if (actual.equals(expectedText)) {
            System.out.println("Header verification is passed");
        } else {
            System.out.println("Header verification is failed");
        }
        WebElement firstName = driver.findElement(By.className("form-control"));
        String expectedPlaceHolder="first name";
         String actualPlaceHolder=firstName.getAttribute("placeholder");

         if (actualPlaceHolder.equals(expectedPlaceHolder)) {
             System.out.println("Placeholder verification passed");
         }else {
             System.out.println("Placeholder verification failed");
         }
         driver.quit();
    }
}
