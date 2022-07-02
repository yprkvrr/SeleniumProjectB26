package com.cydeo.test.day17_pom_syncronization;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_ActionsPractice {
    /*
    1. Open a chrome browser
2. Go to:
https://practice.cydeo.com/drag_and_drop_circles
3. Click and hold small circle
4. Move it on top of the big circle
5. And release on it.
6. Verify “You did great!” text appears on big circle
     */

    @Test
    public void cydeo_practice_drag_and_drop_test() {
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
        WebElement draggable = Driver.getDriver().findElement(By.id("draggable"));

        WebElement dropTarget = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDrop(draggable, dropTarget).perform();
       // actions.moveToElement(draggable).clickAndHold().moveToElement(dropTarget).release().perform();

        Assert.assertEquals(dropTarget.getText(),"You did great!");

        Driver.closeDriver();
    }
}
