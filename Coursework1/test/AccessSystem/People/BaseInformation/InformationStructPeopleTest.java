/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.People.BaseInformation;

import AccessSystem.Enumerations.PersonType;
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
public class InformationStructPeopleTest {

    /**
     *
     */
    public InformationStructPeopleTest() {
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
    @Test(expected = Exception.class)
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        InformationStructPeople instance = new InformationStructPeople();
        instance.setName(name);
        name = null;
        instance.setName(name);
    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSetRoles() {
        System.out.println("setRoles");
        List<PersonType> roles = null;
        InformationStructPeople instance = new InformationStructPeople();
        instance.setRoles(roles);
    }

}
