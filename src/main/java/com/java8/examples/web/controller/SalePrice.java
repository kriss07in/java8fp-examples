package com.java8.examples.web.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalePrice {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<String>();
        cities.add("Dallas");
        cities.add("Austin");
        cities.add("Houston");
        cities.add("Hello");
        getPrices();
    }

    private static void getPrices() {
        final List<BigDecimal> prices = Arrays.asList(
            new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
            new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
            new BigDecimal("45"), new BigDecimal("12")
        );

        //get total the prices greater than 20, discount by 20%
        BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;
        for(BigDecimal price: prices) {
            if(price.compareTo(BigDecimal.valueOf(20)) > 0)
                totalOfDiscountedPrices = totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.8)));
        }
            System.out.println("total discounted prices 1 = "+totalOfDiscountedPrices);

        final BigDecimal totalDiscountedPricess = 
            prices.stream().
                    filter(value -> value.compareTo(BigDecimal.valueOf(20))> 0)
                    .map(value -> value.multiply(BigDecimal.valueOf(0.9)))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        
            System.out.println("total discounted prices 2 = "+totalDiscountedPricess);

        final BigDecimal totalDiscountedPricess2 =  prices.stream()
            .filter(pr -> pr.compareTo(BigDecimal.valueOf(20)) > 0)
            .map(vl -> vl.multiply(BigDecimal.valueOf(0.8)))
            .reduce(BigDecimal.ZERO, BigDecimal::add);

            System.out.println("total discounted prices 3 = "+totalDiscountedPricess2);
    }

}