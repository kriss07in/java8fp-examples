package com.java8.examples.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.java8.examples.web.model.Asset;
import com.java8.examples.web.model.Asset.AssetType;

public class MapExpls {

    final static List<Asset> assets = Arrays.asList(
        new Asset(Asset.AssetType.BOND, 1000),
        new Asset(Asset.AssetType.BOND, 2000),
        new Asset(Asset.AssetType.STOCK, 3000),
        new Asset(Asset.AssetType.STOCK, 4000)
    );

    public static void main(String[] args) {
        System.out.println("total Asset value = "+ assetValues());
        System.out.println("total BOND Asset value = "+ bondValues());
        System.out.println("total STOCK Asset value = "+ stockValues());

        //strategy pattern - for refactoring lambda expression
        //with lambda expression refactoring - no need to write 3 separate methods like above (WOW!!!)
        System.out.println("total Asset value = "+ totalAssetsValues(assets, asset -> true));
        System.out.println("total BOND Asset value = "+ totalAssetsValues(assets, asset -> asset.getType() == AssetType.BOND));
        System.out.println("total STOCK Asset value = "+ totalAssetsValues(assets, asset -> asset.getType() == AssetType.STOCK));
    }

    //total Asset values
    private static int assetValues() {
        return assets.stream()
            .mapToInt(Asset::getValue)
            .sum();
    }

    //total BOND values only
    private static int bondValues() {
        return assets.stream()
            .mapToInt(asset -> asset.getType() == AssetType.BOND ? asset.getValue() : 0)
            .sum();
    }

    //total STOCK values only
    private static int stockValues() {
        return assets.stream()
            .mapToInt(asset -> asset.getType() == AssetType.STOCK ? asset.getValue() : 0)
            .sum();
    }

    //refactor with lambda expression - to avoid duplicate methods like above 3
    //use Predicate class
    private static int totalAssetsValues(final List<Asset> assetList, final Predicate<Asset> assetSelector) {
       return assets.stream()
            .filter(assetSelector)
            .mapToInt(Asset::getValue)
            .sum();
    }
}