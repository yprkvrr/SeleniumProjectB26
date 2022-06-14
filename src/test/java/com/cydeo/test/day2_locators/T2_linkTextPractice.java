package com.cydeo.test.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_linkTextPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://practice.cydeo.com");
        Thread.sleep(3000);

        WebElement abLinkText = driver.findElement(By.linkText("A/B Testing"));
        abLinkText.click();
        Thread.sleep(3000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "No A/B Test";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("No A/B Test Title verification is passed!");
        } else {
            System.out.println("No A/B Test Title verification failed!");
        }

        driver.navigate().back();
        Thread.sleep(3000);

        expectedTitle="Practice";
        actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Practice Title verification is passed!");
        }else {
            System.out.println("Practice Title verification failed!");
        }


        driver.quit();
    }
}
