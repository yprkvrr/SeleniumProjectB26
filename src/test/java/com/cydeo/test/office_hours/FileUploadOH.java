package com.cydeo.test.office_hours;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadOH {
    /*
     Go to  "https://testpages.herokuapp.com/styled/file-upload-test.html"
       - Upload file into Choose File
             NOTE : Create a file called as UploadTest.txt in project to upload ( I will show how we can )
       - Choose General File
       - Click Upload button
       - Verify Expected message equals "You uploaded a file. This is the result."
     */

    @Test
    public void upload() throws InterruptedException {
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/file-upload-test.html");
        WebElement chooseFile = Driver.getDriver().findElement(By.cssSelector("#fileinput"));
        chooseFile.sendKeys("C:\\Users\\yapra\\IdeaProjects\\SeleniumProjectB26\\src\\test\\java\\com\\cydeo\\test\\office_hours\\uploadtext.txt");
        chooseFile.submit();

        // WebElement uploadBtn = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));

//        uploadBtn.click();

        String expectedResult = "You uploaded a file. This is the result.";
        WebElement resultMsg = Driver.getDriver().findElement(By.cssSelector(".explanation"));
        Assert.assertEquals(resultMsg.getText(), expectedResult);

        Driver.closeDriver();
    }
}
