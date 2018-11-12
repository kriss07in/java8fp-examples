package com.java8.examples.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

// DYNAMIC PROGRAMMING

// MEMOIZE (or) MEMOIZATION
// Memoization is a simple technique to make recursive overlapping computations really fast.

// This program takes lot of time when you increase the number from 22 to up above
// it may take hours. Thats because the computation is exponential
// It need to memoize the results to speed up execution - a lot!!!.

// Here we used lambda expressions and infinite Streams to implement TCO (Tail-Call Optimization) and Memoization.

public class MemRecursion {
    final List<Integer> prices;
    // Memoizer memoizer = new Memoizer();
    public MemRecursion(final List<Integer> pricesForLength) {
        prices = pricesForLength;
    }

    final static List<Integer> priceValues = Arrays.asList(2, 1, 1, 2, 2, 2, 1, 8, 9, 15);

    public static void main(String[] args) {
        final MemRecursion rodCutter = new MemRecursion(priceValues);
        // System.out.println (rodCutter.maxProfit(5));
        // System.out.println (rodCutter.maxProfit(22));
        System.out.println (rodCutter.maxProfit2(5));
        System.out.println (rodCutter.maxProfit2(22));
    }

    public int maxProfit(final int length) {
        int profit = (length <= prices.size()) ? prices.get(length - 1) : 0;
        for(int i=1; i<length; i++) {
            int priceWhenCut = maxProfit(i) + maxProfit(length - 1);
            if(profit < priceWhenCut) profit = priceWhenCut;
        }
        return profit;
    }

    // MEMOIZATION - modified above method as needed
    // Create a reusable class - Memoizer

    public int maxProfit2(final int rodLength) {
        BiFunction<Function<Integer, Integer>, Integer, Integer> compute = 
            (func, length) -> {
                int profit = (length <= prices.size()) ? prices.get(length - 1) : 0;
                for(int i=1; i<length; i++) {
                    int priceWhenCut = func.apply(i) + func.apply(length - 1);
                    if(profit < priceWhenCut) profit = priceWhenCut;
                }
                return profit;
            };
            return Memoizer.callMemoized(compute, rodLength);
    }
}