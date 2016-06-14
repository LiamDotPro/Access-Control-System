/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Factories;

import AccessSystem.Enumerations.PersonType;
import AccessSystem.People.BaseInformation.Person;
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
public class PersonFactoryTest {

    /**
     *
     */
    public PersonFactoryTest() {
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
    public void testCreatePerson() {
        System.out.println("createPerson");
        String name = "";
        List<PersonType> roles = null;
        Integer id = null;
        PersonFactory instance = new PersonFactory();
        Person expResult = null;
        Person result = instance.createPerson(name, roles, id);
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testCreateCleaner() {
        System.out.println("create a cleaner");
        String name = "Harry";
        List<PersonType> roles = new ArrayList<>();
        roles.add(PersonType.CLEANER);
        Integer id = 1;
        PersonFactory instance = new PersonFactory();
        Person result = instance.createPerson(name, roles, id);
        assertEquals(PersonType.CLEANER, result.getSwipeCard().getPrimaryRole());
    }

    /**
     *
     */
    @Test
    public void testCreateEmergencyResponder() {
        System.out.println("create a emergency responder");
        String name = "Harry";
        List<PersonType> roles = new ArrayList<>();
        roles.add(PersonType.EMERGENCYRESPONDER);
        Integer id = 1;
        PersonFactory instance = new PersonFactory();
        Person result = instance.createPerson(name, roles, id);
        assertEquals(PersonType.EMERGENCYRESPONDER, result.getSwipeCard().getPrimaryRole());
    }

    /**
     *
     */
    @Test
    public void testCreateManager() {
        System.out.println("create a manager");
        String name = "Harry";
        List<PersonType> roles = new ArrayList<>();
        roles.add(PersonType.MANAGER);
        Integer id = 1;
        PersonFactory instance = new PersonFactory();
        Person result = instance.createPerson(name, roles, id);
        assertEquals(PersonType.MANAGER, result.getSwipeCard().getPrimaryRole());
    }

    /**
     *
     */
    @Test
    public void testCreateSecurity() {
        System.out.println("create a security person");
        String name = "Harry";
        List<PersonType> roles = new ArrayList<>();
        roles.add(PersonType.SECURITY);
        Integer id = 1;
        PersonFactory instance = new PersonFactory();
        Person result = instance.createPerson(name, roles, id);
        assertEquals(PersonType.SECURITY, result.getSwipeCard().getPrimaryRole());
    }

    /**
     *
     */
    @Test
    public void testCreateStaffMember() {
        System.out.println("create a staff member");
        String name = "Harry";
        List<PersonType> roles = new ArrayList<>();
        roles.add(PersonType.STAFFMEMBER);
        Integer id = 1;
        PersonFactory instance = new PersonFactory();
        Person result = instance.createPerson(name, roles, id);
        assertEquals(PersonType.STAFFMEMBER, result.getSwipeCard().getPrimaryRole());
    }

    /**
     *
     */
    @Test
    public void testCreateStudent() {
        System.out.println("create a student");
        String name = "Harry";
        List<PersonType> roles = new ArrayList<>();
        roles.add(PersonType.STUDENT);
        Integer id = 1;
        PersonFactory instance = new PersonFactory();
        Person result = instance.createPerson(name, roles, id);
        assertEquals(PersonType.STUDENT, result.getSwipeCard().getPrimaryRole());
    }

    /**
     *
     */
    @Test
    public void testCreateVisitor() {
        System.out.println("create a visitor");
        String name = "Harry";
        List<PersonType> roles = new ArrayList<>();
        roles.add(PersonType.VISITOR);
        Integer id = 1;
        PersonFactory instance = new PersonFactory();
        Person result = instance.createPerson(name, roles, id);
        assertEquals(PersonType.VISITOR, result.getSwipeCard().getPrimaryRole());
    }

}
