/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem;

import AccessSystem.Architecture.University;
import AccessSystem.Logging.AccessLogger;
import AccessSystem.Logging.EmergencyLogger;
import java.io.Serializable;

/**
 * <h1> Controller Class </h1>
 * <p>
 * The Controller contains a list of both University and PersonRegister that is
 * then used by the GUI. </p>
 *
 * @author Liam Read
 */
public class Controller implements Serializable {

    /**
     * Attributes: List of all system registers, List of all associated
     * Universities, Emergency Logger for the university, AccessLogger for
     * university and active system boolean.
     */
    private PersonRegister SystemRegister;
    private University Universities;
    private transient EmergencyLogger emergencyLogger;
    private boolean ActiveSys;
    private final String universityName;
    private transient AccessLogger accessLogger;

    /**
     * Default Constructor: A new person register, sets the system as not
     * active, the university name and a new Emergency logger.
     *
     * @param univesityName The universities name.
     */
    public Controller(String univesityName) {
        this.SystemRegister = new PersonRegister();
        this.ActiveSys = false;
        this.universityName = univesityName;
    }

    /**
     * gets the university name of the universtiy assigned to this controller.
     * @return String of university name.
     */
    public String getUniversityName() {
        return universityName;
    }

    /**
     * gets the accesslogger assigned to this controller.
     * @return accesslogger assigned to this controller.
     */
    public AccessLogger getAccessLogger() {
        return accessLogger;
    }

    /**
     * Assigns an AccessLogger to this controller.
     * @param accessLogger the accesslogger to be assigned.
     */
    public void setAccessLogger(AccessLogger accessLogger) {
        this.accessLogger = accessLogger;
    }

    /**
     * assigns an EmergencyLogger to this controller.
     * @param emergencyLogger the EmergencyLogger to be set.
     */
    public void setEmergencyLogger(EmergencyLogger emergencyLogger) {
        this.emergencyLogger = emergencyLogger;
    }

    /**
     * gets the current EmergencyLog.
     *
     * @return current emergencyLog.
     */
    public EmergencyLogger getEmergencyLog() {
        return emergencyLogger;
    }

    /**
     * gets the current System register of people.
     *
     * @return returns the current system register.
     */
    public PersonRegister getSystemRegister() {
        return SystemRegister;
    }

    /**
     * Sets the current system register.
     *
     * @param SystemRegister register of people.
     */
    public void setSystemRegister(PersonRegister SystemRegister) {
        this.SystemRegister = SystemRegister;
    }

    /**
     * gets the university of the controller.
     *
     * @return university.
     */
    public University getUniversities() {
        return Universities;
    }

    /**
     * sets the current university.
     *
     * @param Universities current university to be set.
     */
    public void setUniversities(University Universities) {
        this.Universities = Universities;
    }

    /**
     * if the system is active in the systemOverView.
     *
     * @return if it's currently active.
     */
    public boolean isActiveSys() {
        return ActiveSys;
    }

    /**
     * Sets if the university is active in the systemOverView.
     *
     * @param ActiveSys true or false.
     */
    public void setActiveSys(boolean ActiveSys) {
        this.ActiveSys = ActiveSys;
    }

}
