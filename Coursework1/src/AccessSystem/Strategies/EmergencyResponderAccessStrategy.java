/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Strategies;

import AccessSystem.Architecture.Room;
import java.io.Serializable;

/**
 * <h1> Emergency Responder Access Strategy Class  </h1>
 * <p>
 * Implements the strategy for accessing a room as an Emergency Responder within
 * the data model.
 * <p>
 * @author Liam Read
 */
public class EmergencyResponderAccessStrategy implements IAccessStrategy, Serializable {

    /**
     * No arguments Constructor.
     */
    public EmergencyResponderAccessStrategy() {
    }

    /**
     * If the room is in emergency mode grant access.
     *
     * @param room The current Room.
     * @return Boolean based on if the room is in emergency mode.
     */
    @Override
    public boolean canAccess(Room room) {
        return room.getIsEmergency() == true;
    }

}
