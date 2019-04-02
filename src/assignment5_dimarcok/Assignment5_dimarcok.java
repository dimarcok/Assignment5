/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5_dimarcok;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kevin
 */
public class Assignment5_dimarcok extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private static byte[] readFile(String filePath, int location, int size) throws FileNotFoundException, IOException {
        RandomAccessFile file = new RandomAccessFile("Patient.dat", "r");
        file.seek(location);
        byte[] bytes = new byte[size];
        file.read(bytes);
        file.close();
        return bytes;    
    }
    private static void writeFile(String filePath, String data, int location) throws FileNotFoundException, IOException {
        RandomAccessFile file = new RandomAccessFile("Patient.dat", "rw");
        file.seek(location);
        file.write(data.getBytes());
        file.close();
        
    }
    
}
