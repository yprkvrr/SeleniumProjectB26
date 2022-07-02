package com.cydeo.test.day17_pom_syncronization;

import com.cydeo.pages.CydeoPracticePage;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POM_ActionsPractices {
    /*
    1. Open a chrome browser
2. Go to:
https://practice.cydeo.com/drag_and_drop_circles
3. Verify expected default text appears on big circle
   Expected = "Drag the small circle here."
     */
    CydeoPracticePage cydeoPracticePage;
    Actions actions;

    @BeforeMethod
    public void setUpMethod() {
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
        cydeoPracticePage =new CydeoPracticePage();
        actions= new Actions(Driver.getDriver());

    }


    @Test
    public void drag_small_circle_text() {


        Assert.assertEquals(cydeoPracticePage.bigCircle.getText(), "Drag the small circle here.");
    }


    @Test
    public void drop_here_text() {

        actions.moveToElement(cydeoPracticePage.smallCircle).clickAndHold().moveByOffset(100, 0).perform();
        Assert.assertEquals(cydeoPracticePage.bigCircle.getText(), "Drop here.");
    }

}
