package com.cydeo.test.my_practice;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables {
    @Test
    public void getHeaders() {
        Driver.getDriver().get(ConfigurationReader.getProperty("table.url"));

        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//table[@id='table1']//span"));

        System.out.println("elements.size() = " + elements.size());

        for (WebElement eachHeader : elements) {
            System.out.println("eachHeader.getText() = " + eachHeader.getText());
        }
        Assert.assertEquals(elements.size(), 6);

        Driver.closeDriver();
    }

    @Test
    public void getRow() {
        Driver.getDriver().get(ConfigurationReader.getProperty("table.url"));
        WebElement rowTwo = Driver.getDriver().findElement(By.xpath("//table[@id='table1']//tbody//tr[2]"));
        System.out.println("rowTwo.getText() = " + rowTwo.getText());

        List<WebElement> allRows = Driver.getDriver().findElements(By.xpath("//table[@id='table1']//tbody/tr"));
//        for (int i = 1; i < allRows.size(); i++) {
//            String eachRowPath="//table[@id='table1']//tbody/tr["+i+"]";
//            System.out.println(Driver.getDriver().findElement(By.xpath(eachRowPath)).getText());
//        }

        for (WebElement each:allRows){
            System.out.println(each.getText());
        }
        Driver.closeDriver();
    }

    @Test
    public void getInRelation(){
        Driver.getDriver().get(ConfigurationReader.getProperty("table.url"));
        String firstName="Frank";
        String emailLocator="//table[@id='table1']//td[.='"+firstName+"']/../td[contains(.,'@')]";
        WebElement email = Driver.getDriver().findElement(By.xpath(emailLocator));
        System.out.println(email);

        Assert.assertEquals(email.getText(),"fbach@yahoo.com");

        Driver.closeDriver();
    }


}
