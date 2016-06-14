/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Enumerations;

import AccessSystem.People.BaseInformation.TimeRanges;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * <h1> Enumeration of Persons </h1>
 * <p>
 * Contains all of the different types of people that can exist, Uses
 * personFactory for creation of people. Also finds the current time ranges for
 * the different personTypes.  </p>
 *
 * @author Liam Read
 */
public enum PersonType implements Serializable{

    /**
     * A student enrolled on a course at the university. In “normal mode”
     * students have time restricted access to lecture halls and student labs.
     * Students can only access these rooms between 08:30 and 22:00. In
     * “emergency mode” they have no access to any room.
     */
    STUDENT,
    /**
     * A cleaner who visits the university at certain times. In “normal mode”
     * cleaners have time restricted access to all rooms EXCEPT for secured
     * rooms which they cannot access. Cleaners access is restricted to the
     * following time periods: Morning – 05:30 to 10:30 Evening – 17:30 to 22:30
     *
     * In “emergency mode” cleaners cannot access any room at any time.
     *
     */
    CLEANER,
    /**
     * A member of the teaching staff. In “normal mode” staff have time
     * restricted access to lecture halls, student labs, research labs and staff
     * rooms. Staff members can access these rooms between 05:30 and 23:59:59.
     * In “emergency mode” they have no access to any room.
     */
    STAFFMEMBER,
    /**
     * All non-staff or student users.In “normal mode” visitors have time
     * restricted access to lecture halls only. Visitors can access these rooms
     * between 08:30 and 22:00. In “emergency mode” they have no access to any
     * room.
     */
    VISITOR,
    /**
     * A University management team member with extra access privileges.A
     * manager can access any room at any time UNLESS the system is in
     * “emergency mode” when they have no access to any room.
     */
    MANAGER,
    /**
     * A member of the university security team. Security staff can access any
     * room at any time regardless of the systems operating mode.
     */
    SECURITY,
    /**
     * An emergency “first responder” – police, fire and ambulance staff. This
     * type of user can access any room when it is in “emergency mode”. In
     * “normal mode” they have no access to any room.
     */
    EMERGENCYRESPONDER;
    
    /**
     * Takes a list of personTypes and checks if there allowed entry at the
     * specific time.
     *
     *
     * @return Boolean if they are allowed entry at this time.
     */
    public boolean findTimeRanges() {

        TimeRanges timeRangeInfo;

        switch (this) {

            case STUDENT:
                timeRangeInfo = new TimeRanges(LocalTime.of(8, 30), LocalTime.of(22, 00));

                if (timeRangeInfo.isBetweenRanges(LocalTime.now())) {
                    return true;
                }
                break;

            case CLEANER:
                timeRangeInfo = new TimeRanges(LocalTime.of(5, 30), LocalTime.of(10, 30));

                if (timeRangeInfo.isBetweenRanges(LocalTime.now())) {
                    return true;
                }

                timeRangeInfo = new TimeRanges(LocalTime.of(17, 30), LocalTime.of(22, 30));

                if (timeRangeInfo.isBetweenRanges(LocalTime.now())) {
                    return true;
                }
                break;

            case STAFFMEMBER:
                timeRangeInfo = new TimeRanges(LocalTime.of(5, 30), LocalTime.of(23, 59, 59));

                if (timeRangeInfo.isBetweenRanges(LocalTime.now())) {
                    return true;
                }
                break;

            case VISITOR:
                timeRangeInfo = new TimeRanges(LocalTime.of(8, 30), LocalTime.of(22, 00));

                if (timeRangeInfo.isBetweenRanges(LocalTime.now())) {
                    return true;
                }
                break;

            case MANAGER:
                return true;

            case SECURITY:
                return true;

            case EMERGENCYRESPONDER:
                return true;
        }

        return false;
    }
}
