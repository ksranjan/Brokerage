package com.allstate;

/**
 * Created by sameer on 2/1/17.
 */
public class Stock {

    public static Quote getShareQuote(String name) {
        return new Quote(name, 25 + (int)(Math.random()*75)) ;
    }
}
