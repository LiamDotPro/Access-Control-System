/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.People.BaseInformation;

import AccessSystem.Enumerations.PersonType;
import java.io.Serializable;
import java.util.List;

/**
 * <h1> Information Struct People Class</h1>
 * <p>
 * This struct is a basic template for all of the attributes needed to create a
 * person.</p>
 *
 * @author Liam Read
 */
public class InformationStructPeople implements Serializable {

    /**
     * A users name.
     */
    public String name;

    /**
     * A list of users roles.
     */
    public List<PersonType> role;

    /**
     * Sets a users name;
     *
     * @param name Users name.
     */
    public void setName(String name) {
        if (name == null) {
            throw new NullPointerException("No name specfied in information struct.");
        }
        this.name = name;
    }

    /**
     * sets a list of user roles.
     *
     * @param roles List of user Roles.
     */
    public void setRoles(List<PersonType> roles) {
        if (name == null) {
            throw new NullPointerException("no roles passed.");
        }
        this.role = roles;
    }

    /**
     * No arguments Constructor.
     */
    public InformationStructPeople() {

    }
}
