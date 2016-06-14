/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.People.BaseInformation;

import java.time.LocalTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author li
 */
public class TimeRangesTest {

    /**
     *
     */
    public TimeRangesTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Checks if isbetweenRanges returns as true;
     */
    @Test
    public void testIsBetweenRangesTrue() {
        System.out.println("isBetweenRangesTrue");
        LocalTime time = LocalTime.of(8, 45);
        TimeRanges instance = new TimeRanges(LocalTime.of(8, 30), LocalTime.of(9, 00));
        boolean expResult = true;
        boolean result = instance.isBetweenRanges(time);

        assertEquals(expResult, result);
    }

    /**
     * Checks if isbetweenRanges returns false;
     */
    @Test
    public void testIsBetweenRangesFalse() {
        System.out.println("isBetweenRangesFalse");
        LocalTime time = LocalTime.of(9, 30);
        TimeRanges instance = new TimeRanges(LocalTime.of(8, 30), LocalTime.of(9, 00));
        boolean expResult = false;
        boolean result = instance.isBetweenRanges(time);

        assertEquals(expResult, result);
    }
}

