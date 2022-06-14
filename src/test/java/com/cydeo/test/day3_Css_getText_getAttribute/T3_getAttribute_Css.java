package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.utilities.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_Css {
    public static void main(String[] args) {
        /*
        T3_getAttribute_Css
TC #3: NextBaseCRM, locators, getText(), getAttribute() practice 1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In
         */
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();


        WebDriver driver = WebdriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/ ");
//        WebElement loginButton=driver.findElement(By.cssSelector("input[type='submit']"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In'"));
        String expected = "Log In";
        String actual = loginButton.getAttribute("value");

        if (actual.equals(expected)) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }
        driver.quit();
    }
}
