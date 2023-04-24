   
    package br.edu.femass.controller;

    import java.net.URL;
import java.util.ResourceBundle;

import br.edu.femass.dao.AgendaDao;
import br.edu.femass.dao.Dao;
import br.edu.femass.dao.EspecialidadeDao;
import br.edu.femass.dao.MedicoDao;
import br.edu.femass.dao.PacienteDao;
import br.edu.femass.dao.PlanoDao;
import br.edu.femass.model.Agenda;
import br.edu.femass.model.Especialidade;
import br.edu.femass.model.Medico;
import br.edu.femass.model.Paciente;
import br.edu.femass.model.Plano;
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
    
    public class AgendaController implements Initializable {
    
        @FXML
        private TextField TxtCod;
        @FXML
        private ComboBox<Paciente> CboPaciente ;
    
        @FXML
        private ComboBox<Plano> CboPlano;
    
        @FXML
        private ComboBox<Medico> CboMedico;
    
        @FXML
        private ComboBox<Especialidade> CboEspecialidade;
    
        @FXML
        private TextField TxtDataagend;
    
        @FXML
        private TextField TxtDateconsult;
        
        @FXML
        private ListView<Agenda> listaagenda;
    
        private AgendaDao agendaDao = new AgendaDao();
        private Dao<Especialidade> especialidadeDao = new EspecialidadeDao(); 
        private Dao<Medico> medicoDao = new MedicoDao();
        private Dao<Plano> planoDao = new PlanoDao();
        private Dao<Paciente> pacienteDao = new PacienteDao();

    
    
        @FXML 
        private void listaagenda_keyPressed(KeyEvent event) {
            exibirDados();
        }
    
        @FXML 
        private void listaagenda_mouseClicked(MouseEvent event) {
            exibirDados();
        }
    
        
        private void exibirDados() {
            Agenda agenda = listaagenda.getSelectionModel().getSelectedItem();
            if (agenda==null) return;
    
            TxtCod.setText(agenda.getCodagendamento().toString());
            CboPaciente.getSelectionModel().select(agenda.getPaciente());
            CboPlano.getSelectionModel().select(agenda.getPlano());
            CboMedico.getSelectionModel().select(agenda.getMedico());
            CboEspecialidade.getSelectionModel().select(agenda.getEspecialidade());
            TxtDataagend.setUserData(agenda.getDatahoje());
            TxtDateconsult.setText(agenda.getDataagendamento());
            
    
        }
    
        @FXML
        private void BtnExcluir_Click(ActionEvent event) {
            Agenda agenda = listaagenda.getSelectionModel().getSelectedItem();
            if (agenda==null) return;
    
            try {
                if (agendaDao.excluir(agenda)==false) {
                    DiversosJavaFx.exibirMensagem("Não foi possível excluir o agendamento selecionado");
                }
            exibirAgenda();
            } catch (Exception e) {
                e.printStackTrace();
            }
           
    
        }
    
        @FXML
        private void BtnGravar_Click(ActionEvent event) {
            
           
            try {
                /*Agenda agenda = new Agenda(
                    CboMedico.getSelectionModel().getSelectedItem(),
                    CboEspecialidade.getSelectionModel().getSelectedItem(),
                    CboPaciente.getSelectionModel().getSelectedItem(),
                    CboPlano.getSelectionModel().getSelectedItem(),
                    agenda.setDateagendamento(TxtDateConsult.getText()))*/
                    Agenda agenda = new Agenda(
                        CboMedico.getSelectionModel().getSelectedItem(),
                        CboEspecialidade.getSelectionModel().getSelectedItem(),
                        CboPaciente.getSelectionModel().getSelectedItem(),
                        CboPlano.getSelectionModel().getSelectedItem(),
                        TxtDateconsult.getText());
                   
                     TxtDataagend.setText(agenda.getDatahoje().toString());
    
                
    
                if (agendaDao.gravar(agenda)==false) {
                    DiversosJavaFx.exibirMensagem("Não foi possível gravar a Agenda Médica");
                    return;
                }

                    CboMedico.getSelectionModel().select(null);
                    CboEspecialidade.getSelectionModel().select(null);
                    CboPaciente.getSelectionModel().select(null);
                    CboPlano.getSelectionModel().select(null);
                    TxtDateconsult.setText("");
                    TxtDataagend.setText("");   
    
    
                exibirAgenda();   
            } catch (Exception e) {
                DiversosJavaFx.exibirMensagem(e.getMessage());
            }
    
        }
    
        public void exibirAgenda() {
            try {
            ObservableList<Agenda> data = FXCollections.observableArrayList(
                agendaDao.buscarAtivos()
            );
            listaagenda.setItems(data);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

            public void exibirMedicos(){
                try{
                    ObservableList<Medico> data = FXCollections.observableArrayList(
                        medicoDao.buscarAtivos()
                    );
                    CboMedico.setItems(data);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            public void exibirPacientes(){
                try{
                    ObservableList<Paciente> data = FXCollections.observableArrayList(
                        pacienteDao.buscarAtivos()
                    );
                    CboPaciente.setItems(data);
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

            
        
    
     
    public void initialize(URL location, ResourceBundle resource){
        exibirAgenda();
        exibirMedicos();
        exibirEspecialidade();
        exibirPacientes();
        exibirPlano();

       }
    
    }