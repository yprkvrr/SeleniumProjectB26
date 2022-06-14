package com.cydeo.test.next_base;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.CRM_Utilities;
import org.testng.annotations.Test;

public class NextBaseLogInHw extends TestBase {

//  1. Verify users can login
//  2. verify users can check ""Remember me on this computer"" option
//  3. Verify users can access to ""FORGOT YOUR PASSWORD?"" link page

    @Test
    public void logIn(){
        driver.get("https://login2.nextbasecrm.com/");
        CRM_Utilities.login_crm(driver,"helpdesk47@cybertekschool.com","UserUser");

    }
}
