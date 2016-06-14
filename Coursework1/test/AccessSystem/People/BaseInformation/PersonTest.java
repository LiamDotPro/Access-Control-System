/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.People.BaseInformation;

import AccessSystem.Enumerations.PersonType;
import java.util.ArrayList;
import java.util.List;
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
public class PersonTest {

    /**
     *
     */
    public PersonTest() {
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
     *
     */
    @Test
    public void testGetName() {
        System.out.println("getName");

        List<PersonType> roles = new ArrayList<>();
        roles.add(PersonType.STUDENT);
        Person instance = new PersonImpl();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testGetSwipeCard() {
        System.out.println("getSwipeCard");
        Person instance = new PersonImpl();
        SwipeCard expResult = null;
        SwipeCard result = instance.getSwipeCard();
        assertEquals(expResult, result);
    }

    /**
     *
     */
    public class PersonImpl extends Person {

        /**
         *
         */
        public PersonImpl() {
            super("", null, null);
        }
    }

}
