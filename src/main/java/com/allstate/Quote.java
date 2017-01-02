package com.allstate;

/**
 * Created by sameer on 2/1/17.
 */
public class Quote {
    private String name;
    private int price;

    public Quote(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
