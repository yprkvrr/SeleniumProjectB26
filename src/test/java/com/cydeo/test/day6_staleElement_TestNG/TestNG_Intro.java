package com.cydeo.test.day6_staleElement_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Intro {
    @Test(priority = 2)
    public void test1() {
        System.out.println("Test1 is running...");
        String actual="apple";
        String expected="apple";
        Assert.assertEquals(actual,expected,"Test did not pass");
    }
    @Test(priority = 1)


    public void test2(){
        System.out.println("Test2 is running...");
    }
}
