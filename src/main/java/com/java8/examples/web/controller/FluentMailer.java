package com.java8.examples.web.controller;

import java.util.function.Consumer;

//New way of coding with Java8 - LOAN PATTERN******

//We invoked the send() method and passed a lambda expression to it.
//Within the lambda expression, we received an instance of the FluentMailer and invoked
//the desired chain of methods on it.
//THIS IS ALSO CALLED - LOAN PATTERN

public class FluentMailer {

    private FluentMailer() {}

    public FluentMailer from(final String address){/**....*/ return this;} 
    public FluentMailer to(final String address){/**....*/return this;}
    public FluentMailer subject(final String line){/**....*/return this;}
    public FluentMailer body(final String message){/**....*/return this;}

    public static void send(final Consumer<FluentMailer> block){
        final FluentMailer mailer = new FluentMailer();
        block.accept(mailer);
        System.out.println("sending.....");
    }
    
    public static void main(String a[]) {
        //Use Method Chaining - look at MailBuilder.java for better code using chain code
        FluentMailer.send(
                m -> m.from("dev@dev.com")
                            .to("rec@dev.com")
                            .subject("Build notification")
                            .body(".....much better......"));


    }
}