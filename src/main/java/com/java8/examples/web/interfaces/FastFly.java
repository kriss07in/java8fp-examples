package com.java8.examples.web.interfaces;

public interface FastFly extends Fly {
    default void takeOff() {System.out.println("FastFly::takeOff");}
}