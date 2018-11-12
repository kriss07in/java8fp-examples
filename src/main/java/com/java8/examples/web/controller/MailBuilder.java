package com.java8.examples.web.controller;


//New way of coding with Java8
public class MailBuilder {
    public MailBuilder from(final String address){/**....*/ return this;} 
    public MailBuilder to(final String address){/**....*/return this;}
    public MailBuilder subject(final String line){/**....*/return this;}
    public MailBuilder body(final String message){/**....*/return this;}
    public void send(){System.out.println("Sending.....");}
    
    public static void main(String a) {
        //Use Method Chaining - look at MailBuilder.java for better code using chain code
        new MailBuilder()
            .from("dev@dev.com")
            .to("rec@dev.com")
            .subject("build notification")
            .body("...it sucks less than Mailer.java class....")
            .send();

        //See this class for better code using java 8
        //FluentMailer.java
    }
}