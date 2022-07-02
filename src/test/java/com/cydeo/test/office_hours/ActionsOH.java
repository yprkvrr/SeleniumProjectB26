package com.cydeo.test.office_hours;

import com.cydeo.test.utilities.BrowserOfficeHours;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsOH {
    @Test
    public void test1() {
        Driver.getDriver().get("http://automationpractice.com/index.php");
        WebElement dress = Driver.getDriver().findElement(By.xpath("(//a[.='Dresses'])[2]"));

        List<WebElement> subCategories = Driver.getDriver().findElements(By.xpath("(//a[.='Dresses'])[2]/..//li"));

        for (WebElement each : subCategories) {
            System.out.println(each.isDisplayed());
        }
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(dress).perform();
        Driver.closeDriver();
    }

    @Test
    public void test2() throws InterruptedException {
        Driver.getDriver().get("https://www.globalsqa.com/demo-site/draganddrop/");

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));


        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//h5[contains(.,'High')]"));

        BrowserOfficeHours.getElements(elements);
        System.out.println(BrowserOfficeHours.getElementsTextWithStream(elements));

        WebElement firstPic = Driver.getDriver().findElement(By.xpath("//h5[.='High Tatras']"));

        WebElement second = Driver.getDriver().findElement(By.xpath("//h5[.='High Tatras 2']"));

        WebElement trash = Driver.getDriver().findElement(By.id("trash"));

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(firstPic, trash).perform();
        actions.moveToElement(second).clickAndHold().moveToElement(trash).release().perform();
        Thread.sleep(3000);
        List<WebElement> trashElements = Driver.getDriver().findElements(By.xpath("//div[@id='trash']//li"));

        Assert.assertTrue(trashElements.size()==2);

        Driver.closeDriver();
    }
}
