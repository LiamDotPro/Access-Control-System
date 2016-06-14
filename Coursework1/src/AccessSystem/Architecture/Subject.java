/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Architecture;

/**
 * <h1> Subject Interface </h1>
 * <p>
 * Allows functionality for different architectures to view and subscriber to
 * any changes being made. This works alongside the observer interface. </p>
 *
 */
public interface Subject {

    /**
     * Allows an object to register observers.
     * @param observer an observer for a class.
     */
    public void registerObserver(Observers observer);

    /**
     * Allows an object to notify observers of changes.
     */
    public void notifyObservers();

}
