package com.java8.examples.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StrExamples {
    public static void main(String[] args) {
        getOuts();
    }

    private static void getOuts() {
        final List<String> friends = Arrays.asList("Ryan", "Mohan", "Murali", "Sujay", "Sri", "Ramu");

        //print values
        friends.forEach(name -> System.out.println(name));
        friends.forEach(System.out::println);
        //to upper case and then print
        friends.stream()
            .map(n -> n.toUpperCase())
            .forEach(System.out::println);

        //print only
        friends.stream().forEach(System.out::println);

        //print length of each name
        friends.stream()
            .map(n -> n.length())
            .forEach(count -> System.out.println(count));

        //method reference
        friends.stream()
            .map(String::toUpperCase)
            .forEach(n -> System.out.println(n));

        //get the list of names which starts with letter R
        final List<String> startsWithR = 
            friends.stream()
                .filter(v -> v.startsWith("R"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        startsWithR.forEach(System.out::println);

        //creating Predicate
        final Predicate<String> startWithM = nm -> nm.startsWith("M");
        friends.stream().filter(startWithM)
            .forEach(System.out::println);
            //uppercase
            friends.stream().filter(startWithM)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        
    }
}