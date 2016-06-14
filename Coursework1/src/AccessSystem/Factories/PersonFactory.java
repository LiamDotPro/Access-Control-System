/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Factories;

import AccessSystem.Enumerations.PersonType;
import AccessSystem.People.Cleaner;
import AccessSystem.People.EmergencyResponder;
import AccessSystem.People.Manager;
import AccessSystem.People.Security;
import AccessSystem.People.StaffMember;
import AccessSystem.People.Student;
import AccessSystem.People.Visitor;
import AccessSystem.People.BaseInformation.Person;
import java.io.Serializable;
import java.util.List;

/**
 * <h1> Person Factory Class </h1>
 * <p>
 * The Person factory class creates instances of people and can be used like a
 * catalog for creation. Complex factory pattern. </p>
 *
 * @author Liam Read
 */
public class PersonFactory implements Serializable {

    /**
     * Default Constructor: needed for Serializable.
     */
    public PersonFactory() {
    }

    /**
     * Person is created via factory InformationStruct is used to create classes
     * through parameters in personRegister
     *
     * @param name Users name.
     * @param roles Users roles.
     * @param id users id's.
     * @return A new instance of person based on primary role.
     */
    public Person createPerson(String name, List<PersonType> roles, Integer id) {
        Person result = null;
        try {
            PersonType primaryRole = roles.get(0);
            switch (primaryRole) {
                case CLEANER:
                    result = new Cleaner(name, roles, id);
                    break;

                case MANAGER:
                    result = new Manager(name, roles, id);
                    break;

                case EMERGENCYRESPONDER:
                    result = new EmergencyResponder(name, roles, id);
                    break;

                case SECURITY:
                    result = new Security(name, roles, id);
                    break;

                case VISITOR:
                    result = new Visitor(name, roles, id);
                    break;

                case STUDENT:
                    result = new Student(name, roles, id);
                    break;

                case STAFFMEMBER:
                    result = new StaffMember(name, roles, id);
                    break;
            }

        } catch (NullPointerException e) {
            System.out.println("primary roles can not be 0");
        }
        return result;
    }

}
