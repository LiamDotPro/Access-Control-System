/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Logging;

import AccessSystem.Architecture.Room;
import AccessSystem.People.BaseInformation.Person;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <h1> Access Log Entry Class </h1>
 *
 * <p>
 * Provides a template for information that is needed to create a new log of
 * information</p>
 *
 * @author Liam Read
 */
public class AccessLogEntry implements Serializable {

    /**
     * Attributes: Access time, User names, Id number, Building code, Floor
     * name, room number and if the permission is granted.
     */
    private final String accessTime;
    private final String userName;
    private final Integer idNumber;
    private final String buildingCode;
    private final String floorName;
    private final String roomNumber;
    private final String permissionGranted;

    /**
     * Default Constructor.
     *
     * @param person The person.
     * @param room The room there accessing.
     * @param permission If permission was granted.
     */
    public AccessLogEntry(Person person, Room room, Boolean permission) {
        this.userName = person.getName();
        this.idNumber = person.getSwipeCard().getID();
        this.buildingCode = room.getBuildingCode();
        this.floorName = room.getFloorName();
        this.roomNumber = room.getRoomNumber().toString();
        this.accessTime = setAccessTime();
        this.permissionGranted = permission.toString();
    }

    /**
     * Gets the current access time.
     *
     * @return The current date.
     */
    private String setAccessTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");

        String currentTime = df.format(new Date());

        return currentTime;
    }

    /**
     * Gets the username in the entry.
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * gets the users ID number.
     *
     * @return Id number.
     */
    public Integer getIDnumber() {
        return idNumber;
    }

    /**
     * Gets the buildings code.
     *
     * @return building code.
     */
    public String getBuildingCode() {
        return buildingCode;
    }

    /**
     * gets the entries floor Name.
     *
     * @return the floors name
     */
    public String getFloorName() {
        return floorName;
    }

    /**
     * gets the entries room number.
     *
     * @return Room number.
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * gets if permission was granted or not.
     *
     * @return permission granted.
     */
    public String getPermissionGranted() {
        return permissionGranted;
    }

    /**
     * gets the entries access time.
     *
     * @return time of attempt.
     */
    public String getAccessTime() {
        return this.accessTime;
    }

    /**
     * Specialised to string method.
     *
     * @return A formatted string of entry for logging.
     */
    @Override
    public String toString() {
        return "AccessLogEntry{" + "AccessTime=" + accessTime + ", UserName=" + userName + ", IDnumber=" + idNumber + ", BuildingCode=" + buildingCode + ", FloorName=" + floorName + ", RoomNumber=" + roomNumber + ", PermissionGranted=" + permissionGranted + '}';
    }

}
