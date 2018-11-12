package com.java8.examples.web.controller;

import java.util.Arrays;
import java.util.List;

public class Counts {

    final static List<String> friends = Arrays.asList("Ryan", "Mohan", "Murali", "Sujay", "Sri", "Ramu", "Ethen");

    public static void main(String[] args) {
        getOuts();
        getCount();
    }

    //total number of chars in all names
    public static void getOuts() {
        System.out.println("Total number of characters in all names: " +
            friends.stream().mapToInt(n -> n.length()).sum()
        );
    }

    //total number of names
    public static void getCount() {
        System.out.println("Total number of names:  " +
            friends.stream().mapToInt(n -> n.length()).count()
        );
    }

}