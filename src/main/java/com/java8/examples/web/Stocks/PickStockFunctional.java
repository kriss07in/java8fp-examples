package com.java8.examples.web.Stocks;

import com.java8.examples.web.model.StockInfo;
import com.java8.examples.web.model.Tickers;

// Funcational programming - example (alternative to other 2 programming styles
//  Imperative and Clubbed - PickStockImperative.java & PickStockImperativeClubbed.java)

// MAP-REDUCE design pattern

// stream() vs parallelStream()
// above both have same return type, but the instances they return are quite different
// parallelSteam returned instance runs methods like map() and filter() in parallel across multiple threads,
// managed by thread pool under the hood.
// The benefit is that we can easily switch between sequential and concurrent versions, and methods like
// this below code can be obvious to parallelism. !!!

public class PickStockFunctional {

    public static void main(String a[]) {

       final StockInfo highPriced = 
                                    // Tickers.symbols.stream() // (OR)
                                    Tickers.symbols.parallelStream()
                                    .map(StockUtil::getPrice)
                                    // .filter(StockUtil::isPriceLessThan(500))
                                    .reduce(StockUtil::pickHigh)
                                    .get();


        System.out.println("High priced under $500 is "+highPriced);
    }
}