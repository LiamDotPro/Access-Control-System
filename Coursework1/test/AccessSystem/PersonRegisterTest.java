/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem;

import AccessSystem.Enumerations.PersonType;
import AccessSystem.People.BaseInformation.InformationStructPeople;
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
public class PersonRegisterTest {

    /**
     *
     */
    public PersonRegisterTest() {
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
    public void testAddPerson() {
        System.out.println("addPerson");
        InformationStructPeople info = new InformationStructPeople();
        info.setName("Harry");

        List<PersonType> roles = new ArrayList<>();

        roles.add(PersonType.STUDENT);

        info.setRoles(roles);
        PersonRegister instance = new PersonRegister();
        instance.addPerson(info);

        if ("Harry".equals(instance.getRegister().get(0).getName()) && instance.getRegister().get(0).getSwipeCard().getPrimaryRole() == PersonType.STUDENT) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    /**
     *
     */
    @Test
    public void testAddRegister() {
        System.out.println("addRegister");
        List<InformationStructPeople> info = new ArrayList<>();

        InformationStructPeople person1 = new InformationStructPeople();
        InformationStructPeople person2 = new InformationStructPeople();

        List<PersonType> roles = new ArrayList<>();

        roles.add(PersonType.STUDENT);

        person1.setName("John");
        person1.setRoles(roles);
        person2.setName("Matt");
        person2.setRoles(roles);

        info.add(person1);
        info.add(person2);

        PersonRegister instance = new PersonRegister();
        instance.addRegister(info);

        if ("John".equals(instance.getRegister().get(0).getName()) && instance.getRegister().get(0).getSwipeCard().getPrimaryRole() == PersonType.STUDENT) {
            if ("Matt".equals(instance.getRegister().get(1).getName()) && instance.getRegister().get(1).getSwipeCard().getPrimaryRole() == PersonType.STUDENT) {

                assertTrue(true);
            } else {
                assertTrue(false);

            }
        } else {
            assertTrue(false);
        }

    }

    /**
     *
     */
    @Test
    public void testGetRegister() {
        System.out.println("getRegister");
        PersonRegister instance = new PersonRegister();
        List<Person> result = instance.getRegister();
        assertNotNull(result);
    }

    /**
     *
     */
    @Test
    public void testClearRegister() {
        System.out.println("clearRegister");
        List<InformationStructPeople> info = new ArrayList<>();

        InformationStructPeople person1 = new InformationStructPeople();
        InformationStructPeople person2 = new InformationStructPeople();

        List<PersonType> roles = new ArrayList<>();

        roles.add(PersonType.STUDENT);

        person1.setName("John");
        person1.setRoles(roles);
        person2.setName("Matt");
        person2.setRoles(roles);

        info.add(person1);
        info.add(person2);

        PersonRegister instance = new PersonRegister();
        instance.addRegister(info);
        instance.clearRegister();
        if(instance.getRegister().isEmpty()){
            assertTrue(true);
        }
        else{
            assertTrue(false);
        }
    }

    /**
     *
     */
    @Test
    public void testSortUserList() {
        System.out.println("sortUserList");
            List<InformationStructPeople> info = new ArrayList<>();

        InformationStructPeople person1 = new InformationStructPeople();
        InformationStructPeople person2 = new InformationStructPeople();

        List<PersonType> roles = new ArrayList<>();

        roles.add(PersonType.STUDENT);

        person1.setName("Xavier");
        person1.setRoles(roles);
        person2.setName("Adam");
        person2.setRoles(roles);

        info.add(person1);
        info.add(person2);

        PersonRegister instance = new PersonRegister();
        instance.addRegister(info);
        instance.sortUserList();
        
        if("Adam".equals(instance.getRegister().get(0).getName())){
            assertTrue(true);
        }
        else{
            assertTrue(false);
        }
        
    }

}
