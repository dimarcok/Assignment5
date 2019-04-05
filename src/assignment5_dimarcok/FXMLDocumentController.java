/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_dimarcok;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Kevin
 */
public class FXMLDocumentController implements Initializable {
    public static final String FILE_PATH = "Patient.dat";

    @FXML 
    private TextField patientID;
    @FXML 
    private TextField patientName;
    @FXML 
    private TextField ownerID;
    
    /**
     * This is the main function to add the Patient to the list. It parses numbers from the patient
     * and owner IDs and makes sure there is a real String for the patients name. It adds this information
     * to a Patient.dat file to be read through the report function
     * 
     * @param event on click
     * @throws FileNotFoundException To make sure FILE_PATH is found
     * @throws IOException  Read/Write exception to Patient.dat file
     * @throws IllegalArgumentException To parse numbers and blank input in text fields
     */
    @FXML
    private void addPatient(ActionEvent event) throws FileNotFoundException, IOException, IllegalArgumentException {
        String name;
        int patientid;
        int ownerid;
        boolean nullName= patientName.getText().trim().isEmpty();
        if  (nullName) { 
            name = "Default";
        } else {
            name = patientName.getText().trim();
        }
        try {
            patientid = Integer.parseInt(patientID.getText());
            ownerid = Integer.parseInt(ownerID.getText());
        } catch (IllegalArgumentException e) {
            patientid = 1234;
            ownerid = 1234;    
        }
        // clears text fields
        patientID.setText("");
        patientName.setText("");
        ownerID.setText("");
        String data = (String) (patientid + " " + name + " " + ownerid + "\n");
        try {
            RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");
            writeFile(FILE_PATH, data, (int) file.length());
            System.out.println(file.length());
        } catch (FileNotFoundException e) {
            System.out.println("Error in try/catch");
        }      
    }
    /**
     * This is the on main report function that opens a second window to show the current patients.
     * It is pulling the information from the Patient.dat that can be written to in the add patient function.
     * This will pull the information in the following order
     * (Patient ID, Patient Name, OwnerID)
     * 
     * @param event on click
     * @throws IOException  Read/Write exception to Patient.dat file 
     */
    @FXML 
    private void report(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPatient.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Reports");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Does not work, Error in report button"); 
        }
    }
    /**
     * This is the write to file function that is called on the add patient button.
     * It keeps the same location from the last written piece to append onto it. 
     * 
     * @param filePath location to file
     * @param data what is being written to file
     * @param location starting location of file
     * @throws FileNotFoundException To make sure FILE_PATH is found
     * @throws IOException  Read/Write exception to Patient.dat file 
     */
    @FXML 
    public static void writeFile(String filePath, String data, int location) 
            throws FileNotFoundException, IOException {
        try {
            RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");
            file.seek(location);
            file.write(data.getBytes());
            file.close();  
    }   catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
