package com.java8.examples.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FilterExpl {
    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Ryan", "Mohan", "Murali", "Sujay", "Sri", "Ramu");
        getOuts(friends, "S");
        getOuts(friends, "R");
        getOuts(friends, "P");
        getFirst(friends, "S");
        getFirst(friends, "M");
        getFirst(friends, "H");
    }

    //Finding element in an array - any occurance
    public static void getOuts( final List<String> names, final String startingLetterOfString) {
        final Optional<String> myName = 
            names.stream().filter(name -> name.startsWith(startingLetterOfString))
            .findAny();
        myName.ifPresent(n -> System.out.println(n));
        System.out.println(
            String.format("A name starting with %s: %s", startingLetterOfString, myName.orElse("Not found"))
        );
    }

    //Finding element in an array - first occurance
    public static void getFirst( final List<String> names, final String startingLetterOfString) {
        final Optional<String> myName = 
            names.stream().filter(name -> name.startsWith(startingLetterOfString))
            .findFirst();
        myName.ifPresent(System.out::println);
        System.out.println(
            String.format("A name starting with %s: %s", startingLetterOfString, myName.orElse("Not found"))
        );
    }

}