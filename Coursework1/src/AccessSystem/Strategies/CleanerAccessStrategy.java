/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Strategies;

import AccessSystem.Architecture.Room;
import AccessSystem.Enumerations.PersonType;
import AccessSystem.Enumerations.RoomType;
import java.io.Serializable;

/**
 * <h1> Cleaner Access Strategy Class  </h1>
 * <p>
 * Implements the strategy for accessing a room as a cleaner within the data
 * model.
 * <p>
 *
 * @author Liam Read
 */
public class CleanerAccessStrategy implements IAccessStrategy, Serializable {

    /**
     * No arguments Constructor.
     */
    public CleanerAccessStrategy() {

    }

    /**
     * Can the user Access the room.
     *
     * @param room The current Room
     * @return Boolean based on time and if room is secure
     */
    @Override
    public boolean canAccess(Room room) {
        if (room.getRoomFunctionality().contains(RoomType.SECUREROOM)) {
            return false;
        } else if (PersonType.CLEANER.findTimeRanges()) {
            return true;
        }
        return false;
    }
}
