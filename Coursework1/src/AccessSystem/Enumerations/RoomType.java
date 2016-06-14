/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Enumerations;

import java.io.Serializable;

/**
 * <h1> Enumeration of Room Types </h1>
 * <p>
 * Contains enumerations of all the different rooms that can be created within
 * the system. </p>
 *
 * @author Liam Read
 */
public enum RoomType implements Serializable {

    /**
     * This room is used to deliver lectures to students.
     */
    LECTUREHALL,
    /**
     * This room is used to deliver practical lessons to students.
     */
    STUDENTLAB,
    /**
     * This lab is used for the universities research projects. It is not
     * normally accessible by students.
     */
    RESEARCHLAB,
    /**
     * This room is accessible to the university staff and management teams.
     * These are lecturer’s offices and university administration rooms. It is
     * not normally accessible by students.
     */
    STAFFROOM,
    /**
     * These rooms hold sensitive or dangerous equipment or chemicals. A member
     * of the university security OR management team must grant access to these
     * rooms.
     */
    SECUREROOM;
}
