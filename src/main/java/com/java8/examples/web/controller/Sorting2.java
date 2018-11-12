package com.java8.examples.web.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import com.java8.examples.web.model.Person;

public class Sorting2 {

    final static List<Person> friends = Arrays.asList(
        new Person("Kellu", 20),
        new Person("Peter", 71),
        new Person("Ethen", 21),
        new Person("George", 33));

    public static void main(String[] args) {
        getNameSorting();
        getNameAndAgeSorting();
    }

    public static void printFriends(final String message, final List<Person> frieds) {
        System.out.println(message);
        frieds.forEach(System.out::println);
    }

    //Define a Function for lambda expression
    final static Function<Person, String> sortByName = person -> person.getName();
    //comparing method from Comparator interface
    public static void getNameSorting() {
        friends.stream()
            .sorted(Comparator.comparing(sortByName))
            .forEach(System.out::println);
    }

    //Compare by name and age
    final static Function<Person, Integer> sortByAge = person -> person.getAge();
    public static void getNameAndAgeSorting() {
        friends.stream()
            .sorted(Comparator.comparing(sortByName).thenComparing(sortByAge))
            .forEach(System.out::println);
    }
}