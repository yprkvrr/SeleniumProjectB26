package com.cydeo.test.next_base;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search extends TestBase {

    //    "1. users  (hr, marketing and helpdesk) search a valid info : employee, doc, post, task ..
//            2. users cannot find an invalid info, the page should show "" Nothing Found"" (negative)
//            3. users get ""Employees"", ""Groups"", ""
//    Menu itemts"", and ""search"" once typeing at least a letter
//"
    @Test
    public void searchTest() throws InterruptedException {
        driver.get("https://login2.nextbasecrm.com/auth/?backurl=%2Fstream%2F");
        CRM_Utilities.login_crm(driver, "helpdesk47@cybertekschool.com", "UserUser");
        WebElement searchAre = driver.findElement(By.cssSelector("input#search-textbox-input"));
        searchAre.click();
        searchAre.sendKeys("employee" + Keys.ENTER);
        Thread.sleep(3000);


        //INVALID
        WebElement search= driver.findElement(By.cssSelector("input#search-textbox-input"));
        search.click();
        search.sendKeys("FJSBFJBF" + Keys.ENTER);
    WebElement nothingFound= driver.findElement(By.xpath("//div[.='Nothing found']"));

   Assert.assertEquals(nothingFound.getText(),"Nothing found");
    }
}
