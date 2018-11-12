package com.java8.examples.web.controller;

import com.java8.examples.web.interfaces.FastFly;
import com.java8.examples.web.interfaces.Sail;

//Example - Interfaces can have default methods with implementations, 
//interfaces are more attractive and powerful than before!

public class SeaPlane extends Vehicle implements FastFly, Sail {
    //example for object chaining and implementing decorator pattern

    //Java compiler follows a few simple rules to resolve default methods
    //1. Subtypes automatically carry over the default methods from their supertypes
    //2. For interfaces that contribute a default method, the implementation in a subtype take precedence over the one in supertypes
    //3. Implementations in classes, including abstract declarations, take precedence over all interface defaults
    //4. If there's a conflict between two or more default method implementations, or 
        // there's a default-abstract conflict between two interfaces, the inheriting class should disambiguate

    private int altitude;
    //.....
    public void cruise() {
        System.out.println("SeaPlane::cruise currently cruise like: ");
        if(altitude > 0) {
            FastFly.super.cruise();
        } else {
            Sail.super.cruise();
        }
    }

    //All interfaces in this example have default methods - Fly, FastFly and Sail
    //The FastFly interface extends from the Fly interface and overrides takeOff() method,
    //providing its own default implmentation
    //FastFly also carries forward the other three methods of the Fly interface (Rule 1 (above))

    //Any class or interface inheriting from FastFly will see the implementation of takeOff() in FastFly,
        //and not the implementation of Fly (Rule 2 (above))
    
    //All three interfaces have implementation of the cruise() and turn() methods.
    //In addition, the vehicle class implements the turn() method.

    //There appears to be a conflict for the turn() method, but thats really not the case.
    //Even though the turn() method is present in the interfaces, the implementation in the 
    //superclass Vehicle takes precedence here (Rule 3 (above)), so, there's no conflict to resolve

    //However, the java compiler will force us to implement the cruise() method in the SeaPlane class because
    //the default implementations in the interfaces FastFly(derived from Fly) and Sail conflict (Rule 4 (above))

    public static void main(String a[]) {
        SeaPlane seaPlane = new SeaPlane();
        seaPlane.takeOff();
        seaPlane.turn();
        seaPlane.cruise();
        seaPlane.land();
    }

    //The call to the takeOff() method should go to the implementation in the FastFly interface (rule 1 and 2).
    //The implementation of the turn() method in Vehicle should be picked for the call to the turn() method on the 
    //SeaPlane, even though these are available on the interfaces (rule 3).
    //Since we were forced to implement the cruise() method on the SeaPlane, that specific implementation of the method
    //should be invoked for the call to cruise() (rule 4).
    //Finally, the call to the land() method will land on the implementation in the Fly interface (Rule 1)



}