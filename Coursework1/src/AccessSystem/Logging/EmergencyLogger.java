/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Logging;

import AccessSystem.Controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * <h1> Emergency Logger Class </h1>
 * <p>
 * Creates a new emergency log using the emergency log entry class. </p>
 *
 * @author Liam Read
 */
public class EmergencyLogger implements Serializable {

    /**
     * Attributes: list of all emergency entries and base logger which logs the
     * data.
     */
    private final List<EmergencyLogEntry> LoggerEntries;
    private final BaseLogger logger;

    /**
     * Default Constructor: creates a new base logger and passes university name
     * and initialises logger entries as ArrayList.
     *
     * @param uniName university name.
     * @param controller associated controller.
     */
    public EmergencyLogger(String uniName, Controller controller) {
        this.logger = new BaseLogger(uniName, controller);
        this.LoggerEntries = new ArrayList<>();
    }

    /**
     * Logs an emergency in the university.
     *
     * @param entry the entry to be logged.
     * @param controller The current university to save.
     * @param uniName The university name.
     * @throws IOException Exception is thrown is malfunctioned while writing or
     * damaged while writing
     */
    public void log(EmergencyLogEntry entry, Controller controller, String uniName) throws IOException {
        try {
            logger.EmergencyWrite(controller, uniName);
            LoggerEntries.add(entry);
        } catch (FileNotFoundException | UnsupportedEncodingException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong while trying to create a log" + e, "Log Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * gets the current emergency entries.
     *
     * @return all of the current emergency entries.
     */
    public List<EmergencyLogEntry> getLoggerEntries() {
        return LoggerEntries;
    }

}
