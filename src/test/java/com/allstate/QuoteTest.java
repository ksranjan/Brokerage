package com.allstate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sameer on 2/1/17.
 */
public class QuoteTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void quoteCreateWithNameAndPrice (){
        Quote quote = new Quote("Apple", 50);
        assertEquals("Apple", quote.getName());
        assertEquals(50, quote.getPrice());

    }

}