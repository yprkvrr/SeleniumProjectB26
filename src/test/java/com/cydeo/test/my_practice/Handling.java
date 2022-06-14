package com.cydeo.test.my_practice;

import com.cydeo.test.base.TestBase;
import org.testng.annotations.Test;

public class Handling extends TestBase {

    @Test
    public void handleLocator(){
        driver.get("https://learn.cybertekschool.com/courses/741/pages/windows-handling?module_item_id=54959");

        String current=driver.getWindowHandle();
        System.out.println(current);
    }

}
