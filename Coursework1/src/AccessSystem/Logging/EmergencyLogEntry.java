/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Logging;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * <h1> Emergency Log Entry Class </h1>
 * <p>
 * Creates a new emergency log entry with all of the information about the
 * emergency. used by the Emergency logger. </p>
 *
 * @author Liam Read
 */
public class EmergencyLogEntry implements Serializable {

    /**
     * Attributes: The current date, The current time, architecture type and reason for emergency.
     */
    private final String date;
    private final String time;
    private final String architectureType;
    private final String reason;

    /**
     * Default Constructor: Initialises date and time as current, sets architecture type and sets emergency reason. 
     * @param architectureType the architecture type to set.
     * @param reason reason for emergency.
     */
    public EmergencyLogEntry(String architectureType, String reason) {
        this.date = LocalDate.now().toString();
        this.time = LocalTime.now().toString();
        this.architectureType = architectureType;
        this.reason = reason;
    }

    /**
     * gets the entry's date.
     * @return the entries date.
     */
    public String getDate() {
        return date;
    }

    /**
     * gets the entry's time.
     * @return the entries time.
     */
    public String getTime() {
        return time;
    }

    /**
     * gets the entry's architecture type.
     * @return the architecture type.
     */
    public String getArchitectureType() {
        return architectureType;
    }

    /**
     * gets the entry's reason for emergency.
     * @return The reason for emergency.
     */
    public String getReason() {
        return reason;
    }

}
