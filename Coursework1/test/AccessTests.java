/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AccessSystem.Architecture.Building;
import AccessSystem.Architecture.Campus;
import AccessSystem.Architecture.Floor;
import AccessSystem.Architecture.Room;
import AccessSystem.Architecture.University;
import AccessSystem.Controller;
import AccessSystem.Enumerations.PersonType;
import AccessSystem.Enumerations.RoomType;
import AccessSystem.Logging.AccessLogger;
import AccessSystem.Logging.EmergencyLogger;
import AccessSystem.People.BaseInformation.InformationStructPeople;
import AccessSystem.People.BaseInformation.Person;
import AccessSystem.PersonRegister;
import java.io.IOException;
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
public class AccessTests {

    public AccessTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    //These tests show the if access of any persontype is possible on all roomtypes.
    
    @Test
    public void TestAccessRoom() throws IOException {
        System.out.println("SecureRoomTest");

        //Start University creation
        University plymouth = new University("plymouth");
        Controller testControl = new Controller(plymouth.getUniversityName());
        AccessLogger testAccessLogger = new AccessLogger(plymouth.getUniversityName(), testControl);
        EmergencyLogger testEmergencyLogger = new EmergencyLogger(plymouth.getUniversityName(), testControl);
        Campus testCampus = new Campus("testCampus", testAccessLogger, testEmergencyLogger);

        plymouth.addCampus(testCampus);

        Building testBuilding = new Building("testBuilding", 22, testCampus, testAccessLogger, testEmergencyLogger);

        plymouth.getCampusList().get(0).addBuilding(testBuilding);

        Floor testFloor = new Floor("testFloor", testBuilding.getBuildingCode(), testBuilding, testAccessLogger, testEmergencyLogger);

        Building currentBuilding = plymouth.getCampusList().get(0).getBuilding().get(0);
        currentBuilding.addFloorToBuilding(testFloor);

        //Room setup
        List<RoomType> types = new ArrayList<>();
        types.add(RoomType.SECUREROOM);

        Room R1 = new Room(1, "test", "F1", types, testBuilding.getBuildingCode(), testFloor, testAccessLogger, testEmergencyLogger);

        currentBuilding.getFloorsInBuilding().get(0).addRoom(R1);

        Room R1Test = currentBuilding.getFloorsInBuilding().get(0).getRoomsOnFloor().get(0);

        //end university creation
        // Start making people
        PersonRegister testRegister = new PersonRegister();

        List<InformationStructPeople> info = new ArrayList<>();

        InformationStructPeople person1 = new InformationStructPeople();
        InformationStructPeople person2 = new InformationStructPeople();
        InformationStructPeople person3 = new InformationStructPeople();
        InformationStructPeople person4 = new InformationStructPeople();
        InformationStructPeople person5 = new InformationStructPeople();
        InformationStructPeople person6 = new InformationStructPeople();
        InformationStructPeople person7 = new InformationStructPeople();

        List<PersonType> students = new ArrayList<>();
        List<PersonType> cleaners = new ArrayList<>();
        List<PersonType> managers = new ArrayList<>();
        List<PersonType> security = new ArrayList<>();
        List<PersonType> staff = new ArrayList<>();
        List<PersonType> visitors = new ArrayList<>();
        List<PersonType> emergencyResponders = new ArrayList<>();

        students.add(PersonType.STUDENT);
        cleaners.add(PersonType.CLEANER);
        managers.add(PersonType.MANAGER);
        security.add(PersonType.SECURITY);
        staff.add(PersonType.STAFFMEMBER);
        visitors.add(PersonType.VISITOR);
        emergencyResponders.add(PersonType.EMERGENCYRESPONDER);

        //Student
        person1.setName("John");
        person1.setRoles(students);

        //Cleaners
        person2.setName("Matt");
        person2.setRoles(cleaners);

        //Managers
        person3.setName("Derek");
        person3.setRoles(managers);

        //Security
        person4.setName("Tim");
        person4.setRoles(security);

        //Staff
        person5.setName("Max");
        person5.setRoles(staff);

        //Visitors
        person6.setName("Edward");
        person6.setRoles(visitors);

        //Emergency Responders
        person7.setName("Tilly");
        person7.setRoles(emergencyResponders);

        info.add(person1);
        info.add(person2);
        info.add(person3);
        info.add(person4);
        info.add(person5);
        info.add(person6);
        info.add(person7);

        testRegister.addRegister(info);

        testControl.setSystemRegister(testRegister);

        //end making people
        //Starting Access Tests
        for (Person p : testControl.getSystemRegister().getRegister()) {
            if (R1Test.getAccess(p) == true) {
                System.out.println("Access Was Granted for : " + p.getName() + " ~ " + p.getSwipeCard().getPrimaryRole().toString());
            } else {
                System.out.println("Access Wasn't Granted for : " + p.getName() + " ~ " + p.getSwipeCard().getPrimaryRole().toString());
            }
        }

    }

    @Test
    public void TestAccessRoom1() throws IOException {
        System.out.println("LectureHallTest");

        //Start University creation
        University plymouth = new University("plymouth");
        Controller testControl = new Controller(plymouth.getUniversityName());
        AccessLogger testAccessLogger = new AccessLogger(plymouth.getUniversityName(), testControl);
        EmergencyLogger testEmergencyLogger = new EmergencyLogger(plymouth.getUniversityName(), testControl);
        Campus testCampus = new Campus("testCampus", testAccessLogger, testEmergencyLogger);

        plymouth.addCampus(testCampus);

        Building testBuilding = new Building("testBuilding", 22, testCampus, testAccessLogger, testEmergencyLogger);

        plymouth.getCampusList().get(0).addBuilding(testBuilding);

        Floor testFloor = new Floor("testFloor", testBuilding.getBuildingCode(), testBuilding, testAccessLogger, testEmergencyLogger);

        Building currentBuilding = plymouth.getCampusList().get(0).getBuilding().get(0);
        currentBuilding.addFloorToBuilding(testFloor);

        //Room setup
        List<RoomType> types = new ArrayList<>();
        types.add(RoomType.LECTUREHALL);

        Room R1 = new Room(1, "test", "F1", types, testBuilding.getBuildingCode(), testFloor, testAccessLogger, testEmergencyLogger);

        currentBuilding.getFloorsInBuilding().get(0).addRoom(R1);

        Room R1Test = currentBuilding.getFloorsInBuilding().get(0).getRoomsOnFloor().get(0);

        //end university creation
        // Start making people
        PersonRegister testRegister = new PersonRegister();

        List<InformationStructPeople> info = new ArrayList<>();

        InformationStructPeople person1 = new InformationStructPeople();
        InformationStructPeople person2 = new InformationStructPeople();
        InformationStructPeople person3 = new InformationStructPeople();
        InformationStructPeople person4 = new InformationStructPeople();
        InformationStructPeople person5 = new InformationStructPeople();
        InformationStructPeople person6 = new InformationStructPeople();
        InformationStructPeople person7 = new InformationStructPeople();

        List<PersonType> students = new ArrayList<>();
        List<PersonType> cleaners = new ArrayList<>();
        List<PersonType> managers = new ArrayList<>();
        List<PersonType> security = new ArrayList<>();
        List<PersonType> staff = new ArrayList<>();
        List<PersonType> visitors = new ArrayList<>();
        List<PersonType> emergencyResponders = new ArrayList<>();

        students.add(PersonType.STUDENT);
        cleaners.add(PersonType.CLEANER);
        managers.add(PersonType.MANAGER);
        security.add(PersonType.SECURITY);
        staff.add(PersonType.STAFFMEMBER);
        visitors.add(PersonType.VISITOR);
        emergencyResponders.add(PersonType.EMERGENCYRESPONDER);

        //Student
        person1.setName("John");
        person1.setRoles(students);

        //Cleaners
        person2.setName("Matt");
        person2.setRoles(cleaners);

        //Managers
        person3.setName("Derek");
        person3.setRoles(managers);

        //Security
        person4.setName("Tim");
        person4.setRoles(security);

        //Staff
        person5.setName("Max");
        person5.setRoles(staff);

        //Visitors
        person6.setName("Edward");
        person6.setRoles(visitors);

        //Emergency Responders
        person7.setName("Tilly");
        person7.setRoles(emergencyResponders);

        info.add(person1);
        info.add(person2);
        info.add(person3);
        info.add(person4);
        info.add(person5);
        info.add(person6);
        info.add(person7);

        testRegister.addRegister(info);

        testControl.setSystemRegister(testRegister);

        //end making people
        //Starting Access Tests
        for (Person p : testControl.getSystemRegister().getRegister()) {
            if (R1Test.getAccess(p) == true) {
                System.out.println("Access Was Granted for : " + p.getName() + " ~ " + p.getSwipeCard().getPrimaryRole().toString());
            } else {
                System.out.println("Access Wasn't Granted for : " + p.getName() + " ~ " + p.getSwipeCard().getPrimaryRole().toString());
            }
        }

    }

    @Test
    public void TestAccessRoom2() throws IOException {
        System.out.println("ReaserchLabTest");

        //Start University creation
        University plymouth = new University("plymouth");
        Controller testControl = new Controller(plymouth.getUniversityName());
        AccessLogger testAccessLogger = new AccessLogger(plymouth.getUniversityName(), testControl);
        EmergencyLogger testEmergencyLogger = new EmergencyLogger(plymouth.getUniversityName(), testControl);
        Campus testCampus = new Campus("testCampus", testAccessLogger, testEmergencyLogger);

        plymouth.addCampus(testCampus);

        Building testBuilding = new Building("testBuilding", 22, testCampus, testAccessLogger, testEmergencyLogger);

        plymouth.getCampusList().get(0).addBuilding(testBuilding);

        Floor testFloor = new Floor("testFloor", testBuilding.getBuildingCode(), testBuilding, testAccessLogger, testEmergencyLogger);

        Building currentBuilding = plymouth.getCampusList().get(0).getBuilding().get(0);
        currentBuilding.addFloorToBuilding(testFloor);

        //Room setup
        List<RoomType> types = new ArrayList<>();
        types.add(RoomType.RESEARCHLAB);

        Room R1 = new Room(1, "test", "F1", types, testBuilding.getBuildingCode(), testFloor, testAccessLogger, testEmergencyLogger);

        currentBuilding.getFloorsInBuilding().get(0).addRoom(R1);

        Room R1Test = currentBuilding.getFloorsInBuilding().get(0).getRoomsOnFloor().get(0);

        //end university creation
        // Start making people
        PersonRegister testRegister = new PersonRegister();

        List<InformationStructPeople> info = new ArrayList<>();

        InformationStructPeople person1 = new InformationStructPeople();
        InformationStructPeople person2 = new InformationStructPeople();
        InformationStructPeople person3 = new InformationStructPeople();
        InformationStructPeople person4 = new InformationStructPeople();
        InformationStructPeople person5 = new InformationStructPeople();
        InformationStructPeople person6 = new InformationStructPeople();
        InformationStructPeople person7 = new InformationStructPeople();

        List<PersonType> students = new ArrayList<>();
        List<PersonType> cleaners = new ArrayList<>();
        List<PersonType> managers = new ArrayList<>();
        List<PersonType> security = new ArrayList<>();
        List<PersonType> staff = new ArrayList<>();
        List<PersonType> visitors = new ArrayList<>();
        List<PersonType> emergencyResponders = new ArrayList<>();

        students.add(PersonType.STUDENT);
        cleaners.add(PersonType.CLEANER);
        managers.add(PersonType.MANAGER);
        security.add(PersonType.SECURITY);
        staff.add(PersonType.STAFFMEMBER);
        visitors.add(PersonType.VISITOR);
        emergencyResponders.add(PersonType.EMERGENCYRESPONDER);

        //Student
        person1.setName("John");
        person1.setRoles(students);

        //Cleaners
        person2.setName("Matt");
        person2.setRoles(cleaners);

        //Managers
        person3.setName("Derek");
        person3.setRoles(managers);

        //Security
        person4.setName("Tim");
        person4.setRoles(security);

        //Staff
        person5.setName("Max");
        person5.setRoles(staff);

        //Visitors
        person6.setName("Edward");
        person6.setRoles(visitors);

        //Emergency Responders
        person7.setName("Tilly");
        person7.setRoles(emergencyResponders);

        info.add(person1);
        info.add(person2);
        info.add(person3);
        info.add(person4);
        info.add(person5);
        info.add(person6);
        info.add(person7);

        testRegister.addRegister(info);

        testControl.setSystemRegister(testRegister);

        //end making people
        //Starting Access Tests
        for (Person p : testControl.getSystemRegister().getRegister()) {
            if (R1Test.getAccess(p) == true) {
                System.out.println("Access Was Granted for : " + p.getName() + " ~ " + p.getSwipeCard().getPrimaryRole().toString());
            } else {
                System.out.println("Access Wasn't Granted for : " + p.getName() + " ~ " + p.getSwipeCard().getPrimaryRole().toString());
            }
        }

    }

    @Test
    public void TestAccessRoom3() throws IOException {
        System.out.println("StaffRoomTest");

        //Start University creation
        University plymouth = new University("plymouth");
        Controller testControl = new Controller(plymouth.getUniversityName());
        AccessLogger testAccessLogger = new AccessLogger(plymouth.getUniversityName(), testControl);
        EmergencyLogger testEmergencyLogger = new EmergencyLogger(plymouth.getUniversityName(), testControl);
        Campus testCampus = new Campus("testCampus", testAccessLogger, testEmergencyLogger);

        plymouth.addCampus(testCampus);

        Building testBuilding = new Building("testBuilding", 22, testCampus, testAccessLogger, testEmergencyLogger);

        plymouth.getCampusList().get(0).addBuilding(testBuilding);

        Floor testFloor = new Floor("testFloor", testBuilding.getBuildingCode(), testBuilding, testAccessLogger, testEmergencyLogger);

        Building currentBuilding = plymouth.getCampusList().get(0).getBuilding().get(0);
        currentBuilding.addFloorToBuilding(testFloor);

        //Room setup
        List<RoomType> types = new ArrayList<>();
        types.add(RoomType.STAFFROOM);

        Room R1 = new Room(1, "test", "F1", types, testBuilding.getBuildingCode(), testFloor, testAccessLogger, testEmergencyLogger);

        currentBuilding.getFloorsInBuilding().get(0).addRoom(R1);

        Room R1Test = currentBuilding.getFloorsInBuilding().get(0).getRoomsOnFloor().get(0);

        //end university creation
        // Start making people
        PersonRegister testRegister = new PersonRegister();

        List<InformationStructPeople> info = new ArrayList<>();

        InformationStructPeople person1 = new InformationStructPeople();
        InformationStructPeople person2 = new InformationStructPeople();
        InformationStructPeople person3 = new InformationStructPeople();
        InformationStructPeople person4 = new InformationStructPeople();
        InformationStructPeople person5 = new InformationStructPeople();
        InformationStructPeople person6 = new InformationStructPeople();
        InformationStructPeople person7 = new InformationStructPeople();

        List<PersonType> students = new ArrayList<>();
        List<PersonType> cleaners = new ArrayList<>();
        List<PersonType> managers = new ArrayList<>();
        List<PersonType> security = new ArrayList<>();
        List<PersonType> staff = new ArrayList<>();
        List<PersonType> visitors = new ArrayList<>();
        List<PersonType> emergencyResponders = new ArrayList<>();

        students.add(PersonType.STUDENT);
        cleaners.add(PersonType.CLEANER);
        managers.add(PersonType.MANAGER);
        security.add(PersonType.SECURITY);
        staff.add(PersonType.STAFFMEMBER);
        visitors.add(PersonType.VISITOR);
        emergencyResponders.add(PersonType.EMERGENCYRESPONDER);

        //Student
        person1.setName("John");
        person1.setRoles(students);

        //Cleaners
        person2.setName("Matt");
        person2.setRoles(cleaners);

        //Managers
        person3.setName("Derek");
        person3.setRoles(managers);

        //Security
        person4.setName("Tim");
        person4.setRoles(security);

        //Staff
        person5.setName("Max");
        person5.setRoles(staff);

        //Visitors
        person6.setName("Edward");
        person6.setRoles(visitors);

        //Emergency Responders
        person7.setName("Tilly");
        person7.setRoles(emergencyResponders);

        info.add(person1);
        info.add(person2);
        info.add(person3);
        info.add(person4);
        info.add(person5);
        info.add(person6);
        info.add(person7);

        testRegister.addRegister(info);

        testControl.setSystemRegister(testRegister);

        //end making people
        //Starting Access Tests
        for (Person p : testControl.getSystemRegister().getRegister()) {
            if (R1Test.getAccess(p) == true) {
                System.out.println("Access Was Granted for : " + p.getName() + " ~ " + p.getSwipeCard().getPrimaryRole().toString());
            } else {
                System.out.println("Access Wasn't Granted for : " + p.getName() + " ~ " + p.getSwipeCard().getPrimaryRole().toString());
            }
        }

    }

    @Test
    public void TestAccessRoom4() throws IOException {
        System.out.println("StudentLabTest");

        //Start University creation
        University plymouth = new University("plymouth");
        Controller testControl = new Controller(plymouth.getUniversityName());
        AccessLogger testAccessLogger = new AccessLogger(plymouth.getUniversityName(), testControl);
        EmergencyLogger testEmergencyLogger = new EmergencyLogger(plymouth.getUniversityName(), testControl);
        Campus testCampus = new Campus("testCampus", testAccessLogger, testEmergencyLogger);

        plymouth.addCampus(testCampus);

        Building testBuilding = new Building("testBuilding", 22, testCampus, testAccessLogger, testEmergencyLogger);

        plymouth.getCampusList().get(0).addBuilding(testBuilding);

        Floor testFloor = new Floor("testFloor", testBuilding.getBuildingCode(), testBuilding, testAccessLogger, testEmergencyLogger);

        Building currentBuilding = plymouth.getCampusList().get(0).getBuilding().get(0);
        currentBuilding.addFloorToBuilding(testFloor);

        //Room setup
        List<RoomType> types = new ArrayList<>();
        types.add(RoomType.STUDENTLAB);

        Room R1 = new Room(1, "test", "F1", types, testBuilding.getBuildingCode(), testFloor, testAccessLogger, testEmergencyLogger);

        currentBuilding.getFloorsInBuilding().get(0).addRoom(R1);

        Room R1Test = currentBuilding.getFloorsInBuilding().get(0).getRoomsOnFloor().get(0);

        //end university creation
        // Start making people
        PersonRegister testRegister = new PersonRegister();

        List<InformationStructPeople> info = new ArrayList<>();

        InformationStructPeople person1 = new InformationStructPeople();
        InformationStructPeople person2 = new InformationStructPeople();
        InformationStructPeople person3 = new InformationStructPeople();
        InformationStructPeople person4 = new InformationStructPeople();
        InformationStructPeople person5 = new InformationStructPeople();
        InformationStructPeople person6 = new InformationStructPeople();
        InformationStructPeople person7 = new InformationStructPeople();

        List<PersonType> students = new ArrayList<>();
        List<PersonType> cleaners = new ArrayList<>();
        List<PersonType> managers = new ArrayList<>();
        List<PersonType> security = new ArrayList<>();
        List<PersonType> staff = new ArrayList<>();
        List<PersonType> visitors = new ArrayList<>();
        List<PersonType> emergencyResponders = new ArrayList<>();

        students.add(PersonType.STUDENT);
        cleaners.add(PersonType.CLEANER);
        managers.add(PersonType.MANAGER);
        security.add(PersonType.SECURITY);
        staff.add(PersonType.STAFFMEMBER);
        visitors.add(PersonType.VISITOR);
        emergencyResponders.add(PersonType.EMERGENCYRESPONDER);

        //Student
        person1.setName("John");
        person1.setRoles(students);

        //Cleaners
        person2.setName("Matt");
        person2.setRoles(cleaners);

        //Managers
        person3.setName("Derek");
        person3.setRoles(managers);

        //Security
        person4.setName("Tim");
        person4.setRoles(security);

        //Staff
        person5.setName("Max");
        person5.setRoles(staff);

        //Visitors
        person6.setName("Edward");
        person6.setRoles(visitors);

        //Emergency Responders
        person7.setName("Tilly");
        person7.setRoles(emergencyResponders);

        info.add(person1);
        info.add(person2);
        info.add(person3);
        info.add(person4);
        info.add(person5);
        info.add(person6);
        info.add(person7);

        testRegister.addRegister(info);

        testControl.setSystemRegister(testRegister);

        //end making people
        //Starting Access Tests
        for (Person p : testControl.getSystemRegister().getRegister()) {
            if (R1Test.getAccess(p) == true) {
                System.out.println("Access Was Granted for : " + p.getName() + " ~ " + p.getSwipeCard().getPrimaryRole().toString());
            } else {
                System.out.println("Access Wasn't Granted for : " + p.getName() + " ~ " + p.getSwipeCard().getPrimaryRole().toString());
            }
        }

    }

}
