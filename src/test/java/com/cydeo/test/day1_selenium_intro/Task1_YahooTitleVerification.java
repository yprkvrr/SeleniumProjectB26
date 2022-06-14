package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {
    public static void main(String[] args) {

        //Setting up webdriver manager
        WebDriverManager.chromedriver().setup();
//2- Create instance of Webdriver
        WebDriver driver = new ChromeDriver();
//3-Make page full screen
        driver.manage().window().maximize();

        driver.get("https://www.yahoo.org");


        String actualTitle=driver.getTitle();
        System.out.println("ActualTitle  of Yahoo= " + actualTitle);
        String expectedTitle="Yahoo";



        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title verification is passed");
        }else{
            System.out.println("Title verification is failed");
        }
driver.quit();
    }
}
