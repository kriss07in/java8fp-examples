package com.java8.examples.web.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.java8.examples.web.model.Person;

public class Sorting {

    final static List<Person> friends = Arrays.asList(
        new Person("Kellu", 50),
        new Person("Peter", 71),
        new Person("Ethen", 21),
        new Person("George", 33));

    public static void main(String[] args) {
        getSorting();
        getSorting2();
        getAscAndDesc();
        sortByName();
        youngestPerson();
        eldestPerson();
    }

    public static void printFriends(final String message, final List<Person> frieds) {
        System.out.println(message);
        frieds.forEach(System.out::println);
    }

    //Sort example - using lambda-expression
    public static void getSorting() {
        List<Person> ascendAge = 
            friends.stream()
                .sorted(
                    (person1, person2) -> person1.ageDiff(person2)
                )
                .collect(Collectors.toList());
        printFriends("Sorted order in ascending order by age : ", ascendAge);
    }

    //Sort example2 - using method-reference
    public static void getSorting2() {
        List<Person> ascendAge = 
            friends.stream()
                .sorted(Person::ageDiff)
                .collect(Collectors.toList());
        printFriends("Sorted order in ascending order by age : ", ascendAge);
    }

    //Ascending and Descnding with method-reference
    private static void getAscAndDesc() {
        //descending the friends
        //just use reversted() method
        Comparator<Person> asccAge = (person1, person2) -> person1.ageDiff(person2);
        //OR below line
        //Comparator<Person> ascccAge = Person::ageDiff;

        Comparator<Person> descAge = asccAge.reversed();
        printFriends("Sorted order in descending order by age : ", 
            friends.stream()
                .sorted(descAge)
                .collect(Collectors.toList()));

        printFriends("Sorted order in ascending order by age : ", 
            friends.stream()
                .sorted(asccAge)
                .collect(Collectors.toList()));
    }
    
    //Sort list by name in ascending order
    private static void sortByName() {
        printFriends("Sorted in ascending order by name : ", 
            friends.stream()
            .sorted(
                (person1, person2) -> person1.getName().compareTo(person2.getName())
            )
            .collect(Collectors.toList())
            );
    }

    //print youngest person from list
    private static void youngestPerson() {
            friends.stream()
            .min(Person::ageDiff)
            .ifPresent(youngest -> System.out.println("Youngest: "+youngest));
    }

    //print eldest person from list
    private static void eldestPerson() {
        friends.stream()
            .max(Person::ageDiff)
            .ifPresent(oldest -> System.out.println("Eldest person : "+oldest));
    }
}