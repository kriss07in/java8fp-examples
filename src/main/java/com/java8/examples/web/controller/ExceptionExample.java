package com.java8.examples.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

//***** EXECUTE AROUND METHOD PATTERN ******/
//Execute Around Method pattern
//This pattern can help us gain finer control over the flow of execution
//and release external resources.
//Lambda expressions are good fit to implement this pattern.
//In addition to controlling object lifetime, we can use this pattern to
//better manage LOCKS and to write concise exception tests.
//This can lead to more determnistic execution of code, timely cleanup and heavyweight resources, and fewer errors!!


public class ExceptionExample {
    public static void main(String a) throws IOException {
        //This code throws compilation error with unreported exception IOException
        // Stream.of("/src")
        //     .map(path -> new File(path).getCanonicalPath())
        //     .forEach(System.out::println);

        //This compile well when you handle exception manually
        Stream.of("/usr", "/tmp")
            .map( path -> {
                try {
                    return new File(path).getCanonicalPath();
                } catch (IOException ex) {
                    return ex.getMessage();
                }
            })
            .forEach(System.out::println);
    }
}