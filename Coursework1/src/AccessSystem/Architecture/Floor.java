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
 * <h1> Floor Class: Architecture Hierarchy </h1>
 * <p>
 * Creates a Floor that holds a list of Rooms, Used as part of the architecture
 * chain. Instances of the Floor class are created through the architecture
 * factory. </p>
 *
 * @author Liam Read
 */
public class Floor implements Serializable, Subject, Observers {

    /**
     * Attributes: String floorIdentifer the floor identifers also used by rooms
     * in the floor, List of all rooms on the floor.
     *
     * Passes in the current accessLogger and emergencyLogger for the
     * university.
     *
     */
    private List<Room> roomsOnFloor;
    private final ArrayList<Observers> observers = new ArrayList<>();
    private String floorIdentifer;
    private final AccessLogger accessLogger;
    private final EmergencyLogger emergencyLogger;
    private final String buildingCode;
    private Boolean emergencyMode;
    private final Subject building;

    /**
     * Default Constructor: Instantiates roomsOnFloor as a new ArrayList,
     * Requires the floorIdentifer on creation.
     *
     * @param floorIdentifer String name of the floor identifers.
     * @param buildingCode the buildings code.
     * @param building the building the floor is on.
     * @param accesslogger the current access logger.
     * @param emergencyLogger the current emergency logger.
     */
    public Floor(String floorIdentifer, String buildingCode, Subject building, AccessLogger accesslogger, EmergencyLogger emergencyLogger) {
        this.floorIdentifer = floorIdentifer;
        this.accessLogger = accesslogger;
        this.roomsOnFloor = new ArrayList<>();
        this.buildingCode = buildingCode;
        this.emergencyMode = false;
        this.building = building;
        this.building.registerObserver(this);
        this.emergencyLogger = emergencyLogger;
    }

    /**
     * Get the current rooms on the floor.
     *
     * @return The current rooms on the floor.
     */
    public List<Room> getRoomsOnFloor() {
        return roomsOnFloor;
    }

    /**
     * gets the current floor Identifer.
     *
     * @return The current floor Identifer.
     */
    public String getFloorIdentifer() {
        return floorIdentifer;
    }

    /**
     * Adds a room to the floor.
     *
     * @param room room to be added.
     */
    public void addRoom(Room room) {
        this.roomsOnFloor.add(room);
    }

    /**
     * Attaches rooms to the current floor.
     *
     * @param RoomsOnFloor adds a list of rooms to the floor.
     */
    public void setRoomsOnFloor(List<Room> RoomsOnFloor) {
        this.roomsOnFloor = RoomsOnFloor;
    }

    /**
     * Sets the Floor Identifer.
     *
     * @param FloorIdentifer String floor Identifer.
     */
    public void setFloorIdentifer(String FloorIdentifer) {
        this.floorIdentifer = FloorIdentifer;
    }

    /**
     * gets the floors Current mode.
     *
     * @return the operating mode for the floor.
     */
    public String getFloorMode() {
        if (this.emergencyMode == true) {
            return "Emergency Mode";
        } else {
            return "Normal Mode";
        }
    }

    /**
     * sets the emergencyMode for the floor and notify's observers.
     *
     * @param emergencyMode sets an emergency state for the floor.
     */
    public void setEmergency(boolean emergencyMode) {
        this.emergencyMode = emergencyMode;
        notifyObservers();
    }

    /**
     * gets the current accessLogger for the university.
     *
     * @return Current accessLogger.
     */
    public AccessLogger getAccessLogger() {
        return accessLogger;
    }

    /**
     * gets the universtiy current emergencyLogger.
     *
     * @return the floors associated emergencyLogger.
     */
    public EmergencyLogger getEmergencyLogger() {
        return emergencyLogger;
    }

    /**
     * registers a new observer on the floor.
     *
     * @param observer an observer for this floor.
     */
    @Override
    public void registerObserver(Observers observer) {
        this.observers.add(observer);
    }

    /**
     * notify's observers of any changes.
     */
    @Override
    public void notifyObservers() {

        //Cycles all observers of this floor and tells them the EmergencyMode changed
        observers.stream().forEach((o) -> {
            o.update(emergencyMode);
        });

    }

    /**
     * updates the current emergencyMode of the university when building mode
     * changes.
     *
     * @param emergencyMode the ermegency mode to be changed.
     */
    @Override
    public void update(boolean emergencyMode) {
        setEmergency(emergencyMode);
    }

}
