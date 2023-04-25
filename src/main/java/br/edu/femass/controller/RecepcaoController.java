package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.femass.dao.AgendaDao;
import br.edu.femass.model.Agenda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RecepcaoController implements Initializable {

    @FXML
    private TextField Txtsearch;

    @FXML
    private ListView<Agenda> listaconsultas;
    
        private AgendaDao agendaDao = new AgendaDao();

    
        public void exibirAgenda() {
            try {
            ObservableList<Agenda> data = FXCollections.observableArrayList(
                agendaDao.buscarAtivos()
            );
            listaconsultas.setItems(data);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        }

        @FXML 
        private void press_list_keyPressed(KeyEvent event) {
            //exibirDados();
        }
    
        @FXML 
        private void press_list_mouseclicked(MouseEvent event) {
            //exibirDados();
        }

    @FXML
    private void BtnPacienteClick (ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Paciente.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setTitle("Controle Pacientes");
            stage.setScene(scene);
            stage.show();
        } catch(Exception ex){
            ex.printStackTrace();
        }

    }


    @FXML
    private void  BtnMedicoClick (ActionEvent event){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Medico.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setTitle("Controle Medicos");
            stage.setScene(scene);
            stage.show();
        } catch(Exception ex){
            ex.printStackTrace();
        }


    }   

    @FXML

    private void BtnAgendaClick (ActionEvent evet){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Agenda.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setTitle("Controle Agendamento");
            stage.setScene(scene);
            stage.show();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
           exibirAgenda();
    }
    
}
