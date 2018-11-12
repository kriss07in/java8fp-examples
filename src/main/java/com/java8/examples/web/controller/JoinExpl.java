package com.java8.examples.web.controller;

import java.util.Arrays;
import java.util.List;

public class JoinExpl {

    final static List<String> friends = Arrays.asList("Ryan", "Mohan", "Murali", "Sujay", "Sri", "Ramu", "Ethen");

    public static void main(String[] args) {
        getJointring();

    }

    //String class, join method to join all strings in an array
    public static void getJointring() {
        System.out.println(String.join(", ", friends));
    }
}