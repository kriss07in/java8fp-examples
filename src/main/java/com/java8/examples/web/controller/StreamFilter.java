package com.java8.examples.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamFilter {
    public static void main(String[] args) {
        getOuts();
    }

    private static void getOuts() {
        final List<String> friends = Arrays.asList("Ryan", "Mohan", "Murali", "Sujay", "Sri", "Ramu");

        //reducing clutter with creating Function with Predicate
        final Function<String, Predicate<String>> startWithLetter = letter -> name -> name.startsWith(letter);
        System.out.println(""+friends.stream().filter(startWithLetter.apply("M")).count());
        System.out.println(""+ friends.stream().filter(startWithLetter.apply("S")).count());   
        
    }
}