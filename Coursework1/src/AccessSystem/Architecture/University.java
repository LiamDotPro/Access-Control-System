/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Architecture;

import AccessSystem.Logging.AccessLogger;
import AccessSystem.Logging.EmergencyLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1> Room Class: Architecture Hierarchy </h1>
 * <p>
 * Creates a University that holds information about the university, Used as
 * part of the architecture chain. </p>
 *
 * @author Liam Read
 */
public class University implements Serializable {

    /**
     * Attributes: String name of the university, A list of all campuses at the
     * university.
     */
    private List<Campus> campusList;
    private String universityName;
    private AccessLogger accessLogger;
    private EmergencyLogger emergencyLogger;

    /**
     * Default Constructor: Assigns university name on creation.
     *
     * @param universityName the university name.
     */
    public University(String universityName) {
        this.campusList = new ArrayList<>();
        this.universityName = universityName;
    }

    /**
     * Gets the campus list.
     *
     * @return The current Campus list.
     */
    public List<Campus> getCampusList() {
        return this.campusList;
    }

    /**
     * Adds a new campus to the university.
     *
     * @param newCampus new campus to be added.
     */
    public void addCampus(Campus newCampus) {
        this.campusList.add(newCampus);
    }

    /**
     * Gets the University name.
     *
     * @return The current University name.
     */
    public String getUniversityName() {
        return this.universityName;
    }

    /**
     * Sets a new University name.
     *
     * @param name new University name.
     */
    public void setUniversityName(String name) {
        this.universityName = name;
    }

    /**
     * Attaches a list of campuses to the University.
     *
     * @param CampusList list of campuses.
     */
    public void setCampusList(List<Campus> CampusList) {
        this.campusList = CampusList;
    }

    /**
     * Gets the current Access Logger.
     * @return the current Access Logger.
     */
    public AccessLogger getAccessLogger() {
        return accessLogger;
    }

    /**
     * Gets the current associated Emergency Logger.
     * @return the current emergency logger.
     */
    public EmergencyLogger getEmergencyLogger() {
        return emergencyLogger;
    }

    /**
     *  Sets the current AccessLogger.
     * @param accessLogger an AccessLogger.
     */
    public void setAccessLogger(AccessLogger accessLogger) {
        this.accessLogger = accessLogger;
    }

    /**
     * Sets the current Emergency Logger.
     * @param emergencyLogger an AccessLogger.
     */
    public void setEmergencyLogger(EmergencyLogger emergencyLogger) {
        this.emergencyLogger = emergencyLogger;
    }

}
