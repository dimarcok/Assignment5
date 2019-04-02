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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Kevin
 */
public class FXMLDocumentController implements Initializable {
    public static final String FILE_PATH = "C:/Users/Kevin/NetBeansProjects/Assignment5_dimarcok/Patient.dat";
    
    @FXML
    private Label title;
    @FXML 
    private TextField patientID;
    @FXML 
    private TextField patientName;
    @FXML 
    private TextField ownerID;
    
    @FXML
    private void addPatient(ActionEvent event) {
        String name = patientName.getText();
        
        try {
            int patientid = Integer.parseInt(patientID.getText());
            int ownerid = Integer.parseInt(ownerID.getText());
        } catch (IllegalArgumentException e) {
            int patientid = 1234;
            int ownerid = 1234;
            
        }
    }
    @FXML 
    private void report(ActionEvent event) {
        // this is a comment
    }
    public static byte[] readFile(String filePath, int size, int location) throws FileNotFoundException, IOException {
        RandomAccessFile file = new RandomAccessFile("Patient.dat", "r");
        file.seek(location);
        byte[] bytes = new byte[size];
        file.read(bytes);
        file.close();
        return bytes;    
    }
    public static void writeFile(String filePath, String data, int location) throws FileNotFoundException, IOException {
        RandomAccessFile file = new RandomAccessFile("Patient.dat", "rw");
        file.seek(location);
        file.write(data.getBytes());
        file.close();  
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
