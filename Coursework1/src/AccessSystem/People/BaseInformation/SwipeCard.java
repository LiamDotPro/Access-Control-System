/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.People.BaseInformation;

import AccessSystem.Enumerations.PersonType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1> SwipeCard Class </h1>
 * <p>
 * The swipe card class provides a user with a Swipecard that is used to access
 * rooms within the university. </p>
 *
 * @author Liam Read
 */
public final class SwipeCard implements Serializable {

    /**
     * Attributes: Integer ID for Swipecard, A primary role, A List of all
     * secondary roles,.
     */
    private Integer id;
    private PersonType primaryRole;
    private final List<PersonType> secondaryRoles;

    /**
     * Default Constructor: List of persons roles and ID number.
     *
     * @param roles List of persons roles.
     * @param id ID number for Swipecard.
     */
    public SwipeCard(List<PersonType> roles, Integer id) {
        try {
            this.id = id;
        } catch (NullPointerException e) {
        }
        this.secondaryRoles = new ArrayList<>();
        setRoles(roles);
    }

    /**
     * Gets the ID number associated with the Swipecard.
     *
     * @return Current SwipeCards ID Number.
     */
    public Integer getID() {
        return this.id;
    }

    /**
     * Get users primary role.
     *
     * @return Users primary role.
     */
    public PersonType getPrimaryRole() {
        return this.primaryRole;
    }

    /**
     * Get all secondary roles.
     *
     * @return All users Secondary roles.
     */
    public List<PersonType> getSecondaryRoles() {
        return this.secondaryRoles;
    }

    /**
     * Clear all Roles from user.
     */
    public void clearRoles() {
        this.primaryRole = null;
        this.secondaryRoles.clear();
    }

    /**
     * Sets roles for a users Swipecard.
     *
     * @param personRoles A list of all users roles.
     */
    public void setRoles(List<PersonType> personRoles) {
        try {
            this.primaryRole = personRoles.get(0);

            for (int x = 1; x < personRoles.size(); x++) {
                this.secondaryRoles.add(personRoles.get(x));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Insufficent Roles for Secondary Roles");
        }

    }
}
