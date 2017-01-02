package com.allstate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sameer on 2/1/17.
 */
public class Portfolio {
    private String name;

    public Map<String, Integer> getMapOfStocks() {
        return mapOfStocks;
    }

    public Portfolio(String name) {

        this.name = name;
    }

    private Map<String, Integer> mapOfStocks= new HashMap<String, Integer>();
    public void addStock(String name, int noOfShares) {
        if(mapOfStocks.containsKey(name)) {
            int number = mapOfStocks.get(name);
            number += noOfShares;
            mapOfStocks.put(name, number);
        } else {
            mapOfStocks.put(name, noOfShares);
        }
    }
    public boolean sellStock(String name, int noOfShares) {
        if(mapOfStocks.containsKey(name) && mapOfStocks.get(name) >= noOfShares) {
            int number = mapOfStocks.get(name);
            number -= noOfShares;
            mapOfStocks.put(name,number);
            return true ;
        }
        return false ;
    }

    public String getName() {
        return name;
    }
}
