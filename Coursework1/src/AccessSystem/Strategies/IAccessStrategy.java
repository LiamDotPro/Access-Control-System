/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Strategies;

import AccessSystem.Architecture.Room;


/**
 * <h1> IAccess Strategy Interface </h1>
 * <p>
 * Each strategy will have a can access method. </p>
 *
 * @author Liam Read
 */
public interface IAccessStrategy {

    /**
     * Can Access the room.
     *
     * @param room The current Room.
     * @return Boolean of yes or no as true or false.
     */
    public boolean canAccess(Room room);

}
