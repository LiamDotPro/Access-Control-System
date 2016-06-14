/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Architecture;

import AccessSystem.Enumerations.PersonType;
import AccessSystem.Enumerations.RoomType;
import AccessSystem.Factories.AccessStrategyFactory;
import AccessSystem.Logging.AccessLogEntry;
import AccessSystem.Logging.AccessLogger;
import AccessSystem.Logging.EmergencyLogger;
import AccessSystem.People.BaseInformation.Person;
import AccessSystem.Strategies.IAccessStrategy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

/**
 * <h1> Room Class: Architecture Hierarchy </h1>
 * <p>
 * Creates a Room that holds information about the type of room and security,
 * Used as part of the architecture chain. Instances of the Room class are
 * created through the architecture factory. </p>
 *
 * @author Liam Read
 */
public class Room implements Serializable, Observers {

    /**
     * Attributes: Integer of room number, String of room name, Boolean for
     * emergency status, Boolean for Secure status, String for floor name,
     * SwipeCard Machine for access and List of room functionality for
     * functionality, Subject floor that it is subscribed to, AccessLogger at
     * university and emergencyLogger at university.
     */
    private Integer roomNumber;
    private String roomName;
    private Boolean emergencyMode;
    private String floorName;
    private final String buildingCode;
    private final AccessLogger accessLogger;
    private final EmergencyLogger emergencyLogger;
    private final AccessStrategyFactory strategyFactory;
    private final List<RoomType> roomFunctionality;
    private final Subject floor;

    /**
     * Default Constructor: Assigns a room number, Secure room status, Room Name
     * and floor name. Room is not in emergency mode by default.
     *
     * @param roomNumber The current room number.
     * @param roomName The current room name.
     * @param floorName The floor the room is found on.
     * @param roomRoles The rooms roles.
     * @param floor The floor the room subscribes to.
     * @param accessLogger Access Logger for this university.
     * @param buildingCode the building code the room resides in.
     * @param emergencyLogger Emergency Logger for this university.
     */
    public Room(Integer roomNumber, String roomName, String floorName, List<RoomType> roomRoles, String buildingCode, Subject floor, AccessLogger accessLogger, EmergencyLogger emergencyLogger) {
        this.roomNumber = roomNumber;
        this.buildingCode = buildingCode;
        this.roomName = roomName;
        this.emergencyMode = false;
        this.floorName = floorName;
        this.roomFunctionality = new ArrayList<>();
        roomRoles.stream().forEach((type) -> {
            this.roomFunctionality.add(type);
        });
        this.strategyFactory = new AccessStrategyFactory();
        this.accessLogger = accessLogger;
        this.floor = floor;
        this.floor.registerObserver(this);
        this.emergencyLogger = emergencyLogger;
    }

    /**
     * Get current room number.
     *
     * @return the current room number.
     */
    public Integer getRoomNumber() {
        return this.roomNumber;
    }

    /**
     * Gets the current rooms building code.
     *
     * @return the rooms building code.
     */
    public String getBuildingCode() {
        return buildingCode;
    }

    /**
     * Get the current floor name.
     *
     * @return The current floors name.
     */
    public String getFloorName() {
        return this.floorName;
    }

    /**
     * gets the current emergencyMode for the room.
     *
     * @return emergencyMode for building.
     */
    public Boolean getIsEmergency() {
        return emergencyMode;
    }

    /**
     * Get the rooms Access.
     *
     * @return String of Rooms mode.
     */
    public String getRoomMode() {
        if (this.emergencyMode == true) {
            return "Emergency Mode";
        } else {
            return "Normal Mode";
        }
    }

    /**
     * Gets the current rooms name.
     *
     * @return The current rooms name.
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Get list of current room functionalities.
     *
     * @return Current room functionalities.
     */
    public List<RoomType> getRoomFunctionality() {
        return roomFunctionality;
    }

    /**
     * Clears all of the functionality current associated with the room.
     */
    public void clearAllRoomFunctionality() {
        this.roomFunctionality.clear();
    }

    /**
     * Clears a specific functionality from the list.
     *
     * @param roomType The room to be cleared.
     */
    public void clearSpecifcFunctionality(RoomType roomType) {
        this.roomFunctionality.remove(roomType);
    }

    /**
     * Sets the floors name.
     *
     * @param newFloorName The new floor name.
     */
    public void setFloorName(String newFloorName) {
        this.floorName = newFloorName;
    }

    /**
     * Sets the room number
     *
     * @param newRoomNumber sets the new room number.
     */
    public void setRoomNumber(Integer newRoomNumber) {
        this.roomNumber = newRoomNumber;
    }

    /**
     * Sets the rooms name.
     *
     * @param newRoomName new room name.
     */
    public void setRoomName(String newRoomName) {
        this.roomName = newRoomName;
    }

    /**
     * gets the universities current EmergencyLogger.
     *
     * @return the current emergencyLogger.
     */
    public EmergencyLogger getEmergencyLogger() {
        return emergencyLogger;
    }

    /**
     * Allows a person to attempt to gain access to a room.
     *
     * @param person The person who is trying to get access
     * @return If the person provided can access this room.
     * @throws java.io.IOException Failed or interrupted I/O Operations.
     */
    public boolean getAccess(Person person) throws IOException {

        List<PersonType> allRoles = new ArrayList<>();

        allRoles.add(person.getSwipeCard().getPrimaryRole());

        person.getSwipeCard().getSecondaryRoles().stream().forEach((personType) -> {
            allRoles.add(personType);
        });

        for (PersonType personType : allRoles) {
            IAccessStrategy strat = strategyFactory.createStrategy(personType);

            if (strat.canAccess(this)) {
                AccessLogEntry info = new AccessLogEntry(person, this, true);
                this.accessLogger.log(info);
                return true;
            }

        }
        AccessLogEntry info = new AccessLogEntry(person, this, false);
        this.accessLogger.log(info);
        return false;
    }

    /**
     * gets the universtiy current AccessLogger.
     *
     * @return Current AccessLogger.
     */
    public AccessLogger getAccessLogger() {
        return accessLogger;
    }

    /**
     * gets the emergency Mode for the room.
     *
     * @return the current emergency mode for the room.
     */
    public Boolean getEmergencyMode() {
        return emergencyMode;
    }

    /**
     * Sets the current emergencyMode when observers are notified.
     *
     * @param emergencyMode the current emergency mode.
     */
    @Override
    public void update(boolean emergencyMode) {
        setEmergency(emergencyMode);

    }

    /**
     * Changes the current emergency mode based on parameter.
     *
     * @param emergencyMode true or false boolean.
     */
    public void setEmergency(boolean emergencyMode) {
        this.emergencyMode = emergencyMode;

    }

}
