package com.cydeo.test.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_FacebookTitleVerification {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");



        String expected = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expected)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test not passed");
        }
        driver.quit();
    }
}
