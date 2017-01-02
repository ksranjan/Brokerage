package com.allstate;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by sameer on 2/1/17.
 */
public class PortfolioTest {

    @Test
    public void hasANameAndHashMap() {
        Portfolio portfolio = new Portfolio("Technology");
        assertEquals("Technology", portfolio.getName());
        assertTrue(portfolio.getMapOfStocks() instanceof HashMap);
    }

    @Test
    public void addStockAddsTheNameAndNoOfShares() {
        Portfolio portfolio = new Portfolio("Manufacturing");
        portfolio.addStock("Tata", 5);
        assertTrue(5 == portfolio.getMapOfStocks().get("Tata"));
        portfolio.addStock("Mahindra", 10);
        assertTrue(10 ==portfolio.getMapOfStocks().get("Mahindra"));
        portfolio.addStock( "Tata", 5);
        assertTrue(10 == portfolio.getMapOfStocks().get("Tata"));
    }

    @Test
    public void sellStockDecreasesNoOfShares() {
        Portfolio portfolio = new Portfolio("Manufacturing");
        portfolio.addStock("Tata", 5);
        assertTrue(portfolio.sellStock("Tata", 3));
        assertTrue(2 == portfolio.getMapOfStocks().get("Tata"));
        assertFalse(portfolio.sellStock("Tata", 3));
        assertTrue(2 == portfolio.getMapOfStocks().get("Tata"));
        }


}