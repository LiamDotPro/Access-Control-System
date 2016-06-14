/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Strategies;

import AccessSystem.Architecture.Room;
import AccessSystem.Enumerations.PersonType;
import static AccessSystem.Enumerations.RoomType.LECTUREHALL;
import static AccessSystem.Enumerations.RoomType.RESEARCHLAB;
import static AccessSystem.Enumerations.RoomType.STAFFROOM;
import static AccessSystem.Enumerations.RoomType.STUDENTLAB;
import java.io.Serializable;

/**
 * <h1> Staff Member Access Strategy Class  </h1>
 * <p>
 * Implements the strategy for accessing a room as a Staff Member within the
 * data model.
 * <p>
 *
 * @author Liam Read
 */
public class StaffMemberAccessStrategy implements IAccessStrategy, Serializable {

    /**
     * No arguments Constructor.
     */
    public StaffMemberAccessStrategy() {
    }

    /**
     * Can a staff member access the room.
     *
     * @param room The current room.
     * @return Boolean of true or false.
     */
    @Override
    public boolean canAccess(Room room) {
        // Specifically use contains for all rooms otherwise if more rooms are added in the future they will inheritantly have access.
        if ((room.getRoomFunctionality().contains(LECTUREHALL)) || (room.getRoomFunctionality().contains(STUDENTLAB)) || (room.getRoomFunctionality().contains(RESEARCHLAB)) || (room.getRoomFunctionality().contains(STAFFROOM))) {
            if (PersonType.STAFFMEMBER.findTimeRanges()) {
                return true;
            }
        }
        return false;
    }

}
