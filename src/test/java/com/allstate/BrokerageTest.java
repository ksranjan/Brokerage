package com.allstate;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sameer on 2/1/17.
 */
public class BrokerageTest {
    @Test
    public void testBrokerageIsInitializedWithAName() {
        Brokerage b = new Brokerage("ZeroDHA");
        assertEquals("ZeroDHA", b.getName());
    }

}