/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Strategies;

import AccessSystem.Architecture.Room;
import AccessSystem.Enumerations.PersonType;
import static AccessSystem.Enumerations.RoomType.LECTUREHALL;
import static AccessSystem.Enumerations.RoomType.STUDENTLAB;
import java.io.Serializable;

/**
 * <h1> Student Access Strategy Class  </h1>
 * <p>
 * Implements the strategy for accessing a room as a Student within the data
 * model.
 * <p>
 *
 * @author Liam Read
 */
public class StudentAccessStrategy implements IAccessStrategy, Serializable {

    /**
     * No arguments Constructor.
     */
    public StudentAccessStrategy() {

    }

    /**
     * Can a student access the current room.
     *
     * @param room The current room.
     * @return Boolean of true or false.
     */
    @Override
    public boolean canAccess(Room room) {
        if ((room.getRoomFunctionality().contains(LECTUREHALL)) || (room.getRoomFunctionality().contains(STUDENTLAB))) {
            if (PersonType.STUDENT.findTimeRanges()) {
                return true;
            }
        }
        return false;
    }

}
