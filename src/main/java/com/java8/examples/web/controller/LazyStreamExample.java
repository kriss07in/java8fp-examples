package com.java8.examples.web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lazy")
public class LazyStreamExample {

    //The logical sequence of operation is acheived under the hood in the JDK using a fusion operation 
    //All the functions in the intermediate operations are fused together into one function that is
    //evaluated for each element, as appropriate, until the terminal operation is satisfied.
    //In essense - there's only one pass on the data - filtering, mapping and selecting the element all happen in one shot!

    @RequestMapping("/stream")
    public static String main(String a) {
        List<String> names = Arrays.asList(
            "Brad", "Kate", "Kim", "Jack", "Joe", "Mike","Susan","George","Robert","Julia","Parker","Benosn"
        );

        final String firstNameWith5Letters = names.stream()
                                                .filter(name -> name.length() == 5)
                                                .findFirst()
                                                .map(name -> name.toUpperCase())
                                                .get();
        return ("First name with 5 letters = "+firstNameWith5Letters);
    }

}