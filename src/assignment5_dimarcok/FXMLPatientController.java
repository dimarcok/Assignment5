/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_dimarcok;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kevin
 */
public class FXMLPatientController implements Initializable {
    public static final String FILE_PATH = "Patient.dat";
    
    @FXML
    private Label fullList;
    

    public ArrayList<String> readFile(String filePath, int location) 
            throws FileNotFoundException, IOException {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        try {
            RandomAccessFile file = new RandomAccessFile(FILE_PATH, "r");
            RandomAccessFile file2 = new RandomAccessFile(FILE_PATH, "r");
            file.seek(location);
            while (file2.readLine() != null) {
                list.add(file.readLine());
                fullList.setText(fullList.getText() + list.get(i) + "\n");
                i++;
            }
            file.close();
            return list; 
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }       
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            readFile(FILE_PATH, 0);
        } catch (IOException e) {
            System.out.println("Error in readFile");
        }
        
        
    }    
    
}
