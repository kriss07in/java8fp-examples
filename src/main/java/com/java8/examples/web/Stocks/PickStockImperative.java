package com.java8.examples.web.Stocks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.java8.examples.web.model.StockInfo;
import com.java8.examples.web.model.Tickers;

// Imperative programming (old java style)

//Created three different loops (below code)
//Three different steps - from symbols to stocks, then to selected stocks, 
//and finally to the highest priced among the selected stocks

public class PickStockImperative {

    public static void main(String a[]) {
        final List<StockInfo> stocks = new ArrayList<>();

        for(String symbol : Tickers.symbols) {
            stocks.add(StockUtil.getPrice(symbol));
        }

        final List<StockInfo> stocksPricedUnder500 = new ArrayList<>();
        final Predicate<StockInfo> isPriceLessThan500 = StockUtil.isPriceLessThan(500);
        for(StockInfo stockInfo: stocks) {
            if(isPriceLessThan500.test(stockInfo))
                stocksPricedUnder500.add(stockInfo);
        }

        StockInfo highPriced = new StockInfo("", BigDecimal.ZERO);
        for(StockInfo stock: stocksPricedUnder500) {
            highPriced = StockUtil.pickHigh(highPriced, stock);
        }

        System.out.println("High priced under $500 is "+highPriced);
    }
}