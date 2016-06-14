/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.People;

import AccessSystem.People.BaseInformation.Person;
import AccessSystem.Enumerations.PersonType;
import java.io.Serializable;
import java.util.List;

/**
 * <h1> Cleaner Sub Class </h1>
 *
 * <p>
 * Creates a cleaner based on super class person. </p>
 *
 * @author Liam Read
 *
 */
public class Cleaner extends Person implements Serializable {

    /**
     * Default constructor: String name of person, List of users roles at
     * university and user's id.
     *
     * @param name Users Name.
     * @param roles Users Role.
     * @param id Users ID.
     */
    public Cleaner(String name, List<PersonType> roles, Integer id) {
        super(name, roles, id);
    }

}
