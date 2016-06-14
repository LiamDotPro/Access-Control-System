/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem;

import AccessSystem.Architecture.University;
import AccessSystem.Logging.AccessLogger;
import AccessSystem.Logging.EmergencyLogger;
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
public class ControllerTest {

    /**
     *
     */
    public ControllerTest() {
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
     * Test getting the universtiy name.
     */
    @Test
    public void testGetUniversityName() {
        System.out.println("getUniversityName");
        Controller instance = new Controller("Plymouth");
        String expResult = "Plymouth";
        String result = instance.getUniversityName();
        assertEquals(expResult, result);
    }

    /**
     * Tests getting the AccessLogger from the controller.
     */
    @Test
    public void testGetAccessLogger() {
        System.out.println("getAccessLogger");
        Controller instance = new Controller("Plymouth");
        University myUni = new University("plymouth");
        instance.setUniversities(myUni);
        AccessLogger expResult = new AccessLogger(myUni.getUniversityName(), instance);
        instance.setAccessLogger(expResult);
        AccessLogger result = instance.getAccessLogger();
        assertEquals(expResult, result);
    }

    /**
     * Tests assigning an AccessLogger to the controller.
     */
    @Test
    public void testSetAccessLogger() {
        System.out.println("setAccessLogger");
        Controller instance = new Controller("Plymouth");
        University myUni = new University("plymouth");
        instance.setUniversities(myUni);
        AccessLogger expResult = new AccessLogger(myUni.getUniversityName(), instance);
        instance.setAccessLogger(expResult);

        if (instance.getAccessLogger() != null) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }

    }

    /**
     * Tests setting an EmergencyLogger to the controller.
     */
    @Test
    public void testSetEmergencyLogger() {
        System.out.println("setEmergencyLogger");
        Controller instance = new Controller("Plymouth");
        University myUni = new University("plymouth");
        instance.setUniversities(myUni);
        EmergencyLogger expResult = new EmergencyLogger(myUni.getUniversityName(), instance);

        instance.setEmergencyLogger(expResult);

        if (instance.getEmergencyLog() != null) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    /**
     * tests getting the EmergencyLogger from the controller.
     */
    @Test
    public void testGetEmergencyLog() {
        System.out.println("getEmergencyLog");
        Controller instance = new Controller("Plymouth");
        University myUni = new University("plymouth");
        instance.setUniversities(myUni);
        EmergencyLogger expResult = new EmergencyLogger(myUni.getUniversityName(), instance);
        instance.setEmergencyLogger(expResult);
        EmergencyLogger result = instance.getEmergencyLog();
        assertEquals(expResult, result);
    }

    /**
     * Tests getting the system register assigned to the controller.
     */
    @Test
    public void testGetSystemRegister() {
        System.out.println("getSystemRegister");
        Controller instance = new Controller("Plymouth");
        PersonRegister expResult = new PersonRegister();
        instance.setSystemRegister(expResult);
        PersonRegister result = instance.getSystemRegister();

        if (result != null) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    /**
     * Tests setting the system register to the controller.
     */
    @Test
    public void testSetSystemRegister() {
        System.out.println("setSystemRegister");
        Controller instance = new Controller("Plymouth");
        PersonRegister expResult = new PersonRegister();
        instance.setSystemRegister(expResult);
        PersonRegister result = instance.getSystemRegister();

        if (result != null) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    /**
     * Tests getting the universities assigned to the controller.
     */
    @Test
    public void testGetUniversities() {
        System.out.println("getUniversities");
        University plymouth = new University("plymouth");
        Controller instance = new Controller(plymouth.getUniversityName());
        instance.setUniversities(plymouth);
        University result = instance.getUniversities();

        if ("plymouth".equals(result.getUniversityName())) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    /**
     * Tests setting a University to the controller.
     */
    @Test
    public void testSetUniversities() {
        System.out.println("setUniversities");
        University plymouth = new University("plymouth");
        Controller instance = new Controller(plymouth.getUniversityName());
        instance.setUniversities(plymouth);

        if ("plymouth".equals(instance.getUniversities().getUniversityName())) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    /**
     * Tests to see if the system is active.
     */
    @Test
    public void testIsActiveSys() {
        System.out.println("isActiveSys");
        University plymouth = new University("plymouth");
        Controller instance = new Controller(plymouth.getUniversityName());
        boolean expResult = false;
        boolean result = instance.isActiveSys();
        assertEquals(expResult, result);
    }

    /**
     * Tests setting if the system is active.
     */
    @Test
    public void testSetActiveSys() {
        System.out.println("setActiveSys");
        boolean ActiveSys = true;
        University plymouth = new University("plymouth");
        Controller instance = new Controller(plymouth.getUniversityName());
        instance.setActiveSys(ActiveSys);
        
        if(instance.isActiveSys() == true){
            assertTrue(true);
        }
        else{
            assertTrue(false);
        }
    }

}
