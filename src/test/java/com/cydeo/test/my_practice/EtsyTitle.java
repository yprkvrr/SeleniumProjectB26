package com.cydeo.test.my_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsyTitle {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");
        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);
        Thread.sleep(3000);

        String actualTitle=driver.getTitle();
        String expected="Wooden spoon | Etsy";
        if (actualTitle.equals(expected)){
            System.out.println("Title verification passed");
        }else {
            System.out.println("Title verification failed");
        }

        driver.quit();
    }
}
