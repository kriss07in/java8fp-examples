package com.java8.examples.web.Stocks;

import java.math.BigDecimal;
import com.java8.examples.web.model.Tickers;
import java.util.stream.Collectors;
import com.java8.examples.web.Stocks.YahooFinance;

public class Stocks100 {
    public static void main (String a[]) {
        final BigDecimal HUNDRED = new BigDecimal("100");

        System.out.println("Stocks priced over $100 are "+
            Tickers.symbols
                .stream()
                .filter(symbol -> YahooFinance.getPrice(symbol).compareTo(HUNDRED) > 0)
                .sorted()
                .collect(Collectors.joining(", "))
        );
    }
}