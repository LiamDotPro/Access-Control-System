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
 * <h1> Access Logger Class </h1>
 *
 * <p>
 * Formats information which is the logged by the base logger class and keeps a
 * list of all entries made.</p>
 *
 * @author Liam Read
 */
public class AccessLogger implements Serializable {

    /**
     * Attributes: Base logger which logs the information once formatted and a
     * list of all access log entries.
     */
    private final BaseLogger logger;
    private final List<AccessLogEntry> loggerEntries;

    /**
     * Default constructor that makes a new instance of the base logger class
     * and a initialises loggerEntries as an ArrayList.
     *
     * @param uniName university name.
     * @param controller Controller associated with the logger.
     */
    public AccessLogger(String uniName, Controller controller) {
        this.logger = new BaseLogger(uniName, controller);
        this.loggerEntries = new ArrayList<>();
    }

    /**
     * logs a new entry.
     *
     * @param entry entry to be logged.
     * @throws IOException something malfunctioned or was damaged while
     * attempting to write.
     */
    public void log(AccessLogEntry entry) throws IOException {
        try {
            logger.createFile(entry.toString());
            System.out.println(entry.toString());
            loggerEntries.add(entry);
        } catch (FileNotFoundException | UnsupportedEncodingException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong while trying to create a log" + e, "Log Error", JOptionPane.WARNING_MESSAGE);
        }

    }

    /**
     * gets the current list of entries.
     *
     * @return current list of entries.
     */
    public List<AccessLogEntry> getLoggerEntries() {
        return loggerEntries;
    }

}
