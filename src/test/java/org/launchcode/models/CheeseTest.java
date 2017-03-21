package org.launchcode.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adminbackup on 3/13/17.
 */
public class CheeseTest {


    @Test
    public void testCalculatedHalfPrice() throws Exception {
        Cheese cheese = new Cheese();
        cheese.setPrice(5.00);
        Double expected = 2.50;

        Double halfPrice = cheese.calculatedHalfPrice();

        assertEquals("Half price should equal 2.50", expected, halfPrice);

    }
}