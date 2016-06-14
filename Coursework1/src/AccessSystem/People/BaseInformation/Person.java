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
 * <h1> Person Class</h1>
 * <p>
 * Holds all of the generic information about a user. </p>
 *
 * @author li
 * @version 1.0
 */
public abstract class Person implements Serializable {

    /**
     * Attributes: String name of person, Swipecard of the person, Primary role
     * of the person and List of all secondary roles.
     */
    private String name;
    private SwipeCard swipecard;

    /**
     * Default Constructor: Persons name, There roles within the university and
     * there ID.
     *
     * @param name Person name.
     * @param roles Persons roles.
     * @param id Persons ID.
     */
    public Person(String name, List<PersonType> roles, Integer id) {
        try {
            this.name = name;
            this.swipecard = new SwipeCard(roles, id);
        } catch (NullPointerException e) {
            System.out.println("A null reference was passed.");
        }

    }

    /**
     * get current users name.
     *
     * @return current users name.
     */
    public String getName() {
        if (this.name == null) {
            throw new NullPointerException("Name can not be set as null");
        }
        return this.name;
    }

    /**
     * Gets current users Swipecard.
     *
     * @return Current users Swipecard.
     */
    public SwipeCard getSwipeCard() {
        return this.swipecard;
    }

}
