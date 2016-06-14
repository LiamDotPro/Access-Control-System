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
public class SwipeCardTest {

    /**
     *
     */
    public SwipeCardTest() {
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
    public void testGetID() {
        System.out.println("getID");
        List<PersonType> roles = new ArrayList<>();
        roles.add(PersonType.STUDENT);
        SwipeCard instance = new SwipeCard(roles, null);
        Integer expResult = null;
        Integer result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testGetPrimaryRole() {
        System.out.println("getPrimaryRole");
        List<PersonType> roles = new ArrayList<>();
        roles.add(null);
        SwipeCard instance = new SwipeCard(roles, 1);
        PersonType expResult = null;
        PersonType result = instance.getPrimaryRole();
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testGetSecondaryRoles() {
        System.out.println("getSecondaryRoles");
        List<PersonType> roles = new ArrayList<>();
        roles.add(PersonType.CLEANER);
        roles.add(PersonType.STUDENT);
        SwipeCard instance = new SwipeCard(roles, 1);
        List<PersonType> expResult = null;
        List<PersonType> result = instance.getSecondaryRoles();
        assertNotEquals(expResult, result);
    }

    /**
     * Tests the ability to clear roles from the Swipecard.
     */
    @Test
    public void testClearRoles() {
        System.out.println("clearRoles");
        List<PersonType> roles = new ArrayList<>();
        roles.add(PersonType.CLEANER);
        roles.add(PersonType.STUDENT);
        SwipeCard instance = new SwipeCard(roles, 1);
        instance.clearRoles();

        ArrayList exp = new ArrayList<>();

        assertEquals(null, instance.getPrimaryRole());
        assertEquals(exp, instance.getSecondaryRoles());
    }

    /**
     * Checks for index out of range issues.
     */
    @Test
    public void testSetRoles() {
        System.out.println("setRoles");
        List<PersonType> roles = new ArrayList<>();

        ArrayList emptyArray = new ArrayList<>();
        SwipeCard instance = new SwipeCard(emptyArray, 1);
        instance.setRoles(roles);
    }

}
