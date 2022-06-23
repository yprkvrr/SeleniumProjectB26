package com.cydeo.test.my_practice;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TechCrunch {
    /*

	1- Go to https://techcrunch.com/
	2- For “The Latest News” list, verify followings;
		a. each news has an author
		b. each news has an image
	3- Click one of news from “The Latest News” list to reach the full content and verify followings;
		a. the browser title is the same with the news title
		b. the links within the news content
     */

    @Test
    public void techCrunch() throws InterruptedException {
        Driver.getDriver().get("https://techcrunch.com/");
Thread.sleep(3000);
        List<WebElement> authors = Driver.getDriver().findElements(By.xpath("//span[@class='river-byline__authors']//a"));

        List<WebElement> images = Driver.getDriver().findElements(By.xpath("//div[@class='river river--homepage ']//article//img"));

        for (int i = 0; i < authors.size(); i++) {
            Assert.assertTrue(authors.get(i).isDisplayed());
            Assert.assertTrue(images.get(i).isDisplayed());
        }

        List<WebElement> articles = Driver.getDriver().findElements(By.xpath("//article[@class='post-block post-block--image post-block--unread']"));

        //if you have Exception to click use this code block
          // iframe
        // id -- offer_724e67ad478b6fa1c300-0
        //Driver.getDriver().switchTo().frame("offer_724e67ad478b6fa1c300-0");
        // close pop up
       // Driver.getDriver().findElement(By.cssSelector(".pn-ribbon__close")).click();
        //turn back main HTML
     //   Driver.getDriver().switchTo().defaultContent();


        articles.get(4).click();

        String expectedTitle = Driver.getDriver().findElement(By.xpath("//h1[@class='article__title']")).getText();
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));




        List<WebElement> allLinks = Driver.getDriver().findElements(By.xpath("//div[@class='article-content']//a\n"));


        Assert.assertTrue(allLinks.size()>0);

        for (WebElement eachLink : allLinks) {
            System.out.print(eachLink.getText());
            System.out.println("------> "+eachLink.getAttribute("href"));
        }

        Driver.closeDriver();
    }


}
