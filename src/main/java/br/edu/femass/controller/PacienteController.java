package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.femass.dao.Dao;
import br.edu.femass.dao.PacienteDao;
import br.edu.femass.dao.PlanoDao;
import br.edu.femass.utils.DiversosJavaFx;
import br.edu.femass.model.Paciente;
import br.edu.femass.model.Plano;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class PacienteController implements Initializable {

    @FXML
    private TextField TxtProntuario;

    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtCpf;

    @FXML
    private TextField TxtEndereco;

    @FXML
    private TextField TxtEmail;

    @FXML
    private TextField TxtTelefone;

    @FXML
    private ComboBox<Plano> CboPlano;

    @FXML
    private ListView<Paciente> listapaciente;

    private PacienteDao pacienteDao = new PacienteDao();
    private PlanoDao planoDao = new PlanoDao();

    @FXML 
    private void listapaciente_keyPressed(KeyEvent event) {
        exibirDados();
    }

    @FXML 
    private void listapaciente_mouseClicked(MouseEvent event) {
        exibirDados();
    }

    /**
     * 
     */
    private void exibirDados() {
        Paciente paciente  = listapaciente.getSelectionModel().getSelectedItem();
        if (paciente==null) return;


        TxtNome.setText(paciente.getNome());
        TxtCpf.setText(paciente.getCpf());
        TxtEmail.setText(paciente.getEmail());
        TxtEndereco.setText(paciente.getEndereco());
        TxtProntuario.setText(paciente.getProntuario().toString());
        TxtTelefone.setText(paciente.getTelefones().get(0));
        CboPlano.getSelectionModel().select(paciente.getPlanos());
    }

    @FXML
    private void BtnExcluir_Click(ActionEvent event) {
        Paciente paciente = listapaciente.getSelectionModel().getSelectedItem();
        if (paciente==null) return;

        try {
            if (pacienteDao.excluir(paciente)==false) {
                DiversosJavaFx.exibirMensagem("Não foi possível excluir o cliente selecionado");
            }
        exibirPacientes();
        } catch (Exception e) {
            e.printStackTrace();
        }
       

    }

    @FXML
    private void BtnGravar_Click(ActionEvent event) {
        try {
            Paciente paciente = new Paciente(
                    
                    TxtNome.getText(),
                    TxtCpf.getText(),
                    TxtTelefone.getText(),
                    CboPlano.getSelectionModel().getSelectedItem()
                    );
            paciente.setEmail(TxtEmail.getText());
            paciente.setEndereco(TxtEndereco.getText());

            TxtProntuario.setText(paciente.getProntuario().toString());

            if (pacienteDao.gravar(paciente)==false) {
                DiversosJavaFx.exibirMensagem("Não foi possível gravar o cliente");
                return;
            }
            TxtNome.setText("");
            TxtCpf.setText("");
            TxtTelefone.setText("");
            TxtEmail.setText("");
            TxtEndereco.setText("");
            TxtProntuario.setText("");
            CboPlano.getSelectionModel().select(null);
            
            


            exibirPacientes();   
        } catch (Exception e) {
            DiversosJavaFx.exibirMensagem(e.getMessage());
        }

    }

    public void exibirPacientes() {
        try {
        ObservableList<Paciente> data = FXCollections.observableArrayList(
            pacienteDao.buscarAtivos()
        );
        listapaciente.setItems(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    public void exibirPlano(){
        try{
            ObservableList<Plano> data = FXCollections.observableArrayList(
                planoDao.buscarAtivos()
            );
            CboPlano.setItems(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }       
    }

 @Override
public void initialize(URL location, ResourceBundle resource){
    exibirPacientes();
    exibirPlano();
   }

}
