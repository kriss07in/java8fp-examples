package com.java8.examples.web.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//******************** ********************* ********************* ********************* ********************* ********************* */
//The primes() method creates a Stream of an infinite collection of primes, starting at the given input.
//To get a particular number of elements from the collection we call the limit() method.
//Then we convert the returned collection of elements into a list and print it.
//
// While lambda expressions and method references make code elegant, expressive, and concise, the real performance gains in 
// Java8 applications will come from Streams.
//******************** ********************* ********************* ********************* ********************* ********************* */

public class LazyCollections {
    private static int primeAfter(final int number) {
        if(isPrime(number + 1))
            return number + 1;
        else 
            return primeAfter(number + 1);
    }

    public static boolean isPrime(final int number) {
        return number > 1 && 
                    IntStream.rangeClosed(2, (int) Math.sqrt(number))
                    .noneMatch(divisor -> number % divisor == 0);
    }

    public static List<Integer> primes(final int fromNumber, final int count) {
        return Stream.iterate(primeAfter(fromNumber - 1), LazyCollections::primeAfter)
                .limit(count)
                // .collect(Collectors.toList()); (both syntax's work's fine)
                .collect(Collectors.<Integer>toList());
    }

    public static void main(String a[]) {
        System.out.println("10 primes from 1 = "+primes(1,10));
        System.out.println("30 primes from 200 = "+primes(200,30));
    }
}