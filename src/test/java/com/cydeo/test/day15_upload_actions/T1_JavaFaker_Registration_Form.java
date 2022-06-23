package com.cydeo.test.day15_upload_actions;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class T1_JavaFaker_Registration_Form {
    /*
    //    Note: Use JavaFaker OR read from configuration.properties file when possible.
//    1. Open browser
//    2. Go to website: https://practice.cydeo.com/registration_form
//    3. Enter first name
//    4. Enter last name
//    5. Enter username
//    6. Enter email address
//    7. Enter password
//    8. Enter phone number
//    9. Select a gender from radio buttons
//    10.Enter date of birth
//    11.Select Department/Office
//    12.Select Job Title
//    13.Select programming language from checkboxes
//    14.Click to sign up button
//    15.Verify success message “You’ve successfully completed registration.” is
//    displayed.

     */

    @Test
    public void registration_form_test() {
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));
        Faker faker = new Faker();
        WebElement firstName = Driver.getDriver().findElement(By.name("firstname"));
        firstName.sendKeys(faker.name().firstName());
        Driver.getDriver().findElement(By.name("lastname")).sendKeys(faker.name().lastName());
        WebElement userName = Driver.getDriver().findElement(By.name("username"));
        userName.sendKeys(faker.bothify("?????###"));

        WebElement email = Driver.getDriver().findElement(By.name("email"));
        email.sendKeys(faker.internet().emailAddress());
        Driver.getDriver().findElement(By.name("password")).sendKeys(faker.bothify("?????###"));
        Driver.getDriver().findElement(By.name("phone")).sendKeys(faker.numerify("571-###-####"));
        Driver.getDriver().findElement(By.xpath("//input[@value='female']")).click();

        Select office = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        office.selectByIndex(faker.number().numberBetween(1,9));

    }


}
