/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_dimarcok;

//import static assignment5_dimarcok.FXMLPatientController.readFile;
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
    private Label title;
    @FXML 
    private TextField patientID;
    @FXML 
    private TextField patientName;
    @FXML 
    private TextField ownerID;
    
    @FXML
    private void addPatient(ActionEvent event) throws IOException, IllegalArgumentException {
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
