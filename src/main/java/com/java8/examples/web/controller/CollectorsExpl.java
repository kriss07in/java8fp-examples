package com.java8.examples.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.java8.examples.web.model.Person;

public class CollectorsExpl {

    final static List<Person> friends = Arrays.asList(
        new Person("Kellu", 20),
        new Person("Kesav", 50),
        new Person("Peter", 71),
        new Person("Ethen", 21),
        new Person("George", 33),
        new Person("Greg", 33));

    public static void main(String[] args) {
        createArrayListOlderThan25();
        createArrayListOlderThan30();
        createArrayListOlderThan20();
        createUtils();
    }

    //filter and forEach
    public static void createArrayListOlderThan25() {
        List<Person> olderThan25 = new ArrayList<Person>();
        friends.stream()
            .filter(person -> person.getAge() > 25)
            .forEach(person -> olderThan25.add(person));
        System.out.println("Friends older than 25: "+olderThan25);
    }

    //collect method
    public static void createArrayListOlderThan30() {
        List<Person> olderThan30 = 
            friends.stream()
                .filter(person -> person.getAge() > 30)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("Friends older than 30: "+olderThan30);
    }

    //collectors.toList method
    public static void createArrayListOlderThan20() {
    List<Person> olderThan20 = 
        friends.stream()
            .filter(person -> person.getAge() > 20)
            .collect(Collectors.toList());
        System.out.println("Friends older than 20: "+olderThan20);
    }

    //Following different functions available in the Collectors
    //minBy()
    //maxBy()
    //mapping()
    //collectingAndThen()
    //counting
    //avergingInt
    //joining
    //partitioningBy
    //summarizingInt
    //toCollection
    //toMap
    //groupingBy()
    public static void createUtils() {
        Map<Integer, List<Person>> groupingBYList = 
        friends.stream()
            .collect(Collectors.groupingBy(Person::getAge));
        System.out.println("Friends groupby age: "+groupingBYList);

        Map<Integer, List<String>> nameOfFriendsByAge = 
        friends.stream()
            .collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println("Name of friends by Age: "+nameOfFriendsByAge);

        //maxBy
        //Comparator
        //Optional example
        Comparator<Person> byAge = Comparator.comparing(Person::getAge);
        Map<Character, Optional<Person>> oldestFriendOfEachCharacter = 
        friends.stream()
            .collect(Collectors.groupingBy(person -> person.getName().charAt(0), 
                Collectors.reducing(BinaryOperator.maxBy(byAge))));
        System.out.println("Oldest person of each letter: "+oldestFriendOfEachCharacter);
    }
}