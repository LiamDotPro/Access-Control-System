/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Architecture;

/**
 * <h1> Observer Interface </h1>
 * <p>
 * Allows functionality for different architectures to view and subscriber to
 * any changes being made. This works alongside the subject interface. </p>
 *
 * @author Liam Read
 */
public interface Observers {

    /**
     * Updates the observers based on some form of change.
     * @param emergencyMode the current emergency mode.
     */
    public void update(boolean emergencyMode);
}
