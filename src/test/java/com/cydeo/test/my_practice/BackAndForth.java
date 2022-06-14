package com.cydeo.test.my_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForth {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com ");
        Thread.sleep(3000);
        WebElement gMail = driver.findElement(By.linkText("Gmail"));
        gMail.click();

        Thread.sleep(3000);

        String actualTitle=driver.getTitle();
        String expected="Gmail";
        if (actualTitle.contains(expected)){
            System.out.println("Title verification passed");
        }else {
            System.out.println("Title verification failed");
        }

        driver.navigate().back();

        String title=driver.getTitle();
        String google="Google";
        if (title.equals(google)){
            System.out.println("Title verification passed");
        }else {
            System.out.println("Title verification failed");

        }

        driver.quit();
    }
}
