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
 * <h1> Campus Class: Architecture Hierarchy </h1>
 * <p>
 * Creates a Campus that holds a list of buildings, used as part of the
 * architecture chain. Instances of the campus class are created through the
 * architecture factory.</p>
 *
 * @author Liam Read
 */
public class Campus implements Serializable, Subject {

    /**
     * Attributes: String name of the Campus, List of all associated buildings
     * inside the campus, Campus Emergency Mode, AccessLogger, EmergencyLogger
     * and observers.
     *
     *
     */
    private String nameOfCampus;
    private List<Building> campusBuildings;
    private Boolean emergencyMode;
    private final AccessLogger accessLogger;
    private final EmergencyLogger emergencyLogger;
    private final ArrayList<Observers> observers = new ArrayList<>();

    /**
     * Default Constructor: Instantiates campusBuildings as a new ArrayList,
     * Requires the campus name on creation.
     *
     * Passes in the current accessLogger and emergencyLogger for the
     * university.
     *
     * @param campusName The name of the campus
     * @param accessLogger The current accessLogger for the universtiy.
     * @param emergencyLogger The current emergencyLogger for the universtiy.
     */
    public Campus(String campusName, AccessLogger accessLogger, EmergencyLogger emergencyLogger) {
        this.nameOfCampus = campusName;
        this.campusBuildings = new ArrayList<>();
        this.emergencyMode = false;
        this.accessLogger = accessLogger;
        this.emergencyLogger = emergencyLogger;
    }

    /**
     * Gets the current campuses mode.
     *
     * @return the current campuses mode as a String.
     */
    public String getCampusMode() {
        if (this.emergencyMode == true) {
            return "Emergency Mode";
        } else {
            return "Normal Mode";
        }
    }

    /**
     * Adds a building to the current building list in the campus.
     *
     * @param building a building to be added.
     */
    public void addBuilding(Building building) {
        this.campusBuildings.add(building);
    }

    /**
     * Sets the current campus name.
     *
     * @param nameOfCampus The new campus name.
     */
    public void setNameOfCampus(String nameOfCampus) {
        this.nameOfCampus = nameOfCampus;
    }

    /**
     * Sets the list of buildings associated with the campus.
     *
     * @param CampusBuildings List of buildings to be added to the campus.
     */
    public void setCampusBuildings(List<Building> CampusBuildings) {
        this.campusBuildings = CampusBuildings;
    }

    /**
     * get the name of the current Campus.
     *
     * @return the current campus name.
     */
    public String getCampusName() {
        return this.nameOfCampus;
    }

    /**
     * get the current list of buildings in the campus.
     *
     * @return the list of buildings associated with the campus.
     */
    public List<Building> getBuilding() {
        return this.campusBuildings;
    }

    /**
     * Gets the current university accessLogger.
     *
     * @return current university accessLogger.
     */
    public AccessLogger getAccessLogger() {
        return accessLogger;
    }

    /**
     * gets the current university emergencyLoggger.
     *
     * @return current university emergencyLoggger.
     */
    public EmergencyLogger getEmergencyLogger() {
        return emergencyLogger;
    }

    /**
     * Registers observers in the campus.
     *
     * @param observer an observer for the campus.
     */
    @Override
    public void registerObserver(Observers observer) {
        this.observers.add(observer);
    }

    /**
     * Notify's the observers of changes.
     */
    @Override
    public void notifyObservers() {
        observers.stream().forEach((o) -> {
            o.update(emergencyMode);
        });
    }

    /**
     * Sets the campus into emergencyMode and notify's all subscribed observers.
     *
     * @param emergencyMode True or false boolean.
     */
    public void setEmergency(boolean emergencyMode) {
        this.emergencyMode = emergencyMode;
        notifyObservers();
    }

}
