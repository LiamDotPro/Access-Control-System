/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Factories;

import AccessSystem.Enumerations.PersonType;
import AccessSystem.Strategies.CleanerAccessStrategy;
import AccessSystem.Strategies.IAccessStrategy;
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
public class AccessStrategyFactoryTest {

    /**
     *
     */
    public AccessStrategyFactoryTest() {
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
    public void testCreateStrategyCleaner() {
        System.out.println("createStrategy cleaner");
        PersonType person = PersonType.CLEANER;
        AccessStrategyFactory instance = new AccessStrategyFactory();
        IAccessStrategy result = instance.createStrategy(person);

        if (result.toString().contains("CleanerAccessStrategy")) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    /**
     *
     */
    @Test
    public void testCreateStrategyEmergencyResponder() {
        System.out.println("createStrategy emergencyResponder");
        PersonType person = PersonType.EMERGENCYRESPONDER;
        AccessStrategyFactory instance = new AccessStrategyFactory();
        IAccessStrategy result = instance.createStrategy(person);

        if (result.toString().contains("EmergencyResponderAccessStrategy")) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }
    
    /**
     *
     */
    @Test
    public void testCreateStrategyManager() {
        System.out.println("createStrategy Manager");
        PersonType person = PersonType.MANAGER;
        AccessStrategyFactory instance = new AccessStrategyFactory();
        IAccessStrategy result = instance.createStrategy(person);

        if (result.toString().contains("ManagerAccessStrategy")) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }
    
    /**
     *
     */
    @Test
    public void testCreateStrategySecurity() {
        System.out.println("createStrategy Security");
        PersonType person = PersonType.SECURITY;
        AccessStrategyFactory instance = new AccessStrategyFactory();
        IAccessStrategy result = instance.createStrategy(person);

        if (result.toString().contains("SecurityAccessStrategy")) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }
    
    /**
     *
     */
    @Test
    public void testCreateStrategyStaffMember() {
        System.out.println("createStrategy StaffMember");
        PersonType person = PersonType.STAFFMEMBER;
        AccessStrategyFactory instance = new AccessStrategyFactory();
        IAccessStrategy result = instance.createStrategy(person);

        if (result.toString().contains("StaffMemberAccessStrategy")) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }
    
    /**
     *
     */
    @Test
    public void testCreateStrategyStudent() {
        System.out.println("createStrategy Student");
        PersonType person = PersonType.STUDENT;
        AccessStrategyFactory instance = new AccessStrategyFactory();
        IAccessStrategy result = instance.createStrategy(person);

        if (result.toString().contains("StudentAccessStrategy")) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }
    
    /**
     *
     */
    @Test
    public void testCreateStrategyVisitor() {
        System.out.println("createStrategy Visitor");
        PersonType person = PersonType.VISITOR;
        AccessStrategyFactory instance = new AccessStrategyFactory();
        IAccessStrategy result = instance.createStrategy(person);

        if (result.toString().contains("VisitorAccessStrategy")) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

}
