/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.People.BaseInformation;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * <h1> Time Ranges Class </h1>
 * <p>
 * Finds if a a user has access to a room using provided time Ranges. </p>
 *
 * @author Liam Read
 */
public class TimeRanges implements Serializable {

    /**
     * Attributes: A start time to check and an end time to check.
     */
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime timeToCheck;

    /**
     * Default Constructor: A start time to check and an end time to check.
     *
     * @param start The start time.
     * @param end The end time.
     */
    public TimeRanges(LocalTime start, LocalTime end) {
        try {
            startTime = start;
            endTime = end;
        } catch (NullPointerException e) {
            System.out.println("Starting and / or end time can not be null.");
        }
    }

    /**
     * Checks if the current time is between the start and end time provided.
     *
     * @param time The current time.
     * @return A boolean if the current time is between the start and end time.
     */
    public boolean isBetweenRanges(LocalTime time) {
        try {
            this.timeToCheck = time;

        } catch (NullPointerException e) {
            System.out.println("Passed time can not be null");
        }
        return timeToCheck.isAfter(startTime) && time.isBefore(endTime);
    }

}
