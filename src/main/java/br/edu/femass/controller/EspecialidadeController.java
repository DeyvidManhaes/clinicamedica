package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.femass.dao.EspecialidadeDao;
import br.edu.femass.model.Especialidade;
import br.edu.femass.utils.DiversosJavaFx;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class EspecialidadeController implements Initializable{
 
    @FXML
    private TextField Txtespecialidade;

    @FXML
    private ListView<Especialidade> listaespecialidade;

    private EspecialidadeDao especialidadeDao = new EspecialidadeDao();

    @FXML 
    private void listaespecialidade_keyPressed(KeyEvent event) {
        exibirDados();
    }

    @FXML 
    private void listaespecialidade_mouseClicked(MouseEvent event) {
        exibirDados();
    }

    private void exibirDados(){
        Especialidade especialidade = listaespecialidade.getSelectionModel().getSelectedItem();
        if(especialidade == null) return;

        Txtespecialidade.setText(especialidade.getNome());
    }



    @FXML
    private void BtnExcluir_Click2 (ActionEvent event){

        Especialidade especialidade = listaespecialidade.getSelectionModel().getSelectedItem();
        if (especialidade==null) return;

        try{
            if (especialidadeDao.excluir(especialidade)==false){
                DiversosJavaFx.exibirMensagem("Não foi possível excluir a especialidade selecionada");
            }
            exibirEspecialidades();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void BtnGravar_Click2(ActionEvent event){

        try{
            Especialidade especialidade = new Especialidade(
                            Txtespecialidade.getText());
                if(especialidadeDao.gravar(especialidade)==false){
                    DiversosJavaFx.exibirMensagem("Não foi possível gravar especialidade");
                    return;
                }

                Txtespecialidade.setText("");

                exibirEspecialidades();
        }catch (Exception e){
            DiversosJavaFx.exibirMensagem(e.getMessage());
        }
    }

    public void exibirEspecialidades(){
        try{
            ObservableList<Especialidade> data = FXCollections.observableArrayList(
                                    especialidadeDao.buscarAtivos());
            listaespecialidade.setItems(data);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
      
    
    public void initialize (URL location, ResourceBundle rb){
        exibirEspecialidades();
    }
}

    
