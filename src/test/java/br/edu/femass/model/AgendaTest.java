package br.edu.femass.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgendaTest {
    
    private Paciente paciente;
    private Especialidade especialidade;
    private Plano plano;
    private Medico medico;

    @BeforeEach
    void setUp() {
        paciente = new Paciente(
            "Teste", 
            "02792655062", 
            "22 99999-9991",
            plano
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

        Agenda agenda = new Agenda(medico,
         especialidade,
          paciente,
           plano,
           "24/05/2023 08:10" );   

        

    }

    @Test
    void testconstrutor(){

        Agenda agenda2 = new Agenda(
        medico,
        medico.getEspecialidades(),
        paciente,
        paciente.getPlanos(),
        "29/06/2023 10:30"
        );

        assertEquals("Teste", agenda2.getPaciente().getNome());
        assertEquals("João Silva", agenda2.getMedico().getNome());
        assertEquals("Bradesco Saude", agenda2.getPaciente().getNomeplano());


    }




    

    
}
