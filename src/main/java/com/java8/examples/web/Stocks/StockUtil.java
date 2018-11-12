package com.java8.examples.web.Stocks;

import java.math.BigDecimal;
import java.util.function.Predicate;

import com.java8.examples.web.model.StockInfo;

public class StockUtil {
    
    //getPrice() is simply a wrapper, a convenience method.
    public static StockInfo getPrice(final String ticker) {
        return new StockInfo(ticker, YahooFinance.getPrice(ticker));
    }

    //This is a higher-order method. It takes a price value and returns a Predicate 
    //that can be evaluated later to check if a given instance of StockInfo is less than
    //the price value cached in the lambda expression.
    public static Predicate<StockInfo> isPriceLessThan(final int price) {
        return stockInfo -> stockInfo.price.compareTo(BigDecimal.valueOf(price)) < 0;
    }

    //This convenience method will help us pick the highest-priced stock from a pair.
    public static StockInfo pickHigh(final StockInfo stock1, final StockInfo stock2) {
        return stock1.price.compareTo(stock2.price) > 0 ? stock1 : stock2;
    }


}