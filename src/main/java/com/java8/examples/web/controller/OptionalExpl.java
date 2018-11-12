package com.java8.examples.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExpl {

    final static List<String> friends = Arrays.asList("Ryan", "Mohan", "Murali", "Sujay", "Sri", "Ramu", "Ethen");

    public static void main(String[] args) {
        getLongestString();
        getCompareString();

    }

    //MapReduce pattern with Optional
    //get longest string out of all names
    public static void getLongestString() {
        final Optional<String> aLongString = friends.stream()
                                                .reduce((name1, name2) ->
                                                name1.length() >= name2.length() ? name1 : name2);
        //print to see optional values
        System.out.println("Longest string = "+aLongString);
        //get actual name
        aLongString.ifPresent(
            v -> System.out.println(
                String.format("A longest string is: %s", v)
            )
        );
    }

    //MapReduce with comparing default string
    public static void getCompareString() {
        final String arronnOrLonger = friends.stream()
                                                .reduce("Aaronn", (name1, name2) ->
                                                name1.length() >= name2.length() ? name1 : name2);
        //print to see result
        System.out.println("Longest string = "+arronnOrLonger);
    }

    

}