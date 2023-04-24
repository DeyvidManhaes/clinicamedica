package br.edu.femass.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;

import javax.print.event.PrintJobAttributeEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgendaTest {
    private Agenda agenda;
    private Paciente paciente;
    private Especialidade especialidade;
    private Plano plano;
    private Medico medico;

    @BeforeEach
    void setUp() {
        paciente = new Paciente(
            "Teste", 
            "02792655062", 
            "22 99999-9991"
        );

        especialidade = new Especialidade(
            "Clinico geral"
        );

        plano = new Plano(
            "BradescoSaude"
        );

        medico = new Medico(
            "João Silva",
            "12345",
            "84283893064", 
            "111111", especialidade);

        agenda = new Agenda(medico,
         especialidade,
          paciente,
           plano,
           "24/05/2023 08:10" );   

        

    }

    @Test
    void testGetCodagendamento() {
        assertEquals(1, agenda.getCodagendamento());

    }

    @Test
    void testGetDataagendamento() {

        assertEquals("24/05/2023 08:10", agenda.getDataagendamento());

    }

    @Test
    void testGetDatahoje() {

        
        /*assertEquals(sdf.format("24/04/2023"), agenda.getDatahoje());*/
        

    }

    @Test
    void testGetEspecialidade() {

        assertEquals(medico, agenda.getMedico());

    }

    @Test
    void testGetMedico() {

    }

    @Test
    void testGetPaciente() {

    }

    @Test
    void testGetPlano() {

    }

    @Test
    void testSetAtivo() {

    }

    @Test
    void testSetDataagendamento() {

    }
}
