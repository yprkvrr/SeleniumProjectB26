package com.cydeo.test.day16_actions_jsexecuter;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T1_Guru99_DragAndDrop_Test {
    @Test
    public void guru99_dragAndDrop_test() throws InterruptedException {
/*
TC : Guru99 Drag and Drop Test
1- Open a chrome browser
2- Go to: https://demo.guru99.com/test/drag_drop.html
3- Drag “BANK” and drop into Account area under Debit
Side
4- Drag “5000” and drop into Amount area under Debit Side
5- Drag “SALES” and drop into Account area under Credit
Side
6- Drag “5000” and drop into Amount area under Credit
Side
7- Verify “Perfect!” text displayed.

 */
        Driver.getDriver().get(ConfigurationReader.getProperty("guru99"));
        WebElement bank = Driver.getDriver().findElement(By.partialLinkText("BANK"));
        WebElement debitAmount = Driver.getDriver().findElement(By.id("bank"));
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(bank, debitAmount).perform();
        WebElement fiveThousand = Driver.getDriver().findElement(By.linkText("5000"));
        WebElement amountArea = Driver.getDriver().findElement(By.cssSelector("ol#amt7"));
        actions.dragAndDrop(fiveThousand, amountArea).perform();
        Thread.sleep(3000);
        WebElement salesButton = Driver.getDriver().findElement(By.xpath("//a[.=' SALES ']"));

        WebElement creditAccount = Driver.getDriver().findElement(By.id("loan"));
        actions.dragAndDrop(salesButton, creditAccount).perform();
        WebElement five = Driver.getDriver().findElement(By.linkText("5000"));
        WebElement creditAmount = Driver.getDriver().findElement(By.id("amt8"));
        actions.dragAndDrop(five, creditAmount).perform();
        WebElement text = Driver.getDriver().findElement(By.xpath("//a[.='Perfect!']"));
        text.isDisplayed();
        Driver.closeDriver();
    }
}

