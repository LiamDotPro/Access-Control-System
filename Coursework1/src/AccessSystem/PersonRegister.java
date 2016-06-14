/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem;

import AccessSystem.People.BaseInformation.InformationStructPeople;
import AccessSystem.People.BaseInformation.Person;
import AccessSystem.Factories.PersonFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * <h1>Person Register</h1>
 * <p>
 * The person register is a collection of people that is held within the
 * PersonList Attribute. Alongside this the class also contains a list of
 * assigned ID's which stop duplicate id's from being created.</p>
 *
 * @author Liam Read
 */
public class PersonRegister implements Serializable {

    /**
     * Attributes; List of people, List of AssignedID's and Random Number
     * Generator.
     */
    private final List<Person> PersonList;
    private final List<Integer> AssignedIds;
    private final Random randomGenerator = new Random();

    /**
     * Default Constructor: Instantiates Lists as new ArrayLists.
     */
    public PersonRegister() {
        this.PersonList = new ArrayList<>();
        this.AssignedIds = new ArrayList<>();
    }

    /**
     * adds a person to the current person register.
     *
     * @param info Persons starting information.
     */
    public void addPerson(InformationStructPeople info) {
        this.PersonList.add(new PersonFactory().createPerson(info.name, info.role, assignid()));

        sortUserList();
    }

    /**
     * Add new people to the current register(PersonList).
     *
     * @param info Class that contains information about the people such as name
     * and list of roles.
     */
    public void addRegister(List<InformationStructPeople> info) {
        info.stream().forEach((a) -> {
            this.PersonList.add(new PersonFactory().createPerson(a.name, a.role, assignid()));
        });

        sortUserList();
    }

    /**
     * Generates a random number using the RandomNumber Attribute then checks it
     * against the current assignedId's. using the IsIdAvaliable Method.
     *
     * @return A Unique ID for the user.
     */
    private Integer assignid() {
        Integer randomNumber = 2000 + randomGenerator.nextInt((9999999 - 2000) + 1);

        while (isIdAvliable(randomNumber) == false) {
            randomNumber = 2000 + randomGenerator.nextInt((9999999 - 2000) + 1);
        }
        this.AssignedIds.add(randomNumber);
        return randomNumber;
    }

    /**
     * Takes a generated Number and checks it against the already assigned ID's.
     *
     * @param ID A randomly generated number to be checked against already
     * assigned ID's.
     * @return Boolean If AssignedIds is empty return true for first ID,
     * Thereafter if counter goes above 0 return false.
     */
    private boolean isIdAvliable(Integer ID) {

        Integer counter = 0;
        if (this.AssignedIds.isEmpty() == false) {
            for (Integer Assigned : AssignedIds) {
                if (Objects.equals(ID, Assigned)) {
                    counter++;
                }
            }

            return counter <= 0;

        }
        return true;
    }

    /**
     * Get the current register.
     *
     * @return The associated personList.
     */
    public List<Person> getRegister() {
        return this.PersonList;
    }

    /**
     * Clears the current personList.
     */
    public void clearRegister() {
        this.PersonList.clear();
    }

    /**
     * Sorts the current user list into alphabetical order.
     */
    public void sortUserList() {
        Collections.sort(PersonList, (Person person1, Person person2) -> person1.getName().compareTo(person2.getName()));
    }
}
