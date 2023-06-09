package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.femass.dao.EspecialidadeDao;
import br.edu.femass.dao.MedicoDao;
import br.edu.femass.model.Especialidade;
import br.edu.femass.model.Medico;
import br.edu.femass.utils.DiversosJavaFx;
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

public class MedicoController implements Initializable {

    @FXML
    private TextField TxtCRM;

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
    private ComboBox<Especialidade> CboEspecialidade;

    @FXML
    private ListView<Medico> listaMedico;

    private MedicoDao medicoDao = new MedicoDao();
    private EspecialidadeDao especialidadeDao = new EspecialidadeDao();

    @FXML 
    private void listamedico_keyPressed(KeyEvent event) {
        exibirDados();
    }

    @FXML 
    private void listamedico_mouseClicked(MouseEvent event) {
        exibirDados();
    }

    /**
     * 
     */
    private void exibirDados() {
        Medico medico  = listaMedico.getSelectionModel().getSelectedItem();
        if (medico==null) return;


        TxtNome.setText(medico.getNome());
        TxtCpf.setText(medico.getCpf());
        TxtEmail.setText(medico.getEmail());
        TxtEndereco.setText(medico.getEndereco());
        TxtCRM.setText(medico.getCrm().toString());
        TxtTelefone.setText(medico.getTelefones().get(0));
        CboEspecialidade.getSelectionModel().select(medico.getEspecialidades());
    }

    @FXML
    private void BtnExcluir_Click(ActionEvent event) {
        Medico medico = listaMedico.getSelectionModel().getSelectedItem();
        if (medico ==null) return;

        try {
            if (medicoDao.excluir(medico)==false) {
                DiversosJavaFx.exibirMensagem("Não foi possível excluir o cliente selecionado");
            }
        exibirMedicos();
        } catch (Exception e) {
            e.printStackTrace();
        }
       

    }

    @FXML
    private void BtnGravar_Click(ActionEvent event) {
        try {
            Medico medico = new Medico(
                    TxtNome.getText(),
                    TxtCRM.getText(),                    
                    TxtCpf.getText(),
                    TxtTelefone.getText(),
                    CboEspecialidade.getSelectionModel().getSelectedItem()
                    );
            medico.setEmail(TxtEmail.getText());
            medico.setEndereco(TxtEndereco.getText());


            if (medicoDao.gravar(medico)==false) {
                DiversosJavaFx.exibirMensagem("Não foi possível gravar o cliente");
                return;
            }
            TxtNome.setText("");
            TxtCpf.setText("");
            TxtTelefone.setText("");
            TxtEmail.setText("");
            TxtEndereco.setText("");
            TxtCRM.setText("");
            CboEspecialidade.getSelectionModel().select(null);
            
            


            exibirMedicos();   
        } catch (Exception e) {
            DiversosJavaFx.exibirMensagem(e.getMessage());
        }


    }

    public void exibirMedicos() {
        try {
        ObservableList<Medico> data = FXCollections.observableArrayList(
            medicoDao.buscarAtivos()
        );
        listaMedico.setItems(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    public void exibirEspecialidade(){
        try{
            ObservableList<Especialidade> data = FXCollections.observableArrayList(
                especialidadeDao.buscarAtivos()
            );
            CboEspecialidade.setItems(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }       
    }

 @Override
public void initialize(URL location, ResourceBundle resource){
    exibirMedicos();
    exibirEspecialidade();
   }

}
