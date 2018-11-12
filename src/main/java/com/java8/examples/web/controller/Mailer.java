package com.java8.examples.web.controller;

//Old way of coding
public class Mailer {
    public void from(final String address){/**....*/}
    public void to(final String address){/**....*/}
    public void subject(final String line){/**....*/}
    public void body(final String message){/**....*/}
    public void send(){System.out.println("Sending.....");}
    
    public static void main(String a) {
        Mailer mailer = new Mailer();
        mailer.from("build@dev.com");
        mailer.to("rec@dev.com");      
        mailer.subject("biuld notification"); 
        mailer.body("message - your code sucks");
        mailer.send(); 

        //Instead of doing all above calls separately
        //Use Method Chaining - look at MailBuilder.java for better code using chain code
    }
}