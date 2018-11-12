package com.java8.examples.web.controller;

public class ForEachExpl {

    final static String strin = "z00k";
    public static void main(String[] args) {
        getString();

    }

    //create a method to convert into char
    private static void printChars(int ach) {
        System.out.println((char)ach);
    }

    //get chars from string
    public static void getString() {
        strin.chars().forEach(ch -> System.out.println(ch));
        strin.chars().forEach(System.out::println);
        
        //example to call a method in the same class
        strin.chars().forEach(ForEachExpl::printChars);

        //use internal iterator to convert into char
        strin.chars()  
            .mapToObj(c -> Character.valueOf((char)c))
            .forEach(System.out::println);

        
        //using filter on chars()
        strin.chars()
            .filter(c -> Character.isDigit(c))
            .forEach(c -> printChars(c));
   
        //using method references
        strin.chars()
            .filter(Character::isDigit)
            .forEach(ForEachExpl::printChars);
    }

}