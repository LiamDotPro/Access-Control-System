/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessSystem.Logging;

import AccessSystem.Controller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * <h1> base Logger Class </h1>
 * <p>
 * Provides all of the base structure that is needed to write a file, create a
 * folder, copy current log and save university data model. Decorations of the
 * logger decorate the information. </p>
 *
 * @author Liam Read
 */
public class BaseLogger implements Serializable {

    /**
     * Attributes: The file name.
     */
    private Controller controller;
    private String fileName;
    private String currentLogPath;
    private String folderName;

    /**
     * Default constructor: get an instance of the current date and uses it as
     * part of the file name.
     *
     * @param uniName universities name.
     * @param controller controller associated.
     */
    public BaseLogger(String uniName, Controller controller) {
        this.fileName = "UserAccess " + uniName;
        this.controller = controller;
    }

    /**
     * Creates an emergency folder and then copies the associated log to the folder.
     * @param controller Associated controller.
     * @param uniName university name.
     * @throws IOException malfunctioned write or copy of file or folder.
     */
    public void EmergencyWrite(Controller controller, String uniName) throws IOException {
        this.controller = controller;
        this.fileName = "UserAccess " + uniName;
        this.currentLogPath = Paths.get(this.fileName + ".txt").toString();
        CreateFolder();
        CopyCurrentLog();
    }

    /**
     * Creates a file and writes information to it before closing.
     *
     * @param information The string information to be written.
     * @throws FileNotFoundException File has not been found.
     * @throws UnsupportedEncodingException The encoding type chosen was not
     * correct.
     */
    public void createFile(String information) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        if (new File(fileName + ".txt").exists() == false) {
            try {
                System.out.println(information);
                try (PrintWriter writer = new PrintWriter(fileName + ".txt", "UTF-8")) {
                    writer.println(information);
                    writer.close();
                }
            } catch (FileNotFoundException e) {
                System.out.println("File was not found");
            } catch (UnsupportedEncodingException e) {

            }
        } else {
            updateFile(information);
        }
    }

    /**
     * Updates information in the current log file if found.
     *
     * @param information information to be updated.
     * @throws FileNotFoundException The file was not found to update.
     * @throws UnsupportedEncodingException The encoding of the file is not
     * correct.
     * @throws IOException something malfunctioned or was damaged while writing.
     */
    private void updateFile(String information) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".txt", true)))) {
            out.println(information);
            out.close();
        }

    }

    /**
     * Creates a new folder for an emergency log.
     *
     * @throws UnsupportedEncodingException The encoding of the file is not
     * correct
     * @throws IOException something malfunctioned or was damaged while writing.
     */
    private void CreateFolder() throws UnsupportedEncodingException, IOException {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh mm ss");
        String time = dateFormat.format(now);
        this.folderName = "EM_" + time;
        new File(folderName).mkdir();
    }

    /**
     * copies the current log file to the new emergency folder and saves current
     * university model as .ser
     *
     * @throws IOException something malfunctioned or was damaged while writing.
     */
    private void CopyCurrentLog() throws IOException {
        try {
            Files.copy(Paths.get(currentLogPath), Paths.get(this.folderName + "\\Log.txt"), COPY_ATTRIBUTES);
        } catch (NoSuchFileException e) {
            JOptionPane.showMessageDialog(null, "No one has attempted to access a Room within the university", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
        }
        try {

            FileOutputStream fileOut = new FileOutputStream(this.folderName + "\\EmergencyState.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.controller);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException ex) {
            System.out.println("The file was not found");
        } catch (IOException ex) {
            System.out.println("Serialization problems occured. " + ex.getMessage() + Arrays.toString(ex.getStackTrace()));
        }
        System.out.printf("Serialized data is saved in" + this.folderName);
    }
}
