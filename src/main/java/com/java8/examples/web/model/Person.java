package com.java8.examples.web.model;

public class Person {
    private final String name;
    private final int age;

    public String getName() {return name;}
    public int getAge() {return age;}

    public Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public int ageDiff(final Person other) {
        return this.age - other.age;
    }

    public String toString() {
        return String.format("%s - %d", name, age);
    }
}