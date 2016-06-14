/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Strategies;

import AccessSystem.Architecture.Room;
import java.io.Serializable;

/**
 * <h1> Security Access Strategy Class  </h1>
 * <p>
 * Implements the strategy for accessing a room as a Security Person within the
 * data model.
 * <p>
 *
 * @author Liam Read
 */
public class SecurityAccessStrategy implements IAccessStrategy, Serializable {

    /**
     * No arguments Constructor.
     */
    public SecurityAccessStrategy() {
    }

    /**
     * Can a security person enter the room.
     *
     * @param room The current room.
     * @return Boolean of true or false.
     */
    @Override
    public boolean canAccess(Room room) {
        return true;
    }

}
