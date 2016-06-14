/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Strategies;

import AccessSystem.Architecture.Room;
import AccessSystem.Enumerations.PersonType;
import java.io.Serializable;

/**
 * <h1> Manager Access Strategy Class  </h1>
 * <p>
 * Implements the strategy for accessing a room as a manager within the data
 * model.
 * <p>
 * @author Liam Read
 */
public class ManagerAccessStrategy implements IAccessStrategy, Serializable {

    /**
     * No arguments Constructor.
     */
    public ManagerAccessStrategy() {
    }

    /**
     * Can a manager Access the room.
     *
     * @param room The current room.
     * @return Boolean of true or false.
     */
    @Override
    public boolean canAccess(Room room) {
        if (room.getIsEmergency() != true) {
            if (PersonType.MANAGER.findTimeRanges()) {
                return true;
            }
        }
        return false;
    }

}
