package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ADMController implements Initializable {

    @FXML
    private void ClickButton_Esp(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Especialidade.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setTitle("Controle Especialidade");
            stage.setScene(scene);
            stage.show();
        } catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @FXML
    private void ClickButton_Plan(ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Plano.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setTitle("Controle Plano de Saúde");
            stage.setScene(scene);
            stage.show();
        } catch(Exception ex){
            ex.printStackTrace();
        }

         }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    



    
    
    
}
