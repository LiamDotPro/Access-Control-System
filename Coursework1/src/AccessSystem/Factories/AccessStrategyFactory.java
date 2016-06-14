/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Factories;

import AccessSystem.Enumerations.PersonType;
import AccessSystem.Strategies.CleanerAccessStrategy;
import AccessSystem.Strategies.EmergencyResponderAccessStrategy;
import AccessSystem.Strategies.IAccessStrategy;
import AccessSystem.Strategies.ManagerAccessStrategy;
import AccessSystem.Strategies.SecurityAccessStrategy;
import AccessSystem.Strategies.StaffMemberAccessStrategy;
import AccessSystem.Strategies.StudentAccessStrategy;
import AccessSystem.Strategies.VisitorAccessStrategy;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;

/**
 * <h1> Access Strategy Factory </h1>
 * <p>
 * Uses a Hashmap to assign strategies to different types of PersonType, returns
 * a strategy based on the person.</p>
 *
 * @author Liam Read
 */
public class AccessStrategyFactory implements Serializable{

    /**
     * Hashmap of Strategy's.
     */
    private final Map<PersonType, IAccessStrategy> Strategies;

    /**
     * Default Constructor: Assigns the Hashmap with appropriate strategy's.
     */
    public AccessStrategyFactory() {

        //Default Constrcutor - Converts class into EnumMap
        this.Strategies = new EnumMap<>(PersonType.class);

        // Allocate strategy to personType.
        this.Strategies.put(PersonType.CLEANER, new CleanerAccessStrategy());
        this.Strategies.put(PersonType.VISITOR, new VisitorAccessStrategy());
        this.Strategies.put(PersonType.STUDENT, new StudentAccessStrategy());
        this.Strategies.put(PersonType.STAFFMEMBER, new StaffMemberAccessStrategy());
        this.Strategies.put(PersonType.MANAGER, new ManagerAccessStrategy());
        this.Strategies.put(PersonType.SECURITY, new SecurityAccessStrategy());
        this.Strategies.put(PersonType.EMERGENCYRESPONDER, new EmergencyResponderAccessStrategy());
    }

    /**
     *  Create a strategy for a person.
     * @param person The person trying to access the room.
     * @return The specific personTypes strategy.
     */
    public IAccessStrategy createStrategy(PersonType person) {
        return Strategies.get(person);
    }

}
