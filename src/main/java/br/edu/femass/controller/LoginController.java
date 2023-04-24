package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable{

    @FXML
    private TextField TxtLogin; 

    @FXML
    private PasswordField Senha;

    @FXML
    private void Logar_button(ActionEvent event){

        String usuario = TxtLogin.getText();
        String Senha1 = Senha.getText();
      try{

        if(usuario.equals("adm") && Senha1.equals("123456") ){

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ADM.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
    
            stage.setTitle("Adminintração");
            stage.setScene(scene);
            stage.show();


            


        }
        if(usuario.equals("recepcao") && Senha1.equals("12345")){
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/recep.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
    
            stage.setTitle("Recepção");
            stage.setScene(scene);
            stage.show();

        }
        
         
      }catch (Exception ex){
        ex.printStackTrace();
      }

    }

    @Override
    public void initialize(URL location, ResourceBundle rb) {
    
    }


    
}
