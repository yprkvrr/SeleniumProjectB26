package com.cydeo.test.office_hours;

import com.cydeo.pages.EtsySearch;
import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EtsyTask {
    /*
    Task 2

		- Go to https://www.etsy.com
		- Search for “wooden spoon”
		- Click on filters
		- Select free shipping  (use checkbox to click freeshipping. DON'T USE label tagged element to handle )
		- Click apply filters
		- Print count of results

     */

    @Test
    public void etsy_task() {
        Driver.getDriver().get(ConfigurationReader.getProperty("etsy"));
        EtsySearch etsySearch = new EtsySearch();
        etsySearch.searchBox.sendKeys("wooden spoon" + Keys.ENTER);


        WebElement filter = Driver.getDriver().findElement(By.xpath("//span[.='All Filters']"));
        filter.click();


        WebElement free_shipping = Driver.getDriver().findElement(By.name("free_shipping"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click()", free_shipping);
        Driver.getDriver().findElement(By.xpath("//button[@aria-label='Apply']")).click();
        String result= Driver.getDriver().findElement(By.xpath("//span[contains(text(),'results,')]")).getText();
        System.out.println(result);
        Driver.closeDriver();
    }

}
