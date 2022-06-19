package com.cydeo.test.my_practice;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileageCalculator extends TestBase {
    @Test
    public void calculator() throws InterruptedException {
        driver.get("https://www.calculator.net ");
        driver.findElement(By.cssSelector("input#calcSearchTerm")).sendKeys("gas mileage");
        WebElement title = driver.findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        title.click();
        BrowserUtils.verifyTitle(driver, "Gas Mileage Calculator");

        WebElement isDispLabel=driver.findElement(By.xpath("//h1[.='Gas Mileage Calculator']"));
        System.out.println("isDispLabel.isDisplayed() = " + isDispLabel.isDisplayed());


        driver.findElement(By.xpath("(//img[@class='clearbtn'])[1]")).click();
        driver.findElement(By.cssSelector("input[id='uscodreading']")).sendKeys("7925");


        driver.findElement(By.cssSelector("input#uspodreading")).sendKeys("7550");

        driver.findElement(By.cssSelector("input#usgasputin")).sendKeys("16");

        driver.findElement(By.cssSelector("input#usgasprice")).sendKeys("3.55");
        driver.findElement(By.xpath("(//input[@alt='Calculate'])[1]")).click();
      WebElement is= driver.findElement(By.xpath("//font[@color='green']"));
Thread.sleep(3000);
        Assert.assertEquals(is.getText(),"23.44 mpg");
    }
}
