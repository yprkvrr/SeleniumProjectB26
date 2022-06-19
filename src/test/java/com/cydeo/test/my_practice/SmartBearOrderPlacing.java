package com.cydeo.test.my_practice;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.SmartBearUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmartBearOrderPlacing extends TestBase {
    /*
    6. Click on Order
7. Select familyAlbum from product, set quantity to 2
8. Click to “Calculate” button
9. Fill address Info with JavaFaker
• Generate: name, street, city, state, zip code
10. Click on “visa” radio button
11. Generate card number using JavaFaker
12. Click on “Process”
13. Verify success message “New order has been successfully added.”

     */
    @Test
    public void order() throws InterruptedException {
        SmartBearUtils.logInToSmartBear(driver, "Tester", "test");
        WebElement order = driver.findElement(By.xpath("//a[.='Order']"));
        order.click();
        Select select = new Select(driver.findElement(By.cssSelector("select#ctl00_MainContent_fmwOrder_ddlProduct")));
        select.selectByValue("FamilyAlbum");
        WebElement quantity = driver.findElement(By.xpath("//input[@type='text']"));

        quantity.clear();
        quantity.sendKeys("2");
        Thread.sleep(3000);
        WebElement calculate = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculate.click();

        Faker faker = new Faker();
        WebElement name = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_txtName"));
        name.sendKeys(faker.name().fullName());

        WebElement street = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys(faker.address().streetAddress());

        WebElement city = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys(faker.address().city());
        WebElement state = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys(faker.address().state());

        WebElement zip = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys(faker.address().zipCode().replace("-",""));


        WebElement visa = driver.findElement(By.xpath("//input[@value='Visa']"));
        visa.click();
        WebElement card = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox6"));
        card.sendKeys(faker.finance().creditCard().replace("-",""));

        WebElement date = driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox1"));
        date.sendKeys("03/22");
        WebElement process = driver.findElement(By.cssSelector("a#ctl00_MainContent_fmwOrder_InsertButton"));
        process.click();
        Thread.sleep(3000);

        WebElement message= driver.findElement(By.tagName("strong"));
        Assert.assertEquals(message.getText(),"New order has been successfully added.");
    }


}
