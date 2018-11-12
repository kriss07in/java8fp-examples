package com.java8.examples.web.Stocks;

import java.math.BigDecimal;
import java.util.function.Predicate;

import com.java8.examples.web.model.StockInfo;
import com.java8.examples.web.model.Tickers;

// Mixed version - Imperative and Functional programming combined example

// We reduced the code and removed few loops; less code is better.
// But we are still imperative, mutating variables.

// If we want to change the logic, we say to pick the highest priced unser $1,000- we have to modify this code. (Drawback)

// No part of the code reusable!!!

public class PickStockImperativeClubbed {

    public static void main(String a[]) {

        StockInfo highPriced = new StockInfo("", BigDecimal.ZERO);

        final Predicate<StockInfo> isPriceLessThan500 = StockUtil.isPriceLessThan(500);

        for(String symbol : Tickers.symbols) {
            StockInfo stockInfo = StockUtil.getPrice(symbol);

            if(isPriceLessThan500.test(stockInfo))
                highPriced = StockUtil.pickHigh(highPriced, stockInfo);
        }

        System.out.println("High priced under $500 is "+highPriced);
    }
}