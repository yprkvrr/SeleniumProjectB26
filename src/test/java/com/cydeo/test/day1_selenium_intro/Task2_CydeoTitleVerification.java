package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2_CydeoTitleVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://practice.cydeo.com");

        String expectedUrl = "cydeo";
        String actualUrl = driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("URL verification is passed");
        } else {
            System.out.println("URL verification is passed");
        }

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();
        System.out.println("ActualTitle  of Cydeo= " + actualTitle);

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title verification is passed!");
        } else {
            System.out.println("Title verification is failed!");
        }

        driver.quit();
    }
}
