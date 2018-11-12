package com.java8.examples.web.model;

public class Asset {
    public enum AssetType {BOND, STOCK};
    private AssetType type = null;
    private int value = 0;

    public Asset(final AssetType assetType, final int assetValue) {
        this.type = assetType;
        this.value = assetValue;
    }

    public AssetType getType() {return type;}
    public int getValue() {return value;}

}