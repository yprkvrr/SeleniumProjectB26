package com.cydeo.test.day14_driverUtil_JavaFaker;

public class Singleton {
    private Singleton() {
    }

    private static String word;

    public static String getWord() {

        if (word == null) {
            System.out.println("First time calling. Word object is null.");
            word = "something";
        } else {
            System.out.println("Word is already assigned and has a value");
        }
        return word;

    }
}