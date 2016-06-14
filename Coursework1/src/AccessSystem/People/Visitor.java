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
 * <h1> Visitor Sub Class </h1>
 *
 * <p>
 * Creates a Visitor based on super class person. </p>
 *
 * @author Liam Read
 */
public class Visitor extends Person implements Serializable  {

    /**
     * Default Constructor: Default constructor: String name of person, List of
     * users roles at university and user's id.
     *
     * @param name Users name.
     * @param roles Users roles at university.
     * @param id Users ID.
     */
    public Visitor(String name, List<PersonType> roles, Integer id) {
        super(name, roles, id);
    }
}
