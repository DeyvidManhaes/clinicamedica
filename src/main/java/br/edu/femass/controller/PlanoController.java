package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.femass.dao.PlanoDao;
import br.edu.femass.model.Plano;
import br.edu.femass.utils.DiversosJavaFx;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PlanoController implements Initializable{
 
    @FXML
    private TextField Txtplano;

    @FXML
    private ListView<Plano> listaplano;

    private PlanoDao planoDao = new PlanoDao();

    @FXML
    private void BtnExcluir_Click (ActionEvent event){

        Plano plano = listaplano.getSelectionModel().getSelectedItem();
        if (plano==null) return;

        try{
            if (planoDao.excluir(plano)==false){
                DiversosJavaFx.exibirMensagem("Não foi possível excluir o plano selecionado");
            }
            exibirPlano();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void BtnCadastrar_Click(ActionEvent event){

        try{
            Plano plano = new Plano(
                            Txtplano.getText());
                if(planoDao.gravar(plano)==false){
                    DiversosJavaFx.exibirMensagem("Não foi possível cadastrar plano de saúde");
                    return;
                }

                Txtplano.setText("");

                exibirPlano();
        }catch (Exception e){
            DiversosJavaFx.exibirMensagem(e.getMessage());
        }
    }

    public void exibirPlano(){
        try{
            ObservableList<Plano> data = FXCollections.observableArrayList(
                                    planoDao.buscarAtivos());
            listaplano.setItems(data);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
      
    
    public void initialize (URL location, ResourceBundle resources){
        exibirPlano();
    }
}
