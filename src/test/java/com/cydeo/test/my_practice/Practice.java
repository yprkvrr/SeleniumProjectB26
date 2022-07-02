package com.cydeo.test.my_practice;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice extends TestBase {
    @Test
    public void p01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        Actions actions = new Actions(driver);

        List<WebElement> menuBar = driver.findElements(By.cssSelector("ul.nav.navbar-nav>li"));
        for (WebElement element:menuBar) {
            actions.moveToElement(element).perform();
            //Thread.sleep(1000);
        }


        WebElement searchButton = driver.findElement(By.cssSelector("span.input-group-btn"));
        searchButton.click();

        driver.findElement(By.cssSelector("input#input-search")).sendKeys("Iphone");


        WebElement element =driver.findElement(By.xpath("//select[@name='category_id']"));
        Select select=new Select(element);

        select.selectByValue("24");


        driver.findElement(By.cssSelector("input#button-search")).click();

        driver.findElement(By.xpath("//div[@class='button-group']/button[1]")).click();




        WebElement message= driver.findElement(By.cssSelector("div.alert-success"));
        String Stringmessage = message.getText();

        System.out.println(Stringmessage);
//
//       Assert.assertEquals(message.getText(),"Success: You have added iPhone to your shopping cart!");
//
        Assert.assertTrue(Stringmessage.contains("Success"),"FAİLED");
//
        System.out.println("Passed");




    }
}
