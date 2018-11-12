package com.java8.examples.web.controller;

import java.math.BigInteger;

import com.java8.examples.web.interfaces.TailCall;

/******************* ******************** ******************** ******************** ******************** ******************** 
 * With only few lines of code we turned an unoptimized recursion into a tail recursion and averted stack overflow,
 * thanks to lambda expressions, functional interfaces, and infinite Streams.
 * 
 * With this technique on hand we can boldly implement recursive solutions, with a minor redesign to turn them into a tail calls.
/******************* ******************** ******************** ******************** ******************** ******************** */

public class RecursionExample extends TailCalls{
    
    public static BigInteger decrement (final BigInteger number ) {
        return number.subtract(BigInteger.ONE);
    }

    public static BigInteger multiply(final BigInteger first, final BigInteger second) {
        return first.multiply(second);
    }

    final static BigInteger ONE = BigInteger.ONE;
    final static BigInteger FIVE = new BigInteger("5");
    final static BigInteger TWENTYK = new BigInteger("20000");

    private static TailCall<BigInteger> factorialTailRec (final BigInteger factorial, final BigInteger number) {
        if(number.equals(BigInteger.ONE))
            return done(factorial);
        else   
            return call( () -> factorialTailRec(multiply(factorial, number), decrement(number)) );
    }

    public static BigInteger factorial(final BigInteger number) {
        return factorialTailRec(BigInteger.ONE, number).invoke();
    }

    public static void main(String a[]) {
        System.out.println(factorial(FIVE));
        System.out.println(String.format("%.10000s...", factorial(TWENTYK)));
    }
}