/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Strategies;

import AccessSystem.Architecture.Room;
import AccessSystem.Enumerations.PersonType;
import static AccessSystem.Enumerations.RoomType.LECTUREHALL;
import java.io.Serializable;

/**
 * <h1> Visitor Access Strategy Class  </h1>
 * <p>
 * Implements the strategy for accessing a room as a visitor within the data
 * model.
 * <p>
 *
 * @author Liam Read
 */
public class VisitorAccessStrategy implements IAccessStrategy, Serializable {

    /**
     * No arguments Constructor.
     */
    public VisitorAccessStrategy() {
    }

    /**
     * Can a visitor enter the room.
     *
     * @param room The current room.
     * @return Boolean value of true or false.
     */
    @Override
    public boolean canAccess(Room room) {
        if (room.getRoomFunctionality().contains(LECTUREHALL)) {
            if (PersonType.VISITOR.findTimeRanges()) {
                return true;
            }
        }
        return false;
    }

}
