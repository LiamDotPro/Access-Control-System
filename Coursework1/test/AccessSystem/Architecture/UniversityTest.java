/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Architecture;

import AccessSystem.Controller;
import AccessSystem.Logging.AccessLogger;
import AccessSystem.Logging.EmergencyLogger;
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
public class UniversityTest {

    /**
     *
     */
    public UniversityTest() {
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
    public void testGetCampusList() {
        System.out.println("getCampusList");
        Controller plymouth = new Controller("Plymouth");
        Campus newCampus = new Campus("davy", new AccessLogger(plymouth.getUniversityName(), plymouth), new EmergencyLogger(plymouth.getUniversityName(), plymouth));
        University instance = new University("Plymouth");
        instance.addCampus(newCampus);
        List<Campus> result = instance.getCampusList();

        if (result.contains(newCampus)) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    /**
     *
     */
    @Test
    public void testAddCampus() {
        System.out.println("addCampus");
        Controller plymouth = new Controller("Plymouth");
        Campus newCampus = new Campus("davy", new AccessLogger(plymouth.getUniversityName(), plymouth), new EmergencyLogger(plymouth.getUniversityName(), plymouth));
        University instance = new University("Plymouth");
        instance.addCampus(newCampus);
        if (instance.getCampusList().contains(newCampus)) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    /**
     *
     */
    @Test
    public void testGetUniversityName() {
        System.out.println("getUniversityName");
        University instance = new University("plymouth");
        String result = instance.getUniversityName();
        assertEquals("plymouth", result);
    }

    /**
     *
     */
    @Test
    public void testSetUniversityName() {
        System.out.println("setUniversityName");
        String name = "";
        University instance = new University("plymouth");
        instance.setUniversityName("Manchester");
        String expResult = "Manchester";
        String result = instance.getUniversityName();
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testSetCampusList() {
        System.out.println("setCampusList");
        List<Campus> CampusList = new ArrayList<>();
        Controller plymouth = new Controller("Plymouth");
        CampusList.add(new Campus("davy", new AccessLogger(plymouth.getUniversityName(), plymouth), new EmergencyLogger(plymouth.getUniversityName(), plymouth)));
        University instance = new University("plymouth");
        instance.setCampusList(CampusList);

        if (instance.getCampusList().size() > 0) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    /**
     *
     */
    @Test
    public void testGetAccessLogger() {
        System.out.println("getAccessLogger");
        Controller plymouth = new Controller("Plymouth");
        plymouth.setAccessLogger(new AccessLogger("Plymouth", plymouth));
        AccessLogger result = plymouth.getAccessLogger();

        if (result != null) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }

    }

    /**
     *
     */
    @Test
    public void testGetEmergencyLogger() {
        System.out.println("getEmergencyLogger");
        Controller plymouth = new Controller("Plymouth");
        plymouth.setAccessLogger(new AccessLogger("Plymouth", plymouth));
        plymouth.setEmergencyLogger(new EmergencyLogger(plymouth.getUniversityName(), plymouth));
        EmergencyLogger result = plymouth.getEmergencyLog();

        if (result != null) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    /**
     *
     */
    @Test
    public void testSetAccessLogger() {
        System.out.println("setAccessLogger");
        Controller plymouth = new Controller("Plymouth");
        AccessLogger accessLogger = new AccessLogger(plymouth.getUniversityName(), plymouth);
        University instance = new University("plymouth");
        plymouth.setUniversities(instance);
        instance.setAccessLogger(accessLogger);

        if (instance.getAccessLogger()!= null) {
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
    public void testSetEmergencyLogger() {
        System.out.println("setEmergencyLogger");
        Controller plymouth = new Controller("Plymouth");
        EmergencyLogger emergencyLogger = new EmergencyLogger(plymouth.getUniversityName(), plymouth);
        University instance = new University("plymouth");
        plymouth.setUniversities(instance);
        instance.setEmergencyLogger(emergencyLogger);

        if (instance.getEmergencyLogger()!= null) {
            assertTrue(true);
        }
        else{
            assertTrue(false);
        }
    }

}
