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
 * <h1> Building Class: Architecture Hierarchy </h1>
 * <p>
 * Creates a Building that holds a list of Floors, Used as part of the
 * architecture chain. Instances of the building class are created through the
 * architecture factory. </p>
 *
 * @author Liam Read
 */
public class Building implements Serializable, Subject, Observers {

    /**
     * Attributes: String of the building name, List of all associated floors
     * inside the building, Building code, emergency mode, campus that is
     * observing it, AccessLogger, EmergencyLogger, and list of observers.
     */
    private String buildingName;
    private final String buildingCode;
    private List<Floor> floorsInBuilding;
    private Boolean emergencyMode;
    private final Campus campus;
    private final AccessLogger accessLogger;
    private final EmergencyLogger emergencyLogger;
    private final ArrayList<Observers> observers = new ArrayList<>();

    /**
     * Default Constructor : Instantiates floorsInBuilding as a new ArrayList,
     * Requires the building name on creation.
     *
     * @param buildingName The building name.
     * @param buildingCode The building Code.
     * @param campus Parent Campus.
     * @param accessLogger accessLogger associated with university.
     * @param emgergencyLogger EmergencyLogger associated with university.
     */
    public Building(String buildingName, int buildingCode, Campus campus, AccessLogger accessLogger, EmergencyLogger emgergencyLogger) {
        String buildname;

        if (buildingName.length() > 3) {
            buildname = buildingName.substring(0, 2);
        } else {
            buildname = buildingName;
        }

        this.buildingCode = buildname + buildingCode;
        this.buildingName = buildingName;
        this.floorsInBuilding = new ArrayList<>();
        this.emergencyMode = false;
        this.campus = campus;
        this.campus.registerObserver(this);
        this.accessLogger = accessLogger;
        this.emergencyLogger = emgergencyLogger;

    }

    /**
     * Gets Building code.
     *
     * @return The buildings code.
     */
    public String getBuildingCode() {
        return buildingCode;
    }

    /**
     * Get the name of the building.
     *
     * @return The buildings name.
     */
    public String getBuildingName() {
        return this.buildingName;
    }

    /**
     * Get the floors inside the building.
     *
     * @return List of all floors inside the building.
     */
    public List<Floor> getFloorsInBuilding() {
        return floorsInBuilding;
    }

    /**
     * Set's the name of the building.
     *
     * @param newName Sets the name of the building.
     */
    public void setBuildingName(String newName) {
        this.buildingName = newName;
    }

    /**
     * Attaches floors to the building.
     *
     * @param floorsInBuilding The floors to be added to the building.
     */
    public void setFloorsInBuilding(List<Floor> floorsInBuilding) {
        this.floorsInBuilding = floorsInBuilding;
    }

    /**
     * Attaches floor to the building.
     *
     * @param floor the floor to be added.
     */
    public void addFloorToBuilding(Floor floor) {
        this.floorsInBuilding.add(floor);
    }

    /**
     * Gets the current building operating mode.
     *
     * @return String of the current operating mode in the building
     */
    public String getBuildingMode() {
        if (this.emergencyMode == true) {
            return "Emergency Mode";
        } else {
            return "Normal Mode";
        }
    }

    /**
     * Gets the current university Emergency logger.
     *
     * @return EmergencyLogger for the university.
     */
    public EmergencyLogger getEmergencyLogger() {
        return emergencyLogger;
    }

    /**
     * Gets the current university Access logger.
     *
     * @return Returns the current university logger.
     */
    public AccessLogger getAccessLogger() {
        return accessLogger;
    }

    /**
     * Sets the current Building into emergency mode. All architectures below
     * this are also made emergency via observers.
     *
     * @param emergencyMode the emergency mode to be set.
     */
    public void setEmergency(boolean emergencyMode) {
        this.emergencyMode = emergencyMode;
        notifyObservers();
    }

    /**
     * Registers the current building as an observer of it's campus.
     *
     * @param observer observer of campus.
     */
    @Override
    public void registerObserver(Observers observer) {
        this.observers.add(observer);
    }

    /**
     * notify's observers of changes to emergencyMode;
     */
    @Override
    public void notifyObservers() {
        observers.stream().forEach((o) -> {
            o.update(emergencyMode);
        });
    }

    /**
     * updates current emergencyMode when triggered.
     *
     * @param emergencyMode the emergencyMode to be set.
     */
    @Override
    public void update(boolean emergencyMode) {
        setEmergency(emergencyMode);
    }

}
