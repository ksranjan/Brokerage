package com.allstate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sameer on 2/1/17.
 */
public class StockTest {
    @Test
    public void getShareQuoteReturnsAQuote() {
        assertTrue(Stock.getShareQuote("TaTa") instanceof Quote);
    }

}